package rr.scala.chapter2

/**
 * 第38讲：List伴生对象操作方法代码实战
 * Created by Limaoran on 2016/7/22.
 */
object Demo38_ListObject {
  def main(args: Array[String]) {
    println(List.apply(1,2,3))
    println(List.range(1,5))
    println(List.range(9,1,-3))

    val zipped = "abcde".toList zip List(1,2,3,4,5)
    println(zipped)
    println(zipped.unzip)

    //flatten把所有集合内部的元素构成一个大集合
    println(List(List('a','b'),List('c'),List('d','e')).flatten)
    println(List.concat(List(),List('b'),List('c')))  //concat把集合中所有的元素构成一个新的集合

//    println(List.map2(List(10,20),List(10,10),(_*_)))
    println(List(10,20).zip(List(10,10)).map( i=> i._1 * i._2) )
  }
}
