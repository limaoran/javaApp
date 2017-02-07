package rr.scala.chapter2

/**
 * 第19讲：Scala中的正则表达式、与模式匹配结合的的Reg代码实战
 * Created by Limaoran on 2016/7/20.
 */
object Demo19_Regex {
  def main(args: Array[String]) {
    //正则表达式
    val regex = """([0-9]+)([a-z]+)""".r
    val numPattern = "[0-9]+".r
    val numberPattern = """\s+[0-9]+\s+""".r
    //findAllIn方法返回值遍历所有匹配项的迭代器
    for(matchString<- numberPattern.findAllIn("99345 Scala , 22298 Spark"))
      println(matchString)
    //找到收割匹配项
    println(numberPattern.findFirstIn("99ss java,222 hadoop"))

    val numitemPattern = """([0-9]+) ([a-z]+)""".r

    val numitemPattern(num,item) = "99 hadoop"
    //正则表达式与模式匹配
    val line = "93459 spark"
    line match {
      case numitemPattern(num,blog) => println(num+"\t"+blog)
      case _=> println("ohh...")
    }
  }
}
