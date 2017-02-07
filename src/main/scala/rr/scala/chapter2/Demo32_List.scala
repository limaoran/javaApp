package rr.scala.chapter2

/**
 * 第32讲：List的基本操作实战与基于模式匹配的List排序算法实现
 * Created by Limaoran on 2016/7/21.
 */
object Demo32_List {
  def main(args: Array[String]) {
    //List的基本操作实战
    val bigData = List("Hadoop","Spark")
    val data = List(1,2,3)

    val bigData_Core = "Hadoop" :: ("Spark" ::Nil)
    val data_Int = 1 :: 2 :: 3 :: Nil //::是右结合的

    println(data.isEmpty)
    println(data.head)
    println(data.tail.head)

    val List(a,b) = bigData
    println("a:"+a +"===b:"+b)
    val x::y::rest = data
    println("x:"+x+"===y:"+y+"==="+rest)

    //基于模式匹配的List排序算法实现
    val shuffledData = List(6,3,5,6,2,9,1)
    println(sortList(shuffledData))
  }
  def compute(data:Int, dataSet:List[Int]):List[Int] = dataSet match{
    case List() => List(data)
    case head::tail => if(data<head) data::dataSet
      else head :: compute(data,tail)
  }
  def sortList(list:List[Int]):List[Int] = list match {
    case List( ) => List()
    case head :: tail => compute(head,sortList(tail))
  }
}
