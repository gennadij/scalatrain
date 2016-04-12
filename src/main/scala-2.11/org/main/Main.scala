package org.main

import org.scalatrain._

object Main {
  
  def main(args: Array[String]) = {
    
    val st1 = new Station("Weinagrten")
    val st2 = new Station("Ravensburg")
    val t1 = Time(12, 30)
    val t2 = Time(12,45)
    val schedule1 = List(
        (t1, st1), 
        (t2, st2)
    )
    
    val train1 = new Train(TrainKind.Ice, "12", schedule1)
    
    val t3 = Time(14, 30)
    val t4 = Time(14,45)
    val t5 = Time(15,55)
    val st3 = new Station("Baindt")
    val st4 = new Station("Wolpertswende")
    val st5 = new Station("Bainfurt")
    val schedule2 = List(
        (t3, st3), 
        (t4, st4),
        (t5, st5)
    )
    
    val train2 = new Train(TrainKind.Re, "13", schedule2)
    
    val t6 = Time(9, 15)
    val t7 = Time(10,0)
    val t8 = Time(10,30)
    val st6 = new Station("Mochenwangen")
    val st7 = new Station("Wangen")
    val st8 = new Station("Friedrichshafen")
    val schedule3 = List(
        (t6, st6), 
        (t7, st7),
        (t8, st8)
    )
    
    val train3 = new Train(TrainKind.Brb, "13", schedule3)
    
    println(train1.stations)
    println(train1.times)
    
    val journeyPlanner = new JourneyPlanner(Set(train1, train2, train3))
    
    println("Stations:  " + journeyPlanner.stations)
    
    println("Trains: " + journeyPlanner.trains(st1) )
    
    println("Departures: " + journeyPlanner.departures(st3))
    
    println("END")
  }
}