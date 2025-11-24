package reflectionbank10;

import java.lang.reflect.Method;

public class test {
    public static void main(String[] args) {
        try {
         
            Class<?> clazz = Class.forName("bank.BankAccount");
           
            Object instance = clazz.getDeclaredConstructor().newInstance();
          
            Method method = clazz.getMethod("deposit", double.class);
    
            method.invoke(instance, 1000.0);
        
            Method withdrawMethod = clazz.getMethod("withdraw", double.class);
            withdrawMethod.invoke(instance, 500.0);
        
            Method checkBalanceMethod = clazz.getMethod("checkBalance");
            checkBalanceMethod.invoke(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}