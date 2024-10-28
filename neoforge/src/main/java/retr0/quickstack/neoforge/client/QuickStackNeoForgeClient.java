package retr0.quickstack.neoforge.client;

import me.shedaniel.autoconfig.AutoConfig;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import retr0.quickstack.QuickStack;
import retr0.quickstack.client.QuickStackClient;
import retr0.quickstack.config.QuickStackConfig;

@Mod(value = QuickStack.MOD_ID, dist = Dist.CLIENT)
public class QuickStackNeoForgeClient {
    public QuickStackNeoForgeClient(ModContainer mod, IEventBus modBus) {
        QuickStackClient.init();

        mod.registerExtensionPoint(IConfigScreenFactory.class, (modContainer, parent) ->
                AutoConfig.getConfigScreen(QuickStackConfig.class, parent).get()
        );
    }
}
