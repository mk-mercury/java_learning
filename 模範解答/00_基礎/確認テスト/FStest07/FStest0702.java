/**
* 確認テスト0702
*
* 日付： 
* 名前： 
*
* 問題
* for文を使用して下記の仕様のプログラムを作成してください
*
* int型の20行20列の2次元配列を宣言する
*（規則）i 行 j 列の配列要素にする
*「i+j の値を 6 で割って余りが無い」または「i-j の値を 6 で割って余りが無い」場合 → 1 を代入
* そうでない場合 →  0 を代入
* この配列を画面出力する際に、1 は□　0は■で画面に表示
*
*
* 出力される文言は以下の通り。
* □■■■■■□■■■■■□■■■■■□■
* ■□■■■□■□■■■□■□■■■□■□
* ■■□■□■■■□■□■■■□■□■■■
* ■■■□■■■■■□■■■■■□■■■■
* ■■□■□■■■□■□■■■□■□■■■
* ■□■■■□■□■■■□■□■■■□■□
* □■■■■■□■■■■■□■■■■■□■
* ■□■■■□■□■■■□■□■■■□■□
* ■■□■□■■■□■□■■■□■□■■■
* ■■■□■■■■■□■■■■■□■■■■
* ■■□■□■■■□■□■■■□■□■■■
* ■□■■■□■□■■■□■□■■■□■□
* □■■■■■□■■■■■□■■■■■□■
* ■□■■■□■□■■■□■□■■■□■□
* ■■□■□■■■□■□■■■□■□■■■
* ■■■□■■■■■□■■■■■□■■■■
* ■■□■□■■■□■□■■■□■□■■■
* ■□■■■□■□■■■□■□■■■□■□
* □■■■■■□■■■■■□■■■■■□■
* ■□■■■□■□■■■□■□■■■□■□
*/
package jp.co.FStest07;

public class FStest0702 {
    public static void main(String[] args) {
        int[][] blocksArray = new int[20][20];

        blocksArray = setNumsToBlocksArray(blocksArray);
        showBlocks(blocksArray);
    }

    static int[][] setNumsToBlocksArray(int[][] blocksArray) {
        for (int i = 1; i < blocksArray.length; i++) {
            for (int j = 1; j < blocksArray[i].length; j++) {
                if ((i + j) % 6 == 0 || (i - j) % 6 == 0) {
                    blocksArray[i][j] = 1;
                } else {
                    blocksArray[i][j] = 0;
                }
            }
        }
        return blocksArray;
    }

    static void showBlocks(int[][] blocksArray) {
        for (int i = 1; i < blocksArray.length; i++) {
            for (int j = 1; j < blocksArray[i].length; j++) {
                if (blocksArray[i][j] == 1) {
                    System.out.print("□");
                } else {
                    System.out.print("■");
                }
            }
            System.out.println("");
        }
    }
}
