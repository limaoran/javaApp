package rr.scala.chapter3

import java.io.File

import scala.io.Source

/**
 * 第59讲：Scala中隐式转换初体验
 * Created by Limaoran on 2016/7/23.
 * 隐式转换 ， 把一个类的实例当做另一个类的实例
 * 从设计模式来讲，属于门面模式
 */
object Demo59_implicitConvertor {

  def main(args: Array[String]) {
    class RichFile(val file:File){
      def read = Source.fromFile(file.getPath() ).mkString
    }
    object Context{
      implicit def file2RichFile(file:File) = new RichFile(file)
    }
    import Context.file2RichFile
    println(new File("g:/txt/data1.txt").read)
  }
}
