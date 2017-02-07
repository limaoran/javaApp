package rr.scala.chapter4

/**
 * 第72讲：Scala界面事件处理编程实战详解
 * Created by Limaoran on 2016/7/23.
 */
import scala.swing._
import scala.swing.event.ButtonClicked

object Demo72_Event extends SimpleSwingApplication{
  override def top: Frame = new MainFrame(){
    title = "Second GUI"
    val button = new Button(){
      text = "Scala"
    }
    val label = new Label(){
      text = "Here is Scala!!!"
    }
    contents = new BoxPanel(Orientation.Vertical){
      contents += button
      contents += label
      border = Swing.EmptyBorder(50,50,50,50)
    }
    listenTo(button)
    var clicks = 0
    reactions += {
      case ButtonClicked(button) => {
        clicks += 1
        label.text = "Clicked "+clicks+" times"
      }
    }
  }
}
