import java.util.Scanner;
public class Demo02{
    public static void main(String[] args) {
        /*��������������еĳ����������ݣ�
        ��Ҫ����Scanner�Ķ�����ø��ַ�������ֵ��
        �൱��scanf�����á�
        */
        Scanner input = new Scanner(System.in);
        String an = null;
        do {
            System.out.println("���������ε�������");
            int num = input.nextInt();
            //System.out.println(num);
            //����ֻ��������
            if (num%2==0){
                System.out.println("���ε�����ֻ��������!");
            } else {
                int m = (num+1)/2;
                /*�ϲ���
    ���� �ո��� *����
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
                /*�ϲ���
    ���� �ո��� *����
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
            System.out.println("����Ҫ������(y/n)");
            an = input.next();
        } while(an.equals("y"));
        
    }
}