package org.scalatrain

object Time {
  def fromMinutes(minutes: Int) = {
    require(minutes >= 0, "minutes must not be negative")
    new Time(minutes / 60, minutes % 60)
  }
}

case class Time(hours: Int = 0, minutes: Int = 0) extends Ordered[Time] {
  require(hours >= 0, "hours must not be negative")
  require(hours < 24, "hours must be less than 24")
  require(minutes >= 0, "minutes must not be negative")
  require(minutes < 60, "minutes must be less than 60")

  lazy val asMinutes: Int = minutes + 60 * hours
  
  def -(that: Time): Int = {
    minus(that)
  }
  
  def minus(that: Time): Int = {
    require(that != null, "that must not be null")
    this.asMinutes - that.asMinutes
  }
  
  override val toString: String = "%02d:%02d".format(hours, minutes)

  override def compare(that: Time): Int = this - that
}