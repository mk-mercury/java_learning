public class Main {
    public static void main(String[] args) throws Exception {

       // スタッククラスのインスタンス化
       Stack stack = new Stack();

       // スタックに値を格納
       stack.push("1番目");
       stack.push("2番目");
       stack.push("3番目");

       // 結果の表示
       System.out.println("スタック表示");
       System.out.println(stack.pop());
       System.out.println(stack.pop());
       System.out.println(stack.pop());
       System.out.println("");
    }
}