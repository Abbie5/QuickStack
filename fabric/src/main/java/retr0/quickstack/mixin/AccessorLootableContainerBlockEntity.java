package retr0.quickstack.mixin;

import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(LootableContainerBlockEntity.class)
public interface AccessorLootableContainerBlockEntity {
    @Accessor("lootTable")
    RegistryKey<LootTable> getLootTableId();
}
