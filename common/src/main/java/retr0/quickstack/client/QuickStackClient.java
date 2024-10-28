package retr0.quickstack.client;

import retr0.quickstack.network.client.PacketRegistry;
import retr0.quickstack.util.OutlineColorManager;

public class QuickStackClient {
    public static void init() {
        PacketRegistry.registerS2CPackets();
        OutlineColorManager.init();
    }
}
