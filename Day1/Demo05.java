import java.util.Scanner;
import java.util.Arrays;
public class Demo05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入要排序的数组长度:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.print("请输入要排序的数字:");
        for (int i = 0; i<n; i++) {
            arr[i] = input.nextInt();
        }
        BubbleSort(arr);
		System.out.print("排序结果:");
		for (int i = 0; i<n; i++) {
            System.out.print(arr[i]+" ");
        }
		//System.out.println(Arrays.toString(arr));
    }
	public static void BubbleSort(int[] arr) {
		int temp;//定义一个临时变量
		boolean flag = false;
		for(int i=0;i<arr.length-1;i++){//冒泡趟数
			flag = true;
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j+1]<arr[j]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = false;
				}
			}
			if(flag == true){
				break;
			}
		}
	}
}
