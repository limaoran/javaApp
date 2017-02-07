package rr.scala.chapter4

/**
 * 第82讲：Scala中List的ListBuffer是如何实现高效的遍历计算的？
 * Created by Limaoran on 2016/7/24.
 */
object Demo82_ListBuffer {
  def main(args: Array[String]) {
    def increment(list:List[Int]):List[Int] = list match{
      case List() => List()
      case head::tail => head +1 :: increment(tail)
    }
    def incrementMoreEffective(list:List[Int]):List[Int] = {
      var result = List[Int] ()
      for(element <- list) result = result ::: List(element+1)
      result
    }
    def incrementMostEfefective(list:List[Int]):List[Int] = {
      import scala.collection.mutable.ListBuffer
      var buffer = new ListBuffer[Int]
      for(element<- list) buffer += element+1
      buffer.toList
    }
    //List和java中的String一样，构建改变是产生大量中间对象，推荐使用ListBuffer
    val list = List(1,2,3,4,5,6,7,8,9)
    println(increment(list))
    println(incrementMostEfefective(list) )
    println(incrementMoreEffective(list) )
  }
}
