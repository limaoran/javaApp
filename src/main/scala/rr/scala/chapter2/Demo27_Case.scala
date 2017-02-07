package rr.scala.chapter2

/**
 * 第27讲：Type、Array、List、Tuple模式匹配实战解析
 * Created by Limaoran on 2016/7/21.
 */
object Demo27_Case {
  def main(args: Array[String]) {
    def match_type(t : Any) = t match{
      case p :Int => println("It is Integer")
      case p:String => println("It is String")
      case m:Map[_,_] => m.foreach(println)
      case _ => println("Unknow type!!!")
    }
    match_type(2)
    match_type(Map("Scala"->"Spark"))

    def match_array(arr:Any) = arr match{
      case Array(0) => println("Array"+"0")
      case Array(x,y) => println("Array"+x+" "+y)
      case Array(0,_*) => println("Array"+"0 ...")
      case _ => println("something else")
    }

    match_array(Array(0) )
    match_array(Array(0,1))
    match_array(Array(0,1,2,3,4,5))
  }
}
