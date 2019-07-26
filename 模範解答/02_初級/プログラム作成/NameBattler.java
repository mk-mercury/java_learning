package novice;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;
import java.util.Scanner;

public class NameBattler {
	public static void main(String[] args) {
		// キーボード入力を行うための Scanner の準備
		Scanner stdin = new Scanner(System.in);

		// 乱数を使うための準備
		Random random = new Random();

		// ■処理の流れ
		// ①プレイヤー名の入力プレイヤー名の入力
		// １－１．プレイヤー１の名前を決める
		// １－２．プレイヤー２の名前を決める
		System.out.println("プレイヤー１の名前を入力：");
		String player1Name = stdin.nextLine();

		System.out.println("プレイヤー２の名前を入力：");
		String player2Name = stdin.nextLine();

		// ②キャラクターの作成キャラクターの作成
		// ２－１．プレイヤー１のキャラクターを作成
		// バランス調整として、HPは5倍の値にし、LUCKは0～50までの値にする
		int player1HP = GetNumber(player1Name, 0) * 5;
		int player1STR = GetNumber(player1Name, 1);
		int player1DEF = GetNumber(player1Name, 2);
		int player1LUCK = GetNumber(player1Name, 3) * 50 / 255;

		// ２ー２．プレイヤー２のキャラクターを作成
		int player2HP = GetNumber(player2Name, 0) * 5;
		int player2STR = GetNumber(player2Name, 1);
		int player2DEF = GetNumber(player2Name, 2);
		int player2LUCK = GetNumber(player2Name, 3) * 50 / 255;

		// ③バトル開始の表示
		System.out.println("プレイヤー１：" + player1Name + "(HP " + player1HP + " / STR " + player1STR + " / DEF " + player1DEF + " / LUCK " + player1LUCK + ")");
		System.out.println("プレイヤー２：" + player2Name + "(HP " + player2HP + " / STR " + player2STR + " / DEF " + player2DEF + " / LUCK " + player2LUCK + ")");
		System.out.println("");
		System.out.println("=== バトル開始 ===");

		while (true) {
			int power;
			int damage;
			int luck;

			// ④プレイヤー１の攻撃ターン
			// ４－１．プレイヤー１の攻撃
			System.out.println(player1Name + "の攻撃！");
			power = random.nextInt(player1STR) + 1;

			// ４－２．プレイヤー２のダメージ
			// 会心の一撃が発生しているか
			luck = random.nextInt(100);
			if (luck <= player1LUCK) {
				System.out.println("会心の一撃!");
				damage = power;
			} else {
				damage = power - player2DEF;
			}

			// ダメージが0以下の場合はミス！
			if (damage <= 0) {
				System.out.println(player1Name + "の攻撃はミス！");
			} else {
				System.out.println(player2Name + "に" + damage + "のダメージ！");
				player2HP = player2HP - damage;
			}

			// ４－３．プレイヤー２の死亡判定→⑥へ
			if (player2HP <= 0) {
				System.out.println(player2Name + "は力尽きた...");
				break;
			}

			// ⑤プレイヤー２の攻撃ターン
			// ５－１．プレイヤー２の攻撃
			System.out.println(player2Name + "の攻撃！");
			power = random.nextInt(player2STR) + 1;

			// ５－２．プレイヤー１のダメージ
			// 会心の一撃が発生しているか
			luck = random.nextInt(100);
			if (luck <= player2LUCK) {
				System.out.println("会心の一撃!");
				damage = power;
			} else {
				damage = power - player1DEF;
			}

			// ダメージが0以下の場合はミス！
			if (damage <= 0) {
				System.out.println(player2Name + "の攻撃はミス！");
			} else {
				System.out.println(player1Name + "に" + damage + "のダメージ！");
				player1HP = player1HP - damage;
			}

			// ５－２．プレイヤー１の死亡判定→⑥へ
			if (player1HP <= 0) {
				System.out.println(player1Name + "は力尽きた...");
				break;
			}

			// ※④と⑤の繰り返し
			System.out.println("");
			System.out.println("- 次のターン -");
			System.out.println("プレイヤー１：" + player1Name + "(HP " + player1HP + ")");
			System.out.println("プレイヤー２：" + player2Name + "(HP " + player2HP + ")");
			System.out.println("--------------------------------");
		}

		// ⑥勝ち負けの表示
		System.out.println("");
		if (player1HP <= 0) {
			System.out.println(player2Name + "の勝利！！");
		} else {
			System.out.println(player1Name + "の勝利！！");
		}

		// プログラム終了前の後片付け
		stdin.close();
	}

	// ハッシュダイジェストから数値を取り出す
	// name : 名前
	// index : 何番目の数値を取り出すか
	// return 数値(0~255)
	public static Integer GetNumber(String name, Integer index) {
		try {
			byte[] result = MessageDigest.getInstance("SHA-1").digest(name.getBytes());
			String digest = String.format("%040x", new BigInteger(1, result));
			String hex = digest.substring(index * 2, index * 2 + 2);
			return Integer.parseInt(hex, 16);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
}