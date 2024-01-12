import java.util.Scanner;

public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int row = scn.nextInt();
        int col = scn.nextInt();

        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        int minr = 0, minc = 0, maxr = row - 1, maxc = col - 1;
        int te = row * col;
        int cnt = 0;

        while (cnt < te) {
            //left wall
            for (int i = minr, j = minc; i <= maxr && cnt < te; i++) {
                System.out.print(arr[i][j] + "\t");
                cnt++;
            }
            minc++;

            //down wall
            for (int i = minc, j = maxr; i <= maxc && cnt < te; i++) {
                System.out.print(arr[j][i] + "\t");
                cnt++;
            }
            maxr--;

            //right wall
            for (int i = maxr, j = maxc; i >= minr && cnt < te; i--) {
                System.out.print(arr[i][j] + "\t");
                cnt++;
            }
            maxc--;

            //top wall
            for (int i = maxc, j = minr; i >= minc && cnt < te; i--) {
                System.out.print(arr[j][i] + "\t");
                cnt++;
            }
            minr++;
        }

    }
}
