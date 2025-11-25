package work15QuC;

import java.util.ArrayList;
import java.util.Scanner;
public class quchong {
    public static void main(String[] args){
    Scanner a1=new Scanner(System.in);
    ArrayList<Integer> list =new ArrayList<>();
    System.out.println("请输入一个数字（输入-1结束）：");
    while(true){
        
        int num=a1.nextInt();
        if(num==-1){
            break;
        }
        if(!list.contains(num)){
            list.add(num);
        }
    }
    System.out.println("去重后"+list);
}
}
