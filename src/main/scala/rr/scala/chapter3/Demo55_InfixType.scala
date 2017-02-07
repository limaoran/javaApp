package rr.scala.chapter3

/**
 * 第55讲：Scala中Infix Type实战详解
 * Created by Limaoran on 2016/7/23.
 * Infix Type 中置类型，是允许我们带有两个参数的类型
 */
object Demo55_InfixType {
  def main(args: Array[String]) {
    object Log{
      def >>: (data:String):Log.type = {println(data);Log}
    }
    "Hadoop" >>: "Spark" >>: Log //右结合

    val list = List()
    val newList = "A"::"B"::list
    println(newList )

    class InfixType[A,B]
    //这里表明 A为Int 中置类型为InfixType B类型为String
    val infix : Int InfixType String = null

    case class Cons(first:String,second:String)
    val caseClass = Cons("one","two")
    caseClass match{
      case "one" Cons "two" => println("Spark!")  //unapply
    }
  }
}
