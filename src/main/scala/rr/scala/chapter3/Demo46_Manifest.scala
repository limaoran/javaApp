package rr.scala.chapter3

/**
 * 第46讲： ClassTag 、Manifest、ClassManifest、TypeTag代码实战
 * Created by Limaoran on 2016/7/23.
 */
object Demo46_Manifest {
  def main(args: Array[String]) {
    //推荐使用这种写法
    def arrayMake[T:Manifest](first:T,second:T) = {
      val r = new Array[T](2)
      r(0) = first; r(1) = second ;r
    }
    arrayMake(1,2).foreach(println)

    def manif[T](x:List[T])(implicit m:Manifest[T]) = {
      if(m <:< manifest[String] )  //if(m == manifest[String] )
        println("List strings")
      else
        println("Some other type")
    }
    manif(List("Spark","Hadoop"))
    manif(List(1,2))
    manif(List("Scala",3))

    val m = manifest[String]
    println(m)
  }
}
