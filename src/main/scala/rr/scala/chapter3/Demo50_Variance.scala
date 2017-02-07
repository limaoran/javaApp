package rr.scala.chapter3

/**
 * 第50讲：Scala中Variance变化点及其在Spark中的应用源码解析
 * Created by Limaoran on 2016/7/23.
 */
object Demo50_Variance {
  def main(args: Array[String]) {
    class P[+T](val first:T,val second:T){
      def replaceFirst[R>:T](newFirst:R) = new P[R](newFirst,second ) //>: 形变点
    }
  }
}
