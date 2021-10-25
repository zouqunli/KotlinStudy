package cn.mdm.lib.basic
//另外as可以还有特殊的用法 例如下方导入给包名设置别名Human
import cn.mdm.lib.classes.Man
import cn.mdm.lib.classes.Person as Human

/**
 * 智能类型转换
 * 关键字 as,as?
 */
open class Parent {

}

class Child : Parent() {
    var name:String = "liSi"
}

fun main(args: Array<String>) {
    //1.kotlin中的强制转换关键字 as
    val parent1: Parent = Child()
    val cast = parent1 as Child
    //只要转换过，也可以直接使用原parent1
    println(parent1.name)
    //或者使用重新复制的值
    println(cast.name)

    //2.已知Java中父类型的转换需要强制转换,但kotlin中若是有了判断就会自动强转
    val parent2: Parent = Child()
    if(parent2 is Child){
        //自动强转，并使用子类的属性了
        println(parent2.name)
    }
    //若不加判断就会报错,找不到name属性
//    parent2.name

    //3.若类型不对而强转就会报错
    val parent3:Parent = Parent()
    //报错转换异常
//    val child:Child = parent3 as Child
    //若不想报错转换异常之后代码无法继续执行可以使用 as? 并在声明变量时使用可为null的?
    val child :Child? = parent3 as? Child
    //打印异常转换后的child,发现都为null
    println(child)
    println(child?.name)

    //4.设置别名 其实本质就是import导入的Person类
    val human:Human = Human("人类","2亿年")

    //5.通过类可以打印类名 写法
    println(Man::class.java.simpleName)
}