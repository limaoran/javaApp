package rr.scala.chapter3

/**
 * 第56讲：Scala中Self Types实战详解
 * Created by Limaoran on 2016/7/23.
 * Self Type 自身类型
 */
object Demo56_SelfTypes {
  def main(args: Array[String]) {
    class Self{
      self => //self是this的别名
      val tmp = "Scala"
      def foo = self.tmp + this.tmp
    }
    trait S1
    class S2{this:S1=>}
    class S3 extends S2 with S1

    trait T{this:S1 => }
    object S4 extends T with S1

    class Outer{ outer =>
      val v1 = "Spark"
      class Inner{
        println(outer.v1)
      }
    }
    val c = new S2 with S1
  }
}
