package rr.scala.chapter3

/**
 * 第47讲：Scala多重界定代码实战及其在Spark中的应用源码解析
 * Created by Limaoran on 2016/7/23.
 * T <: A with B  T是A或B的子类
 * T >: A with B T是A或B的父类
 * T >: A <:B     T的下界是A，上界是B，即T是A的父类，B的子类，那么A也是B的子类
 * T : A : B      上下文界定：T必须同时满足A和B的类型
 * T <% A <% B    视图界定：T可以有多个视图界定，可以被隐式转换成A或B
 * T不可以有多个上界和下界（下界必须写在前面，上界必须写在后面），但是T可以有多个上界或者多个下界
 */
object Demo47_MultiBounds {
  def main(args: Array[String]) {
    class M_A[T]{println("convert to M_A")}
    class M_B[T]{println("convert to M_B")}
    implicit val a = new M_A[Int] //隐式的表达式，会被Scala编译器隐式的使用
    implicit val b = new M_B[Int] //这里把Int转换隐式转换成M_B
    //T 必须同时是M_A和M_B类型的
    def foo[T : M_A:M_B](i:T) = println("OK")
    foo(2)
  }
}
