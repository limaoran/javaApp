package rr.scala.chapter2

/**
 * 第31讲：Option使用和实现内幕源码揭秘
 * Created by Limaoran on 2016/7/21.
 */
object Demo31_Option {
  def main(args: Array[String]) {
    //Option：def apply[A](x: A): Option[A] = if (x == null) None else Some(x)
    //sealed abstract class Option[+A] extends Product with Serializable {}
    //final case class Some[+A](x: A) extends Option[A]
    val scores = Map("Alice"-> 99 , "Spark" -> 100)
    scores.get("Alice") match{
      case Some(score) => println(score )
      case None => println("No score")
    }
  }
}
