package rr.scala.chapter2

/**
 * 第33讲：List的一阶函数操作代码实战详解
 * 一阶函数：操作的参数不是函数
 * 高阶函数：操作的参数是函数
 * Created by Limaoran on 2016/7/21.
 */
object Demo33_ListFunction1 {
  def main(args: Array[String]) {
    //List一阶函数
    println(List(1,2,3,4) ::: List(4,5,6,7,8) ::: List(10,11))  //List(1, 2, 3, 4, 4, 5, 6, 7, 8, 10, 11)
    println(List(1,2,3,4) :::( List(4,5,6,7,8) ::: List(10,11 ))) //List(1, 2, 3, 4, 4, 5, 6, 7, 8, 10, 11)
    //从数组的考量，应该用List.isEmpty 来判断是否为空，不应该用length=0
    val bigData = List("Hadoop","Spark","Kafka")
    println(bigData.last) //Kafka
    println(bigData.init) //List(Hadoop, Spark)
    println(bigData.reverse)  //List(Kafka, Spark, Hadoop)
    println(bigData)        //List(Hadoop, Spark, Kafka)
    println(bigData take 2) //List(Hadoop, Spark)
    println(bigData drop 2) //List(Kafka)
    println(bigData splitAt(2)) //(List(Hadoop, Spark),List(Kafka))
    println(bigData apply 2)  //Kafka
    println(bigData(2))   //Kafka

    val data = List('a','b','c','d','e','f')
    println(data.indices)           //Range(0, 1, 2, 3, 4, 5)
    println(data.indices zip data ) //Vector((0,a), (1,b), (2,c), (3,d), (4,e), (5,f))
    println(data.zipWithIndex)    //List((a,0), (b,1), (c,2), (d,3), (e,4), (f,5))
    println(data.toString())      //List(a, b, c, d, e, f)
    println(data.mkString("[",",","]")) //[a,b,c,d,e,f]
    println(data.mkString("  "))    //a  b  c  d  e  f
    println(data.mkString)          //abcdef

    val buffer = new StringBuilder
    data addString (buffer,"(",";;",")")
    println(buffer)
    println(data)

    val array = data.toArray
    println(array.toList)

    val newArray = new Array[Char](10)
    data.copyToArray(newArray , 3)  //跳过前面3个元素
    newArray.foreach(print)

    val iterator = data.toIterator
    println(iterator.next())
    println(iterator.next())
  }
}
