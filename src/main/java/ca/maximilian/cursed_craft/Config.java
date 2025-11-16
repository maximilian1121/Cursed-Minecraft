package ca.maximilian.cursed_craft;

import com.google.gson.GsonBuilder;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;

public class Config {

    private static final String fileName =
            FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT ? "cursed_craft_config_CLIENT.json5" : "cursed_craft_config_SERVER.json5";

    public static ConfigClassHandler<Config> HANDLER = ConfigClassHandler.createBuilder(Config.class)
            .id(CursedCraft.id("cursed_craft", "cursed_craft_config"))
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(FabricLoader.getInstance().getConfigDir().resolve(fileName))
                    .appendGsonBuilder(GsonBuilder::setPrettyPrinting)
                    .setJson5(true)
                    .build())
            .build();

    @SerialEntry
    public boolean waterFast = false;
    @SerialEntry
    public boolean waterInfinite = false;
    @SerialEntry
    public boolean waterInNether = false;

    @SerialEntry
    public boolean lavaFast = false;
    @SerialEntry
    public boolean lavaInfinite = false;

    @SerialEntry
    public boolean infinitePiston = false;

    @SerialEntry
    public CrashOnDeathType crashOnDeathType = CrashOnDeathType.OFF;

    @SerialEntry(comment = "Requires version 1.21.1+")
    public boolean rapidSkeletons = false;

    @SerialEntry
    public boolean instantCreepers = false;

    @SerialEntry(comment = "Does not work on server, Singleplayer only!")
    public boolean oneTapZombies = false;
}