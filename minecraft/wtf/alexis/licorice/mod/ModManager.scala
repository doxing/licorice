package wtf.alexis.licorice.mod

import com.google.common.eventbus.Subscribe
import org.lwjgl.input.Keyboard
import wtf.alexis.licorice.events.{EventKeyPress, EventStart}
import wtf.alexis.licorice.mod.mods._
import scala.collection.mutable.{ArrayBuffer, MutableList}
import wtf.alexis.licorice.Licorice

/**
 * Created by Sage on 09-May-15.
 */
class ModManager {

  Licorice.eventBus.register(this)

  val mods = List(new Bright, new Speed, new Chameleon, new Aimbot, new NoFall, new Flight)
  val enabledMods = ArrayBuffer[Mod]()

  @Subscribe
  def things(eventStart: EventStart) = for(m <- mods) if(m.state) enabledMods += m

  @Subscribe
  def checkForToggle(eventKeyPress: EventKeyPress){
    for(m <- mods){
      if(Keyboard.isKeyDown(m.key)){
        m.toggle
        if(m.state){
          enabledMods += m
          Licorice.eventBus.register(m)
        }else{
          enabledMods -= m
          Licorice.eventBus.unregister(m)
        }
      }
    }
  }

}
