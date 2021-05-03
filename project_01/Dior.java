import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Dior {

    static int index = -1;
    static int[] a;
    static Long ans = 0L;
    static int[] pivot_list;
    static HashMap<Integer, Integer> hashMap;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        pivot_list = new int[n];
        for(int i = 0; i < n; i++){
            pivot_list[i] = scanner.nextInt();
        }

        Arrays.sort(a);
        hashMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            hashMap.put(a[i], i);
        }

        solve(0, n);
        System.out.print(ans);

    }

    static void solve(int p, int r){
        if(r-p >= 1){
           index++;
        }
        if(r-p <= 1){
            return;
        }
        ans += (r-p-1);
        int pivot =  pivot_list[index];
        int id = hashMap.get(pivot);
        solve(p, id);
        solve(id+1, r);
    }
}
