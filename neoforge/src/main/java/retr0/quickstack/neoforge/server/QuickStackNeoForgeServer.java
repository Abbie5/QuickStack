package retr0.quickstack.neoforge.server;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import retr0.quickstack.QuickStack;
import retr0.quickstack.server.QuickStackServer;

@Mod(value = QuickStack.MOD_ID, dist = Dist.DEDICATED_SERVER)
public class QuickStackNeoForgeServer {
    public QuickStackNeoForgeServer() {
        QuickStackServer.init();
    }
}
