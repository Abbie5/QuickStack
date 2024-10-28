package retr0.quickstack.network.server;

import dev.architectury.networking.NetworkManager;
import retr0.quickstack.network.S2CPacketDepositResult;
import retr0.quickstack.network.S2CPacketToastResult;

public class PacketRegistry {
    public static void registerPayloadTypes() {
        NetworkManager.registerS2CPayloadType(S2CPacketToastResult.ID, S2CPacketToastResult.PACKET_CODEC);
        NetworkManager.registerS2CPayloadType(S2CPacketDepositResult.ID, S2CPacketDepositResult.PACKET_CODEC);
    }
}
