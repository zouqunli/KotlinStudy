package cn.mdm.lib.basic

/**
 * 运算符的重载 kotlin
 * 视频 ： https://coding.imooc.com/lesson/108.html#mid=8292
 * 官网文档地址 ： https://kotlinlang.org/docs/operator-overloading.html
 */

//1.自定义运算符重载类
//自定义一个+ 官方文档的写法参考，我们在平常使用的例如 a + b
//其实就是系统封装好的a.plus(b) 所以其实 + 就是plus方法
//所以 + 就是plus方法不可修改，但我们可以重载以使它的作用改变
//下面这个就是官方中原始的plus功能类似的方法实现了两个数相+
data class Counter(val dayIndex: Int) {
    operator fun plus(increment: Int): Counter {
        return Counter(dayIndex + increment)
    }
}
//2.这里我们使用了视频教程的写法，改变了一些运算符的规则
class Complex(var real:Double,var imaginary:Double){
    //重载加号 已知+是运算符，但它其实也是对应一个函数的 函数名就是plus
    //文档就是上面的官方文档 a + b 其实本质就是调用了 a.plus(b)
    //改变+的算法和使用
//    operator fun plus(other:Complex):Complex{
//        return Complex(real + other.real,imaginary + other.imaginary)
//    }
    //也可以换个返回值
    operator fun plus(other:Complex):Double{
        return real + other.real + imaginary + other.imaginary
    }

    //我们还可以在文档中找到 minus(-),times(*),div(/),rem(%)，contains(in)，rangeTo(..)最后一个是Range就是这个1..10中间的符号
    //我们可以重写上面我举出的例子许多的运算符更多的可以在上面官网中寻找
}


fun main(args: Array<String>) {
    //3.使用官方的重载例子
    val counter = Counter(1)
    //使用也很简单，这里的+就是plus方法 由于我们自定义了就改变了使用规则
    //用我们自定义的类 再使用其自定义的方法
    println(counter + 2)
    //这里的本质调用的方法就是下面这个方法
    //由于定义的plus方法返回的是Counter这个类
    //所以我们这里输出的就是类名了
    println(counter.plus(2))

    //4.使用自定义的重载例子
    val complex1 = Complex(2.0,4.0)
    val complex2 = Complex(5.0,7.5)
    //这里的+就是Complex中定义的plus方法
    println(complex1 + complex2)
    //本质就是这个方法
    //这里我们返回的 由于我们改过方法的返回值所以就可以直接查看打印出来的值了
    println(complex1.plus(complex2))

    //很多运算符可以在上面的文档地址中查看kotlin本质调用的方法
    var b:Boolean = false
    //!b 相当于 b.not()
    b = !b
    b = b.not()

}