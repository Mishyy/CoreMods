package org.mhdvsolutions.coremods.events

import net.minecraft.client.Minecraft
import net.minecraft.client.settings.KeyBinding
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent
import org.mhdvsolutions.coremods.CoreMod

class ClientTick(private val mod: CoreMod) {

    val minecraft = Minecraft.getMinecraft()

    @SubscribeEvent
    fun onClientTick(event: TickEvent.ClientTickEvent) {
        val sprintKey = minecraft.gameSettings.keyBindSprint.keyCode
        if (mod.toggleSprint) KeyBinding.setKeyBindState(sprintKey, true)
    }

}