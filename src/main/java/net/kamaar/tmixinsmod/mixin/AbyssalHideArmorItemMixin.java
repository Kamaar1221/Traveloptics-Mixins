package net.kamaar.tmixinsmod.mixin;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.acetheeldritchking.cataclysm_spellbooks.registries.CSAttributeRegistry;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "com.gametechbc.traveloptics.item.armor.AbyssalHideArmorItem")
public class AbyssalHideArmorItemMixin {

    @Inject(
        method = "calculateAbyssOrbDamage",
        at = @At("HEAD"),
        cancellable = true
    )
    private void replaceDamageCalculation(LivingEntity entity, CallbackInfoReturnable<Float> cir) {

        float abyssalSpellPower = (float) entity.getAttributeValue(
                CSAttributeRegistry.ABYSSAL_MAGIC_POWER.get()
        );

        cir.setReturnValue(abyssalSpellPower * 3.0F);
    }
}