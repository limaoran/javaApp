package rr.scala.chapter3

/**
 * 第60讲：Scala中隐式参数实战详解
 * Created by Limaoran on 2016/7/23.
 */
object Demo60_implicitParam {
  def main(args: Array[String]) {
    object Context_Implicits{
      implicit val default:String = "Java"
    }
    object Param{
      def print(content:String)(implicit language:String): Unit ={
        println(language + ":"+content)
      }
    }
    Param.print("Spark")("Scala")

//    Param.print("Hadoop") //报错
    import Context_Implicits._
    Param.print("Hadoop")
  }
}
