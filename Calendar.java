import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calendar{
	public static void main(String[] args) throws IOException{
		System.out.print("�J�����_�[���{���������N����͂��Ă��������B�F");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine());

		System.out.println("\n\n" + year + "�N\n\n");

		int y = year-1;
		int day = 1; //��������\���ϐ�
		int dw = (36+y%100+y%100/4+y/100*5+y/400)%7; //�c�F���[�̌����œ��͂��ꂽ�N��1��1���̗j�������߂�

		//�J�����_�[�\���i12�������J��Ԃ��j
		for(int i=1; i<=12; i++) {
			System.out.println(i + "��"); //��������\��
			System.out.println("��\t��\t��\t��\t��\t��\t�y"); //�j����\��

			//1���̗j���܂Ń^�u������
			for(int j=0; j<dw; j++) {
				System.out.print("\t");
			}

			//6�T���J��Ԃ�
			for(int k=0; k<6; k++) {
				if(k==0) { //1�T�ڂ͐挎�̍ŏI���̎��̗j������X�^�[�g
					for(; dw<7; dw++) {
						System.out.print(day + "\t");
						day++;
					}
				}else { //2�T�ڈȍ~�͓��j����X�^�[�g
					for(dw=0; dw<7; dw++) {
						System.out.print(day + "\t");

						if((i==2 && !(year%400==0 || (year%100!=0 && year%4==0)) && day==28) || (i==2 && day==29) ||
								((i==4 || i==6 || i==9 || i==11) && day==30) || day==31) { //���̍ŏI���Ȃ�
							day = 1; //1���ɂ���
							k = 6; //�����I��6�T�ڂɂ��ă��[�v���甲����
							dw++;
							if(dw==7) dw = 0; //���̌���1�T�ڂ͏���������Ȃ��̂ŁA�y�j���ŏI������ꍇ�͏�����
							break;
						}

						day++;
					}
				}

				System.out.println(); //���s
			}

			System.out.println("\n"); //2�s���s
		}
	}
}