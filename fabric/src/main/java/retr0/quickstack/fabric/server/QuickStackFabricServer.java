package retr0.quickstack.fabric.server;

import net.fabricmc.api.DedicatedServerModInitializer;
import retr0.quickstack.server.QuickStackServer;

public class QuickStackFabricServer implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        QuickStackServer.init();
    }
}
