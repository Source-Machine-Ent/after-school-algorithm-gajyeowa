import java.io.*;
import java.util.*;

class Main {
   static int count = 0;
   static ArrayList<Integer> sizes = new ArrayList<>();
   static int size = 0;
   
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int lines = Integer.parseInt(br.readLine());
      int[][] area = new int[lines][lines];
      boolean[][] visited = new boolean[lines][lines];
      
      for(int i=0; i<lines; i++){
         String currLineStr = br.readLine();
         String[] elements = currLineStr.split(" ");
         
         for(int j = 0; j < lines; j++) {
            area[i][j] = Integer.parseInt(elements[j]);
         }
      }
      
      for(int i=0; i<lines; i++){
         for(int j = 0; j < lines; j++) {
            if (!visited[i][j] && area[i][j] == 1) {
               count++;
               size = 0;
               dfs(visited, area, lines, i, j);
               sizes.add(size);
            }
         }
      }
      
      System.out.println(sizes.size()+" ");
      Collections.sort(sizes);
      for(int i = 0;i<sizes.size();i++) {
         System.out.print(sizes.get(i) + " ");
      }
      
   }
   
   public static void dfs(boolean[][] visited, int[][] area, int lines, int i, int j) {
      visited[i][j] = true;
      if (area[i][j] == 1) {
         size++;
         if (j>0 && !visited[i][j-1]) dfs(visited, area, lines, i, j-1);
         if (i>0 && !visited[i-1][j]) dfs(visited, area, lines, i-1, j);
         if (i<lines-1 && !visited[i+1][j]) dfs(visited, area, lines, i+1, j);
         if (j<lines-1 && !visited[i][j+1]) dfs(visited, area, lines, i, j+1);
      }
      
      return;
   }
}