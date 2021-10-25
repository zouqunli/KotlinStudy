package cn.mdm.lib.classes

import javax.tools.JavaCompiler


/**
 * 女人
 */
class Women(name:String,age: String): Person(name,age)

/**
 * 男人
 */
class Man(name:String,age:String): Person(name,age){
    //直接打印toString方法内容
    override fun toString(): String {
        return "${name}男人"
    }
}

/**
 * 人
 */
open class Person(var name: String,var age:String){
    init {
        println("${this.javaClass.simpleName} my name is $name and my age is $age")
    }
}

fun main(args:Array<String>) {
    val man = Man("Jack","28")
    val women = Women("lucy","27")
}