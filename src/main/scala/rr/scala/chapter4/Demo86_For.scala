package rr.scala.chapter4

/**
 * 第86讲：Scala中For表达式的生成器、定义和过滤器
 * Created by Limaoran on 2016/7/24.
 */
object Demo86_For {
  def main(args: Array[String]) {
    case class Person(name: String, isMale: Boolean, children: Person*)
    val lauren = Person("Lauren", false)
    val rocky = Person("Rocky", true)
    val vivian = Person("Vivian", false, lauren, rocky)
    val persons = List(lauren, rocky, vivian)

    val result = for (person <- persons; if !person.isMale; child <- person.children)
      yield (person.name, child.name)
    println(result)

    val content = for (x <- List(1, 2, 3); y <- List("Hadoop", "Spark", "Flink")) yield (x, y)
    println(content)
  }
}
