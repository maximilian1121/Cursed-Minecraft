package ca.maximilian.shenanigans;

import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ConfigScreen {
    public static Screen create(Screen parent) {
        Config config = Config.HANDLER.instance();

        return YetAnotherConfigLib.createBuilder()
                .title(Component.translatable("cursed_craft.config.title"))
                .category(ConfigCategory.createBuilder()
                        .name(Component.translatable("cursed_craft.config.category.fluids"))
                        .group(OptionGroup.createBuilder()
                                .name(Component.translatable("cursed_craft.config.group.water"))
                                .option(Option.createBuilder(boolean.class)
                                        .name(Component.translatable("cursed_craft.config.option.waterFast"))
                                        .description(OptionDescription.of(Component.translatable("cursed_craft.config.option.waterFast.tooltip")))
                                        .binding(config.waterFast,
                                                () -> config.waterFast,
                                                val -> config.waterFast = val)
                                        .controller(TickBoxControllerBuilder::create)
                                        .build())
                                .option(Option.createBuilder(boolean.class)
                                        .name(Component.translatable("cursed_craft.config.option.waterInfinite"))
                                        .description(OptionDescription.of(Component.translatable("cursed_craft.config.option.waterInfinite.tooltip")))
                                        .binding(config.waterInfinite,
                                                () -> config.waterInfinite,
                                                val -> config.waterInfinite = val)
                                        .controller(TickBoxControllerBuilder::create)
                                        .build()).build())
                        .group(OptionGroup.createBuilder()
                                .name(Component.translatable("cursed_craft.config.group.lava"))
                                .option(Option.createBuilder(boolean.class)
                                        .name(Component.translatable("cursed_craft.config.option.lavaFast"))
                                        .description(OptionDescription.of(Component.translatable("cursed_craft.config.option.lavaFast.tooltip")))
                                        .binding(config.lavaFast,
                                                () -> config.lavaFast,
                                                val -> config.lavaFast = val)
                                        .controller(TickBoxControllerBuilder::create)
                                        .build())
                                .option(Option.createBuilder(boolean.class)
                                        .name(Component.translatable("cursed_craft.config.option.lavaInfinite"))
                                        .description(OptionDescription.of(Component.translatable("cursed_craft.config.option.lavaInfinite.tooltip")))
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
