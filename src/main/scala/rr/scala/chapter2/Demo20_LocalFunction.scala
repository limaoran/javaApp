package rr.scala.chapter2

import scala.io.Source

/**
 * 第20讲：Scala中的本地函数与作为语言一等公民的函数详解
 * Created by Limaoran on 2016/7/20.
 */
object Demo20_LocalFunction {
  def main(args: Array[String]) {
    val arr = Array[String]("10","g:/txt/笑话4.txt","g:/txt/笑话5.txt")
    val width = arr(0).toInt
    for(arg<-arr.drop(1)) //这里打印文件"笑话4"和"笑话5"的内容
      processData(arg,width)

    var increase = (x:Int) => x +1
    increase(10)
    increase = (x:Int) => x+9999

    val someNumbers = List(-11,-10,-5,0,5,10)
    someNumbers.foreach( (x:Int)=> println(x) )
    someNumbers.filter((x:Int)=> x>0)
    someNumbers.filter( (x)=> x>0)
    someNumbers.filter( x => x>0)
    someNumbers.filter( _ > 0)
    val f = (_:Int) + (_:Int)
    f(5,10)
  }
  //本地函数
  def processData(filename:String,width:Int): Unit ={
    def processLine(line:String): Unit ={
      if(line.length>width)
        println(filename+": "+line)
    }
    val source = Source.fromFile(filename)
    for(line<-source.getLines()){
      processLine(line)
    }
  }
}
