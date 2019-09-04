/**
* 確認テスト05
*
* 日付： 
* 名前： 
*
* 問題
* 下記の型の定数を作成し表示するプログラムを作成してください
* String型
*	定数名：TYPE_STRING		値：String型の定数です！
* int型：
*	定数名：TYPE_INT		値：100
* long型：
*	定数名：TYPE_LONG		値：123
* float型
*	定数名：TYPE_FLOAT		値：3.14
*
* 出力される文言は以下の通り。
* String型の定数です！
* 100
* 123
* 3.14
*/
package jp.co.FStest05;

public class FStest05 {

    //↓↓↓↓ここに定数を記述↓↓↓↓
    private static final String TYPE_STRING = "String型の定数です！";
    private static final int TYPE_INT = 100;
    private static final long TYPE_LONG = 123L;
    private static final float TYPE_FLOAT = 3.14F;
    //↑↑↑↑ここに定数を記述↑↑↑↑

    public static void main(String[] args) {
        //↓↓↓↓ここに表示処理を記述↓↓↓↓
        System.out.println(TYPE_STRING);
        System.out.println(TYPE_INT);
        System.out.println(TYPE_LONG);
        System.out.println(TYPE_FLOAT);
        //↑↑↑↑ここに表示処理を記述↑↑↑↑
    }
}