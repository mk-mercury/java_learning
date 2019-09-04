/**
* 確認テスト0103
*
* 日付： 
* 名前： 
*
* 課題
* if-else文を使用して、int型の変数nの値に応じて出力結果が変わるプログラムを作成してください
* 出力される文言は以下の通り。
* nが10または20 →「10または20です」
* それ以外 →「10でも20でもありません」
*/
package jp.co.FStest01;

public class FStest0103 {
    public static void main(String[] args) {
        int n = 10;
        //↓↓↓↓ここに記述↓↓↓↓
        if (n == 10 || n == 20) {
            System.out.println("10または20です");
        } else {
            System.out.println("10でも20でもありません");
        }
        //↑↑↑↑ここに記述↑↑↑↑
    }
}
