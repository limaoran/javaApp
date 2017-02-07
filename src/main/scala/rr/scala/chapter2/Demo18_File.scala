package rr.scala.chapter2

import java.io.{File, PrintWriter}

import scala.io.{StdIn, Source}

/**
 * 第18讲：Scala中文件的读取、写入、控制台输入操作代码实战
 * Created by Limaoran on 2016/7/20.
 */
object Demo18_File {
  def main(args: Array[String]) {
    val file = Source.fromFile("g:/txt/word.txt","GBK")
    for(line<-file.getLines()) println(line)
    file.close()

    val webFile = Source.fromURL("http://spark.apache.org")
    webFile.foreach(print)
    webFile.close()

    val writer = new PrintWriter(new File("z:/test.txt"))
    for(i<-1 to 100) writer.println(i)
    writer.close()

    print("Please enter your input:")
    val line = StdIn.readLine("请输入内容")
    println("Thanks,you input just typed: "+line)
  }
}
