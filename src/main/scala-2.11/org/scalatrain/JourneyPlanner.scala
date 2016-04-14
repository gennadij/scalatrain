package org.scalatrain

import org.log.Logging

class JourneyPlanner(trains: Set[Train]) extends Logging{
  require(trains != null, "must not be null")
  logger.debug("Initalized with the foloowing %s trains:\n%s".format(trains.size, trains))

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