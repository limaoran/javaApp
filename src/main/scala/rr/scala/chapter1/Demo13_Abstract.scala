package rr.scala.chapter1

/**
 * 第13讲：抽象类、抽象字段、抽象方法
 * Created by Limaoran on 2016/7/20.
 */
object Demo13_Abstract {
  def main(args: Array[String]) {
    val teacher = new TeacherForMaths("Spark")
    teacher.teach

    println("teacher.id:"+teacher.id)
    println("teacher.name:"+teacher.name)
  }
  class AbstractClassOps{
    var id:Int = _ //这里使用_占位符，必须使用var声明
  }
  abstract class SuperTeacher(val name:String){ //抽象类
    var id:Int
    var age:Int //抽象字段
    def teach //抽象方法
  }
  class TeacherForMaths(name:String) extends SuperTeacher(name){
    override var id = name.hashCode
    override var age = 29
    override def teach: Unit ={
      println("Teaching!!!")
    }
  }
}
