package rr.scala.chapter1

/**
 * 第7讲：Scala类的属性和对象私有字段实战详解
 * Created by Limaoran on 2016/7/20.
 */
object Demo07_Class {
  def main(args: Array[String]) {
    val person = new Person
    person.increment()
    println(person.current)

    val student = new Student();
    println(student.age)
  }
  class Person{
    private var age = 0
    def increment(){age+=1}
    def current = age
  }
  class Student{
    var age = 0
    val name = "Scala"
  }
}
