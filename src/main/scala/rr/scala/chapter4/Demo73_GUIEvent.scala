package rr.scala.chapter4

/**
 * 第73讲：Scala界面和事件处理编程进阶实战
 * Created by Limaoran on 2016/7/23.
 */

import java.io.File

import scala.swing._
import scala.swing.event.ButtonClicked

object Demo73_GUIEvent extends SimpleSwingApplication{
  val fileChooser = new FileChooser(new File("."))
  fileChooser.title = "文件选择"
  val button = new Button(){
    text = "Choose a File from local"
  }
  val label = new Label(){
    text = "No any file selected yet."
  }
  val mainPanel = new FlowPanel(){
    contents+=button
    contents += label
  }
  override def top: Frame = new MainFrame(){
    title = "Scala GUI Programing advanced!!!"
    contents = mainPanel

    listenTo(button)

    reactions += {
      case ButtonClicked(b) => {
        val result = fileChooser.showOpenDialog(mainPanel)
        if(result==FileChooser.Result.Approve){
          label.text = fileChooser.selectedFile.getPath
        }
      }
    }
  }
}
