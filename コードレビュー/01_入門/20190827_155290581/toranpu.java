
package introduction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
public class toranpu {
	public static void main(String[] args) {
		//図柄のリスト
		ArrayList<String> mark = new ArrayList<String>();
		Collections.addAll(mark, "ハート", "ダイヤ", "スペード", "クローバー");
		//数字のリスト
		ArrayList<String> number = new ArrayList<>();
		Collections.addAll(number, "A", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"J", "Q", "K");
		//数値用のクラス
		Random random = new Random();
		Scanner stdin = new Scanner(System.in);

		//図柄の答えの要素番号
		int markRam = random.nextInt(4);
		//数字の答えの要素番号
		int numberRam = random.nextInt(13);
		System.out.println("トランプを選んだよ¥nトランプの図柄を当ててね¥n");
		System.out.print("0:ハート¥n1:ダイヤ¥n2:スペード¥n3:クローバー¥n");
		//図柄を当てさせる
		int i;
		for (i = 0; i<=3 ; i++) {
		            if (i == 3) {
		                System.out.println("3回目になりました。ゲームオーバーです。正解は" + markRam + "でした。");
		                break;
		            }else {
					//図柄の回答番号を入れる変数
					int markAns = 0;
					System.out.print("どれだと思う：");
					markAns = stdin.nextInt();
		                if (markAns != markRam) {
		              			//回答が間違っている場合
						System.out.println("¥n残念！" + mark.get(markAns) + "じゃないよ");
					} else {
						//回答があっている場合
						System.out.println("¥n正解！図柄は" + mark.get(markRam) + "だよ¥n");
						break;
		                }
		            }
		        }
		System.out.print("次は数字を当ててね¥n");
		//数字を当てさせる
		for (i = 0; i<=5 ; i++) {
            if (i == 5) {
                System.out.println("5回目になりました。ゲームオーバーです。正解は" + numberRam + "でした。");
                break;
            }else {
						//数字の回答番号を入れる変数
	int numberAns = 0;
	System.out.print("どれだと思う：");
	numberAns = stdin.nextInt();
if (numberAns - 1 == numberRam) {
              							//回答があっている場合
		System.out.print("¥n正解！" + mark.get(markRam) + "の" +
				number.get(numberRam) + "だよ");
		break;
}  else if (numberAns - 1 < numberRam) {
              			//正解より大きい場合
				System.out.println("¥n残念！" + number.get(numberAns - 1) + "よりもっと小さいよ");
			} else {
				//正解より小さい場合
				System.out.println("¥n残念！" + number.get(numberAns - 1) + "よりもっと大きいよ");
                }
            }
        }
		//終了処理を行う
		stdin.close();
	}
}
