package org.scalatrain

class JourneyPlanner(trains: Set[Train]) {
  require(trains != null, "must not be null")
  
  val stations: Set[Station] = 
    trains flatMap { _.stations }
  
  def trains(station: Station): Set[Train] = {
    require(station != null, "must not be null")
    
    trains filter { _.stations contains station }
  }
  
  def departures(station: Station): Set[(Time, Train)] = {
    require(station != null, "must be not null")
      
    for {
      train <- trains
      timeAndStation <- train.schedule if (timeAndStation._2 == station)
    } yield timeAndStation._1 -> train
  }
}