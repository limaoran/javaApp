package rr.scala.chapter3

import scala.io.{Source, BufferedSource}

/**
 * 第58讲：Scala中Abstract Types实战详解
 * Created by Limaoran on 2016/7/23.
 */
object Demo58_AbstractTypes {
  def main(args: Array[String]) {
    trait Reader{
      type In <: java.io.Serializable
      type Contents
      def read(in:In) :Contents
    }
    class FileReader extends Reader{
      type In = String
      type Contents = BufferedSource
      def read(name:In) = Source.fromFile(name)
    }
    val fileReader = new FileReader
    val content = fileReader.read("G:\\txt\\data1.txt")
    for(line <- content.getLines()){
      println(line)
    }
  }
}
