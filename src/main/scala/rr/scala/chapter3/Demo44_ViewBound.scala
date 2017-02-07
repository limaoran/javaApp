package rr.scala.chapter3

/**
 * 第44讲：Scala中View Bounds代码实战及其在Spark中的应用源码解析
 * Created by Limaoran on 2016/7/23.
 * <%（视图界定，<:改为<%的学术名称就叫视图界定）它具体是指我们可以把传入的T类型的实例转换成指定的类型
 *  如果指定的类型不是T的父类的话，用视图界定，它会隐式的转换成指定类型的类型（内部有隐式转换）。
 */
object Demo44_ViewBound {
  def main(args: Array[String]) {
    val pair = new Pair_NotPerfect("Spark","Hadoop")
    println(pair.bigger)

    val pairInt = new Pair_NotPerfect(3,5)  //Int -> RichInt ， RichInt 是Comparable的子类，Int是RichInt的上限，
    println(pairInt.bigger)

    val pair_Better_String = new Pair_Better("Java","Scala")  //String->RickString
    println(pair_Better_String.bigger)

    val pair_Better_Int = new Pair_Better(20,12)
    println(pair_Better_Int.bigger)
  }
//  class Pair_NotPerfect[T <: Comparable[T]](val first:T,val second:T ){
//    def bigger = if(first.compareTo(second) >0 ) first else second
//  }
  class Pair_NotPerfect[T <% Comparable[T]](val first:T,val second:T ){
    def bigger = if(first.compareTo(second) > 0) first else second
  }
  //T如果是能够被视图界定为Ordered的T话，我们就可以使用Order的T的<或>，也就是说Order的T在Comparable T的基础上提供了一些关系操作符
  class Pair_Better[T <% Ordered[T]](val first:T,val second:T ){
    def bigger = if(first > second ) first else second
  }
}
