package retr0.quickstack.neoforge.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import retr0.quickstack.QuickStack;
import retr0.quickstack.client.QuickStackClient;

@Mod(value = QuickStack.MOD_ID, dist = Dist.CLIENT)
public class QuickStackNeoForgeClient {
    public QuickStackNeoForgeClient() {
        QuickStackClient.init();
    }
}
