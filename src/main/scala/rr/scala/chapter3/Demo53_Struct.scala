package rr.scala.chapter3

/**
 * 第53讲：Scala中结构类型实战详解
 * Created by Limaoran on 2016/7/23.
 */
object Demo53_Struct {
  def init(res:{def open():Unit}){
    res.open
  }
  def main(args: Array[String]) {
    class Structural{def open() = println("A class instance Opened")}
    init(new {def open() = println("Opened")})
    type X = {def open():Unit}
    def init(res:X) = res.open()
    init(new {def open() = println("Opened again")})

    object A {def open(){println("A single object Opened")}}
    init(A)
    val structural = new Structural
    init(structural)
  }
}
