package cn.mdm.lib.basic

/**
 * 空指针处理
 * 关键字 ?,!!
 */
//1.方法默认不能返回null
//fun getName():String{
//    return null
//}

//2/方法若想可以返回null，就在返回的类型上加个？
fun getName():String?{
    return null
}

fun main(args:Array<String>){
    //3.直接打印也不会报错，会显示为null
    println("this name is ${getName()}")
    //4.若是方法可以返回null,kotlin更好的处理办法 ?: 若为空直接return方法，后面就不执行了
//    val name = getName()?:return
//    println("this name is $name")

    //5.若是你定义了一个可以为空的变量
    var value:String? = "Hello World"
    //知道不为空，可你使用的时候会编译器会报错，提示你应该加个？
    println(value?.length)
    //6.不想用? 人为判断了一定不为空,就可以使用"!!"
    println(value!!.length)
}