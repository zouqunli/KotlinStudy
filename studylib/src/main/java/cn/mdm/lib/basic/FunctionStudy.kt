package cn.mdm.lib.basic

/**
 * 函数（方法）
 */
//1.java中的void等价于kotlin中的Unit
fun one():Unit{
}
//当是Unit可以不写返回类型 当然这种方式没什么意义
fun two(){}  //简写 fun two() = Unit

//2.定义带返回值的方法
fun three(value1:Int,value2: Int): Int{
    return value1 + value2
}
//若是返回一个表达式值的方法可以简写
fun four(value1: Int,value2: Int) = value1 + value2

//3.用变量或常量接收匿名的函数
val tempFun = fun(x:Int){
    println("$x be is value")
}
//或者运算方法 简写
val tempFun2 = fun(y:Int) = y * 10

fun main(args: Array<String>) {

    one()
    two()
    three(2,2)
    four(10,10)

    tempFun(10)
    println(tempFun2(100))


}