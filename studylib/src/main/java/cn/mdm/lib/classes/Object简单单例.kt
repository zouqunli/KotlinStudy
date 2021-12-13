package cn.mdm.lib.classes

/**
 * kotlin中简单的单例实现
 * 视频：https://coding.imooc.com/lesson/108.html#mid=8256
 */

abstract class Play

//创建单例
object MusicPlay:Play(){
    fun playUrl(url:String){

    }
    fun stop(){

    }
}
//类似java实现可以用kotlin Bytecode 反编译成java查看 如下：
//public final class MusicPlay extends Play {
//    @NotNull
//    public static final MusicPlay INSTANCE;
//
//    public final void playUrl(@NotNull String url) {
//        Intrinsics.checkNotNullParameter(url, "url");
//    }
//
//    public final void stop() {
//    }
//
//    private MusicPlay() {
//    }
//
//    static {
//        MusicPlay var0 = new MusicPlay();
//        INSTANCE = var0;
//    }
//}

fun main(args: Array<String>) {
    //kotlin的调用
    MusicPlay.playUrl("http://yyds.mp4")
    //若是java中调用 这里只做查看，kotlin中使用不了
//    MusicPlay.INSTANCE.playUrl("http://yyds.mp4")
}