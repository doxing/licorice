package wtf.alexis.licorice.mod.mods

import com.google.common.eventbus.Subscribe
import org.lwjgl.input.Keyboard
import wtf.alexis.licorice.events.EventOnUpdate
import wtf.alexis.licorice.mod.{ModCategory, Mod}

/**
 * Created by Sage on 09-May-15.
 */
class Chameleon extends Mod("Chameleon", Keyboard.KEY_Z, ModCategory.PLAYER){

  @Subscribe
  def onUpdate(eventOnUpdate: EventOnUpdate){
    if(mc.thePlayer.moveForward == 0 && mc.thePlayer.moveStrafing == 0 && !mc.thePlayer.capabilities.isFlying)
      mc.gameSettings.keyBindSneak.pressed = true
    else if(!Keyboard.isKeyDown(mc.gameSettings.keyBindSneak.keyCode))
      mc.gameSettings.keyBindSneak.pressed = false
  }

  override def postToggle = if(!state && !Keyboard.isKeyDown(mc.gameSettings.keyBindSneak.keyCode)) mc.gameSettings.keyBindSneak.pressed = false


}
