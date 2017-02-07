package rr.scala.chapter3

import scala.collection.generic.GenericTraversableTemplate
import scala.collection.{LinearSeqOptimized, LinearSeq, AbstractSeq}
import scala.reflect.ClassTag

/**
 * 第42讲：Scala中泛型类、泛型函数、泛型在Spark中的广泛应用
 * Created by Limaoran on 2016/7/22.
 */
object Demo42_ClassTag {
  def main(args: Array[String]) {
    val triple = new Triple("Spark",3,3.1415)
    val bigData = new Triple[String,String,Char]("Spark","Hadoop",'R')

    def getData[T](list:List[T]) = list(list.length / 2)
    println(getData(List("Spark","Hadoop",'R')))
    val f = getData[Int] _
    println(f(List(1,2,3,4,5,6,7,8)))

    def buildArray[T:ClassTag](len:Int) = new Array[T](len)
    println(buildArray[Int](5).toList)
  }
  class Triple[F,S,T](val first:F,val second:S,val third:T)
  /**
   * []泛型的标志
   * +A代表：泛型的类型必须是A的子类
   *
   * ClassTag：给我们添加更多的上下文信息，在我们运行时可以根据运行时这个泛型类传递来的具体的
   *    数据来提供更多的信息的。ClassTag可以增加Runtime级别的更丰富的信息。
   */
//  sealed abstract class List[+A] extends AbstractSeq[A]
//    with LinearSeq[A] with Product with GenericTraversableTemplate[A,List]
//    with LinearSeqOptimized[A,List[A]]{}
}
