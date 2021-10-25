package cn.mdm.lib.basic


/**
 * 基本类型
 * 关键字 in, ？
 */
//基本类型
val aBoolean:Boolean = false
val anInt:Int = 1
val aLong:Long = 1000 //也可以 anInt.toLong()
val aShort:Short = Short.MAX_VALUE
val aByte:Byte = Byte.MAX_VALUE
val aChar:Char = 'A'
val string:String = ""  //也可以 String(charArrayOf('H','e','l','l','l','o'))
val aFloat:Float = Float.MAX_VALUE
val otherFloat:Float = -Float.MAX_VALUE
val aDouble:Double = Double.MAX_VALUE
val otherDouble:Double = -Double.MAX_VALUE

//可为空的类型定义
val nullType1:Int? = null
val nullType2:String? = null

//kotlin特殊的一些类型
//1.区间
val aRange:IntRange = 0..1024 //相当于数学上[0,1024]的闭区间
val anotherRange: IntRange = 0 until 1024 //相当于[0,1024) 右边是开区间 也就相当于[0,1023]
val aCharRange: CharRange = 'A'..'Z'
val aLongRange:LongRange = 0L..1000L
//未来更高级的用法可以自定义Range类型

fun main(args: Array<String>) {
    //2.使用区间
    //判断某个数是否在期间
    println(aRange.contains(500))
    //或者另一种写法
    println(500 in aRange)

    //3.循环迭代区间
    for (i in aLongRange){
        print("$i,")
    }

}