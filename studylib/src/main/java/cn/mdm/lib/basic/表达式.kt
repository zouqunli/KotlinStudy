package cn.mdm.lib.basic



/**
 * kotlin的表达式
 * 关键字 infix, if, is, when
 * 视频 ： https://coding.imooc.com/lesson/108.html#mid=8293
 */

//1.中缀表达式
//不想用Book.on(any)这种形式就可以用这个表达式 book on any
 class Book{
    //只有一个参数，且用infix修饰的函数
    infix fun on(any:Any){
        println("中缀表达式 ： $any")
    }
}
fun main(args: Array<String>) {
    //使用中缀表达式
    var book = Book()
    var str = "hello"
    //这就是中缀表达式的使用
    book on str

    //2.if表达式
    //常见用法
    if(str == "world"){
        println("hello $str")
    }else if(str == "hello"){
        println("$str world")
    }else{
        println("nothing")
    }
    //表达式用法 if else 是可以返回值的，最后一行的就是返回值
    //但要注意 作为返回值必须要完整的写出if else 不然会报错
    val isString = if (str is String) {
        "是"
    }else{
        "否"
    }
    println("if表达式的值是 : $isString")

    //3.when表达式
    //替代了java的switch 并比强大很多
    //基本用法
    val x = 1
    val num = 10
    when(x){
        //可以同值判断筛选
        1 -> println("等于1")
        2 -> println("等于2")
        3 -> println("等于3")
        4 -> println("等于4")
        //可以单独加判断条件
        is Int -> println("是")
        in 0..10 -> println("在0..10之间")
        !in 0..10 -> println("不在0..10之间")
        //可以判断是否等于某个变量或常量
        num -> println("等于num")
        //类似switch的default
        else -> println("都不是")
    }
    //同样是个表达式可以返回值
    val xStr = when(x){
        //可以同值判断筛选
        1 -> "等于1"
        2 -> "等于2"
        3 -> "等于3"
        4 -> "等于4"
        //可以单独加判断条件
        is Int -> "是"
        in 0..10 -> "在0..10之间"
        !in 0..10 -> "不在0..10之间"
        //可以判断是否等于某个变量或常量
        num -> "等于num"
        //类似switch的default
        else -> "都不是"
    }
    println("when表达式的值是 : $xStr")

}
