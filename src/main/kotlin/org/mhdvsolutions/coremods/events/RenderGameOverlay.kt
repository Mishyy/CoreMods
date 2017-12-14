package org.mhdvsolutions.coremods.events

import net.minecraft.client.Minecraft
import net.minecraftforge.client.event.RenderGameOverlayEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import org.mhdvsolutions.coremods.CoreMod
import org.mhdvsolutions.coremods.utils.Constants.FONT_COLOR
import org.mhdvsolutions.coremods.utils.Constants.X_OFFSET
import org.mhdvsolutions.coremods.utils.Constants.Y_OFFSET

class RenderGameOverlay(private val mod: CoreMod) {

    private val minecraft = Minecraft.getMinecraft()
    private var yOffset = Y_OFFSET

    @SubscribeEvent
    fun onRenderGameOverlay(event: RenderGameOverlayEvent) {
        if (event.type != RenderGameOverlayEvent.ElementType.TEXT) return


        minecraft.fontRendererObj.apply {
            var y = Y_OFFSET
            fun line(text: String) {
                drawString(text, X_OFFSET, y, FONT_COLOR)
                y += FONT_HEIGHT
            }

            line("Sprinting: ${mod.toggleSprint}")
            line("Sneaking: ${mod.toggleSneak}")
            line("Gamma: ${mod.toggleGamma}")
        }
    }

}