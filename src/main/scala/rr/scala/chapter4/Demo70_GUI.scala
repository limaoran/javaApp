package rr.scala.chapter4

import scala.swing.SimpleSwingApplication

/**
 * 第70讲：Scala界面GUI编程实战详解
 * Created by Limaoran on 2016/7/23.
 */
object Demo70_GUI extends SimpleSwingApplication{
  import scala.swing._
  def top = new MainFrame{
    title = "Hello GUI"
    contents = new Button{text = "Scala => Spark"}
  }
}
