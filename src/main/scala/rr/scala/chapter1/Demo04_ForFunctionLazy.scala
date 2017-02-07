package rr.scala.chapter1

import scala.io.Source

/**
 * 第4讲：For与Function进阶实战、Lazy的使用
 * Created by Limaoran on 2016/7/20.
 */
object Demo04_ForFunctionLazy {
  def main(args: Array[String]) {
    //for 进阶
    for( i <- 1 to 2; j<- 1 to 2 ) print( (100*i + j) + " " )
    println
    for( i<- 1 to 2; j<- 1 to 2 if(i!=j) ) print( (100*i +j )+ " " )
    println
    //Function
    def addA(x :Int) = x+100
    val add = (x :Int ) => x+100
    println("The result from a function is : "+addA(2))
    println("The result from a val is : "+add(2))
    def fac(n:Int):Int = if(n<=0) 1 else n*fac(n-1)
    println("The result from a fac is : "+fac(10))
    def combine(content:String, left:String = "[",right:String = "]" ) = left + content + right
    println("The result from a combine is : "+ combine("I love Spark!"))
    def connected(args:Int* ) = {
      var result = 0;
      for(arg <- args) result += arg
      result
    }
    println("The result from a connected is : "+connected(1,2,3,4,5))

    lazy val file = Source.fromFile("z:/test.txt")
  }

}
