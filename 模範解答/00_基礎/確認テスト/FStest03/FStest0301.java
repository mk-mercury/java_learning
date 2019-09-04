/**
* 確認テスト0301
*
* 日付： 
* 名前： 
*
* 問題
* for文とif文を使用して、1から10までの間で偶数だけを表示するプログラムを作成してください
* 偶数：2で割って余りが0の値
* Javaでの余りの求め方：演算子「%」を使用
*
* 出力される文言は以下の通り。
* 2
* 4
* 6
* 8
* 10
*/
package jp.co.FStest03;

public class FStest0301 {
    public static void main(String[] args) {
        //↓↓↓↓ここに記述↓↓↓↓
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
        //↑↑↑↑ここに記述↑↑↑↑
    }
}