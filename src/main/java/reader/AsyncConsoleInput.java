package reader;

import java.util.Scanner;

public class AsyncConsoleInput implements Runnable{
    private volatile boolean isConsoleInactive = false;
    private final Scanner scanner = new Scanner(System.in);
    private volatile boolean isTextReady = false;
    private volatile String nextLine = null;
    private static final AsyncConsoleInput asyncConsoleInput = new AsyncConsoleInput();
    private AsyncConsoleInput() {
    }

    public static AsyncConsoleInput getInstance() {
        return asyncConsoleInput;
    }

    public boolean isTextReady() {
        return isTextReady;
    }

    public String getText() {
        isTextReady = false;
        return nextLine;
    }

    public boolean isConsoleInactive() {
        return isConsoleInactive;
    }

    public void suggestToInactivateConsole() {
        this.isConsoleInactive = true;
    }

    @Override
    public void run() {
        while( !isConsoleInactive && scanner.hasNextLine()) {
            String buf = scanner.nextLine();
            if (!buf.equals("\n")) {
                nextLine = buf;
                isTextReady = true;
            }
        }
        scanner.close();
        System.out.println("Admin console inactivated!");
        this.isConsoleInactive = true;
    }
}
