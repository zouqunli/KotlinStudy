package cn.mdm.lib.classes

/**
 * 继承父类或接口的冲突
 * <A>.x()
 * 视频地址 ： https://coding.imooc.com/lesson/108.html#mid=8328
 */
abstract class A{
    open fun x() = 1
}

interface B{
    fun x() = 2
}

interface C{
    fun x() = 3
}

//一个类可以实现类和接口中相同的方法
//但要保证方法的参数和返回值一致否则无效，请改接口或者抽象类方法名
//相同的方法怎么调用呢？用super<类/接口>.x() 方式调用
class D(var y:Int):A(),B,C{
    override fun x(): Int {
        println("call x() in D")
        if(y > 0){
            return super<A>.x()
        }else if(y < -200){
            return super<B>.x()
        }else if(y < -100){
            return super<C>.x()
        }else{
            return y
        }
    }
}


fun main(args: Array<String>) {
    println(D(10).x())
    println(D(-250).x())
    println(D(-150).x())
    println(D(0).x())
}