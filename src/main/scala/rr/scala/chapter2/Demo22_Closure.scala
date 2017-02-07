package rr.scala.chapter2

/**
 * 第22讲：Scala中的闭包实战详解
 * Created by Limaoran on 2016/7/20.
 */
object Demo22_Closure {
  def main(args: Array[String]) {
    //闭包代码实战
    val data = List(1,2,3,4,5,6)
    var sum = 0
    data.foreach(sum += _)
    println(sum)

    def add(more:Int) = (x:Int) => x+more
    val a = add(1)
    val b = add(9999)
    println(a(10))
    println(b(10))
  }
}
