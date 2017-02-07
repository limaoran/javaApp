package rr.scala.chapter1

/**
 * 第11讲：Scala中的apply实战详解
 * Created by Limaoran on 2016/7/20.
 */
object Demo11_Apply {
  def main(args: Array[String]) {
    val array = Array(1,2,3,4,5)
    val a = ApplyTest()
    a.haveATry
    a()
  }
  object ApplyTest{
    def apply() = {
      println("I an into Scala so much!!!")
      new ApplyTest
    }
  }
  class ApplyTest{
    def apply() = println("I an into Spark on much!")
    def haveATry(): Unit ={
      println("Have a try on apply!")
    }
  }
}
