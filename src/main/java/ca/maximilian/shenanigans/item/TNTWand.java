package ca.maximilian.shenanigans.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class TNTWand extends Item {
    public TNTWand(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if (level.isClientSide) { return InteractionResultHolder.fail(player.getItemInHand(usedHand)); }
        HitResult hitResult = player.pick(100.0D, 0.0F, false);

        Vec3 spawnPos = hitResult.getLocation();
        spawnPos = new Vec3(spawnPos.x, spawnPos.y + 15, spawnPos.z);
        PrimedTnt tnt = EntityType.TNT.create(level);
        if (tnt != null) {
            tnt.setPos(spawnPos);
            level.addFreshEntity(tnt);
        }
        if (!player.isCreative()) {
            player.getCooldowns().addCooldown(this, 40);
        }

        ItemStack itemStack = player.getItemInHand(usedHand);
        itemStack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);

        return InteractionResultHolder.success(player.getItemInHand(usedHand));
    }
}
