public class Demo01 {
	public static void main(String[] args) {
		/*
		*实现1-100奇数的和，偶数的和，以及能被3整除的数之和
		*/
		int i = 1;
		while (i<=100) {
			if(i%2==0) {
				//偶数的和
			} else {
				//奇数的和
			}
			i++;
		}
		
		int j = 1;
		do {
			if(j%2==0) {
				//偶数的和
			} else {
				//奇数的和
			}
			j++;
		} while(j<=100);
		
		for (int k = 1; k<=100; k++) {
			if(k%2==0) {
				//偶数的和
			} else {
				//奇数的和
			}
		}
		int[] num = {1,2,3,4,5,6};
		for (int i = 1; i<=6; i++) {
			System.out.println(num[i-1]);
		}
		
	}
}