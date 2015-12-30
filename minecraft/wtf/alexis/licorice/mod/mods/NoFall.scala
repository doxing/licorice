package wtf.alexis.licorice.mod.mods

import com.google.common.eventbus.Subscribe
import org.lwjgl.input.Keyboard
import wtf.alexis.licorice.events.{EventPostUpdate, EventOnUpdate}
import wtf.alexis.licorice.mod.{ModCategory, Mod}

/**
 * Created by Sage on 31-May-15.
 */
class NoFall extends Mod("NoFall", Keyboard.KEY_N, ModCategory.PLAYER) {

  @Subscribe
  def update(event: EventOnUpdate) = if(mc.thePlayer.fallDistance >= Math.PI) mc.thePlayer.onGround = true

  @Subscribe
  def postUpdate(event: EventPostUpdate) = if(mc.thePlayer.fallDistance >= Math.PI) mc.thePlayer.onGround = false

}
