package cn.mdm.lib.classes

//kotlin 官网 https://kotlinlang.org/docs/getting-started.html
/**
 * 类的创建和类方法和变量的说明
 *  lateinit,by, open
 *  视频： https://coding.imooc.com/lesson/108.html#mid=8291
 *  https://coding.imooc.com/lesson/108.html#mid=8290
 */
//1.类的简单创建
//啥都没有都可以创建一个类
class Test
//当然啥都没有也没有什么意义,原始创建
class Test1{
    //在类中创建的变量，kotlin会自动赋予get和set的
    var a = 0
    //当然你也可以写出来，虽然没什么用 如下
//    var a = 0
//    get
//    set
    //若想自定义get，set怎么办？
    var b = 0
        get(){
            //这就是get的方法体,我们可以打印一下文字
            println("这里是b的Get方法 $field")
            //这里面的 field自动生成的其实就是默认的b的本体
            return field
        }
        //这里的value的类型就是定义成员变量b的类型
        set(value) {
            //这里就是set的方法体
            println("这里是b的Get方法 $field")
            //这里我们就给value + 1再赋值给本体field
            field = value + 1
        }
    //若是想要开放继承get，set方法怎么办
    //因为在kotlin中类的成员变量的定义都是public的，所以要使用此变量其实不用这么麻烦
    //但是为了学习还是记录下怎么继承，简单来说就是使用protected字段定义变量，其实不怎么用的到
    protected var c = 0
    protected get
    protected set

    //2.当你的成员变量不想定义时就初始化可以加个lateint关键字
    //但要记住一定要先定义类型，然后要注意的是必须再用到的时候初始化使用，否则会异常报错
    lateinit var d:String

    //3.当你的成员变量是val常量的时候你想要延迟初始化怎么办,可以如下使用 by lazy
    val e: Person by lazy {
        print("我是在使用的时候才初始化的被调用该方法的哦")
        //依然是最后一行是赋值
        Person("jack","28")
    }
    //而且val修饰的只能有get不能有set 因为常量一旦被定义是不可修改的
    val f:String = "haha"
    get() = field  //没有特殊需求只是返回当前字段也是可以不用写这个get的

    //4.极端用法 不推荐
    //当你想让你的成员变量可以为null 你就要这么设置了
    //但这么设置面临的是使用这个参数的使用 Test1().g?.length 其中必须加上?
    //所以是不推荐的
    var g:String? = null
}

//5.创建类简化版本及类的特性
//若想此类可以被继承 必须在类名前加上 open 关键字
//而且可以把类变量放入类名的后的()中定义， 这既是类的构造方法也做了类成员变量的定义，双重功能
open class Person1(var name: String ,var age:String ){}
//也可以给上初始值
open class Person(var name: String = "jack",var age:String = "28"){
    //这里的init是kotlin给每个类初始化定义的方法，你可以在这里面做一些初始化操作或其他你想做的
    init {
        println("${this.javaClass.simpleName} my name is $name and my age is $age")
    }
}
//但要注意的是构造方法中用var|val定义的才是成员变量，若不是就是普通的构造方法的参数并不是类的成员变量
//类的成员变量是可以被类中的方法访问的，但普通参数不行
open class Person3(var name: String,age: String){
    //
    init {
        name = "我可以被访问，因为我是类成员变量"
        //age 就会报错，因为它是普通参数不能在类中随意使用
//        age =
    }
}



/**
 * 女人
 */
class Women(name:String,age: String): Person(name,age)

/**
 * 男人
 */
class Man(name:String,age:String): Person(name,age) {
    //直接打印toString方法内容
    override fun toString(): String {
        return "${name}男人"
    }
}

fun main(args:Array<String>) {
    val man = Man("Jack","28")
    val women = Women("lucy","27")
    //定义了构造函数是传两个参数，所以初始化就必须带上参数
    val person1 = Person1("zuo","22")
    //这里因为定义类时给了初始值 所以可以不用给值
    val person = Person()
}