public class Demo01 {
	public static void main(String args[]) {
		for(int i = 1; i <= 9; i = i+1) {
			for(int j = i; j <= 9; j = j+1) {
				if(j>i) {
					System.out.print("\t");
				}
				System.out.print(i+"*"+j+"="+i*j);
				//System.out.print("%d*%d=%d",i,j,i*j);
			}
			System.out.print("\n");
			//System.out.println();
		}
	}
}