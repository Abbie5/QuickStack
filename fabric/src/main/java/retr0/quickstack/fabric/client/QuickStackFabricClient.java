package retr0.quickstack.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import retr0.quickstack.client.QuickStackClient;
import retr0.quickstack.network.client.PacketRegistry;
import retr0.quickstack.util.OutlineColorManager;

public class QuickStackFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        QuickStackClient.init();
    }
}
