package cn.mdm.lib.basic

import cn.mdm.lib.classes.Man

/**
 * 常量和变量
 */
//1.常量定义 不可二次修改的数据
//类似等于java中 public final String FINAL_HELLO_ONE = "HelloWorld"
val FINAL_HELLO_ONE: String = "HelloWorld"
//也可以直接不用定义类型 由语言特性自动推导
val FINAL_HELLO_TWO = "HelloTwo"
//也可以用来修饰类
val FINAL_MAN = Man("jj","26")

//2.编译期常量
//虽然加了val表示常量，但程序在编译器编译成虚拟机中间语言的时候并不会跟java中定义的final一样
//java中了final常量 是用到的地方都会自动替换成常量定义的字符串temp = "HelloWorld"，而kotlin直接用val的常量是
//采用赋值也就是 用到的地方temp = FINAL_HELLO_ONE 去赋值,想要达到java中的效果就必须使用const修饰
const val FINAL_HELLO_THREE = "Hello_Three"

//3.变量 可修改的数据
//两种写法 都可以
var value1:String = "aaa"
var value2 = "bbb"

//4.静态变量/常量
class Test{
    //在类中声明需要加上companion关键字 并且可以起个别名
    //这里ValOrVar就是别名 也可以不写 建议是不写
    companion object ValOrVar{
        //静态变量
        var isHello = true
        //静态常量
        const val MY_COMPUTER_NAME = "macbook pro"
        //静态方法
        fun todo(){
            println("todo")
        }
    }
}
//若是单独作为一个静态文件独立于类之外就可以不用写companion关键字 默认里面的数据就是静态的
//这时候一定要起个别名，不然就不知道怎么访问了这里的别名就是TTT
object TTT{
    //静态变量
    var isHello = true
    //静态常量
    const val MY_COMPUTER_NAME = "macbook pro"
    //静态方法
    fun todo(){
        println("todo")
    }
}

fun main(args: Array<String>) {

    //这3个可以使用kotlin Bytecode工具看一下区别
    //打开方法：工具栏Tools -> kotlin -> show kotlin Bytecode
    //可以查看反编译java的类 点击窗口的Decompile按钮
    var one = FINAL_HELLO_ONE
    var two = FINAL_HELLO_TWO
    var three = FINAL_HELLO_THREE

    println(value1)
    //修改变量
    value1 = "ccc"
    println(value1)
    //打印第二个变量
    println(value2)

    if(Test.isHello){
        Test.todo()
    }
}