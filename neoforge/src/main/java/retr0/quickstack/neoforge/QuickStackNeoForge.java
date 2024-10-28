package retr0.quickstack.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import retr0.quickstack.QuickStack;

@Mod(QuickStack.MOD_ID)
public class QuickStackNeoForge {
    public QuickStackNeoForge(ModContainer mod, IEventBus modBus) {
        QuickStack.init();
    }
}
