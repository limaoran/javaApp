package rr.scala.chapter4

/**
 * 第75讲：模式匹配下的For循环
 * Created by Limaoran on 2016/7/23.
 */
object Demo74_For {
  def main(args: Array[String]) {
    for(i <- List(1,2,3,4,5)) println(i)
    //@变量绑定，给Flink设置了一个别名
    for(index@"Flink" <- List("Hadoop","Spark","Flink")) println(index)
    for( (language,"Hadoop")<- Set("Scala"->"Spark","Java"->"Hadoop")) println(language)
    for( (k,v:Int) <- List(("Spark"->5),("Hadoop"->"Big Data"))) println(k)
  }
}
