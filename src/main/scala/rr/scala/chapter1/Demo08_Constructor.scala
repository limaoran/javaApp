package rr.scala.chapter1

/**
 * 第8讲：Scala主构造器、私有构造器、构造器重载实战详解
 * Created by Limaoran on 2016/7/20.
 */
class Demo08_Constructor {
  def main(args: Array[String]) {

  }
  //主构造器
  class Teacher private[Demo08_Constructor](name:String,val age:Int){
    private[this] var gender = "male"

    //构造器重载
    def this(name:String,age:Int,gender:String){
      this(name,age)
      this.gender = gender
    }
    def sayHello(): Unit ={
      println(this.name + ":" + this.age + ":"+this.gender)
    }
  }
}
