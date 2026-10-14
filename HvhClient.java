package com.example.hvh;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Точка входа клиентской части мода
public class HvhClient implements ClientModInitializer {
    public static final String MOD_ID = "hvh";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Глобальный флаг: включена ли логика мода
    public static volatile boolean enabled = true;

    @Override
    public void onInitializeClient() {
        LOGGER.info("HvH загружен, enabled = {}", enabled);
    }
}
