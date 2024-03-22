package javacodes.Arrays;

public class PrintMinValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] a = {{20,8,9},{15,3,96},{45,1,94}};
		
		int min = a[0][0];
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				//System.out.println(a[i][j]);
			
				if(a[i][j]<min) {
					min=a[i][j];
				}
			}
		}
		System.out.println(min);
	}
	
}
