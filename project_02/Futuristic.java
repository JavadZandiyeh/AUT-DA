import java.util.Scanner;

public class Futuristic {
    static int n;
    static int[] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        int index = find_index(0, n-1);
        arr[index] *= 2;
        int ans = 0;
        for(int i = 0; i < n; i++)
            ans = ans | arr[i];
        System.out.print(ans);
    }

    public static int find_index(int i, int j){
        if(j == i)
            return i;
        if(j == i+1){
            int a = (2 * arr[j]) | arr[i];
            int b = arr[j] | (2 * arr[i]);
            if(a > b)
                return j;
            else
                return i;
        }

        int middle = (j + i) / 2;
        int index1 = find_index(i, middle);
        int index2 = find_index(middle+1, j);
        int a = (2 * arr[index1]) | arr[index2];
        int b = arr[index1] | (2 * arr[index2]);
        if(a > b)
            return index1;
        else
            return index2;
    }
}
