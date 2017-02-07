package rr.scala.chapter2

import scala.collection.immutable.{TreeMap, TreeSet}

/**
 * 第40讲：Set、Map、TreeSet、TreeMap操作代码实战
 * Created by Limaoran on 2016/7/22.
 */
object Demo40_SetMap {
  def main(args: Array[String]) {
    val data = scala.collection.mutable.Set.empty[Int]
    data ++= List(1,2,3)
    data += 4
    data --= List(2,3)
    println(data)
    data += 1
    println(data)
    data.clear
    println(data)

    val map = scala.collection.mutable.Map.empty[String,String]
    map("Java") = "Hadoop"
    map("Scala") = "Spark"
    println(map)
    println(map("Scala"))

    val treeSet = TreeSet(9,3,1,8,0,2,7,4,6,5)
    println(treeSet)
    val treeSetForChar = TreeSet("Spark","Scala","Hadoop")
    println(treeSetForChar)

    val treeMap = TreeMap("Scala"->"Spark","Java"->"Hadoop")
    println(treeMap)
  }
}
