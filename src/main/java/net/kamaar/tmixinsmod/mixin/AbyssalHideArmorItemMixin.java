package net.kamaar.tmixinsmod.mixin;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.acetheeldritchking.cataclysm_spellbooks.registries.CSAttributeRegistry;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "com.gametechbc.traveloptics.item.armor.AbyssalHideArmorItem")
public abstract class AbyssalHideArmorItemMixin {

    @Redirect(
            method = "calculateAbyssOrbDamage",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/LivingEntity;getAttributeValue(Lnet/minecraft/world/entity/ai/attributes/Attribute;)D",
                    ordinal = 0
            )
    )
    private double redirectEnderSpellPower(LivingEntity entity, Attribute attribute) {
        return entity.getAttributeValue(CSAttributeRegistry.ABYSSAL_MAGIC_POWER.get());
    }

    @Redirect(
            method = "calculateAbyssOrbDamage",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/LivingEntity;getAttributeValue(Lnet/minecraft/world/entity/ai/attributes/Attribute;)D",
                    ordinal = 1
            )
    )
    private double redirectEldritchSpellPower(LivingEntity entity, Attribute attribute) {
        return 0.0D;
    }
}