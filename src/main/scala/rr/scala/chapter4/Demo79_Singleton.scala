package rr.scala.chapter4

/**
 * 第79讲：单例深入讲解及单例背后的链式表达式
 * Created by Limaoran on 2016/7/24.
 */
object Scala
class Java3
class JVM{
  def method1:this.type = this
}
class JVMLanguage extends JVM {
  def method2 :this.type = this
}
object Demo79_Singleton {
  def main(args: Array[String]) {
    println(Scala.getClass)
    import scala.reflect.runtime.universe._
    println(typeOf[Scala.type ])

    val java = new Java3
    val java2 = new Java3
    println(typeOf[java.type ])
    val content:java.type = java
//    val content:java.type = java2
    val jvm = new JVMLanguage
    jvm.method1.method2
  }
}
