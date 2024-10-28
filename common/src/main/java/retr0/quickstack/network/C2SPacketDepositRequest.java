package retr0.quickstack.network;

import dev.architectury.networking.NetworkManager;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.server.network.ServerPlayerEntity;
import retr0.quickstack.QuickStack;
import retr0.quickstack.util.QuickStackManager;

public class C2SPacketDepositRequest implements CustomPayload {
    public static final Id<C2SPacketDepositRequest> ID = new Id<>(QuickStack.id("request_quick_stack"));
    public static final C2SPacketDepositRequest INSTANCE = new C2SPacketDepositRequest();
    public static final PacketCodec<RegistryByteBuf, C2SPacketDepositRequest> PACKET_CODEC = PacketCodec.unit(INSTANCE);

    /**
     * Executes a quick stack operation for the sender player.
     */
    public static void receive(
            C2SPacketDepositRequest payload, NetworkManager.PacketContext context)
    {
        QuickStackManager.getInstance().quickStack(
                (ServerPlayerEntity) context.getPlayer(), QuickStack.CONFIG.containerSearchRadius, QuickStack.CONFIG.allowHotbarQuickStack);
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
