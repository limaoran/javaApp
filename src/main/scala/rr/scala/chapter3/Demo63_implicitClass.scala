package rr.scala.chapter3

import java.io.File

import scala.io.Source

/**
 * 第63讲：Scala中隐式类代码实战详解
 * Created by Limaoran on 2016/7/23.
 */
object Demo63_implicitClass {
  def main(args: Array[String]) {
    object Context_Helper{
      implicit class FileEnhancer(file:File){
        def read = Source.fromFile(file.getPath).mkString
      }
      implicit class Op(x:Int){
        def add(second:Int) = x+second
      }
    }
    import Context_Helper._
    println(1.add(2))
    println(new File("g:/txt/data1.txt").read)
  }
}
