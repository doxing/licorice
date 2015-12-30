package wtf.alexis.licorice.mod.mods

import com.google.common.eventbus.Subscribe
import org.lwjgl.input.Keyboard
import wtf.alexis.licorice.events.EventOnUpdate
import wtf.alexis.licorice.mod.{ModCategory, Mod}

/**
 * Created by Sage on 02-Jun-15.
 */
class Flight extends Mod("Flight", Keyboard.KEY_R, ModCategory.MOVEMENT) {

  @Subscribe
  def onUpdate(event: EventOnUpdate) = mc.thePlayer.capabilities.isFlying = true

  @Override
  override def postToggle() = mc.thePlayer.capabilities.isFlying = false

}
