package retr0.quickstack.network;


import dev.architectury.networking.NetworkManager;

public class PacketRegistry {
    public static void registerPayloadTypes() {
        NetworkManager.registerS2CPayloadType(S2CPacketToastResult.ID, S2CPacketToastResult.PACKET_CODEC);
        NetworkManager.registerS2CPayloadType(S2CPacketDepositResult.ID, S2CPacketDepositResult.PACKET_CODEC);
    }

    public static void registerC2SPackets() {
        NetworkManager.registerReceiver(NetworkManager.Side.C2S, C2SPacketDepositRequest.ID, C2SPacketDepositRequest.PACKET_CODEC, C2SPacketDepositRequest::receive);
    }
}
