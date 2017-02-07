package rr.scala.chapter2

/**
 * 第35讲：List的map、flatMap、foreach、filter操作代码实战
 * Created by Limaoran on 2016/7/22.
 */
object Demo35_ListFunction {
  def main(args: Array[String]) {
    println(List(1,2,3,4,6) map  (_+1) )
    val data = List("Scala","Hadoop","Spark")
    println(data map (_.length))
    println(data map (_.toList.reverse.mkString))

    println(data.map(_.toList))
    println(data.flatMap(_.toList))
    println(List.range(1,10) flatMap(i=>List.range(1,i) map (j =>(i,j) ) ))

    var sum = 0
    List(1,2,3,4,5) foreach(sum+=_)
    println("sum:"+sum )

    println(List(1,2,3,4,6,7,8,9,10) filter (_%2==0))
    println(data filter (_.length == 5))
  }
}
