package rr.scala.chapter2

/**
 * 第37讲：List的foldLeft、foldRight、sort操作代码实战
 * Created by Limaoran on 2016/7/22.
 */
object Demo37_List {
  def main(args: Array[String]) {
    //Scala可以把一些符号定义为具体的操作
//    def /:[B](z: B)(op: (B, A) => B): B = foldLeft(z)(op)
//    def :\[B](z: B)(op: (A, B) => B): B = foldRight(z)(op)

    println((1 to 100).foldLeft(0)(_ + _))  //分解后为 (( (1+0)+2)+3 )+4
    println((0/:(1 to 100))(_+_))

    println((1 to 5).foldRight(100)(_ - _)) //分解后为 (1-(2-(3-(4-(5-100)))))
    println( ((1 to 5) :\ 100) (_ - _) )

    println(List(1, -3, 4, 2, 6).sortWith(_ < _))
    println(List(1, -3, 4, 2, 6).sortWith(_ > _))
  }
}
