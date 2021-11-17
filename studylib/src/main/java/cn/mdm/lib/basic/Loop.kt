package cn.mdm.lib.basic

/**
 * kotlin的循环
 * 关键字 for，while ,do..while,continue,break
 * 视频 ： https://coding.imooc.com/lesson/108.html#mid=8294
 */
fun main(args: Array<String>) {
    //1.for 循环
    for(i in 1..10){
        println(i)
    }
    for((index,value) in (1..10).withIndex()){
        println("$index -> $value")
    }
    for (indexValue in (1..10).withIndex()){
        println("${indexValue.index} --> ${indexValue.value}")
    }
    //for 循环的本质是 循环list的Iterator
    val myList = MyInitList().apply {
        add(1)
        add(2)
        add(3)
    }
    //满足Iterator可以使用in进行循环
    for (i in myList){
        println(i)
    }

    //2.while 循环
    var x = 5
    while (x < 0){
        println(x)
        x--
    }

    //3.do..while 循环
    do {
        println(x)
        x--
    }while (x < 0)

    //4.continue 中止某次循环，break 跳出循环
    for (i in 1..10){
        if(i == 5)continue
        if(i == 8)break
    }

}

class MyIterator(val iterator:Iterator<Int>){
    operator fun next():Int{
        return iterator.next()
    }
    operator fun hasNext():Boolean{
        return iterator.hasNext()
    }
}

class MyInitList{
    val list = mutableListOf<Int>()
    fun add(int:Int){
        list.add(int)
    }
    fun remove(int: Int){
        list.remove(int)
    }
    operator fun iterator():MyIterator{
        return MyIterator(list.iterator())
    }
}