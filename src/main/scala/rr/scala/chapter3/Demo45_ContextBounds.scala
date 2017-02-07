package rr.scala.chapter3

/**
 * 第45讲：Scala中Context Bounds代码实战及其在Spark中的应用源码解析
 * Created by Limaoran on 2016/7/23.
 */
object Demo45_ContextBounds {
  def main(args: Array[String]) {
    val pair = new Pair_Ordering("Spark","Hadoop")
    println(pair.bigger)

    val pairInt = new Pair_Ordering(3,5)
    println(pairInt.bigger)
  }
  //T:Ordering 存在一个隐式的值，这个值就是Ordering中括号里面是T
  class Pair_Ordering[T:Ordering] (val first : T,val second:T) {
    def bigger(implicit ordered:Ordering[T]) = {
      if(ordered.compare(first,second)>0) first else second
    }
  }
}
