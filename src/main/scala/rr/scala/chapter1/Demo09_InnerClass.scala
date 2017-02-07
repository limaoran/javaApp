package rr.scala.chapter1

/**
 * 第9讲：Scala的内部类实战详解
 * Created by Limaoran on 2016/7/20.
 */
object Demo09_InnerClass {
  def main(args: Array[String]) {
    val outer1 = new Outer("Spark")
    val outer2 = new Outer("Hadoop")
    val inner1 = new outer1.Inner("Scala")
    val inner2 = new outer2.Inner("Java")
    inner1.foo(inner1)
    inner2.foo(inner2)
  }
  class Outer(val name:String){ outer=>
    class Inner(val name:String){
      def foo(b:Inner) = println("Outer:"+outer.name + ",Inner:"+b.name)
    }
  }
}
