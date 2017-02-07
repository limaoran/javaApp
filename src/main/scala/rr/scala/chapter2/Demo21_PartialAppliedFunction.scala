package rr.scala.chapter2

/**
 * 第21讲：Scala中的偏函数实战详解
 * Created by Limaoran on 2016/7/20.
 */
object Demo21_PartialAppliedFunction {
  def main(args: Array[String]) {
    //偏函数代码实战
    val data = List(1,2,3,4,5,6)
    data.foreach(print _)
    data.foreach( x => print(x))

    def sum(a:Int,b:Int,c:Int) = a+b+c
    println(sum(1,2,3))

    val fp_a = sum _
    println(fp_a(1, 2, 3))
    println(fp_a.apply(1, 2, 3))
    val fp_b = sum(1, _: Int, 3)
    println(fp_b(2))
    println(fp_b(10))

    data.foreach(print _)
    data.foreach(print)
  }
}
