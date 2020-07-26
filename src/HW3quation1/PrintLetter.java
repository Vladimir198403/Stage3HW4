package HW3quation1;

import java.sql.PreparedStatement;

public class PrintLetter {

    public static final int printCount = 5;

    private static Object lock = new Object();
    private static volatile Letter currentLetter = Letter.A;

    private Letter printLetter;

    public PrintLetter(Letter letter) {
        this.printLetter = letter;
    }

    public void print() {
        for (int i = 0; i < printCount; i++) {
            synchronized (lock) {
                while (printLetter != currentLetter) {
                    waitLetter();
                }
                System.out.println(printLetter.getLetter());
                currentLetter = currentLetter.getNextLetter();
                lock.notifyAll();
            }
        }
    }

    private void waitLetter() {
        try {
            lock.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
