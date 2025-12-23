from io import StringIO
import os
import configparser
from time import time
import httpx
import json

MODRINTH_TOKEN = os.getenv("MODRINTH_TOKEN")

versions = {}

def read_properties(file_path):
    with open(file_path, 'r') as f:
        config_string = '[dummy_section]\n' + f.read()

    config_file = StringIO(config_string)
    
    config = configparser.ConfigParser()
    config.read_file(config_file)

    return dict(config['dummy_section'])

top_level_props = read_properties("../gradle.properties")

class Config:
    def __init__(self, config_dict):
        self.name = f"Cursed Craft {top_level_props['mod.version']} for {config_dict['mod.mc_title']}"
        self.version_number = top_level_props['mod.version']
        self.changelog = open("../CHANGELOG.md", "r").read()
        self.dependencies = [
            {
                "project_id": "P7dR8mSH",
                "dependency_type": "required"
            },
            {
                "project_id": "1eAoo2KR",
                "dependency_type": "required"
            },
            {
                "project_id": "mOgUt4GM",
                "dependency_type": "required"
            }
        ]
        self.game_versions = config_dict['mod.mc_targets'].split(" ")
        self.version_type = "release"
        self.loaders = ["fabric"]
        self.featured = True
        self.project_id = "2nyjaLUy"

class Version:
    def __init__(self, version_str, version_config, main_file, sources_file):
        self.version_str = version_str
        self.version_config = Config(version_config)
        self.main_file = main_file
        self.sources_file = sources_file

for dir in os.listdir("."):
    if not os.path.isfile(dir):
        libs_dir = os.path.join(dir, "build", "libs")
        sources_file = ""
        for file in os.listdir(libs_dir):
            if not file.endswith(".jar"):
                continue
            if "-sources.jar" in file:
                sources_file = file
            if ".jar" in file and not "-sources.jar" in file:
                main_file = file
        versions[dir] = Version(dir, read_properties(os.path.join(dir, "gradle.properties")), main_file, sources_file)

def publish_modrinth(version_info: Version):
    url = "https://api.modrinth.com/v2/version"
    
    headers = {
        "Authorization": MODRINTH_TOKEN,
        "User-Agent": f"maximilian1121/Cursed-Minecraft/{top_level_props['mod.version']} (latific.click)"
    }
    
    data_payload = {
        "name": version_info.version_config.name,
        "version_number": version_info.version_config.version_number,
        "changelog": version_info.version_config.changelog,
        "dependencies": version_info.version_config.dependencies,
        "game_versions": version_info.version_config.game_versions,
        "version_type": version_info.version_config.version_type,
        "loaders": version_info.version_config.loaders,
        "featured": version_info.version_config.featured,
        "project_id": version_info.version_config.project_id,
        "file_parts": ["main_jar"],
        "primary_file": "main_jar"
    }
    
    libs_dir = os.path.join(version_info.version_str, "build", "libs")
    main_path = os.path.join(libs_dir, version_info.main_file)
    
    with open(main_path, "rb") as f:
        main_jar_data = f.read()
    
    print(f"Main JAR size: {len(main_jar_data)} bytes")
    
    files = {
        "data": ("data.json", json.dumps(data_payload), "application/json"),
        "main_jar": (version_info.main_file, main_jar_data, "application/java-archive")
    }
    
    try:
        with httpx.Client(timeout=120.0) as client:
            response = client.post(url, headers=headers, files=files)
        
        if response.status_code == 200:
            print(f"Successfully published {version_info.version_config.name}!")
            print(response.json())
        else:
            print(f"Failed to publish: {response.status_code}")
            print(response.text)
        
        return response
    except Exception as e:
        print(f"Error: {e}")
        raise

for version_key in versions:
    publish_modrinth(versions[version_key])
    time.sleep(20)