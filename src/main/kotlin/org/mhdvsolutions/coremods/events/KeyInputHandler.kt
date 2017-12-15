package org.mhdvsolutions.coremods.events

import net.minecraft.client.Minecraft
import net.minecraft.client.settings.KeyBinding
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.InputEvent
import org.lwjgl.input.Keyboard
import org.mhdvsolutions.coremods.CoreMod
import org.mhdvsolutions.coremods.keys.Keybinds

class KeyInputHandler(private val mod: CoreMod) {

    private val minecraft = Minecraft.getMinecraft()

    @SubscribeEvent
    fun onKeyInput(event: InputEvent.KeyInputEvent) {
        if (Keybinds.TOGGLE_SPRINT.isPressed) toggleSprint()
        if (Keybinds.TOGGLE_GAMMA.isPressed) toggleGamma()
        if (Keybinds.TOGGLE_INFORMATION.isPressed) toggleInformation()
    }

    private fun toggleSprint() {
        val key = minecraft.gameSettings.keyBindSprint.keyCode

        mod.toggleSprint = !mod.toggleSprint
        if (!mod.toggleSprint && key > 0) KeyBinding.setKeyBindState(key, Keyboard.isKeyDown(key))
    }

    private fun toggleGamma() {
        mod.toggleGamma = !mod.toggleGamma
        minecraft.gameSettings.gammaSetting = if (mod.toggleGamma) 10f else 1f
    }

    private fun toggleInformation() {
        mod.toggleInformation = !mod.toggleInformation
    }

}