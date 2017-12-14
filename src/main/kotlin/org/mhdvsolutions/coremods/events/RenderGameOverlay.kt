package org.mhdvsolutions.coremods.events

import net.minecraft.client.Minecraft
import net.minecraftforge.client.event.RenderGameOverlayEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import org.mhdvsolutions.coremods.CoreMod
import org.mhdvsolutions.coremods.utils.Constants.FONT_COLOR
import kotlin.math.roundToInt

class RenderGameOverlay(private val mod: CoreMod) {

    private val minecraft = Minecraft.getMinecraft()

    @SubscribeEvent
    fun onRenderGameOverlay(event: RenderGameOverlayEvent) {
        if (event.type != RenderGameOverlayEvent.ElementType.TEXT) return

        minecraft.fontRendererObj.apply {
            val verticalOffset = FONT_HEIGHT + 3
            drawString("Full Gamma: ${mod.toggleGamma}", 2, verticalOffset, FONT_COLOR)
            drawString("Sprinting: ${mod.toggleSprint}", 2, (verticalOffset * 1.83).roundToInt(), FONT_COLOR)
        }
    }

}