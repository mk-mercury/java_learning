/**
* 確認テスト0204
*
* 日付： 
* 名前： 
*
* 問題
* for文を使用して、1から10まで合計した数値を表示するプログラムを作成してください
* 出力される文言は以下の通り。
* 55
*/
package jp.co.FStest02;

public class FStest0204 {
    public static void main(String[] args) {
        //↓↓↓↓ここに記述↓↓↓↓
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum = sum + i;
        }
        System.out.println(sum);
        //↑↑↑↑ここに記述↑↑↑↑
    }
}