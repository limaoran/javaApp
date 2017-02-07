package rr.scala.chapter3

/**
 * 第49讲：Scala中Variance代码实战
 * Created by Limaoran on 2016/7/23.
 * Variance：形变
 */
object Demo49_Variance {
  def main(args: Array[String]) {
    //+ 协变，是为了满足高阶函数中能够替换参数函数(functional parameter)的需要，就和普通函数中使用多态参数一样。
    // -逆变，用于传参，协变用于产出值
    class Person
    class Student extends Person
    class C[+T](val args:T)
    class S[+T](arg:T) extends C[T](arg)

    trait Friend[-T]{
      def makeFriend(somebody:T)
    }
    def makeFriendWithYou(s:Student,f:Friend[Student]){f.makeFriend(s)}

    val value : C[Person] = new C[Student](new Student)
  }
}
