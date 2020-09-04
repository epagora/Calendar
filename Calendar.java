import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Calendar
{
	public static void main(String[] args) throws IOException
	{
		System.out.print("カレンダーを閲覧したい年を入力してください。：");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine());

		System.out.println("\n\n" + year + "年\n\n");

		int y = year-1;
		int day = 1;
		int dw = (36+y%100+y%100/4+y/100*5+y/400)%7;

		for(int i=1; i<=12; i++) {
			System.out.println(i + "月");
			System.out.println("日\t月\t火\t水\t木\t金\t土");

			for(int l=0; l<dw; l++) {
				System.out.print("\t");
			}

			for(int j=0; j<6; j++) {
				if(j==0) {
					for(; dw<7; dw++) {
						System.out.print(day + "\t");
						day++;
					}
				}else {
					for(dw=0; dw<7; dw++) {
						System.out.print(day + "\t");

						if((i==2 && !(year%400==0 || (year%100!=0 && year%4==0)) && day==28) || (i==2 && day==29) ||
								((i==4 || i==6 || i==9 || i==11) && day==30) || day==31) {
							day = 1;
							j = 6;
							dw++;
							if(dw==7) dw = 0;
							break;
						}

						day++;
					}
				}

				System.out.println();
			}

			System.out.println("\n");
		}
	}
}