package retr0.quickstack.network;

import dev.architectury.networking.NetworkManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Pair;
import retr0.quickstack.QuickStack;
import retr0.quickstack.util.IconPair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Maps items to a "deposited total" along with an immutable icon for the container it was deposited into.
 */
public record S2CPacketToastResult(
        int totalItemsDeposited,
        int totalContainersUsed,
        List<IconPair> topDeposited
) implements CustomPayload {
    public static Id<S2CPacketToastResult> ID = new Id<>(QuickStack.id("c2s/toast_result"));

    public static PacketCodec<RegistryByteBuf, S2CPacketToastResult> PACKET_CODEC = PacketCodec.tuple(
            PacketCodecs.INTEGER, S2CPacketToastResult::totalItemsDeposited,
            PacketCodecs.INTEGER, S2CPacketToastResult::totalContainersUsed,
            PacketCodecs.collection(
                    ArrayList::new,
                    PacketCodec.tuple(
                            ItemStack.PACKET_CODEC, IconPair::itemIcon,
                            ItemStack.PACKET_CODEC, IconPair::containerIcon,
                            IconPair::new
                    )
            ), S2CPacketToastResult::topDeposited,
            S2CPacketToastResult::new
    );

    /**
     * Sends a {@link S2CPacketToastResult} packet to the client.
     */
    public static void send(
        Map<Item, Pair<Integer, ItemStack>> itemUsageMap, int totalItemsDeposited, int totalContainersUsed,
        ServerPlayerEntity player)
    {
        var topDeposited = itemUsageMap.entrySet().stream()
            .sorted(Comparator.comparingInt(entry -> -entry.getValue().getLeft()))
            .limit(3)
            .map(entry -> new IconPair(entry.getKey().getDefaultStack(), entry.getValue().getRight()))
            .toList();

        NetworkManager.sendToPlayer(player, new S2CPacketToastResult(totalItemsDeposited, totalContainersUsed, topDeposited));
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
