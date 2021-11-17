package cn.mdm.lib.basic


/**
 * kotlin的 具名参数，变长参数，默认参数
 * 关键字 无
 * 视频 ： https://coding.imooc.com/lesson/108.html#mid=8296
 */
fun main(args: Array<String>) {
    //1.具名参数
    hello(name = "mdm",age = 19,school = "清华")
    //也可以不全是具名
    hello(name = "mdm",19,"清华")

    //2.变长参数 对应java的参数 String.. className
    classList("一班","二班","三班","四班")
    //java中变长的参数只能作为方法的最后一个参数，
    // 但kotlin中因为有具名参数所以可以放在任何位置
    classTeacher("一班","二班","三班","四班",teacher = "mdm")
    //想放数组咋办 集合不行，只能是数组
    val list = mutableListOf<String>("一班","二班","三班","四班")
    val array = arrayOf("一班","二班","三班","四班")
    //用*表示展开数组
    classTeacher(*array,teacher = "mdm")

    //3.默认参数 极大的优化了java中的方法重载的写法
    students(20,"mdm")
    students(name="mdm")
    student1(19)

    //4.混合用法
    test(28,*array,teacher = "mdm")
}

fun hello(name:String,age:Int,school:String){
    println("name：$name,age；$age,school:$school")
}

fun classList(vararg className:String){
    className.forEach {
        println(it)
    }
}
fun classTeacher(vararg className:String,teacher:String){
    className.forEach {
        println(it)
    }
    println("老师:$teacher")
}

fun students(age: Int = 18,name: String){
    println("$age,$name")
}
fun student1(age: Int,name: String = "mdm"){
    println("$age,$name")
}

fun test(age:Int,vararg className: String,teacher: String){
    println("$age's teacher $teacher teach class is :")
    className.forEach { println(it) }
}