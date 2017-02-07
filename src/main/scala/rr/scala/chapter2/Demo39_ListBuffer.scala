package rr.scala.chapter2

/**
 * 第39讲：ListBuffer、ArrayBuffer、Queue、Stack操作代码实战
 * Created by Limaoran on 2016/7/22.
 */
object Demo39_ListBuffer {
  def main(args: Array[String]) {
    import scala.collection.mutable.ListBuffer
    val listBuffer = new ListBuffer[Int]
    listBuffer += 1
    listBuffer += 2
    println(listBuffer)

    import scala.collection.mutable.ArrayBuffer
    val arrayBuffer = new ArrayBuffer[Int]()
    arrayBuffer += 1
    arrayBuffer += 2
    println(arrayBuffer)

    //不可变的Queue
    val empty = scala.collection.immutable.Queue[Int]()
    val queue1 = empty.enqueue(1)
    val queue2 = queue1.enqueue(List(2,3,4,5))
    println(queue2)
    val (element , left) = queue2.dequeue
    println(element + " : " + left)
    //可变的Queue
    import scala.collection.mutable.Queue
    val queue = Queue[String]()
    queue += "a"
    queue ++= List("b","c")
    println(queue)
    println(queue.dequeue()) //拿出第一个元素
    println(queue)
    //Stack
    import scala.collection.mutable.Stack
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.push(3)
    println(stack.top)
    println(stack)
    println(stack.pop())
    println(stack)
  }
}
