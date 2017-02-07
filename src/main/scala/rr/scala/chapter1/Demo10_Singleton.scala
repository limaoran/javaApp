package rr.scala.chapter1

/**
 * 第10讲：Scala单例对象、伴生对象实战详解
 * Created by Limaoran on 2016/7/20.
 */
object Demo10_Singleton {
  def main(args: Array[String]) {
    println(Singleton)
    println(Singleton)
  }
  object Singleton{
    private var studentNo = 0
    def newStudentNo = {
      studentNo += 1
      studentNo
    }
  }
  class University{
    val id = University.newStudentNo
    private var number = 0
    def aClass(number:Int) = (this.number+=number)
  }
  object University{
    private var studentNo = 0
    private def newStudentNo = {
      studentNo += 1
      studentNo
    }
  }
}
