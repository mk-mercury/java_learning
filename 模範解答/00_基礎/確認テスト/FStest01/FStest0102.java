/**
* 確認テスト0102
*
* 日付： 
* 名前： 
*
* 課題
* if-else文を使用して、int型の変数nの値に応じて出力結果が変わるプログラムを作成してください
* 出力される文言は以下の通り。
* nが0以上10未満 →「0以上10未満です」
* それ以外 →「0以上10未満ではありません」
*/
package jp.co.FStest01;

public class FStest0102 {
    public static void main(String[] args) {
        int n = 10;
        //↓↓↓↓ここに記述↓↓↓↓
        if (0 <= n && n < 10) {
            System.out.println("0以上10未満です");
        } else {
            System.out.println("0以上10未満ではありません");
        }
        //↑↑↑↑ここに記述↑↑↑↑
    }
}