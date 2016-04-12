package org.scalatrain

case class Train(kind: TrainKind.Value, number: String, schedule: Seq[(Time, Station)]) {
  require(kind != null, "kind must not be null!")
  require(number != null, "number must not be null!")
  require(schedule != null, "must not be not null")
  require(schedule.size >= 2, "must have at least two stops")
  
  val stations: Seq[Station] = schedule map { _._2 }
  val times: Seq[Time] = schedule map { _._1 }
  
  override def toString = "<Train -> Kind: " + kind + ", " + number + ">"
}

case class Station(name: String) {
  require(name != null, "name most be not null")
}

object TrainKind extends Enumeration {
  val Ice = Value("ICE")
  val Re = Value("RE")
  val Brb = Value("RBR")
}