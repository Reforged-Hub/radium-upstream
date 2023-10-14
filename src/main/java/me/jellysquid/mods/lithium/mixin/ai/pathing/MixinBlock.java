package me.jellysquid.mods.lithium.mixin.ai.pathing;

import me.jellysquid.mods.lithium.api.pathing.BlockPathing;
import me.jellysquid.mods.lithium.common.ai.pathing.BlockClassChecker;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public class MixinBlock implements BlockPathing {
    private boolean needsDynamicNodeTypeCheck = true;
    private boolean needsDynamicBurnCheck = true;

    @Inject(method = "<init>", at = @At("RETURN"))
    public void postConstruct(AbstractBlock.Settings p_i241196_1_, CallbackInfo ci) {
        this.needsDynamicNodeTypeCheck = BlockClassChecker.shouldUseDynamicTypeCheck(this.getClass());
        this.needsDynamicBurnCheck = BlockClassChecker.shouldUseDynamicBurningCheck(this.getClass());
    }

    @Override
    public boolean needsDynamicNodeTypeCheck() {
        return needsDynamicNodeTypeCheck;
    }

    @Override
    public boolean needsDynamicBurningCheck() {
        return needsDynamicBurnCheck;
    }
}
