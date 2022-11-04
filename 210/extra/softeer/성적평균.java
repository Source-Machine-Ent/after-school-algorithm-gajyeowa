import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] score = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        
        for(int i=0; i<N; i++){
            score[i] = Integer.parseInt(st.nextToken());
        }

        String answer = "";

        while(K-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            float sum = 0;
            for (int i = start - 1; i < end; i++) {
                sum += score[i];
            }

            answer += String.format("%.2f", (sum / (end - start + 1))) + "\n";
        }

        System.out.println(answer);

    }
}