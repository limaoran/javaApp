package rr.scala.chapter2

/**
 * 第23讲：Scala高阶函数实战详解
 * 高阶函数：函数的参数是函数
 * Created by Limaoran on 2016/7/21.
 */
object Demo23_Function {
  def main(args: Array[String]) {
    //高阶函数代码示例
    (1 to 9).map("*"* _).foreach(println _)
    (1 to 9).filter(_%2==0).foreach(println)
    println( (1 to 9).reduceLeft(_*_) )
    "Spark is the most exciting thing happening in big data today".split(" ")
      .sortWith(_.length< _.length).foreach(println)

    //高阶函数详解
    val fun = Math.ceil _
    val num = 3.14
    fun(num)
    Array(3.14,1.42,2.0).map(fun)

    val triple = (x:Double) => 3*x
    Array(3.14,1.42,2.0).map( (x:Double)=> 3*x)
    Array(3.14,1.42,2.0).map{ (x:Double) => 3*x}

    def high_order_functions( f:(Double)=>Double ) = f(0.25)
    println(high_order_functions(Math.ceil( _)))
    println(high_order_functions(Math.sqrt( _)))

    def mulBy(factory:Double) = (x:Double) => factory * x
    val quintuple = mulBy(5)
    println(quintuple)

    println(high_order_functions((x:Double)=> 3*x))
    high_order_functions((x)=> 3*x )
    high_order_functions(x => 3*x)
    high_order_functions( 3* _)
    val fun2 = 3*(_:Double)
    val fun3 :(Double) => Double = 3 * _

  }
}
