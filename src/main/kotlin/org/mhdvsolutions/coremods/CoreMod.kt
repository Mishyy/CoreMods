package org.mhdvsolutions.coremods

import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import org.mhdvsolutions.coremods.events.ClientTick
import org.mhdvsolutions.coremods.events.KeyInputHandler
import org.mhdvsolutions.coremods.events.RenderGameOverlay
import org.mhdvsolutions.coremods.keys.Keybinds
import org.mhdvsolutions.coremods.utils.Constants.MOD_ID
import org.mhdvsolutions.coremods.utils.Constants.MOD_NAME
import org.mhdvsolutions.coremods.utils.Constants.MOD_VERSION

@Mod(modid = MOD_ID, name = MOD_NAME, version = MOD_VERSION)
class CoreMod {

    var toggleSprint = false
    var toggleGamma = false
    var toggleInformation = false

    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        Keybinds.register()
    }

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        setOf(ClientTick(this), KeyInputHandler(this), RenderGameOverlay(this))
                .forEach { MinecraftForge.EVENT_BUS.register(it) }
    }

}