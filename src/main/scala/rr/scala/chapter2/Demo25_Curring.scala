package rr.scala.chapter2

/**
 * 第25讲：Scala中Curring实战详解（颗粒化）
 * 颗粒化是把接收多个参数的函数变换成一个单一参数的函数
 * 单一参数一般也是我们接收多个参数的第一个参数，那由于原先参数有多个参数，
 *  那我们把它变成接收单一参数的函数，所以就函数本身而言它还有其他的参数。
 *  我们会返回一个新的函数，这个新的函数是接收原先除了第一个参数以外，
 *  其余的参数而构成的函数。这在实际的开发中用的是非常的广泛地。
 *
 * 颗粒化最常见的用途：参数的推导
 * Created by Limaoran on 2016/7/21.
 */
object Demo25_Curring {
  def main(args: Array[String]) {
    def multiple(x: Int, y: Int) = x * y
    //颗粒化
    def multipleOne(x: Int) = (y: Int) => x * y
    println(multipleOne(6)(7))

    def curring(x: Int)(y: Int) = x * y
//    println(curring(10)(10))

    val a = Array("Hello","Spark")
    val b = Array("Hello","Spark")
    //判断两个集合是否内容相等
    println(a.corresponds(b)(_.equalsIgnoreCase(_)))
  }
}
