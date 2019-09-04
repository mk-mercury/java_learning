import java.util.ArrayList;
import java.util.Random;

/**
 * 文字列を格納し、その値をランダムな順番で取り出すランダムキュークラス
 */
class RandomQueue {
    // 値の格納用リスト
    ArrayList<String> list = new ArrayList<String>();

    // コンストラクタ
    public RandomQueue() {}

    //値の格納
    public void push(String str) {
        list.add(str);
    }

    // 値の取り出し
    public String pop() {
        String str = "";

        if(list.size() > 0) {
            // ランダムクラスの生成
            Random random = new Random();

            // 取り出す文字列のインデックスを生成
            int index = random.nextInt(list.size());

            //popした値の保存
            str = list.get(index);
            //popした値の削除
            list.remove(index);

        }

        return str;
    }

}