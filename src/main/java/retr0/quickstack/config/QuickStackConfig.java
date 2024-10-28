package retr0.quickstack.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import retr0.quickstack.QuickStack;

@Config(name = QuickStack.MOD_ID)
public class QuickStackConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip
    public boolean allowHotbarQuickStack = false;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 0, max = 32)
    public int containerSearchRadius = 8;

    @ConfigEntry.Gui.Tooltip
    public float containerHighlightDuration = 5.0f;

    public static QuickStackConfig register() {
        AutoConfig.register(QuickStackConfig.class, GsonConfigSerializer::new);
        return AutoConfig.getConfigHolder(QuickStackConfig.class).getConfig();
    }
}
