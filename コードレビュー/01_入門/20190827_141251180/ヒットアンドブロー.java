���O�F��� �B��
���t�F19/08/11

package sample;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TatsuyaOobayashi {

	public static void main(String[] args) {

		// ���͗p�N���X
		Scanner stdin = new Scanner(System.in);

		// ���������p�N���X
		Random random = new Random();

		// �R���s���[�^�̐��������߂�
		// ��4�̐����ŁA�����������g���Ă͂����Ȃ�

		// �R���s���[�^���I�񂾐�����z��Ƃ��ĕێ����邽�߂̕ϐ�
		ArrayList<Integer> answer = new ArrayList<Integer>();

		// �����������g���Ȃ����߂̑΍�
		// 0-9�܂ł̐�������ꂽ�z�� numbers ���쐬����
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			numbers.add(i);
		}

		// numbers ���烉���_���ɐ�����4���o���āAanswers �ɓ����
		for (int i = 0; i < 4; i++) {
			// numbers ������o�������̃C���f�b�N�X�������_���Ō��߂�
			// ������ 0�` numbers�̗v�f��-1 �܂�
			int index = random.nextInt(numbers.size());

			// numbers ���烉���_���Ō��߂��C���f�b�N�X�̐��������o��
			int num = numbers.get(index);

			// ���o���������� answers �ɒǉ�����
			answer.add(num);

			// ���o���������� numbers �����菜��
			numbers.remove(index); // �z�񂩂� index �Ԗڂ̗v�f����菜��
		}

		System.out.println("numbers = " + numbers);
		System.out.println("answer = " + answer);
		System.out.println();

		// ���͉񐔂𐔂���ϐ�
		int count = 1;
		
		// �q���g���ɋ����鐔���̏��Ԃ̕ϐ�
		int anum = 1;

		// �N���A����܂ł̃��[�v(�N���A������break�Ŕ�����z��)
		while (true) {
			// ���[�U�[��4���̐�������͂���
			// ���͂��Ă����������b�Z�[�W��\��
			System.out.println("4���̐�������͂��Ă��������B");

			// ���[�U�[�����͂����������擾
			int input = stdin.nextInt();
			System.out.println("���͂��ꂽ������" + input + "�ł�");

			// ���͂��ꂽ������z���1�����i�[����
			ArrayList<Integer> user = new ArrayList<Integer>();
			user.add((input / 1000) % 10); // 1�ڂ̐���
			user.add((input / 100) % 10); // 2�ڂ̐���
			user.add((input / 10) % 10); // 3�ڂ̐���
			user.add(input % 10); // 4�ڂ̐���
			System.out.println(user);

			// ���͂��ꂽ�����̃q�b�g�̐��𐔂���
			int hit = 0;
			for (int i = 0; i < 4; i++) {
				if (answer.get(i) == user.get(i)) {
					// �ʒu�������������Ă���=�q�b�g!
					hit++;
				}
			}

			// ���͂��ꂽ�����̃u���[�̐��𐔂���
			int blow = 0;
			for (int i = 0; i < 4; i++) {
				// user��i�Ԗڂ̐����� answer����T�����߂̃��[�v
				int user_num = user.get(i); // ���͂��ꂽ������ i �Ԗڂ̐���

				for (int j = 0; j < 4; j++) {
					// user��i�Ԗڂ̐����� answer �� j �ԖڂƔ�r���邽�߂̃��[�v
					if (user_num == answer.get(j)) {
						if (i != j) { // �����ʒu�̏ꍇ�̓q�b�g�ɂȂ�̂ŁA���O����
							blow++;
						}
					}
				}
			}

			// �N���A���� (�q�b�g = 4)���s��(break�Ŕ�����)
			if (hit == 4) {
				break;
			}

			// ����(�q�b�g�̐��A�u���[�̐�) ��\��
			System.out.println("�c�O!!�q�b�g:" + hit + " / �u���[:" + blow);
			
			// 3�񂲂ƂɎg���Ă��鐔����������
			if((count % 3) == 0){
				System.out.println(anum + "�ڂ̐����� " + answer.get(anum - 1));
				anum++;
			}

			// ���͉񐔂�1���₷
			count++;
		}

		// �N���A���b�Z�[�W��\�����ďI��
		System.out.println("���߂łƂ�!!" + count + "��ڂœ��Ă�ꂿ�����!!");

		// �I���������s��
		stdin.close();
	}
}
