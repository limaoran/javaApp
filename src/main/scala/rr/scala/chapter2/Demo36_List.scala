package rr.scala.chapter2

/**
 * 第36讲：List的partition、find、takeWhile、dropWhile、span、forall、exsists操作代码实战
 * Created by Limaoran on 2016/7/22.
 */
object Demo36_List {
  def main(args: Array[String]) {
    val list = List(1, 2, 3, 4, 5)
    println(list partition (_ % 2 == 0))  //按照某种条件进行分类  (List(2, 4),List(1, 3, 5))
    println(list find (_ % 2 == 0)) //返回Some(2)
    println(list find (_ <= 0))     //None
    println(list takeWhile (_ < 4)) //List(1, 2, 3)
    println(list dropWhile (_ < 4)) //List(4, 5)
    println(list span (_ < 4))    //(List(1, 2, 3),List(4, 5))

    //forall：只有List中所有的元素都满足作为参数的条件的时候，才会返回true，否则返回false
    def hastotallyZeroRow(m: List[List[Int]]) = m exists (row => row forall (_ == 0))
    val m = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 0))
    println(hastotallyZeroRow(m)) //true
  }
}
