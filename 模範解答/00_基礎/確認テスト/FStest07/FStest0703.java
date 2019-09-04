/**
* 確認テスト0703
*
* 日付： 
* 名前： 
*
* 問題
* 下記の仕様のプログラムを作成してください
*
* arrayを小さい順に並び替えて表示する
*
*
* 出力される文言は以下の通り。
* -62
* -34
* -7
* 2
* 12
* 27
* 30
* 54
* 75
* 91
*/
package jp.co.FStest07;

public class FStest0703 {
    public static void main(String[] args) {
        int[] array = { 12, 54, 2, -7, 30, 75, -34, 91, 27, -62 };
        bubbleSort(array);
        showArray(array);
    }

    /**
     * bubbleSort
     * 配列を昇順に並び替える
     * ①先頭から順番に末尾に向かって隣り合う値を昇順になるように入れ替え
     * ②末尾から先頭に向かって順番に最大値を決定
     * @param array 配列（並び替え対象）
     */
    private static void bubbleSort(int[] array) {
        int tmp;
        for (int i = array.length - 1; 0 < i; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[j + 1] == false) {
                    tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    /**
     * showArray
     * 配列の値をすべて表示
     */
    private static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}