package fsnyuumon5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//チャレンジ：3回ごとに使われている数字を1つ教えてくれる
public class FSnyuumon5_3 {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		ArrayList<String>list = new ArrayList<String>();//0-9の数字が入ったリスト
		ArrayList<String>list2 = new ArrayList<String>();//listからランダムに4つの数字を入れたリスト
		ArrayList<String>list2Hint = new ArrayList<String>();//list2に使われている数字を順番は1つずつ教えるリスト
		ArrayList<String>list3 = new ArrayList<String>();//入力した数字を入れ、list2と比較するリスト
		int number = 5;//何桁の数字を当てるようにするか
		int count = 0;
		int Hintcount = 0;

		for(int i = 0 ; i < 10 ; i++) {

			String k = String.valueOf(i);
			list.add(k);
		}
		//シャッフルして順番をランダムに並び替える
		Collections.shuffle(list);

		for(int j = 0 ; j < number ; j++) {
			list2.add(list.get(j));
		}

		//ヒントの作成
		for(int j = 0 ; j < list2.size() ; j++) {
			list2Hint.add(list2.get(j));
		}
		Collections.shuffle(list2Hint);

		while(true) {

		System.out.print(number +  "桁の数字を入力してください。");
		String answer = stdin.next();
		count = count + 1;

		for(int i = 0 ; i < answer.length() ; i++) {

			String l = String.valueOf(answer.charAt(i));
			list3.add(l);
		}

		//2つのリストを比較する
		int HitCount = 0;
		int BlowCount = 0;

		for(int i = 0 ; i < list2.size() ; i++) {

			if(list2.get(i).equals(list3.get(i))) {

				HitCount++;
			}
		}

		if(HitCount == list2.size()) {

			System.out.println("おめでとう！" + count + "回目で成功♪");
			stdin.close();
			return;
		}

		for(String a : list2) {
			for(String b : list3) {

				if(a.equals(b)) {
					BlowCount++;//このままだとヒットの場合の数も含んでいる
					break;
				}
			}
		}

		BlowCount = BlowCount-HitCount;
		System.out.println(list2);
		System.out.println("ヒット:" + HitCount + "個、ブロー:" + BlowCount + "個");
		System.out.println("");

		if(count % 3 == 0 && Hintcount < list2.size()) {

			System.out.println("ヒント:" + list2Hint.get(Hintcount) + "の数字がどこかに使われているよ");
			Hintcount++;
		}

		list3.clear();
		}

	}

}
