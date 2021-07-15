import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class CoolooRing {
    static int[][] adj;
    static int[] vcolor;
    static int ans = 0;
    static int n, c, m;

    static LinkedList<Integer> set1;
    static LinkedList<Integer> set2;
    static int[] ucolor;
    static int n1, n2, n3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String t = scanner.next();
        n = scanner.nextInt();
        c = scanner.nextInt();
        m = scanner.nextInt();

        if(t.equals("t")) {
            System.out.print((int)((c * Math.pow(c - 1, n - 1)) % (Math.pow(10, 9) + 7)));
            return;
        }

        adj = new int[n][n];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            adj[a-1][b-1] = 1;
            adj[b-1][a-1] = 1;
        }

        if(t.equals("g")) {
            vcolor = new int[n + 1];
            m_coloring_g(0);
            System.out.print((int)(ans % ((Math.pow(10, 9) + 7))));
            return;
        }

        if(t.equals("b")) {
            // divide into two sets
            set1 = new LinkedList<>();
            set2 = new LinkedList<>();
            for(int j = 0; j < n; j++){
                if ((!set1.contains(j)) && (!set2.contains(j))){
                    set1.add(j);
                    func(1, j);
                }
            }
            n1 = set1.size();
            n2 = set2.size();

            //backtracking on set with less numbers
            if(n1 < n2) {
                ucolor = new int[n1 + 1];
                n3 = n1;
            }
            else {
                n3 = n2;
                ucolor = new int[n2 + 1];
            }

            m_coloring_b(0);
            System.out.print((int)(ans % ((Math.pow(10, 9) + 7))));
        }
    }

    public static void m_coloring_g(int i){
        if(m_coloring_promising_g(i)){
            if(i == n)
                ans += 1;
            else{
                for(int j = 0; j < c; j++){
                    vcolor[i+1] = j;
                    m_coloring_g(i+1);
                }
            }
        }
    }

    public static boolean m_coloring_promising_g(int i){
        int j = 1;
        while (j < i){
            if((adj[i-1][j-1] == 1) && (vcolor[i] == vcolor[j]))
                return false;
            j = j + 1;
        }
        return true;
    }

    public static void func(int curr, int row){
        if (curr == 1) {
            for (int i = 0; i < n; i++) {
                if ((adj[row][i] == 1) && (!set2.contains(i))){
                    set2.add(i);
                    func(2, i);
                }
            }
        }else {
            for (int i = 0; i < n; i++) {
                if ((adj[row][i] == 1) && (!set1.contains(i))){
                    set1.add(i);
                    func(1, i);
                }
            }
        }
    }


    public static void m_coloring_b(int i){
        if(i == n3){
            Set<Integer> w = new HashSet<Integer>();
            int ans_b = 1;
            LinkedList<Integer> s;
            LinkedList<Integer> s1;

            if (n1 == n3) {
                s = set2;
                s1 = set1;
            }
            else{
                s = set1;
                s1 = set2;
            }

            for (int q: s) {
                for (int col = 0; col < n; col++) {
                    if(adj[q][col] == 1)
                        w.add(ucolor[s1.indexOf(col)+1]);
                }
                ans_b *= (c - w.size());
                w.clear();
            }
            ans += ans_b;
        }else {
            for(int j = 0; j < c; j++){
                ucolor[i+1] = j;
                m_coloring_b(i+1);
            }
        }
    }
}
