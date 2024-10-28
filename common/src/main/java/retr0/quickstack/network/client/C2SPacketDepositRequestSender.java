package retr0.quickstack.network.client;

import dev.architectury.networking.NetworkManager;
import retr0.quickstack.network.C2SPacketDepositRequest;

public class C2SPacketDepositRequestSender {
    public static void send() {
        NetworkManager.sendToServer(C2SPacketDepositRequest.INSTANCE);
    }
}
