package retr0.quickstack.network.client;

import dev.architectury.networking.NetworkManager;
import retr0.quickstack.network.S2CPacketDepositResult;
import retr0.quickstack.network.S2CPacketToastResult;

public class PacketRegistry {
    public static void registerS2CPackets() {
        NetworkManager.registerReceiver(NetworkManager.Side.S2C, S2CPacketToastResult.ID, S2CPacketToastResult.PACKET_CODEC, new S2CPacketToastResultReceiver());
        NetworkManager.registerReceiver(NetworkManager.Side.S2C, S2CPacketDepositResult.ID, S2CPacketDepositResult.PACKET_CODEC, new S2CPacketDepositResultReceiver());
    }
}
