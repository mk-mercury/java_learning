名前：大林 達矢
日付：19/08/11

package sample;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TatsuyaOobayashi {

	public static void main(String[] args) {

		// 入力用クラス
		Scanner stdin = new Scanner(System.in);

		// 乱数生成用クラス
		Random random = new Random();

		// コンピュータの数字を決める
		// ※4つの数字で、同じ数字を使ってはいけない

		// コンピュータが選んだ数字を配列として保持するための変数
		ArrayList<Integer> answer = new ArrayList<Integer>();

		// 同じ数字を使われないための対策
		// 0-9までの数字を入れた配列 numbers を作成する
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			numbers.add(i);
		}

		// numbers からランダムに数字を4つ取り出して、answers に入れる
		for (int i = 0; i < 4; i++) {
			// numbers から取り出す数字のインデックスをランダムで決める
			// 乱数は 0～ numbersの要素数-1 まで
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
		
		// ヒント時に教える数字の順番の変数
		int anum = 1;

		// クリアするまでのループ(クリアしたらbreakで抜ける想定)
		while (true) {
			// ユーザーが4桁の数字を入力する
			// 入力してくださいメッセージを表示
			System.out.println("4桁の数字を入力してください。");

			// ユーザーが入力した数字を取得
			int input = stdin.nextInt();
			System.out.println("入力された数字は" + input + "です");

			// 入力された数字を配列に1桁ずつ格納する
			ArrayList<Integer> user = new ArrayList<Integer>();
			user.add((input / 1000) % 10); // 1つ目の数字
			user.add((input / 100) % 10); // 2つ目の数字
			user.add((input / 10) % 10); // 3つ目の数字
			user.add(input % 10); // 4つ目の数字
			System.out.println(user);

			// 入力された数字のヒットの数を数える
			int hit = 0;
			for (int i = 0; i < 4; i++) {
				if (answer.get(i) == user.get(i)) {
					// 位置も数字もあっている=ヒット!
					hit++;
				}
			}

			// 入力された数字のブローの数を数える
			int blow = 0;
			for (int i = 0; i < 4; i++) {
				// userのi番目の数字を answerから探すためのループ
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

			// クリア判定 (ヒット = 4)を行う(breakで抜ける)
			if (hit == 4) {
				break;
			}

			// 結果(ヒットの数、ブローの数) を表示
			System.out.println("残念!!ヒット:" + hit + " / ブロー:" + blow);
			
			// 3回ごとに使われている数字を教える
			if((count % 3) == 0){
				System.out.println(anum + "つ目の数字は " + answer.get(anum - 1));
				anum++;
			}

			// 入力回数を1増やす
			count++;
		}

		// クリアメッセージを表示して終了
		System.out.println("おめでとう!!" + count + "回目で当てられちゃった!!");

		// 終了処理を行う
		stdin.close();
	}
}
