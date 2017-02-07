package com.rr.scala

/**
 * 第16讲：Scala中包的定义、包对象、包的引用、包的隐式引用代码实战
 * Created by Limaoran on 2016/7/20.
 */
object Demo16_Package {
  def main(args: Array[String]) {
    //Scala包的隐式引用
    import java.util.{HashMap => JavaHashMap}

    import scala.{StringBuilder => _}  //把StringBuilder隐藏掉，不能访问
  }
}
//Scala中包的定义
package spark.navigation{
  class Navigator
  package tests{
    //在spark.navigation.tests包里
    class NavigatorSuite
  }
}
package hadoop{
  package navigation{
    class Navigator
  }
  package launch{
  class Booster{
      var nav = new navigation.Navigator
    }
  }
}
//Scala中的包对象和包引用
package object people{
  val defaultName = "Scala"
}
package people{
  class People{
    var name = defaultName
  }
}