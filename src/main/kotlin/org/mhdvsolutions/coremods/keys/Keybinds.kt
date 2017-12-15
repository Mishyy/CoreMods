package org.mhdvsolutions.coremods.keys

import net.minecraft.client.settings.KeyBinding
import net.minecraftforge.fml.client.registry.ClientRegistry
import org.lwjgl.input.Keyboard

object Keybinds {

    val TOGGLE_SPRINT = KeyBinding("key.toggleSprint", Keyboard.KEY_Z, "key.categories.coremods")
    val TOGGLE_GAMMA = KeyBinding("key.toggleGamma", Keyboard.KEY_X, "key.categories.coremods")
    val TOGGLE_INFORMATION = KeyBinding("key.toggleInformation", Keyboard.KEY_C, "key.categories.coremods")

    fun register() {
        setOf(TOGGLE_SPRINT, TOGGLE_GAMMA, TOGGLE_INFORMATION).forEach { ClientRegistry.registerKeyBinding(it) }
    }

}