import java.util.Random;
import java.util.Scanner;

public class kazuate {
	public static void main(String[] args) throws Exception {
		// コンピュータの数字を決める
		Random random = new Random();
		int number = random.nextInt(1000);
		System.out.println("数字を当ててみてね。");
		System.out.println("回答は10回までです。");
		System.out.println();
		var stdin = new Scanner(System.in);
		for (int count = 1; count <= 10; count++) {
			System.out.print(count + "回目：");
			int inputNumber = stdin.nextInt();
			System.out.println(inputNumber);
			if (number == inputNumber) {
				System.out.print("すごい！！" + count + "回で当てられちゃった！");
				return;
			}

			int znumber = number - inputNumber;
			if (znumber > -100 && znumber < 100 ) {
				System.out.println("近づいてきたよ");
			} else {
				System.out.println("まだまだ遠いよ");
			}
		}

		System.out.println("残念！！正解は " + number + " でした！");
		//終了処理
		stdin.close();
	}
}