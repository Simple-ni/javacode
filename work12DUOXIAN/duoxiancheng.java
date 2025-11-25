package work12DUOXIAN;

public class duoxiancheng {
    public static void main(String[] args) {
        new NumberThread().start();

        new Thread(new LetterTask()).start();
    }
}

class NumberThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Number: " + i);
           
            try {
                Thread.sleep(90);
            } catch (InterruptedException e) {
       
                e.printStackTrace();
            }
        }
    }
}


class LetterTask implements Runnable {
    @Override
    public void run() {
        for (char c = 'A'; c <= 'J'; c++) {
            System.out.println("Letter: " + c);
       
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}