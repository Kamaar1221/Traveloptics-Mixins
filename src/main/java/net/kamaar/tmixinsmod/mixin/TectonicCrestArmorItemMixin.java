package net.kamaar.tmixinsmod.mixin;

import com.gametechbc.gtbcs_geomancy_plus.api.init.GGAttributes;
import com.gametechbc.traveloptics.item.armor.TectonicCrestArmorItem;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = TectonicCrestArmorItem.class)
public abstract class TectonicCrestArmorItemMixin {

    @WrapOperation(
            method = "triggerTectonicShockwave",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/gametechbc/traveloptics/api/utils/TOGeneralUtils;getSpellPowerScaling(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/entity/ai/attributes/Attribute;Lnet/minecraft/world/entity/ai/attributes/Attribute;)F"
            ),
            remap = false
    )
    private static float addGeoSpellPower(LivingEntity sourceEntity, Attribute mainStat, Attribute subStat, Operation<Float> original) {
        float base = original.call(sourceEntity, mainStat, subStat);
        float geo = (float) sourceEntity.getAttributeValue(GGAttributes.GEO_SPELL_POWER.get());
        return (base + geo) / 2f;
    }
}