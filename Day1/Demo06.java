import java.util.Scanner;
public class Demo06 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入斐波那契数列的长度:");
		int n = input.nextInt();
		int[] arr = new int[n];
		int even = Fibonacci(arr);
		int odd = arr.length - even;
		System.out.println("斐波那契数列前"+n+"个数:");
		for (int i = 0; i<n; i++) {
            System.out.print(arr[i]+" ");
        }
		System.out.println();
		System.out.println("斐波那契数列前"+n+"个数中有"+odd+"个奇数");
		System.out.println("斐波那契数列前"+n+"个数中有"+even+"个偶数");
	}
	public static int Fibonacci(int[] arr) {
		int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                arr[0] = 1;
            }else if (i == 1) {
                arr[1] =1;
            }else {
                arr[i] = arr[i-1] +arr[i-2];
				if (arr[i]%2 == 0) {
					ret++;
				}
            }
        }
		return ret;
    }
}