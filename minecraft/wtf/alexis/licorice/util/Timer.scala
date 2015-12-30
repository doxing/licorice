package wtf.alexis.licorice.util

/**
 * Created by Sage on 31-May-15.
 */
class Timer {

  var last = sysTime

  def hasReach(target: Int) = timePassed >= target

  def timePassed: Long = sysTime - last

  def reset = last = sysTime

  def sysTime: Long = System.nanoTime / 1000000L

}
