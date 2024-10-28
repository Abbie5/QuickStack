package retr0.quickstack.network.client;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import retr0.quickstack.network.C2SPacketDepositRequest;

public class C2SPacketDepositRequestSender {
    public static void send() {
        ClientPlayNetworking.send(C2SPacketDepositRequest.INSTANCE);
    }
}
