package wtf.alexis.licorice.mod.mods

import com.google.common.eventbus.Subscribe
import net.minecraft.client.Minecraft
import net.minecraft.entity.EntityLivingBase
import org.lwjgl.input.Keyboard
import wtf.alexis.licorice.events.{EventPostUpdate, EventOnUpdate}
import wtf.alexis.licorice.mod.{ModCategory, Mod}
import wtf.alexis.licorice.util.{EntityTools, Timer}

/**
 * Created by Sage on 31-May-15.
 */
class Aimbot extends Mod("Aimbot", Keyboard.KEY_C, ModCategory.COMBAT) with EntityTools {

  @Override
  override val mc = Minecraft.getMinecraft

  var target: EntityLivingBase = null
  val (timer, range, speed) = (new Timer, 4.0F, 8)

  @Subscribe
  def update(event: EventOnUpdate){
    target = getNearestValidEntity
    if(isInRange(target, range) && mc.thePlayer.canEntityBeSeen(target)){
      faceEntity(target)
    }
  }

  @Subscribe
  def postUpdate(event: EventPostUpdate){
    if(timer.timePassed >= 1000F / speed && target != null && isInRange(target, range) && mc.thePlayer.canEntityBeSeen(target)){
      mc.thePlayer.swingItem()
      mc.playerController.attackEntity(mc.thePlayer, target)
      timer.reset
    }
  }

}
