package ca.maximilian.cursed_craft.mixin;

import org.spongepowered.asm.mixin.Mixin;

//? >=1.21 {

import org.spongepowered.asm.mixin.Overwrite;
import ca.maximilian.cursed_craft.Config;
import net.minecraft.world.entity.monster.AbstractSkeleton;

@Mixin(AbstractSkeleton.class)
public class SkeletonRapidFire {

    /**
     * @author max
     * @reason To set hard attack intervals for AbstractSkeletons
     */
    @Overwrite
    public int getHardAttackInterval() {
        if (Config.HANDLER.instance().rapidSkeletons) {
            return 0;
        }
        return 20;
    }

    /**
     * @author max
     * @reason To set attack intervals for AbstractSkeletons
     */
    @Overwrite
    public int getAttackInterval() {
        if (Config.HANDLER.instance().rapidSkeletons) {
            return 0;
        }
        return 40;
    }
}
//?} else {

/*import org.apache.commons.lang3.ObjectUtils;
@Mixin(ObjectUtils.Null.class)
public class SkeletonRapidFire {

}

*///?}