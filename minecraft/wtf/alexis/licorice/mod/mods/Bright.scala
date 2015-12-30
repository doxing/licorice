package wtf.alexis.licorice.mod.mods

import com.google.common.eventbus.Subscribe
import net.minecraft.potion.PotionEffect
import org.lwjgl.input.Keyboard
import wtf.alexis.licorice.events.EventOnUpdate
import wtf.alexis.licorice.mod.{ModCategory, Mod}

/**
 * Created by Sage on 09-May-15.
 */
class Bright extends Mod("Night", Keyboard.KEY_B, ModCategory.RENDER){

  //TODO: make this mod not stupid later if/when you are willing to do more than test if things work

  @Subscribe
  def onUpdate(eventOnUpdate: EventOnUpdate) = mc.thePlayer.addPotionEffect(new PotionEffect(16, Integer.MAX_VALUE))


  override def postToggle = if(!state) mc.thePlayer.removePotionEffect(16)

}
