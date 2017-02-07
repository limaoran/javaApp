package rr.scala.chapter3

/**
 * 第57讲：Scala中Dependency Injection实战详解
 * Created by Limaoran on 2016/7/23.
 * Dependency Injection 依赖注入
 */
object Demo57_DependencyInjection {
  def main(args: Array[String]) {
    trait Logger{def log(msg:String )}
    trait Auth{
      auth : Logger =>
      def act(msg:String): Unit ={
        println("Before")
        log(msg)
        println("After")
      }
    }
    object DI extends Auth with Logger{
      override def log(msg: String): Unit = println(msg)
    }
    DI.act("I hope you'll like it")
  }
}
