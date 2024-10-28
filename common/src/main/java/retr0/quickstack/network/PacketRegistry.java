package retr0.quickstack.network;


import dev.architectury.networking.NetworkManager;

public class PacketRegistry {
    public static void registerC2SPackets() {
        NetworkManager.registerReceiver(NetworkManager.Side.C2S, C2SPacketDepositRequest.ID, C2SPacketDepositRequest.PACKET_CODEC, C2SPacketDepositRequest::receive);
    }
}
