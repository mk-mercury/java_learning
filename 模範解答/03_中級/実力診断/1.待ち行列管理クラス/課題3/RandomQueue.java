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

    public String pop() {
        String pop_str = "";

        if(list.size() > 0) {
            // ランダムクラスの生成
            Random rnd = new Random();

            // 取り出す文字列のインデックスを生成
            int index = rnd.nextInt(list.size());

            //popした値の保存
            pop_str = list.get(index);
            //popした値の削除
            list.remove(index);

        } else {
            System.out.println("配列が空です。処理を終了します");
            System.exit(0);
        }

        return pop_str;
    }

}