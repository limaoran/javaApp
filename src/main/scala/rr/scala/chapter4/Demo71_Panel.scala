package rr.scala.chapter4

/**
 * 第71讲：Scala界面Panel、Layout实战详解
 * Created by Limaoran on 2016/7/23.
 */
import scala.swing._
object Demo71_Panel extends SimpleSwingApplication{
  override def top: Frame = new MainFrame(){
    title = "Second GUI"
    val button = new Button(){
      text = "Scala"
    }
    val label = new Label(){
      text = "Here is Scala!!!"
    }
    contents = new BoxPanel(Orientation.Vertical){
      contents+=button
      contents+=label
      border = Swing.EmptyBorder(50,50,50,50)
    }
  }
}
