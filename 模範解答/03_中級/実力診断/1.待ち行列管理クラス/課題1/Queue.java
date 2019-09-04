import java.util.ArrayList;

/**
 * 文字列を格納し、格納した順番に値を取り出すキュークラス
 */

class Queue {

    // 文字列を格納しておくためのString型のArrayListのlistを定義
    // 後々に値をどれ程格納するかわからないため動的に値を格納できるArrayListを利用
    ArrayList<String> list = new ArrayList<String>();

    // コンストラクタ
    public Queue(){};

    //リストに値を格納
    public void push(String str) {
        list.add(str);
    }

    //値の取得
    public String pop() {
        // 取り出す値を格納する変数
        String str = "";

        // 値を取り出し、その値を配列に残さないために削除
        if(list.size() > 0) {
        	str = list.get(0);
            list.remove(0);
        }

        // 取り出した値を返す
        return str;
    }
}