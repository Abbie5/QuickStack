package retr0.quickstack.network.client;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import retr0.quickstack.network.S2CPacketDepositResult;
import retr0.quickstack.network.S2CPacketToastResult;

public class PacketRegistry {
    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(S2CPacketToastResult.ID, new S2CPacketToastResultReceiver());
        ClientPlayNetworking.registerGlobalReceiver(S2CPacketDepositResult.ID, new S2CPacketDepositResultReceiver());
    }
}
