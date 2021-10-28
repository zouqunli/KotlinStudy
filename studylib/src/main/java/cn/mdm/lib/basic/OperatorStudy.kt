package cn.mdm.lib.basic

/**
 * 运算符 比对 kotlin
 * 视频 ： https://coding.imooc.com/lesson/108.html#mid=8292
 * 官网文档地址 ： https://kotlinlang.org/docs/operator-overloading.html
 */

fun main(args: Array<String>) {
    //很多运算符可以在上面的文档地址中查看kotlin本质调用的方法
    var b:Boolean = false
    //!b 相当于 b.not()
    b = !b
    b = b.not()

}