package rr.scala.chapter2

/**
 * 第41讲：List继承体系实现内幕和方法操作源码揭秘
 * Created by Limaoran on 2016/7/22.
 */
object Demo41_List {
  def main(args: Array[String]) {
    //sealed用在模式匹配中
    val list :List[Int] = List(1,2,3,4,5)
    val listAny : List[Any] = list
    println(list.isEmpty)
    println(list.head)
    println(list.tail)
    println(list.length)
    println(list.drop(2))
    list.map( _* 2)
  }
}
