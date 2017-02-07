package rr.scala.chapter1

/**
 * 第15讲：Scala多重继承、多重继承构造器执行顺序及AOP实现
 * Created by Limaoran on 2016/7/20.
 */
object Demo15_Extends {
  def main(args: Array[String]) {
//    val t1 = new PianoTeacher
//    t1.playPiano
//    t1.teach
//    val t2 = new Human with TTeacher with PianoPlayer{
//      def teach = {println("I'm teaching students.")}
//    }
//    t2.playPiano
//    t2.teach
    val work = new Work with TBeforeAfter
    work.doAction
//    val logger = new ConcreateLogger
//    logger.concreateLog
  }
//  class MyAccount extends Account with ConsoleLogger
  class Human{
    println("Human")
  }
  trait TTeacher extends Human{
    println("TTeacher")
    def teach
  }
  trait PianoPlayer extends Human{
    println("PianoPlayer")
    def playPiano = {println("I'm playing piano.")}
  }
  class PianoTeacher extends Human with TTeacher with PianoPlayer{
    override def teach = {println("I'm training students.")}
  }
  //AOP
  trait Action{
    def doAction
  }
  trait TBeforeAfter extends Action{
    abstract override def doAction: Unit ={
      println("Initialization")
      super.doAction
      println("Destroyed")
    }
  }
  class Work extends Action{
    override def doAction = println("Working...")
  }
//  object UseTrait extends App{
//    val t1 = new PianoTeacher
//    t1.playPiano
//    t1.teach
//  }
}
