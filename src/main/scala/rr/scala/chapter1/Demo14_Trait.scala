package rr.scala.chapter1

/**
 * 第14讲：Scala中作为接口的trait、在对象中混入trait代码实战
 * Created by Limaoran on 2016/7/20.
 */
object Demo14_Trait {
  def main(args: Array[String]) {
    val logger = new ConcreateLogger with TraitLogger
    logger.concreateLog
  }
  trait Logger{
    def log(msg:String){}
  }
  class ConcreateLogger extends Logger with Cloneable{
//    override def log(msg:String) = println(msg)
    def concreateLog: Unit ={
      log("It's me !!!")
    }
  }
  trait TraitLogger extends Logger{
    override def log(msg:String): Unit ={
      println(" TraitLogger Log content is :"+msg)
    }
  }
}
