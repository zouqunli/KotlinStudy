package cn.mdm.lib.basic

import java.lang.Exception
import java.lang.NullPointerException

/**
 * kotlin的异常捕获
 * 关键字 try..catch,
 * 视频 ： https://coding.imooc.com/lesson/108.html#mid=8294
 */
fun main(args: Array<String>) {
    //1.try..catch
    try{

    }catch (e:NullPointerException){

    }catch (e:Exception){

    }
    //2.try..catch..finally
    try {
        var result = 10 / 0
        println(result)
    }catch (e:Exception){
//        return
    }finally {
        println("不管怎样我都执行,哪怕加了return")
    }

    //3.try..catch也是表达式
    var res = try {
        10 / 0
    }catch (e:Exception){
        50 + 50
    }
    //做表达式时finally会优先计算后再计算try和catch里面的值，返回值会被覆盖，但的确执行了
    finally {
        println("我执行了")
        100 + 100
    }
    println(res)
}