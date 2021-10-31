package com.github.nikkollaii.ic3;

import com.github.nikkollaii.ic3.setup.ClientSetup;
import com.github.nikkollaii.ic3.setup.Registration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(IC3.MOD_ID)
public class IC3
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "ic3";

    public IC3() {
        Registration.init();
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::setup);
        eventBus.addListener(ClientSetup::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {}
}
