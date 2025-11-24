package SHUZHU13;
import java.util.ArrayList;
import java.util.Scanner;
public class shuzucounter{
    public static void main(String[] args){
      Scanner a=new Scanner(System.in);
      System.out.println("请输入一串数字，以空格隔开：");
      String input=a.nextLine();
      for(int i=input.length();i>0;i--){
        System.out.print(input.charAt(i-1)+"");
      }

    }
}