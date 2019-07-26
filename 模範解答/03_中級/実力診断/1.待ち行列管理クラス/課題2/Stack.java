import java.util.ArrayList;

/**
 * 文字列を格納し、値を取り出すときは最新のものから取り出していくスタッククラス
 */

class Stack {

    // 文字列を格納するためのリスト
    ArrayList<String> list = new ArrayList<String>();

    // コンストラクタ
    public Stack(){}

    // 値を格納
    public void push(String str) {
        list.add(str);
    }

    // 値の取り出し
    public String pop() {
        // 取り出す値を格納する変数
        String str = "";

        // リストに一つでも値があるとき
        if(list.size() > 0) {
            // 格納した値の最新のものを取り出すためリストのサイズを表すlist.size()を使う。
            //list.size()で取れる値は配列の0番目を１と数えていくのでここで1をひかないと値が格納されていないところを参照してしまいエラーになる
        	str = list.get(list.size() - 1);
            // list.indexOf("indexの位置を知りたい文字列")で文字列のindexを検索可能
            list.remove(list.indexOf(str));
        } else {
            System.out.println("リストに何もありません。処理を終了します");
            System.exit(0);
        }

        return str;
    }
}