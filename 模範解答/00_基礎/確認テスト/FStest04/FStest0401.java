/**
* 確認テスト0401
*
* 日付： 
* 名前： 
*
* 問題
* 果物配列を作成し配列の中身を全て表示するプログラムを作成してください
* 配列名：fruitArray
* 配列の中身： りんご、みかん、パイナップル、いちご、バナナ
*
* 出力される文言は以下の通り。
* りんご
* みかん
* パイナップル
* いちご
* バナナ
*/
package jp.co.FStest04;

public class FStest0401 {
    public static void main(String[] args) {
        //↓↓↓↓ここに記述↓↓↓↓
        String[] fruitArray = {"りんご", "みかん", "パイナップル", "いちご", "バナナ"};
        
        for (int i = 0; i < fruitArray.length; i++) {
            System.out.println(fruitArray[i]);
        }
        //↑↑↑↑ここに記述↑↑↑↑
    }
}