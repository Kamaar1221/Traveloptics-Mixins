package net.kamaar.tmixinsmod.mixin;

import com.gametechbc.gtbcs_geomancy_plus.api.init.GGAttributes;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "com.gametechbc.traveloptics.item.armor.PrimordialCrestArmorItem")
public abstract class PrimordialCrestArmorItemMixin {

    @Redirect(
            method = "triggerKnockbackAndDamage",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraftforge/registries/RegistryObject;get()Ljava/lang/Object;",
                    ordinal = 0
            ),
            remap = false
    )
    private Object redirectAttributeGet(RegistryObject<?> instance) {
        if (instance == AttributeRegistry.NATURE_SPELL_POWER) {
            return GGAttributes.GEO_SPELL_POWER.get();
        }
        return instance.get();
    }
}