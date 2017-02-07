package rr.scala.chapter2

/**
 * 第26讲：Scala中模式匹配入门实战详解
 * Created by Limaoran on 2016/7/21.
 */
object Demo26_Match {
  def main(args: Array[String]) {
    //模式匹配
    val data = 30
    data match{
      //在match...case中我们可以使用函数
      case 1 => println("First")
      case 2 => println("Second")
      case _ => println("Not Known Number")
    }
    //模式匹配中使用守卫
    val result = data match{
      case i if i==1 => "The First"
      case number if number==2 => "The Second"
      case _ => "Not Known Number"
    }
    println(result)
    //模式匹配中变量使用
    "Spark !" foreach{ c=> println(
      c match {
        case ' ' => "space"
        case ch => "Char:"+ch
      }
    )}
  }
}
