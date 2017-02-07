package rr.scala.chapter4

/**
 * 第77讲：模式匹配下的提取器动手构造实战
 * Created by Limaoran on 2016/7/23.
 */
object Demo77_Extractor {
  def main(args: Array[String]) {
    object :> { //:> 有一个: 代表是右结合的
      //提取器最重要的方法unapply
      def unapply[A](list:List[A]) = {
        //init 最后一个元素以外的所有元素
        Some( (list.init,list.last))
      }
    }
    (1 to 9).toList match {
        //这里通过提取器进行匹配，(List(1,2,8),9)
      case _ :> 9 => println("Hadoop")  //最后一个元素是9
    }
    (1 to 9).toList match{
      case x :> 8 :> 9 => println("Spark")  //这里结果是 先匹配List(1,2,8),9，在匹配List(1,2,7),8
    }
    (1 to 9).toList match{
      case :>(:>(_,8),9) => println("Flink")  //可以加括号来匹配参数
    }
  }
}
