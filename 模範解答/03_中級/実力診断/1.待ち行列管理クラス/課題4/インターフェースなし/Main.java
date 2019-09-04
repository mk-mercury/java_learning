public class Main {
    public static void main(String[] args) throws Exception {

       // どの値から取り出すかを優先度として設定し、優先度によって値を取り出すpriorityキュークラスをインスタンス化
       PriorityQueue priorityqueue = new PriorityQueue();

       // 値と優先度をセットで格納
       priorityqueue.push("1番目", 10);
       priorityqueue.push("2番目", 10);
       priorityqueue.push("3番目", 100);
       priorityqueue.push("4番目", 50);

       // 結果の表示
       System.out.println("優先度キュー表示");
       System.out.println(priorityqueue.pop());
       System.out.println(priorityqueue.pop());
       System.out.println(priorityqueue.pop());
       System.out.println(priorityqueue.pop());
       System.out.println("");
    }
}