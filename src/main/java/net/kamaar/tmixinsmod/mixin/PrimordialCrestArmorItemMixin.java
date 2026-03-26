package net.kamaar.tmixinsmod.mixin;

import com.gametechbc.gtbcs_geomancy_plus.api.init.GGAttributes;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "com.gametechbc.traveloptics.item.armor.PrimordialCrestArmorItem")
public class PrimordialCrestArmorItemMixin {

    @Redirect(
        method = "triggerKnockbackAndDamage",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraftforge/registries/RegistryObject;get()Ljava/lang/Object;"
        )
    )
    private Object replaceNatureSpellPower(RegistryObject instance) {
        if (instance == AttributeRegistry.NATURE_SPELL_POWER) {
            return GGAttributes.GEO_SPELL_POWER.get();
        }
        return ((net.minecraftforge.registries.RegistryObject<?>) instance).get();
    }
}