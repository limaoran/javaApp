package rr.scala.chapter3

/**
 * 第52讲：Scala中路径依赖代码实战详解
 * Created by Limaoran on 2016/7/23.
 */
object Demo52_Role {
  def main(args: Array[String]) {
    class Outer{
      private val x = 10
      class Inner{
        private val y = x+10
      }
    }
    val outer = new Outer
    //Scala中构建外部类中的内部类，如果内部类是在class中声明，必须借助于外部类
    val inner = new outer.Inner
    val inner2 : outer.Inner = new outer.Inner

    val o1 = new Outer
    val o2 = new Outer
//    val i : o2.Inner = new o1.Inner //错误，这是因为路径依赖
    //Scala另外一个语法：外部类后面紧接着内部类的时候，加一个#符号
    //# 类型投影：作用和Java中的外部类.内部类是一样的意思
    val i:Outer#Inner = new o1.Inner
  }
}
