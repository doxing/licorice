package wtf.alexis.licorice.mod

import net.minecraft.client.Minecraft
import wtf.alexis.licorice.Licorice

/**
 * Created by Sage on 09-May-15.
 */
abstract class Mod(n: String, k: Int, c: ModCategory.Category) {

  var (state, name, key, category) = (false, n, k, c)
  val mc = Minecraft.getMinecraft

  def postToggle{}

  def toggle {
    state = !state
    postToggle
  }

  Licorice.licoriceMessage("Loaded " + n)
}
