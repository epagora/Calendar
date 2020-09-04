import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calendar{
	public static void main(String[] args) throws IOException{
		System.out.print("カレンダーを閲覧したい年を入力してください。：");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine());

		System.out.println("\n\n" + year + "年\n\n");

		int y = year-1;
		int day = 1; //何日かを表す変数
		int dw = (36+y%100+y%100/4+y/100*5+y/400)%7; //ツェラーの公式で入力された年の1月1日の曜日を求める

		//カレンダー表示（12か月分繰り返す）
		for(int i=1; i<=12; i++) {
			System.out.println(i + "月"); //何月かを表示
			System.out.println("日\t月\t火\t水\t木\t金\t土"); //曜日を表示

			//1日の曜日までタブを入れる
			for(int j=0; j<dw; j++) {
				System.out.print("\t");
			}

			//6週分繰り返す
			for(int k=0; k<6; k++) {
				if(k==0) { //1週目は先月の最終日の次の曜日からスタート
					for(; dw<7; dw++) {
						System.out.print(day + "\t");
						day++;
					}
				}else { //2週目以降は日曜からスタート
					for(dw=0; dw<7; dw++) {
						System.out.print(day + "\t");

						if((i==2 && !(year%400==0 || (year%100!=0 && year%4==0)) && day==28) || (i==2 && day==29) ||
								((i==4 || i==6 || i==9 || i==11) && day==30) || day==31) { //月の最終日なら
							day = 1; //1日にする
							k = 6; //強制的に6週目にしてループから抜ける
							dw++;
							if(dw==7) dw = 0; //次の月の1週目は初期化されないので、土曜日で終わった場合は初期化
							break;
						}

						day++;
					}
				}

				System.out.println(); //改行
			}

			System.out.println("\n"); //2行改行
		}
	}
}