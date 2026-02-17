package CoreJavaTopics;

public class A009_MultiDimArray {

	public static void main(String[] args) {

		int[][] a = {{3,4,2},{2,1,5},{6,8,9}};
		
		int min = a[0][0];
		int max = a[0][0];
		
		for(int i=0;i<3;i++){
			for(int j = 0; j < 3; j++) {
				if(a[i][j] < min) {
					min = a[i][j];
				}
				if(a[i][j] > max) {
					max = a[i][j];
				}
			}
		}
		System.out.println(min);
		System.out.println(max);


	}

}
