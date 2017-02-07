package rr.scala.chapter2

/**
 * 第30讲：模式匹配高级实战：嵌套的Case class
 * Created by Limaoran on 2016/7/21.
 */
object Demo30_Match {
  abstract class Item
  case class Book(description:String,price:Double,items:Item *) extends Item
  case class Bundle(descriptioin:String,price:Double,item:Item *) extends Item
  def main(args: Array[String]) {
    //嵌套的Case class
    //Case object
    def caseclass_nested(person:Item) = person match{
//      case Bundle(_,_,art@Book(_,_),rest @ _* ) => println(art.description+" : " +art.price)
      case Bundle(_,_,Book(desc,_),_*) => println("The first description is "+desc)
      case _ => println("Oops!")
    }
    caseclass_nested(Bundle("1111 Special's",30.0,
      Book("Scala for the Spark Developer",69.95), Bundle("Hadoop",40.0,Book("Hive",79.95),Book("HBase",32.95))))
    caseclass_nested(Bundle("1212 Special's",35.0,Book("Spark for the Impatient",39.95)))
  }

}
