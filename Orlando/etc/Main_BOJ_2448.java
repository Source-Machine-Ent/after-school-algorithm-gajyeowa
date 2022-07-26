package com.com.etc;

import java.util.Scanner;

public class Main_BOJ_2448 {
    static int[][] star;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        star = new int[n][2*n-1];
        star(0,0, n);

        StringBuilder st = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2*n-1; j++) {
                st.append(star[i][j]==1?"*":" ");
            }
            st.append("\n");
        }
        System.out.println(st.toString());
    }

    public static void star(int r, int c, int n){
        if(n==3){
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    if(i==0&&j==2) star[r+i][c+j] = 1;
                    else if(i==1 &&(j==1||j==3)) star[r+i][c+j] = 1;
                    else if(i == 2) star[r+i][c+j] = 1;
                }
            }
            return;
        }
        else{
            star(r+1, c+n/2, n/2);
            star(r+n/2, c+0, n/2);
            star(r+n/2, c+n, n/2);
        }
    }
}
