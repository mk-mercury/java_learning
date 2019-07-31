package jp.co.FSsakusei2;

import java.util.Random;
import java.util.Scanner;

public class Challenge5 {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		Random r = new Random();

		int kaitou[] = { 0, 0, 0, 0, 0 };
		int input[] = { 0, 0, 0, 0, 0 };
		int cheak = 0;
		int hit = 0;
		int buro = 0;
		int a = r.nextInt(9);
		kaitou[0] = a;

		// 2つ目
		a = r.nextInt(9);
		while (cheak != 1) {
			if (kaitou[0] == a) {
				a = r.nextInt(9);
			} else {
				kaitou[1] = a;
				break;
			}
		}
		// 3つ目
		a = r.nextInt(9);
		while (cheak != 1) {
			if ((kaitou[0] == a) || (kaitou[1] == a)) {
				a = r.nextInt(9);
			} else {
				kaitou[2] = a;
				break;
			}
		}
		// 4つめ
		a = r.nextInt(9);
		while (cheak != 1) {
			if ((kaitou[0] == a) || (kaitou[1] == a) || (kaitou[2] == a)) {
				a = r.nextInt(9);
			} else {
				kaitou[3] = a;
				break;
			}
		}
		// 5つめ
		a = r.nextInt(9);
		while (cheak != 1) {
			if ((kaitou[0] == a) || (kaitou[1] == a) || (kaitou[2] == a)
					|| (kaitou[3] == a)) {
				a = r.nextInt(9);
			} else {
				kaitou[4] = a;
				break;
			}
		}

		System.out.println("5桁の数字を当てる(同じ数字は2回以上使わない)");
		System.out.println("3回間違えるとヒント");
		for (int i = 0; i < 5; i++) {
			System.out.println(kaitou[i]);
		}
		// int input1 = stdin.nextInt();

		// input[0]=input1/1000;
		// input[1]=(input1/100)%10;
		// input[2]=(input1/10)%10;
		// input[3]=input1%10;

		int count = 0;
		cheak = 0;
		while (cheak != 1) {
			hit = 0;
			buro = 0;
			if ((count % 3 == 0) && (count != 0)) {
				int hint = r.nextInt(4);
				System.out.println("3回ミスヒント:答えに「" + kaitou[hint] + "」が含まれる");
			}
			System.out.println(count + 1 + "回目入力");
			int input1 = stdin.nextInt();
			input[0] = (input1 / 10000) % 10;
			input[1] = (input1 / 1000) % 10;
			input[2] = (input1 / 100) % 10;
			input[3] = (input1 / 10) % 10;
			input[4] = input1 % 10;
			count = count + 1;

			for (int i = 0; i < 5; i++) {
				if (kaitou[i] == input[i]) {
					hit = hit + 1;
				}
			}
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (kaitou[i] == input[j]) {
						buro = buro + 1;
					}
				}
			}
			if (hit == 5) {
				System.out.println("正解");
				break;
			} else {
				buro = buro - hit;
				System.out.println("ヒット" + hit);
				// ブローはヒットの数を含めない
				System.out.println("ブロー" + buro);
			}

		}
	}

}
