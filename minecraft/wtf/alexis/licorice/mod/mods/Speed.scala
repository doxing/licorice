package wtf.alexis.licorice.mod.mods

import com.google.common.eventbus.Subscribe
import org.lwjgl.input.Keyboard
import wtf.alexis.licorice.events.EventOnUpdate
import wtf.alexis.licorice.mod.{ModCategory, Mod}

/**
 * Created by Sage on 09-May-15.
 */
class Speed extends Mod("Sprint", Keyboard.KEY_F, ModCategory.MOVEMENT) {

  @Subscribe
  def onUpdate(eventOnUpdate: EventOnUpdate) = mc.thePlayer.setSprinting(canSprint)

  def canSprint = mc.thePlayer.moveForward > 0.0F && mc.thePlayer.getFoodStats.getFoodLevel > 6 && !mc.thePlayer.isCollidedHorizontally && !mc.thePlayer.isSneaking && !mc.thePlayer.isInWater

}
