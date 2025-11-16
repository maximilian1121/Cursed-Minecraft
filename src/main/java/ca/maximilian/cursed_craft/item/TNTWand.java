package ca.maximilian.cursed_craft.item;

import net.minecraft.world.InteractionHand;
//? < 1.21.9 {
/*import net.minecraft.world.InteractionResultHolder;
*///?} else {
import net.minecraft.world.InteractionResult;
//?}
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

    public void onUsed(Player player, Level level, InteractionHand usedHand) {
        HitResult hitResult = player.pick(100.0D, 0.0F, false);

        Vec3 spawnPos = hitResult.getLocation();
        spawnPos = new Vec3(spawnPos.x, spawnPos.y + 15, spawnPos.z);
        //? < 1.21.9 {
        /*PrimedTnt tnt = EntityType.TNT.create(level);
         *///?} else {
        PrimedTnt tnt = EntityType.TNT.create(level, EntitySpawnReason.TRIGGERED);
        //?}
        ItemStack itemStack = player.getItemInHand(usedHand);
        if (tnt != null) {
            tnt.setPos(spawnPos);
            level.addFreshEntity(tnt);
        }
        if (!player.isCreative()) {
            //? >=1.21.9 {
            player.getCooldowns().addCooldown(itemStack, 40);
            //?} else {
            /*player.getCooldowns().addCooldown(this, 40);
            *///?}
        }

        //? if <1.21 {
        /*itemStack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(usedHand));
         *///?} else
        itemStack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
    }

    //? < 1.21.9 {
    /*@Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if (!level.isClientSide) {
            onUsed(player, level, usedHand);
        }

        return InteractionResultHolder.success(player.getItemInHand(usedHand));
    }
    *///?} else {
    @Override
    public @NotNull InteractionResult use(Level level, Player player, InteractionHand usedHand) {
        if (!level.isClientSide()) {
            onUsed(player, level, usedHand);
         }

        return InteractionResult.SUCCESS;
    }
    //?}
}
