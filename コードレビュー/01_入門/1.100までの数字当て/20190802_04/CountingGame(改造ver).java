package fs01_GettingStarted_ProgramCreation;

import java.util.Random;
import java.util.Scanner;

public class CountingGame {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Random random = new Random();
		Scanner stdin = new Scanner(System.in);

		int janny = random.nextInt(1000);	//ジャニー喜多川の入力

		System.out.println("YOU、数字当てちゃいなよ。");
		System.out.println("答えられるのは１０回までだよ。");
		System.out.println("");

		for(int i = 1; i<11; i++){
			int jr = stdin.nextInt();	//Jrの入力

			//判定(数字の離れ具合で出力結果を変更)

			//正解の場合
			if(janny==jr){
				System.out.println(i + "回目 : " + jr);
				System.out.println("");
				System.out.println
				("YOU、イケてるね！！ " + i + "回で当てちゃったよ！");

				//入力した数字が「正解の数字の+-5」の範囲内の場合
			} else if((jr>janny && jr<janny+5) || (jr<janny && jr>janny-5)){
				System.out.println(i + "回目 : " + jr);
				System.out.println
				("近いよ！！ YOUがCANと思うならDOすればいいじゃない！");

				//入力した数字が「正解の数字の+-250」の範囲外の場合
			} else if(jr>janny+250 || jr<janny-250){
				System.out.println(i + "回目 : " + jr);
				System.out.println("遠いよ！! YOUどこ行ってるの！");

				//入力した数字が「正解の数字～+250」の範囲内の場合
			} else if(jr>janny){
				System.out.println(i + "回目 : " + jr);
				System.out.println("もっと小さい数字だよ。");

				//入力した数字が「正解の数字～-250」の範囲内の場合
			} else {
				System.out.println(i + "回目 : " + jr);
				System.out.println("もっと大きい数字だよ。");
			}


			//10回入力して不正解の場合
			if(i==10 && janny!=jr){
				System.out.println("");
				System.out.println
				("YOU、イケてないね！！ 正解は「" + janny + "」だよ。");
			}

		}

	}

}

//<仕様変更>
//(済み) １．１０回まで数字を入力できるようにする
//(済み) ２．３桁の数字（０－９９９）を当てる仕様に変える
//(済み) ３．数字が遠く離れているか近いかでメッセージを変える
