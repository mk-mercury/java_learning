/**
* 確認テスト0404
*
* 日付： 
* 名前： 
*
* 問題
* 1～5までがランダムに入っている配列dataがあります、この配列dataに1～5が何個ずつあるか集計するプログラムを作成してください
*
* 出力される文言は以下の通り。
*
* 1は4個
* 2は3個
* 3は5個
* 4は2個
* 5は2個
*/
package jp.co.FStest04;

public class FStest0404 {

    static int[] data = { 1, 3, 5, 2, 1, 3, 4, 1, 1, 2, 3, 4, 5, 3, 3, 2 };

    public static void main(String[] args) {
        //↓↓↓↓ここに記述↓↓↓↓
        int[] sums = new int[5];

    	for(int i = 0; i < data.length; i++){
    		switch(data[i]){
	    		case 1:
	    			sums[0]++;
	    			break;
	    		case 2:
	    			sums[1]++;
	    			break;
	    		case 3:
	    			sums[2]++;
	    			break;
	    		case 4:
	    			sums[3]++;
	    			break;
	    		case 5:
	    			sums[4]++;
	    			break;
	    		default:
    		}
    	}

    	for(int j = 0; j < sums.length; j++)
    	{
    		System.out.println(j + 1 + "は" + sums[j] + "個");
    	}
        //↑↑↑↑ここに記述↑↑↑↑
    }
}