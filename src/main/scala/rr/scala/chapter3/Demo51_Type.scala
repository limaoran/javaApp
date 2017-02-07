package rr.scala.chapter3

/**
 * 第51讲：Scala中链式调用风格的实现代码实战
 * Created by Limaoran on 2016/7/23.
 */
object Demo51_Type {
  def main(args: Array[String]) {
    class Animal{def breathe:this.type = this}
    class Cat extends Animal{def eat:this.type = this}

    val cat = new Cat
    println(cat.breathe.eat)
  }
}
