���O�F��� �B��
���t�F19/08/04

import java.util.Random;
import java.util.Scanner;

public class  Main { 
    public static void main(String[] args) {

		Random random = new Random();

		System.out.println("����񂯂񏟕�");

		System.out.println("�O�[�`���L�p�[�𐔎��œ��͂��Ă�");

		System.out.println("0:�O�[");

		System.out.println("1:�`���L");

		System.out.println("2:�p�[");

		System.out.println();

		String[] names = { "�O�[", "�`���L", "�p�[" };

		// �|�����̎��
		Scanner stdin = new Scanner(System.in);

		Boolean isFirst = true;
		while (true) {

			if (isFirst == true) {

				System.out.print("�ŏ��͂��[�A������������F");

			} else {

				System.out.print("�������ł��F");

			}

			// ���[�U�[���͗p

			int player = stdin.nextInt();

			System.out.println(player);

			// �ΐ푊��p

			int com = random.nextInt(3);

			System.out.println(names[com] + "(COM)��" + names[player]
					+ "(Player)�Łc");

			// �ΐ팋��

			if (com == player) {

				System.out.println("����������I");
				isFirst = false;

			} else if ((com == 0 && player == 1) || (com == 1 && player == 2)
					|| (com == 2 && player == 0)) {

				sub1();

				break;

			} else {

				sub2();

				break;

			}
			System.out.println();
		}

		// �I������
		stdin.close();
	}

	private static void sub1() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

		System.out.println("�������ނ��ăz�C����");

		System.out.println("�㉺���E�𐔎��œ��͂��Ă�");

		System.out.println("0:��");

		System.out.println("1:��");

		System.out.println("2:�E");

		System.out.println("3:��");

		System.out.println();

		String[] hands1 = { "��", "��", "�E", "��" };

		Random randomA = new Random();

		Scanner stdin = new Scanner(System.in);

		while (true) {
			System.out.println("�������ނ��ăz�C!");

			// ���[�U�[���͗p

			int player = stdin.nextInt();

			System.out.println(player);

			// �ΐ푊��p

			int com = randomA.nextInt(4);

			System.out.println(hands1[com] + "(COM)��" + hands1[player]
					+ "(Player)�Łc");

			// �ΐ팋��

			if (com == player) {

				System.out.println("���Ȃ��̕���");

				return;

			} else {

				System.out.println("������x!");
				return;

			}
		}
	}

	private static void sub2() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

		System.out.println("�������ނ��ăz�C����");

		System.out.println("�㉺���E�𐔎��œ��͂��Ă�");

		System.out.println("0:��");

		System.out.println("1:��");

		System.out.println("2:�E");

		System.out.println("3:��");

		System.out.println();

		String[] hands1 = { "��", "��", "�E", "��" };

		Random randomA = new Random();

		Scanner stdin = new Scanner(System.in);

		while (true) {
			System.out.println("�������ނ��ăz�C!");

			// ���[�U�[���͗p

			int player = stdin.nextInt();

			System.out.println(player);

			// �ΐ푊��p

			int com = randomA.nextInt(4);

			System.out.println(hands1[com] + "(COM)��" + hands1[player]
					+ "(Player)�Łc");

			// �ΐ팋��

			if (com == player) {

				System.out.println("���Ȃ��̏���");

				return ;

			} else {

				System.out.println("������x!");
				return;

			}
		}
	}
}
