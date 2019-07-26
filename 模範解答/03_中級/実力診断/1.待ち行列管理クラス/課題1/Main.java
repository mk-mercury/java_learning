public class Main {
    public static void main(String[] args) throws Exception {

       // キュークラスのインスタンス化
       Queue queue = new Queue();

       // 値をキュークラスに格納
       queue.push("1番目");
       queue.push("2番目");
       queue.push("3番目");

       // キュークラスのpopメソッドを使うことで値を取り出し結果を表示
       System.out.println("キュー表示");
       System.out.println(queue.pop());
       System.out.println(queue.pop());
       System.out.println(queue.pop());
       System.out.println("");
    }

}