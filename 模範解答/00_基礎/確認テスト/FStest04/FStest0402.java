/**
* 確認テスト0402
*
* 日付： 
* 名前： 
*
* 問題
* array に格納されている 10 個の整数を左右反転して配列rev_array に入れるプログラムを作成してください
*
* 出力される文言は以下の通り。
* 反転前の配列 12 54 2 -7 30 75 -34 91 27 -62
* 反転後の配列 -62 27 91 -34 75 30 -7 2 54 12
*/
package jp.co.FStest04;

public class FStest0402 {
    public static void main(String[] args) {
        int i;
        //反転前の配列
        int[] array = { 12, 54, 2, -7, 30, 75, -34, 91, 27, -62 };
        //arrayを反転して入れる配列
        int[] rev_array = new int[10];

        System.out.print("反転前の配列 ");
        for (i = 0; i < 10; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        //↓↓↓↓ここに反転処理を追加↓↓↓↓
        for (i = 0; i < 10; i++)
        {
            rev_array[(rev_array.length - 1) - i] = array[i];
        }
        //↑↑↑↑ここに反転処理を追加↑↑↑↑

        System.out.print("反転後の配列 ");
        for (i = 0; i < 10; i++)
        {
            System.out.print(rev_array[i] + " ");
        }
        System.out.println();
    }
}