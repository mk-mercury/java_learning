package name_battler;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;
import java.util.Scanner;

public class NameBattler_5 {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		Random rnd = new Random();

		System.out.print("プレイヤー1の名前を入力してください:");
		String Player1 = stdin.next();

		System.out.print("プレイヤー2の名前を入力してください:");
		String Player2 = stdin.next();

		//体力を生成
		int Player1HP = GetNumber(Player1, 0) * 5;
		int Player2HP = GetNumber(Player2, 2) * 5;
		//攻撃力を生成
		int Player1STR = GetNumber(Player1, 1);
		int Player2STR = GetNumber(Player2, 2);
		//防御力を生成
		int Player1DEF = GetNumber(Player1, 2);
		int Player2DEF = GetNumber(Player2, 0);
		//運を生成
		int Player1LUCK = GetNumber(Player1, 3) * 50 / 255;
		int Player2LUCK = GetNumber(Player2, 3) * 50 / 255;

		System.out.println("プレイヤー1:" + Player1 + " /体力:" + Player1HP + " /攻撃力:" +
				Player1STR + " /防御力:" + Player1DEF + " /運:" + Player1LUCK);
		System.out.println("プレイヤー2:" + Player2 + " /体力:" + Player2HP + " /攻撃力:" +
				Player1STR + " /防御力:" + Player2DEF + " /運:" + Player2LUCK);

		stdin.close();

		System.out.println("");
		System.out.println("===バトル開始===");

		while(Player1HP > 0 && Player2HP > 0) {

			System.out.println(Player1 + "の攻撃！");
			int ATK = rnd.nextInt(Player1STR) + 1;
			int damage = ATK - Player2DEF;
			int Luck = rnd.nextInt(100);

			if(Luck <= Player1LUCK) {

				System.out.println("会心の一撃！");
				damage = ATK;
			}
			if(damage <= 0) {

				System.out.println("攻撃がミス");
			}
			else {

				System.out.println(Player2 + "に" + damage + "のダメージ！");
				Player2HP -= damage;
			}

			if(Player2HP <= 0) {

				System.out.println(Player2 + "は力尽きた…\n");
				System.out.println(Player1 + "の勝利！");

				return;
			}

			System.out.println(Player2 + "の攻撃！");
			ATK = rnd.nextInt(Player2STR) + 1;
			damage = ATK - Player1DEF;

			if(Luck <= Player2LUCK) {

				System.out.println("会心の一撃！");
				damage = ATK;
			}
			if(damage <= 0) {

				System.out.println("攻撃がミス");
			}
			else {
				System.out.println(Player1 + "に" + damage + "のダメージ！");
				Player1HP -= damage;
			}

			if(Player1HP <= 0) {

				System.out.println(Player1 + "は力尽きた…\n");
				System.out.println(Player2 + "の勝利！");

				return;
			}

			if(Player1HP > 0 && Player2HP > 0) {

				System.out.println("");
				System.out.println("-次のターン-");
				System.out.println("プレイヤー1：" + Player1 + "(HP " + Player1HP + ")");
				System.out.println("プレイヤー2：" + Player2 + "(HP " + Player2HP + ")");
				System.out.println("---------------------------------");

				damage = rnd.nextInt(3) + 1;
			}
		}


	}
	// ハッシュダイジェストから数値を取り出す
	// name : 名前
	// index : 何番目の数値を取り出すか
	// return 数値(0~255)
	public static Integer GetNumber(String name, Integer index){

		try {
			byte[] result = MessageDigest.getInstance("SHA-1").digest(name.getBytes());
			String digest = String.format("%040x", new BigInteger(1, result));
			String hex = digest.substring(index * 2, index * 2 + 2);
			return Integer.parseInt(hex, 16);
		}
		catch (Exception e){

			e.printStackTrace();
		}
		return 0;
	}


}
