package retr0.quickstack;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retr0.quickstack.config.QuickStackConfig;
import retr0.quickstack.network.PacketRegistry;
import retr0.quickstack.util.QuickStackManager;

public class QuickStack implements ModInitializer {
    public static final String MOD_ID = "quickstack";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static QuickStackConfig CONFIG;

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        CONFIG = QuickStackConfig.register();

        PacketRegistry.registerPayloadTypes();
        PacketRegistry.registerC2SPackets();
        QuickStackManager.init();
    }

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}
