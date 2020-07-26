package HW3quation1;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Старт задания 1");

        List<Thread> printers = List.of(
                new Thread(new PrintLetter(Letter.A)::print),
                new Thread(new PrintLetter(Letter.B)::print),
                new Thread(new PrintLetter(Letter.C)::print)
        );

       printers.forEach(Thread::start);

        for (Thread printer : printers) {
            printer.join();
        }
        System.out.println("\nЗавершение задания 1");
    }
}
