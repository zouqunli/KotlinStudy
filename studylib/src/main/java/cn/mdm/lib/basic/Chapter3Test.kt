package cn.mdm.lib.basic

import java.lang.Exception
import java.lang.UnsupportedOperationException

/**
 * kotlin的 第3章测试 命令行计算器
 * 关键字 无
 * 视频 ： https://coding.imooc.com/lesson/108.html#mid=8297
 */
fun main(args: Array<String>) {
    while (true){
        try{
            println("请输入运算例如: 3 + 4")
            var input = readLine()?:break
            val splits = input.trim().split(" ")
            var args1 = splits[0].toDouble()
            var op = splits[1]
            var args2 = splits[2].toDouble()
            println("$args1 $op $args2 = ${Operator(op).opFun(args1,args2)}")
        }catch (e :Exception){
            println("数值设置有误")
        }
    }
}

class Operator(op:String){
    val opFun : (left:Double,right:Double) -> Double = when(op){
        "+" -> {left,right -> left+right}
        "-" -> {left,right -> left-right}
        "*" -> {left,right -> left*right}
        "/" -> {left,right -> left/right}
        else -> {
            throw UnsupportedOperationException(op)
        }
    }
}