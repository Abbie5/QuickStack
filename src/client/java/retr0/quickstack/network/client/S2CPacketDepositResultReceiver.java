package retr0.quickstack.network.client;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import retr0.quickstack.network.S2CPacketDepositResult;
import retr0.quickstack.util.InventoryUtil.InventorySource;
import retr0.quickstack.util.InventoryUtil.InventorySource.SourceType;
import retr0.quickstack.util.OutlineColorManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S2CPacketDepositResultReceiver implements ClientPlayNetworking.PlayPayloadHandler<S2CPacketDepositResult> {
    @Override
    public void receive(S2CPacketDepositResult payload, ClientPlayNetworking.Context context)
    {
        MinecraftClient client = context.client();
        var slotUsageMap = new HashMap<Integer, List<InventorySource<?>>>();

        payload.slotUsageMap().forEach((slotId, list) -> {
            var associatedInventories = new ArrayList<InventorySource<?>>(1);

            list.forEach((either) -> {
                associatedInventories.add(either.map(
                        blockPos -> new InventorySource<>(blockPos, SourceType.BLOCK_ENTITY),
                        uuid -> new InventorySource<>(uuid, SourceType.INVENTORY_ENTITY)
                ));
            });
            slotUsageMap.put(slotId, associatedInventories);
        });

        client.execute(() -> {
            if (client.player == null) return;

            OutlineColorManager.getInstance().addMappings(client.player.getWorld(), slotUsageMap);
        });
    }
}
