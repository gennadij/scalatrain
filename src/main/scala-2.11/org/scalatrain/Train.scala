package org.scalatrain

sealed abstract class TrainInfo {
  def number: String
}

case class Ice(number: String, hasWifi: Boolean = false) extends TrainInfo
case class Re(number: String) extends TrainInfo
case class Brb(number: String) extends TrainInfo

case class Train(kind: TrainInfo, schedule: Seq[(Time, Station)]) {
  require(kind != null, "kind must not be null!")
  require(schedule != null, "must not be not null")
  require(schedule.size >= 2, "must have at least two stops")

  val stations: Seq[Station] = schedule map { _._2 }
  val times: Seq[Time] = schedule map { _._1 }

  override def toString = "<Train -> Kind: " + kind + ">"
}

case class Station(name: String) {
  require(name != null, "name most be not null")
}