package rr.scala.chapter1

import scala.collection.mutable.ArrayBuffer

/**
 * 第5讲：Scala数组操作实战详解
 * Created by Limaoran on 2016/7/20.
 */
object Demo05_Array {
  def main(args: Array[String]) {
    //数组基本操作
    val nums = new Array[Int](10)
    val a = new Array[String](10)
    val s = Array("Hello","World")
    s(0) = "GoodBye"

    val b = ArrayBuffer[Int]()
    b+=1
    b+=(1,2,3,5)
    b++=Array(8,13,31)
    b.trimEnd(5)
    b.insert(2,6)
    b.insert(2,7,8,9)
    b.remove(2)
    b.remove(2,3)
    b.toArray

    for(i <- 0 until(a.length)){
      println(i + ": "+a(i))
    }
    //数组进阶操作
    val c = Array(2,3,5,7,11)
    val result = for(elem <- c) yield 2 * elem
    for(elem <- c if  elem%2==0 ) yield 2*elem
    c.filter( _%2==0).map(2 * _)

    Array(1,6,2,9).sum
    ArrayBuffer("Mary","had","a","little","lamb" ).max

    val d = ArrayBuffer(1,7,2,8)
    val bSorted = d.sorted

    val e = Array(1,7,2,9)
    scala.util.Sorting.quickSort(e)

    e.mkString(" and ")
    a.mkString("<",",",">")
    //多维数组
    val matrix = Array.ofDim[Double](3,4)
    matrix(2)(1) = 42
    val triangle = new Array[Array[Int]](10)
    for(i <- 0 until(triangle.length))
      triangle(i) = new Array[Int]( i + 1)
  }
}
