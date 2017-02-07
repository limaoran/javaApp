package rr.scala.chapter1

import scala.io.Source

/**
 * 第3讲：Tuple、Array、Map与文件操作入门实战
 * Created by Limaoran on 2016/7/20.
 */
object Demo03_TupleArrayMap {
  def main(args: Array[String]) {
    val pair = (100,"Scala","Spark")
    println(pair._1)
    println(pair._2)

    val ages = Map("Rocky"-> 27 , "Spark" -> 5)
    for( (k,v) <- ages){
      println("Key is "+k+",Value is "+v)
    }
    for( (k,_) <- ages){
      println("Key is "+k)
    }

    val array = Array(1,2,3,4,5)
    for(i <- 0 until array.length){
      println(array(i))
    }
    for(elem <- array){
      println(elem)
    }

//    val file = Source.fromFile("G:/txt/word.txt","GBK")
    val file = Source.fromURL("http://spark.apache.org")
    for(line <- file.getLines()){
      println(line)
    }
  }


}
