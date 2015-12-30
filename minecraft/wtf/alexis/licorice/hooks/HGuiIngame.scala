package wtf.alexis.licorice.hooks

import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiIngame
import wtf.alexis.licorice.Licorice
import wtf.alexis.licorice.events.EventOverlay

/**
 * Created by Sage on 09-May-15.
 */
class HGuiIngame(minecraft: Minecraft) extends GuiIngame(minecraft){

  override def func_175180_a(idkWhatThisDoes: Float){
    super.func_175180_a(idkWhatThisDoes)
    Licorice.eventBus.post(new EventOverlay)
  }

}
