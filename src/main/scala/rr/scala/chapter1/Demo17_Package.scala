package com.rr.scala

/**
 * 第17讲：Scala中包、类、对象、成员、伴生类、伴生对象访问权限实战彻底详解
 * Created by Limaoran on 2016/7/20.
 */
object Demo17_Package {
  def main(args: Array[String]) {

  }
}
//包、类、对象、成员访问权限实战
package sparkDemo{
  package navigation{
    private[sparkDemo] class Navigator{
      protected [navigation] def useStarChart(){}
      class LegOfJourney{
        protected [Navigator] val distance = 100
      }
      private [this] var speed = 200
    }
  }
  package launch{
    import com.rr.scala.spark.navigation._
    object Vehicle{
      private [launch] val guide = new Navigator
    }
  }
}
//伴生类、伴生对象访问权限实战
class PackageOps_Advanced{
  import PackageOps_Advanced.power
  private def canMakeItTrue = power > 10001
}
object PackageOps_Advanced{
  private def power = 10000
  def makeItTrue(p : PackageOps_Advanced):Boolean = {
    val result = p.canMakeItTrue
    result
  }
}