package cn.mdm.lib.basic

import cn.mdm.lib.classes.Man

/**
 * 数组
 */
//1.定义数组
val arrayOfInt:IntArray = intArrayOf(1,2,3,4,5,6)
val arrayOfChar:CharArray = charArrayOf('H','e','l','l','l','o')
val arrayOfString:Array<String> = arrayOf("中国","美国","日本")
//对象
val arrayOfMan:Array<Man> = arrayOf(Man("jack","19"),Man("ak","19"),Man("mc","19"))

fun main(args: Array<String>) {
    //2.获取数组长度
    println(arrayOfInt.size)
    //3.循环
    for(i in arrayOfInt){
        println(i)
    }
    //4.提取某个具体值
    println(arrayOfString[1])
    println(arrayOfMan[0])
    //修改具体值
    arrayOfMan[0] = Man("LiSi","40")
    println(arrayOfMan[0])

    //5.合并数组值
    //默认合并的分割字符是", "
    println(arrayOfChar.joinToString())
    //设置具体的分割字符 这里设置空字符串 当然还可以设置其他想要的字符
    println(arrayOfChar.joinToString(""))
    //复杂对象用法
    println(arrayOfMan.joinToString(
        separator = "/",
        prefix = "[",   //前缀
        postfix = "]",  //后缀
        limit = 2,      //限制几个字符串来操作 指定长度
        truncated = "=" //超过指定长度的使用什么来代替
    ) {
        it.name
    }.apply {
        println(this)
        //  [LiSi/ak/=]
    })

    //6.数组切片分割
    //参数传区间 若区间超过数组长度会报异常
    //slice返回的是List<T>类型
    val one:List<Man> = arrayOfMan.slice(0..2)
    println(one[0]) //也可以使用one.get(0)来取值
    //sliceArray返回的是Array<T>类型
    val arrayMan:Array<Man> = arrayOfMan.sliceArray(1..2)
    println(arrayMan[0])

    //打印原数组是否有变化,分割不会有变化
    println(arrayOfMan.size)

}

