package retr0.quickstack.network;

import com.mojang.datafixers.util.Either;
import dev.architectury.networking.NetworkManager;
import net.minecraft.entity.Entity;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Uuids;
import net.minecraft.util.math.BlockPos;
import retr0.quickstack.QuickStack;
import retr0.quickstack.util.InventoryUtil.InventoryInfo;
import retr0.quickstack.util.InventoryUtil.InventorySource.SourceType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public record S2CPacketDepositResult(
        Map<Integer, List<Either<BlockPos, UUID>>> slotUsageMap
) implements CustomPayload {
    public static Id<S2CPacketDepositResult> ID = new Id<>(QuickStack.id("s2c/deposit_result"));

    public static PacketCodec<RegistryByteBuf, S2CPacketDepositResult> PACKET_CODEC = PacketCodecs.<RegistryByteBuf, Integer, List<Either<BlockPos, UUID>>, Map<Integer, List<Either<BlockPos, UUID>>>>map(
            HashMap::new,
            PacketCodecs.INTEGER,
            PacketCodecs.collection(
                    ArrayList::new,
                     PacketCodecs.either(
                        BlockPos.PACKET_CODEC,
                        Uuids.PACKET_CODEC
                    )
            )
    ).xmap(S2CPacketDepositResult::new, S2CPacketDepositResult::slotUsageMap);

    public static void send(Map<Integer, List<InventoryInfo>> slotUsageMap, ServerPlayerEntity player) {
        Map<Integer, List<Either<BlockPos, UUID>>> explodedMap = new HashMap<>();
        slotUsageMap.forEach((slotId, usageInfoList) -> {
            List<Either<BlockPos, UUID>> list = new ArrayList<>();
            usageInfoList.forEach(inventoryInfo -> {
                SourceType sourceType = inventoryInfo.source().sourceType();
                Either<BlockPos, UUID> either;
                if (sourceType == SourceType.BLOCK_ENTITY) {
                    either = Either.left(inventoryInfo.sourcePosition());
                } else if (sourceType == SourceType.INVENTORY_ENTITY) {
                    either = Either.right(((Entity)inventoryInfo.source().instance()).getUuid());
                } else {
                    throw new AssertionError();
                }
                list.add(either);
            });
            explodedMap.put(slotId, list);
        });
        NetworkManager.sendToPlayer(player, new S2CPacketDepositResult(explodedMap));
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
