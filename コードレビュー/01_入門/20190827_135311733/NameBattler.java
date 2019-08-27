package namebattler;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;
import java.util.Scanner;


public class NameBattler{
	public static void main(String[] args) {

		var stdin = new Scanner(System.in);

		Random random = new Random();

		System.out.print("プレイヤー１の名前を入力してください：");
		String player1 = stdin.next();
		System.out.print("プレイヤー２の名前を入力してください：");
		String player2 = stdin.next();

		int player1_hp = GetNumber(player1,0) / 2;
		int player2_hp = GetNumber(player2,0) / 2;
		int player1_at = GetNumber(player1,1) / 6;
		int player2_at = GetNumber(player2,1) / 6;
		int player1_df = GetNumber(player1,2) / 6;
		int player2_df = GetNumber(player2,2) / 6;
		int player1_lu = GetNumber(player1,3) / 10;
		int player2_lu = GetNumber(player2,3) / 10;

		System.out.println("プレイヤー1:HP" + player1_hp + " AT" + player1_at + " DF" + player1_df + " LU" + player1_lu);
		System.out.println("プレイヤー2:HP" + player2_hp + " AT" + player2_at + " DF" + player2_df + " LU" + player2_lu);

		System.out.println("\n=== バトル開始 ===");

		while(true) {
			System.out.println(player1 + "の攻撃！");
			int player1_dam = player1_at - player2_df;
			if(player1_lu > random.nextInt(100)) {
				player1_dam = player1_at;
			}
			if(player1_dam <= 0) {
				System.out.println("攻撃がミス");
			}
			else {
				player2_hp -= player1_dam;
				System.out.println(player2 + "に" + player1_dam + "のダメージ！");
			}
			if(player2_hp <= 0) {
				System.out.println(player2 + "は力尽きた...");
				System.out.println(player1 + "の勝利！");
				break;
			}

			System.out.println(player2 + "の攻撃！");
			int player2_dam = player2_at - player1_df;
			if(player2_lu > random.nextInt(100)) {
				player2_dam = player2_at;
			}
			if(player2_dam <= 0) {
				System.out.println("攻撃がミス");
			}
			else {
				player1_hp -= player2_dam;
				System.out.println(player1 + "に" + player2_dam + "のダメージ！");
			}
			if(player1_hp <= 0) {
				System.out.println(player1 + "は力尽きた...");
				System.out.println(player2 + "の勝利！");
				break;
			}

			System.out.println("\n- 次のターン -");
			System.out.println("プレイヤー１：" + player1 + "(HP " + player1_hp + ")");
			System.out.println("プレイヤー２：" + player2 + "(HP " + player2_hp + ")");
			System.out.println("--------------------------------");
		}
		stdin.close();
	}

	public static Integer GetNumber(String name, Integer index) {
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