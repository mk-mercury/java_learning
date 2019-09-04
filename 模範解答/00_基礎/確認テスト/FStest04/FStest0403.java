/**
* 確認テスト0403
*
* 日付： 
* 名前： 
*
* 問題
* arrayAとarrayB に格納されている6個の整数を足した値を配列arrayResultに入れるプログラムを作成してください
*
* 出力される文言は以下の通り。
* 配列A 1 4 0 3 2 5
* 配列B 2 4 1 3 2 1
* 結果 3 8 1 6 4 6

*/
package jp.co.FStest04;

public class FStest0403 {
    public static void main(String[] args) {
        int i;
        int[] arrayA = { 1, 4, 0, 3, 2, 5 };
        int[] arrayB = { 2, 4, 1, 3, 2, 1 };
        int[] arrayResult = { 0, 0, 0, 0, 0, 0 };

        //↓↓↓↓ここに記述↓↓↓↓
        int arraySize = arrayA.length;
        for (i = 0; i < arraySize; i++)
        {
            arrayResult[i] = arrayA[i] + arrayB[i];
        }

        System.out.print("配列A ");
        for (i = 0; i < arraySize; i++)
        {
            System.out.print(arrayA[i] + " ");
        }
        System.out.println();

        System.out.print("配列B ");
        for (i = 0; i < arraySize; i++)
        {
            System.out.print(arrayB[i] + " ");
        }
        System.out.println();

        System.out.print("結果 ");
        for (i = 0; i < arraySize; i++)
        {
            System.out.print(arrayResult[i] + " ");
        }
        System.out.println();
        //↑↑↑↑ここに記述↑↑↑↑
    }
}