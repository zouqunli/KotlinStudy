package cn.mdm.lib.classes


/**
 * 接口的实现
 *  by
 *  视频： https://coding.imooc.com/lesson/108.html#mid=8327
 */
//驾驶
interface Driver{
    fun driver()
    fun driver1()
}

//写手
interface Writer{
    fun write()
}

class CarDriver:Driver {
    override fun driver() {
        println("开车")
    }

    override fun driver1() {
        println("开车1")
    }
}

class PPTWriter:Writer {
    override fun write() {
        println("写PPT呢")
    }
}

//实现并代理 可以不是成员变量 用by进行代理 代理用传进来的实现类实现方法了
class SeniorManager(driver: Driver, writer: Writer):Driver by driver ,Writer by writer
//实现并代理 也可以是类的成员变量
class SeniorManager1(val driver: Driver, val writer: Writer):Driver by driver ,Writer by writer

fun main(args: Array<String>) {
    val driver = CarDriver()
    val writer = PPTWriter()
    val manager = SeniorManager(driver,writer)
    manager.driver()
    manager.driver1()
    manager.write()
}