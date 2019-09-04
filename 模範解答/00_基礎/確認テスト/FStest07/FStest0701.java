/**
* 確認テスト0701
*
* 日付：
* 名前：
*
* 問題
* for文を使用し九九を表示するプログラムを作成してください
*
* 出力される文言は以下の通り。
* 1×1=1
* 1×2=2
* 1×3=3
* 1×4=4
* ～中略～
* 9×5=45
* 9×6=54
* 9×7=63
* 9×8=72
* 9×9=81
*/
package jp.co.FStest07;

public class FStest0701 {
    public static void main(String[] args) {
        //↓↓↓↓ここに記述↓↓↓↓
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.println(i + "×" + j + "=" + (i * j));
            }
        }
        //↑↑↑↑ここに記述↑↑↑↑
    }
}