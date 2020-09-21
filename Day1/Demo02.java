import java.util.Scanner;
public class Demo02{
    public static void main(String[] args) {
        /*如果想向正在运行的程序输入数据，
        需要利用Scanner的对象调用各种方法输入值，
        相当于scanf的作用。
        */
        Scanner input = new Scanner(System.in);
        String an = null;
        do {
            System.out.println("请输入菱形的行数：");
            int num = input.nextInt();
            //System.out.println(num);
            //菱形只能是奇数
            if (num%2==0){
                System.out.println("菱形的行数只能是奇数!");
            } else {
                int m = (num+1)/2;
                /*上部分
    行数 空格数 *数量
    i	m-i		2*i-1
                */
                for(int i = 1; i<=m; i++){
                    for(int j = 1; j<=m-i;j++){
                        System.out.print(" ");
                    }
                    for(int k = 1; k<=2*i-1;k++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                /*上部分
    行数 空格数 *数量
    i	i		num-2*i
                */
                int n = num-m;
                for(int i = 1; i<=n; i++){
                    for(int j = 1; j<=i;j++){
                        System.out.print(" ");
                    }
                    for(int k = 1; k<=num-2*i;k++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
            }
            System.out.println("请问要继续吗？(y/n)");
            an = input.next();
        } while(an.equals("y"));
        
    }
}