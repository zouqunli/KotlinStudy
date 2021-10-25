package cn.mdm.ktstudy.classes


/**
 * 女人
 */
class Women(name:String,age: String):Person(name,age)

/**
 * 男人
 */
class Man(name:String,age:String):Person(name,age)

/**
 * 人
 */
open class Person(var name: String,var age:String){
    init {
        println("My name is $name and my age is $age")
    }
}

fun main(args:Array<String>) {
    val man = Man("Jack","28")
    val women = Women("lucy","27")
}