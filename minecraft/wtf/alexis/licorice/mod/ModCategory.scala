package wtf.alexis.licorice.mod

/**
 * Created by Sage on 09-May-15.
 */
object ModCategory {

  sealed abstract class Category(n: String, c: Int){
    val (name, color) = (n, c)
  }

  case object PLAYER extends Category("Player", 0x48A9C7)
  case object COMBAT extends Category("Combat", 0xB034FD)
  case object MOVEMENT extends Category("Movement", 0xFF3333)
  case object WORLD extends Category("World", 0xD6D6D6)
  case object RENDER extends Category("Render", 0x7C6BE8)
  case object MISC extends Category("Other", 0xFFFFFF)

  val categories = Seq(PLAYER, COMBAT, MOVEMENT, WORLD, RENDER, MISC)

}
