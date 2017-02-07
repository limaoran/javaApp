package rr.scala.chapter3

/**
 * 第62讲：Scala中上下文界定中的隐式参数
 * Created by Limaoran on 2016/7/23.
 */
object Demo62_Context {
  def main(args: Array[String]) {
    class Pair_Implicits[T:Ordering](val first:T , val second:T){
      def bigger( implicit ordered:Ordering[T]) =
        if(ordered.compare(first,second) >0 ) first else second
    }
    class Pair_Implicitly[T:Ordering](val first:T,val second:T){
      def bigger = if(implicitly[Ordering[T]].compare(first,second) > 0)
        first else second
    }
    class Pair_Implicitly_Ordered[T:Ordering](val first:T,val second:T){
      def bigger = {
        import Ordered._
        if(first>second) first else second
      }
    }
    println(new Pair_Implicits(7,9).bigger)
    println(new Pair_Implicitly(7,9).bigger)
    println(new Pair_Implicitly_Ordered(7,9).bigger)
  }
}
