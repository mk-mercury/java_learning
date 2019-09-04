/**
* 確認テスト0302
*
* 日付： 
* 名前： 
*
* 問題
* for文とif文を使用して、1から100までの間で4で割り切れる数だけを表示するプログラムを作成してください
* 出力される文言は以下の通り。
* 4
* 8
* 12
* 16
* ～中略～
* 92
* 96
* 100
*/
package jp.co.FStest03;

public class FStest0302 {
    public static void main(String[] args) {
    	//↓↓↓↓ここに記述↓↓↓↓
        for (int i = 1; i <= 100; i++) {
            if (i % 4 == 0) {
                System.out.println(i);
            }
        }
    	//↑↑↑↑ここに記述↑↑↑↑
    }
}