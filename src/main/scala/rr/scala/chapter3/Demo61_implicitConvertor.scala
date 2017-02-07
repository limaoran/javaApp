package rr.scala.chapter3

/**
 * 第61讲：Scala中隐式参数与隐式转换的联合使用实战详解
 * Created by Limaoran on 2016/7/23.
 */
object Demo61_implicitConvertor {
  def main(args: Array[String]) {
    //颗粒化函数，Ordered传入类型是T，说白了就是把a、b转换成Ordered[T]
    //隐式参数下的隐式转换
    def bigger[T](a: T, b: T)(implicit ordered: T => Ordered[T])
      = if (ordered(a) > b) a else b
//    = if (a > b) a else b

    println(bigger(4, 3))
    println(bigger("Spark", "Hadoop"))
  }
}
