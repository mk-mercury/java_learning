package introduction;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Program_5 {
	public static void main(String[] args) throws Exception {
		// 乱数を使う準備
		Random random = new Random();

		// 文字入力を行うので、Scanner の準備
		Scanner stdin = new Scanner(System.in);

		// ----------------------------------
		// コンピュータの数字を決める
		// ※４つの数字で、同じ数字を使ってはいけない

		// コンピューターが選んだ数字を配列として保持するための変数
		ArrayList<Integer> answer = new ArrayList<Integer>();

		// 同じ数字を使わないための対策を行う
		// 0-9までの数字を入れた配列 numbers を作成する
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			numbers.add(i);
		}
		// numbers からランダムに数字を４つ取り出して、answers に入れる
		for (int i = 0; i < 4; i++) {
			// numbers から取り出す数字のインデックスをランダムで決める
			// 乱数は ０〜 numbersの要素数-1 まで
			int index = random.nextInt(numbers.size());

			// numbers からランダムで決めたインデックスの数字を取り出す
			int num = numbers.get(index);

			// 取り出した数字を answers に追加する
			answer.add(num);

			// 取り出した数字を numbers から取り除く
			numbers.remove(index); // 配列から index 番目の要素を取り除く
		}
		System.out.println("numbers = " + numbers);
		System.out.println("answer = " + answer);
		System.out.println();

		// 入力回数を数える変数
		int count = 1;

		// クリアするまでのループ(クリアしたらbreakで抜ける想定)
		while (true) {
			// ユーザーが４桁の数字を入力する
			// 　入力してくださいメッセージを表示
			System.out.println("４桁の数字を入力してください。");

			// 　ユーザーが入力した数字を取得
			int input = stdin.nextInt();
			System.out.println("入力された数字は" + input + "です");

			// 　入力された数字を配列に１桁ずつ格納する
			ArrayList<Integer> user = new ArrayList<Integer>();
			user.add((input / 1000) % 10); // １つ目の数字
			user.add((input / 100) % 10); // ２つ目の数字
			user.add((input / 10) % 10); // ３つ目の数字
			user.add(input % 10); // ４つ目の数字
			System.out.println(user);

			// 入力された数字のヒットの数を数える
			int hit = 0;
			for (int i = 0; i < 4; i++) {
				if (answer.get(i) == user.get(i)) {
					// 位置も数字もあっている＝ヒット！
					hit++;
				}
			}

			// 入力された数字のブローの数を数える
			int blow = 0;
			for (int i = 0; i < 4; i++) {
				// userのi番目の数字を answer から探すためのループ
				int user_num = user.get(i); // 入力された数字の i 番目の数字

				for (int j = 0; j < 4; j++) {
					// userのi番目の数字が answer の j 番目と比較するためのループ
					if (user_num == answer.get(j)) {
						if (i != j) { // 同じ位置の場合はヒットになるので、除外する
							blow++;
						}
					}
				}
			}

			// クリア判定（ヒット＝４）を行う(breakで抜ける)
			if (hit == 4) {
				break;
			}

			// 結果（ヒットの数、ブローの数）を表示
			System.out.println("残念！！ヒット:" + hit + " / ブロー:" + blow);

			// 入力回数を１増やす
			count++;
		}

		// クリアメッセージを表示して終了
		System.out.println("おめでとう！！" + count + "回目で当てられちゃった！！");


		// 終了処理を行う
		stdin.close();
	}
}
