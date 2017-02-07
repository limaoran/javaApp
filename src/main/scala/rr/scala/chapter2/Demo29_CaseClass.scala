package rr.scala.chapter2

/**
 * 第29讲：Case class和Case object代码实战解析
 * Created by Limaoran on 2016/7/21.
 * case object和case class的用途：
 *  1.是用于传递消息的
 *  2.用于模式匹配
 *
 * case class编译器帮我们做的内幕：
 *  1.每个成员都是val类型，当然也可以显示的声明var
 *  2.另外就是每个case class它都有伴生对象，它里面有apply方法。这个伴生对象它会帮我们构建出
 *    case class的具体的对象
 * 在模式匹配的时候，非常重要的是我们一定要从case class对象中提取出内容，而提取方法其实也是在伴生对象中。
 * un_apply是apply的反操作
 *  apply是传进值构建对象，un_apply提取case object、case class的内容
 */
object Demo29_CaseClass {
  def main(args: Array[String]) {
    def caseOps(person:Person) = person match{
      case Student(age) => println("I am "+age+" years old")
      case Worker(_,salary) => println("Wow,I got "+salary)
      case Shared => println("No property")
    }
    caseOps(Student(19))
    caseOps(Shared)

    val worker = Worker(29,10000)
    //拷贝
    val worker2 = worker.copy(salary = 10.95)
    val worker3 = worker.copy(age = 30)
    println(worker==worker2)
  }
  abstract class Person
  case class Student(age:Int) extends Person
  case class Worker(age:Int,salary:Double) extends Person
  case object Shared extends Person
}
