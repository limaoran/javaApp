package rr.scala.chapter3

/**
 * 第48讲：Scala类型约束代码实战及其在Spark中的应用源码解析
 * Created by Limaoran on 2016/7/23.
 */
object Demo48_Class {
  def main(args: Array[String]) {
    //A =:= B 表示A类型等同于B
    //A <:< B 表示A类型是B的子类
    //A <%< B 视图界定，表示A可以隐式转换成B类型，但是在2.10.x后此方法被废弃
    def rocky[T](i:T)(implicit ev:T <:< java.io.Serializable): Unit = {
      println("java and scala is soo easy!")
    }
    rocky("Scala")
//    rocky(100) //报错，Int不是Serializable类型
  }
}
