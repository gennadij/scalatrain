package org.scalatrain

object Time {
  def fromMinutes(minutes: Int) = {
    // TODO Check precondition
    new Time
  }
}

case class Time(hours: Int = 0, minutes: Int = 0) {
  // TODO check preconditions
  lazy val asMinutes: Int = minutes + 60 * hours
  
  def -(that: Time): Int = {
    minus(that)
  }
  
  def minus(that: Time): Int = {
    //TODO check preconditions
    this.asMinutes - that.asMinutes
  }
  
  override val toString: String = "%02d:%02d".format(hours, minutes)
}