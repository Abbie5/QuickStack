package retr0.quickstack.network.client;

import dev.architectury.networking.NetworkManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.sound.SoundEvents;
import retr0.quickstack.QuickStackToast;
import retr0.quickstack.network.S2CPacketToastResult;

/**
 * Maps items to a "deposited total" along with an immutable icon for the container it was deposited into.
 */
public class S2CPacketToastResultReceiver implements NetworkManager.NetworkReceiver<S2CPacketToastResult> {
    /**
     * Shows/updates a {@link QuickStackToast} instance with the packet data on the client.
     */

    @Override
    public void receive(S2CPacketToastResult payload, NetworkManager.PacketContext context)
    {
        MinecraftClient client = MinecraftClient.getInstance();
        var totalItemsDeposited = payload.totalItemsDeposited();
        var totalContainersUsed = payload.totalContainersUsed();
        var iconMappings = payload.topDeposited();

        client.execute(() -> {
            QuickStackToast.show(client.getToastManager(), totalItemsDeposited, totalContainersUsed, iconMappings);

            var player = client.player;
            if (player == null) return;
            // Play up to a maximum of three sound instances based on deposited container counts to prevent spam.
            for (var i = 0; i < Math.min(totalContainersUsed, 3); ++i) {
                var volume = 0.5f;
                var pitch = player.getWorld().random.nextFloat() * 0.1f + 0.9f;
                player.playSound(
                    SoundEvents.BLOCK_BARREL_CLOSE, volume, pitch);
            }
        });
    }
}
