package retr0.quickstack;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retr0.quickstack.config.QuickStackConfig;
import retr0.quickstack.network.PacketRegistry;
import retr0.quickstack.util.QuickStackManager;

public class QuickStack {
    public static final String MOD_ID = "quickstack";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static QuickStackConfig CONFIG;

    public static void init() {
        QuickStack.CONFIG = QuickStackConfig.register();

        PacketRegistry.registerPayloadTypes();
        PacketRegistry.registerC2SPackets();
        QuickStackManager.init();
    }

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}
