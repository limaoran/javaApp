package rr.scala.chapter4

/**
 * 第85讲：Scala中For表达式的强大表现力实战
 * Created by Limaoran on 2016/7/24.
 */
object Demo85_For {
  def main(args: Array[String]) {
    case class Person(name: String, isMale: Boolean, children: Person*)
    val lauren = Person("Lauren", false)
    val rocky = Person("Rocky", true)
    val vivian = Person("Vivian", false, lauren, rocky)
    val persons = List(lauren, rocky, vivian)

    val result = persons.filter(person => !person.isMale).flatMap(person =>
      (person.children.map(child => (person.name, child.name))))
    println(result)

    val forResult = for (person <- persons; if !person.isMale; child <- person.children)
      yield (person.name, child.name)
    println(forResult)
  }
}
