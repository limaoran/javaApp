package rr.scala.chapter3

/**
 * 第54讲：Scala中复合类型实战详解
 * Created by Limaoran on 2016/7/23.
 */
object Demo54_Multi {
  def main(args: Array[String]) {
    trait Type1
    trait Type2
    class CType extends Type1 with Type2

    def compound_Type(x: Type1 with Type2) = {println("Compound Type in global method")}
    compound_Type(new Type1 with Type2)
    object TypeObject extends Type1 with Type2
    compound_Type(TypeObject)

    type TypeAlias = Type1 with Type2
    def TypeLocal(x:TypeAlias) = println("Compound Type in local method")
    val TypeClass = new CType
    TypeLocal(TypeClass)

    //定义一个别名
    type Scala = Type1 with Type2{def init():Unit}
  }
}
