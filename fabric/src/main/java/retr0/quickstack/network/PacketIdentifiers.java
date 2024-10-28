package retr0.quickstack.network;

import net.minecraft.util.Identifier;
import retr0.quickstack.QuickStack;

import static retr0.quickstack.QuickStack.MOD_ID;

public abstract class PacketIdentifiers {
    public static final Identifier DEPOSIT_REQUEST_ID = QuickStack.id("request_quick_stack");
    public static final Identifier DEPOSIT_RESULT_ID = QuickStack.id("quick_stack_color_response");
    public static final Identifier TOAST_RESULT_ID = QuickStack.id("quick_stack_response");
}
