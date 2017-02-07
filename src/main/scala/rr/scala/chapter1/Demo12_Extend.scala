package rr.scala.chapter1

/**
 * 第12讲：Scala中的继承：超类的构造、重写字段、重写方法代码实战
 * Created by Limaoran on 2016/7/20.
 */
object Demo12_Extend {
  def main(args: Array[String]) {
//    new Person("Spark",20)
    new Worker("Java",25,200)
  }
  class Person(val name:String,var age:Int){
    println("The primary constructor of Person")
    val school = "3JU"
    def sleep = "8 hour"
    override def toString = "I am a Person!"
  }
  class Worker(name:String,age:Int,val salary:Long)extends Person(name,age){
    println("This is the subClass of Person,Primary constructor of Worker")
    override val school = "Spark"
    override def toString = "I am a Worker!"+super.sleep
  }
}
