package wtf.alexis.licorice.ui

import com.google.common.eventbus.Subscribe
import net.minecraft.client.Minecraft
import wtf.alexis.licorice.Licorice
import wtf.alexis.licorice.events.EventOverlay

/**
 * Created by Sage on 09-May-15.
 */
class Overlay {

  Licorice.eventBus.register(this)

  val mc = Minecraft.getMinecraft

  @Subscribe
  def overlay(event: EventOverlay){
    if(mc.gameSettings.showDebugInfo) return
    var (y, fr) = (2, mc.fontRendererObj)
    for(m <- Licorice.modManager.enabledMods){
      fr.drawStringWithLightShadow(m.name, 2, y, m.category.color)
      y += 10
    }
  }

}
