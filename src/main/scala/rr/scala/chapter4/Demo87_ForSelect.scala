package rr.scala.chapter4

/**
 * 第87讲：Scala中使用For表达式做查询
 * Created by Limaoran on 2016/7/24.
 */
object Demo87_ForSelect {
  def main(args: Array[String]) {
    case class Book(title:String,authors:List[String])

    val books:List[Book] = List(
      Book("Scala in Action",List("LiMing","LiSi")),
      Book("Java in Action",List("ZhangSan","LiSi")),
      Book("Groovy in Action",List("WangHong","LiFeng","LiuYan")),
      Book("The Java Language Specification",List("ZhangSan","WangWu","WangErMaZi","Lames"))
    )
    val result = for(b<-books; a<- b.authors if a startsWith "Zhang" ) yield b.title
    println(result)
  }
}
