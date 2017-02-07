package rr.scala.chapter4

/**
 * 第78讲：Type与Class实战详解
 * Created by Limaoran on 2016/7/24.
 */
class Spark
trait Hadoop
object Flink
class Java{class Scala}
object Demo78_Type {
  def main(args: Array[String]) {
    import scala.reflect.runtime.universe._


    //泛型在运行和编译的时候是被擦除掉的
    println(typeOf[Spark])    //type比class更加具体
    println(classOf[Spark])

    val spark = new Spark
    println(spark.getClass)

    println(typeOf[Hadoop])
    println(classOf[Hadoop])

    println(Flink.getClass)
    //不能够使用 classOf[Flink]和typeOf[Flink]

    val java1 = new Java
    val java2 = new Java
    val scala1 = new java1.Scala
    val scala2 = new java2.Scala
    println(scala1.getClass)
    println(scala2.getClass)
    println(typeOf[java1.Scala])
    println(typeOf[java2.Scala])

    println(classOf[List[Int]] == classOf[List[String]])
    println(typeOf[List[Int]] == typeOf[List[String]])
  }
}
