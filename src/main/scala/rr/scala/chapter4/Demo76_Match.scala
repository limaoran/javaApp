package rr.scala.chapter4

/**
 * 第76讲：模式匹配下的赋值语句
 * Created by Limaoran on 2016/7/23.
 */
object Demo76_Match {
  def main(args: Array[String]) {
    val a@b = 1000
    println("a = "+a+",b="+b)
    val (c,d) = (1000,2000)
//    val (e,F) = (1000,2000) //这里面不能写大写的字母，它会把大写的字母当成常量
    val Array(g,h) = Array(1000,2000)
//    val Array(i,J) = Array(1000,2000)
    object Test2{val 1=1}
    object Test{ val 1=2}
  }
}
