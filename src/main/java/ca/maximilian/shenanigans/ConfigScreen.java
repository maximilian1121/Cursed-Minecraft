package ca.maximilian.shenanigans;

import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import dev.isxander.yacl3.platform.YACLPlatform;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import static ca.maximilian.shenanigans.Shenanigans.MOD_ID;

public class ConfigScreen {
    private static ResourceLocation imageSample(String name) {
        return YACLPlatform.rl(MOD_ID, "textures/images/" + name);
    }
    public static Screen create(Screen parent) {
        Config config = Config.HANDLER.instance();

        return YetAnotherConfigLib.createBuilder()
                .title(Component.translatable("cursed_craft.config.title"))
                .category(ConfigCategory.createBuilder()
                        .name(Component.translatable("cursed_craft.config.category.fluids"))
                        .group(OptionGroup.createBuilder()
                                .name(Component.translatable("cursed_craft.config.group.water"))
                                .description(OptionDescription.createBuilder()
                                        .text(Component.translatable("cursed_craft.config.group.water.description"))
                                        .build())
                                .option(Option.createBuilder(boolean.class)
                                        .name(Component.translatable("cursed_craft.config.option.waterFast"))
                                        .description(OptionDescription.createBuilder()
                                                .text(Component.translatable("cursed_craft.config.option.waterFast.description"))
//                                                .webpImage(imageSample("fast_lava_preview.webp"))
                                                .build()
                                        )
                                        .binding(config.waterFast,
                                                () -> config.waterFast,
                                                val -> config.waterFast = val)
                                        .controller(TickBoxControllerBuilder::create)
                                        .build())
                                .option(Option.createBuilder(boolean.class)
                                        .name(Component.translatable("cursed_craft.config.option.waterInfinite"))
                                        .description(OptionDescription.createBuilder()
                                                .text(Component.translatable("cursed_craft.config.option.waterInfinite.description"))
//                                                .webpImage(imageSample("fast_lava_preview.webp"))
                                                .build()
                                        )
                                        .binding(config.waterInfinite,
                                                () -> config.waterInfinite,
                                                val -> config.waterInfinite = val)
                                        .controller(TickBoxControllerBuilder::create)
                                        .build()).build())
                        .group(OptionGroup.createBuilder()
                                .name(Component.translatable("cursed_craft.config.group.lava"))
                                .description(OptionDescription.createBuilder()
                                        .text(Component.translatable("cursed_craft.config.group.lava.description"))
                                        .build())
                                .option(Option.createBuilder(boolean.class)
                                        .name(Component.translatable("cursed_craft.config.option.lavaFast"))
                                        .description(OptionDescription.createBuilder()
                                                .text(Component.translatable("cursed_craft.config.option.lavaFast.description"))
                                                .webpImage(imageSample("fast_lava_preview.webp"))
                                                .build()
                                        )
                                        .binding(config.lavaFast,
                                                () -> config.lavaFast,
                                                val -> config.lavaFast = val)
                                        .controller(TickBoxControllerBuilder::create)
                                        .build())
                                .option(Option.createBuilder(boolean.class)
                                        .name(Component.translatable("cursed_craft.config.option.lavaInfinite"))
                                        .description(OptionDescription.createBuilder()
                                                .text(Component.translatable("cursed_craft.config.option.lavaInfinite.description"))
                                                .webpImage(imageSample("inf_lava_preview.webp"))
                                                .build()
                                        )
                                        .binding(config.lavaInfinite,
                                                () -> config.lavaInfinite,
                                                val -> config.lavaInfinite = val)
                                        .controller(TickBoxControllerBuilder::create)
                                        .build()).build())
                        .build())
                .save(() -> Config.HANDLER.save())
                .build()
                .generateScreen(parent);
    }
}
