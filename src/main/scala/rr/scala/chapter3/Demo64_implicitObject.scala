package rr.scala.chapter3

/**
 * 第64讲：Scala中隐式对象代码实战详解
 * Created by Limaoran on 2016/7/23.
 */
object Demo64_implicitObject {
  def main(args: Array[String]) {
    abstract class Template[A]{
      def add(x:A,y:A) : A
    }
    abstract class SubTemplate[A] extends Template[A]{
      def unit : A
    }
    implicit object StringAdd extends SubTemplate[String]{
      def add(x:String,y:String):String = x concat(y)
      def unit:String = ""
    }
    implicit object IntAdd extends SubTemplate[Int]{
      def add(x:Int,y:Int):Int = x+y
      def unit:Int = 0
    }
    def sum[A](xs:List[A])(implicit m:SubTemplate[A]):A={
      if(xs.isEmpty) m.unit
      else m.add(xs.head,sum(xs.tail))
    }
    println(sum(List(1,2,3)))
    println(sum(List("a","b","c")))
  }
}
