public class Main {
    public static void main(String[] args) throws Exception {

       // ランダムに値を取り出すキュークラスをインスタンス化
       RandomQueue randomqueue = new RandomQueue();

       // ランダムキュークラスに値を格納
       randomqueue.push("1番目");
       randomqueue.push("2番目");
       randomqueue.push("3番目");

       // 結果の表示
       System.out.println("ランダムキュー表示");
       System.out.println(randomqueue.pop());
       System.out.println(randomqueue.pop());
       System.out.println(randomqueue.pop());
       System.out.println("");
    }
}