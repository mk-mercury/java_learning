/**
* 確認テスト0303
*
* 日付： 
* 名前： 
*
* 問題
* for文とif文を使用して、1から100までの間で3で割り切れ、かつ4で割り切れる数だけを表示するプログラムを作成してください
* 出力される文言は以下の通り。
* 12
* 24
* ～中略～
* 84
* 96
*/
package jp.co.FStest03;

public class FStest0303 {
    public static void main(String[] args) {
        //↓↓↓↓ここに記述↓↓↓↓
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 4 == 0) {
                System.out.println(i);
            }
        }
        //↑↑↑↑ここに記述↑↑↑↑
    }
}