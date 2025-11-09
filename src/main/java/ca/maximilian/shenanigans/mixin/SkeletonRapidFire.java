package ca.maximilian.shenanigans.mixin;

import ca.maximilian.shenanigans.Config;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

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
