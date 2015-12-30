package wtf.alexis.licorice

import com.google.common.eventbus.{EventBus, Subscribe}
import wtf.alexis.licorice.events.EventStart
import wtf.alexis.licorice.mod.ModManager
import wtf.alexis.licorice.ui.Overlay

object Licorice {

  private val (name, ver, release) = ("Licorice", 1.0, "alpha")
  val eventBus = new EventBus

  val modManager = new ModManager
  val overlay = new Overlay

  def licoriceMessage(message: String) = println("[LICORICE] " + message)


  def getTitle = name + " v" + ver + " " + release


}