package retr0.quickstack.server;

import retr0.quickstack.network.server.PacketRegistry;

public class QuickStackServer {
    public static void init() {
        PacketRegistry.registerPayloadTypes();
    }
}
