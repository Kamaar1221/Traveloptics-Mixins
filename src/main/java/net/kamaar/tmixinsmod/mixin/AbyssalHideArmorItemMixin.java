package net.kamaar.tmixinsmod.mixin;

import com.gametechbc.traveloptics.item.armor.AbyssalHideArmorItem;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.acetheeldritchking.cataclysm_spellbooks.registries.CSAttributeRegistry;
import net.minecraft.world.entity.ai.attributes.Attribute;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = AbyssalHideArmorItem.class)
public abstract class AbyssalHideArmorItemMixin {

    @ModifyArg(
            method = "calculateAbyssOrbDamage",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/LivingEntity;getAttributeValue(Lnet/minecraft/world/entity/ai/attributes/Attribute;)D", ordinal = 0)
    )
    private Attribute redirectEnderSpellPowerA(Attribute pAttribute) {
        return CSAttributeRegistry.ABYSSAL_MAGIC_POWER.get();
    }

    @ModifyArg(
            method = "calculateAbyssOrbDamage",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/LivingEntity;getAttributeValue(Lnet/minecraft/world/entity/ai/attributes/Attribute;)D", ordinal = 1)
    )
    private Attribute redirectEnderSpellPowerB(Attribute pAttribute) {
        return CSAttributeRegistry.ABYSSAL_MAGIC_POWER.get();
    }


    @ModifyReturnValue(
            method = "calculateAbyssOrbDamage",
            at = @At("RETURN"), remap = false
    )
    private float redirectEnderSpellPowerC(float original) {
        return original / 2;
    }
}