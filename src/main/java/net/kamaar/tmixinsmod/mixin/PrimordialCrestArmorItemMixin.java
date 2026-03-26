package net.kamaar.tmixinsmod.mixin;

import com.gametechbc.gtbcs_geomancy_plus.api.init.GGAttributes;
import com.gametechbc.traveloptics.item.armor.PrimordialCrestArmorItem;
import com.llamalad7.mixinextras.injector.ModifyReceiver;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = PrimordialCrestArmorItem.class)
public abstract class PrimordialCrestArmorItemMixin {

    @ModifyReceiver(
            method = "triggerKnockbackAndDamage",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraftforge/registries/RegistryObject;get()Ljava/lang/Object;"
            ),
            remap = false
    )
    private RegistryObject redirectAttributeGet(RegistryObject instance) {
        if (instance == AttributeRegistry.NATURE_SPELL_POWER) {
            return GGAttributes.GEO_SPELL_POWER;
        }
        return instance;
    }
}