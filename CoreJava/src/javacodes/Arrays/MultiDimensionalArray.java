package javacodes.Arrays;

public class MultiDimensionalArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int row = 2;
		int col = 3;
		
		int[][] a = new int[row][col];
		a[0][0] = 1;
		a[0][1] = 2;
		a[0][2] = 3;
		a[1][0] = 4;
		a[1][1] = 5;
		a[1][2] = 6;
		
		int[][] b = {{2,4,6},{8,10,12}};
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.println(b[i][j]);
			}
		}
	}

}
