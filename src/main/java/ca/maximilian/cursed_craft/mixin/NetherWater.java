package ca.maximilian.cursed_craft.mixin;

import ca.maximilian.cursed_craft.Config;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BucketItem.class)
public abstract class NetherWater {
    @WrapOperation(method = "emptyContents", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/dimension/DimensionType;ultraWarm()Z"))
    private boolean overWriteEmptyContents(DimensionType instance, Operation<Boolean> original) {
        return !Config.HANDLER.instance().waterInNether;
    }
}