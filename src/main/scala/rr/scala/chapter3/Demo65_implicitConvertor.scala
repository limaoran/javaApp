package rr.scala.chapter3

import java.io.File

import scala.io.Source

/**
 * 第65讲：Scala中隐式转换内幕操作规则揭秘、最佳实践
 * Created by Limaoran on 2016/7/23.
 */
object Demo65_implicitConvertor {
  def main(args: Array[String]) {
    class RicherFile(val file:File){
      def read = Source.fromFile(file.getPath).mkString
    }
    class File_Implicits(path:String) extends File(path)
    //构建伴生对象，以提供自动隐式转换
    object File_Implicits{
      implicit def file2RichFile(file:File) = new RicherFile(file) //File->RicherFile
    }

    println(new File_Implicits("g:/txt/data1.txt").read)
  }
}
