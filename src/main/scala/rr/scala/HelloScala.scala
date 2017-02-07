package rr.scala

/**
 * Created by Limaoran on 2016/7/20.
 */
object HelloScala {
  def main(args: Array[String]):Unit = {
    val file = if(!args.isEmpty ) args(0) else "Spark.xml"
    println(file)
    println("Hello Scala!")
    println(looper(100,298))
    for(i <- 1.to(10)){
      println("Number is :"+i)
    }
    val files = new java.io.File(".").listFiles()
    for(file<- files) println(file)
//    doWhile()
    //异常
    try{
      val n = 99
      val half = if( n% 2==0 ) n/2 else throw new RuntimeException("N must be event")
    }catch{
      case e:Exception => println("Exception:"+e.getMessage)
    }finally {
      //close (file)
    }
  }
  def doWhile(){
    var line = ""
    do{
      line = readLine("请输入内容：")
      println("Read:"+line)
    }while(line!="")
  }

  def looper(x:Long,y:Long ) :Long = {
    var a = x
    var b = y
    while(a!=0){
      var temp = a
      a = b%a
      b = temp
    }
    b
  }
}
