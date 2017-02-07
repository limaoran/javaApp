package rr.scala.chapter3

/**
 * 第43讲：Scala中类型变量Bounds代码实战
 * Created by Limaoran on 2016/7/22.
 * <:（上界）表明泛型类型是谁的子类，例如[T <: Comparable]，T必须是Comparable或它的子类
 * >:（下界）表明泛型类型是谁的父类，例如[R>:T]，R就是T的父类
 */
object Demo43_Bound {
  def main(args: Array[String]) {
    val pair = new Pair("Spark","Hadoop")
    println(pair.bigger)
  }
  //class Pair[T](val first:T,val second:T) //普通泛型
  //指定T必须要是Comparable的子类，具有compareTo方法
  class Pair[T <: Comparable[T ]](val first:T,val second:T){
    //求出两个对象那个更大
    def bigger = if(first.compareTo(second)>0) first else second
  }
  class Pair_Lower_Bound[T](val first:T,val second:T){
    //>: 表明R是T的父类，也就是说T一定是R的子类。
    // 从R的角度来看，T的类型就是R的下界；从T的角度来看的话，T的类型就是R的上界，叫做类型变量界定
    //说白了，就是 T<:R，T是子类，R是父类；T>:R，T是父类，R是子类
    def replaceFirst[R>:T](newFirst:R) = new Pair_Lower_Bound[R](newFirst,second )
  }

}
