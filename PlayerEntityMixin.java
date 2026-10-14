package com.example.hvh.mixin;

import com.example.hvh.HvhClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// Миксин в PlayerEntity: всегда возвращаем полный прогресс кулдауна атаки
@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Inject(method = "getAttackCooldownProgress", at = @At("HEAD"), cancellable = true)
    private void hvh$noCooldown(float baseTime, CallbackInfoReturnable<Float> cir) {
        if (!HvhClient.enabled) {
            return;
        }
        // Затрагиваем только локального игрока
        PlayerEntity self = (PlayerEntity) (Object) this;
        if (self != MinecraftClient.getInstance().player) {
            return;
        }
        cir.setReturnValue(1.0F);
    }
}
