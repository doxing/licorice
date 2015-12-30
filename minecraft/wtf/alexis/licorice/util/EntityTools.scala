package wtf.alexis.licorice.util

import net.minecraft.client.Minecraft
import net.minecraft.entity.{Entity, EntityLivingBase}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.MathHelper
import collection.JavaConversions._

/**
 * Created by Sage on 31-May-15.
 */
trait EntityTools {

  val mc = Minecraft.getMinecraft

  def getNearestValidEntity: EntityLivingBase ={
    var closest: EntityLivingBase = null
    for(ent <- mc.theWorld.loadedEntityList)
      if(ent.isInstanceOf[EntityLivingBase]){
        val eL = ent.asInstanceOf[EntityLivingBase]
        if(eL != mc.thePlayer && eL != null && eL.isEntityAlive){
          if(closest != null){
            if(closer(closest, eL)) closest = eL
          }else{
            closest = eL
          }
        }
      }
    return closest
  }

  def faceEntity(ent: EntityLivingBase){
    val rotations = getRotations(ent)
    if(rotations != null){
      mc.thePlayer.rotationYaw = rotations(0)
      mc.thePlayer.rotationPitch = rotations(1) + 14F
    }
  }

  def getRotations(ent: EntityLivingBase): Array[Float] ={
    val x = ent.posX - mc.thePlayer.posX
    val y = ent.posY + ent.getEyeHeight - (mc.thePlayer.posY + mc.thePlayer.getEyeHeight)
    val z = ent.posZ - mc.thePlayer.posZ
    val dist = MathHelper.sqrt_double(x * x + z * z)
    val yaw = ((Math.atan2(z, x) * 180D / Math.PI) - 90).toFloat
    val pitch = -(Math.atan2(y, dist) * 180D / Math.PI).toFloat
    Array(yaw, pitch)
  }

  def closer(e1: EntityLivingBase, e2: EntityLivingBase) = mc.thePlayer.getDistanceToEntity(e2) < mc.thePlayer.getDistanceToEntity(e1)

  def isInRange(ent: EntityLivingBase, dist: Float) = mc.thePlayer.getDistanceToEntity(ent) <= dist

}
