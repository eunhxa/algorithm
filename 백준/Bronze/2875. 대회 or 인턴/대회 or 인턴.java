import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int m = sc.nextInt();
        int intern = sc.nextInt();

        while(intern > 0) {
            if(w >= 2*m) {
                w--;
            } else {
                m--;
            }
            intern--;
        }

        int cnt = 0;
        while(w>=2 && m>=1) {
            w -= 2;
            m--;
            cnt++;
        }

        System.out.println(cnt);
    }
}