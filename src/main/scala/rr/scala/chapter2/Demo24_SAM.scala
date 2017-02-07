package rr.scala.chapter2

import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.{JButton, JFrame}

/**
 * 第24讲：Scala中SAM转换实战详解（Single Abstract Method）
 * Created by Limaoran on 2016/7/21.
 */
object Demo24_SAM {
  def main(args: Array[String]) {
    var data = 0
    val frame = new JFrame("SAM Testing")
    val jButton = new JButton("Counter")
    //非SAM转换
    jButton.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        data += 1
        println(data)
      }
    })
    //SAM转换
    //我们传递的参数是一个函数，在这个作为参数的函数来指明具体化的工作细节
    implicit def convertedAction( action:ActionEvent => Unit) ={
      new ActionListener {
        override def actionPerformed(e: ActionEvent): Unit = {
          action(e)
        }
      }
    }
    jButton.addActionListener((event:ActionEvent) => { data+=1;println(data)} )
    //end
    frame.setContentPane(jButton)
    frame.pack()
    frame.setVisible(true)
  }
}
