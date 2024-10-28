package retr0.quickstack.network;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class PacketRegistry {
    public static void registerPayloadTypes() {
        PayloadTypeRegistry.playC2S().register(C2SPacketDepositRequest.ID, C2SPacketDepositRequest.PACKET_CODEC);
        PayloadTypeRegistry.playS2C().register(S2CPacketToastResult.ID, S2CPacketToastResult.PACKET_CODEC);
        PayloadTypeRegistry.playS2C().register(S2CPacketDepositResult.ID, S2CPacketDepositResult.PACKET_CODEC);
    }

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(C2SPacketDepositRequest.ID, C2SPacketDepositRequest::receive);
    }
}
