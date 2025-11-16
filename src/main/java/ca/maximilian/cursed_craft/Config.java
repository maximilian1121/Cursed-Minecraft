package ca.maximilian.cursed_craft;

import com.google.gson.GsonBuilder;
import dev.isxander.yacl3.api.NameableEnum;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.chat.Component;

public class Config {
    public static ConfigClassHandler<Config> HANDLER = ConfigClassHandler.createBuilder(Config.class)
            .id(CursedCraft.id("cursed_craft", "cursed_craft_config"))
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(FabricLoader.getInstance().getConfigDir().resolve("cursed_craft_config.json5"))
                    .appendGsonBuilder(GsonBuilder::setPrettyPrinting)
                    .setJson5(true)
                    .build())
            .build();

    @SerialEntry
    public boolean waterFast = false;
    @SerialEntry
    public boolean waterInfinite = false;

    @SerialEntry
    public boolean lavaFast = false;
    @SerialEntry
    public boolean lavaInfinite = false;

    @SerialEntry
    public boolean infinitePiston = false;

    @SerialEntry
    public CrashOnDeathType crashOnDeathType = CrashOnDeathType.OFF;

    //? >=1.21 {
    @SerialEntry
    public boolean rapidSkeletons = false;
    //?}

    @SerialEntry
    public boolean instantCreepers = false;

    @SerialEntry
    public boolean oneTapZombies = false;
}