import java.util.Scanner;

public class Stringing {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 0; i < T; i++){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String s = scanner.next();
            String t = scanner.next();
            int ans = lcs(n, m , s, t);

            if(n == ans)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }

    static int lcs(int n, int m, String s, String t){
        if(m == 0 || n == 0 || n > m) {
            return 0;
        }else if(s.charAt(n - 1) == t.charAt(m - 1)) {
            return 1 + lcs(n - 1, m - 1, s, t);
        } else {
            return lcs(n, m - 1, s, t);
        }
    }
}
