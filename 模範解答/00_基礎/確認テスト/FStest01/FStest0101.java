/**
 * 確認テスト0101
 *
 * 日付： 
 * 名前： 
 *
 * 課題
 * if-else文を使用して、int型の変数nの値に応じて出力結果が変わるプログラムを作成してください
 * 出力される文言は以下の通り。
 * nが0の場合 →「0です」
 * nが正の場合 →「正です」
 * nが負の場合 →「負です」
 */
package jp.co.FStest01;

public class FStest0101 {
    public static void main(String[] args) {
        int n = 0;
        // ↓↓↓↓ここに記述↓↓↓↓
        if (n == 0) {
            System.out.println("0です");
        } else if (0 < n) {
            System.out.println("正です");
        } else {
            System.out.println("負です");
        }
        // ↑↑↑↑ここに記述↑↑↑↑
    }
}