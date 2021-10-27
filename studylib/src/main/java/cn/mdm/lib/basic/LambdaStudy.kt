package cn.mdm.lib.basic

/**
 * Lambda表达式
 * 视频:https://coding.imooc.com/lesson/108.html#mid=23216
 * 匿名函数
 * 写法 {[参数列表] ->[函数体，最后一行是返回值]}
 */
//1.kotlin方法
fun sum(arg1:Int,arg2:Int) = arg1 + arg2
val sum = fun(arg1:Int,arg2:Int){arg1 + arg2} //或者 val sum = fun(arg1:Int,arg2:Int) = arg1 + arg2
//lambda (Int,Int)->Int
val sum1 = {arg1:Int,arg2:Int ->
    //返回值是最后一行的执行的语句的值所以在中间的其他语句都是可以添加的
    println("$arg1 + $arg2 = ${arg1 + arg2}")
    arg1 + arg2
}
fun hello(sum:(arg1: Int,arg2: Int) -> Int){
    sum(1,2)
}
fun hello2(p1:Long,sum:(arg1:Int,arg2:Int,arg3:Int)->Long):String{
    return "$p1 + $sum"
}
fun hello3(p1:Long,sum1:(arg1:Int,arg2:Int,arg3:Int)->Long,p2:String):String{
    return "$p1 + $sum1 + $p2"
}
fun hello4(p1:Long,sum1:(arg1:Int,arg2:Int,arg3:Int)->Long,sum2:(arg1: Int,arg2: Int) -> Int):String{
    return "$p1 + $sum1 + $sum2"
}
fun helloWorld(){
    println("Hello World")
}
fun message(msg:String){
    println(msg)
}
//任何函数都能变成一种lambda表达式，它也是一种类型，类似Int,Long这种使用方式的类型
//例如 主要结构 (参数类型列表) -> 返回值类型 ,kotlin里面特殊类型类名 称号 Function参数个数<参数类型>，具体可以按两次Shift键搜索Function0
// hellWorld 函数的的类型是 () -> Unit   如： Function0
// message 是 (Int) -> Unit     如： Function1
// sum 是 (Int,Int) -> Int      如： Function2
// hello 就比较复杂类似套娃 他的参数本身是个类型 所以他的结构是 ((Int,Int)->Int) -> Int
// hello2 是 (Long,(Int,Int,Int)->Long) -> String

fun main(args: Array<String>) {
    println(sum1(1,2))
    //变量方法执行相当于执行了变量的invoke方法
    println(sum1.invoke(1,2))

    //2.简化变迁
    val array:IntArray = intArrayOf(1,2,3,4)
    //kotlin原来的方法
    for(i in array){
        println(i)
    }
    //lambda 简化1 表达式作为forEach的参数
    array.forEach({it -> println(it)})
    //简化2 ()可以提取出来放在最前面 ，it是可以修改成自定义的名称（推荐）
    array.forEach(){item -> println(item)}
    //简化3 若是()为空可以隐藏 ,it是默认可以不写 （推荐）
    array.forEach{println(it)}
    //简化4 若是表达式的执行的方法和forEach参数一致可以简写成下面这样
    array.forEach(::println)

    //3.终止循环 可以采用打标签形式return跳转到第一个@地方 例如：(自定义的名字)@  stop@
    println("3.终止循环 可以采用打标签形式 例如：(自定义的名字)@  stop@")
    array.forEach stop@{
        if(it == 3)return@stop
        println(it)
    }
    println("网上例子 完整的跳出使用break标签 只跳一次就continuing标签")
    //网址 1：https://mp.weixin.qq.com/s?__biz=MzIzMTYzOTYzNA==&mid=2247483942&idx=1&sn=a6758e1033dd2ed31ef455d7738f86f1&chksm=e8a05d1bdfd7d40d47497007c79b9b316e3199bc299aa07cd098fae2dcad4cf5a4977e04a7de#rd
    //网址 2：https://mp.weixin.qq.com/s?__biz=MzIzMTYzOTYzNA==&mid=2247483942&idx=1&sn=a6758e1033dd2ed31ef455d7738f86f1&chksm=e8a05d1bdfd7d40d47497007c79b9b316e3199bc299aa07cd098fae2dcad4cf5a4977e04a7de#rd
    run breaking@ {
        (0..20).forEach continuing@ {
            if (10 <= it) return@breaking
            println(it)
        }
    }
    //4.使用方法
    //首先看看hello方法的调用，它只用一个参数就是lambda表达式类型
    //sum1本身就是lambda表达式 所以可以直接传入
    println(hello(sum1))
    //若没有可以这样
    println(hello({ arg1, arg2 -> arg1 + arg2}))
    //因为参数就一个lambda表达式类型 所以可以提取出来()
    println(hello(){ arg1, arg2 -> arg1 + arg2})
    //因为提取出来的()是空的没用所以可以省略
    println(hello{ arg1, arg2 -> arg1 + arg2})

    //-1再来看看hello2方法的的调用，它是两个参数 一个是Long类型一个是lambda表达式类型 函数返回值是String
    println(hello2(2L,{arg1, arg2, arg3 -> (arg1 + arg2 + arg3).toLong()}))
    //同样因为最后一个是lambda表达式类型，还是可以提取()的 将其他参数
    println(hello2(2L){arg1, arg2, arg3 -> (arg1 + arg2 + arg3).toLong()})

    //-2若是lambda表达式在中间参数就不能提取()了
    println(hello3(2L,{arg1, arg2, arg3 ->(arg1 + arg2 + arg3).toLong()},"ss"))

    //-3若是后面存在几个lambda表达式类型 可以这样写
    println(hello4(2L,{arg1, arg2, arg3 ->(arg1 + arg2 + arg3).toLong()},{arg1, arg2 -> arg1 + arg2 }))
    //当然最后一个是lambda表达式的话 还是可以提取()只不过只有最后一个lambda表达式能单独拧出来
    println(hello4(2L,{arg1, arg2, arg3 ->(arg1 + arg2 + arg3).toLong()}){arg1, arg2 -> arg1 + arg2 })

    //结论就是最后一个是lambda表达式才可以使用最简写的方式提取()
}
