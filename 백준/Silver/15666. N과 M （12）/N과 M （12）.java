import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static boolean[] check;
    static int[] arr, result, cnt;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        check = new boolean[n];
        arr = new int[n];
        result = new int[m];

        stk = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);

        HashSet<String> set = new HashSet<>();
        go(0, n, m, set);
        System.out.println(sb);
    }

    public static void go(int index, int n, int m, HashSet<String> set) {
        if(index == m) {
            StringBuilder tmpsb = new StringBuilder();
            for(int i=0; i<m; i++) {
                tmpsb.append(result[i]+" ");
            }
            tmpsb.append("\n");
            if(!set.contains(tmpsb.toString())) {
                sb.append(tmpsb);
                set.add(tmpsb.toString());
            }
            return;
        }
        for(int i=0; i<n; i++) {
            if(index >= 1 && result[index-1] > arr[i]) continue;
            check[i] = true;
            result[index] = arr[i];
            go(index+1, n, m, set);
            check[i] = false;
        }
    }
}