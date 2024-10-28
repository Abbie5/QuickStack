package retr0.quickstack.fabric;

import net.fabricmc.api.ModInitializer;
import retr0.quickstack.QuickStack;
import retr0.quickstack.network.PacketRegistry;
import retr0.quickstack.util.QuickStackManager;

public class QuickStackFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        QuickStack.init();
    }
}
