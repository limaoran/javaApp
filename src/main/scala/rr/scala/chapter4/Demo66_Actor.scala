package rr.scala.chapter4

import scala.actors.Actor

/**
 * 第66讲：Scala并发编程实战初体验
 * Created by Limaoran on 2016/7/23.
 */
object Demo66_Actor {
  def main(args: Array[String]) {
    FirstActor.start()
    SecondActor.start()
  }
}
object FirstActor extends Actor{
  def act(): Unit ={
    for(i <- 1 to 10){
      println("Step:"+i )
      Thread.sleep(2000)
    }
  }
}
object SecondActor extends Actor{
  def act(): Unit ={
    for(i <- 1 to 10){
      println("Step Further:"+i)
      Thread.sleep(2000)
    }
  }
}
