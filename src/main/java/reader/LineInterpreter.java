package reader;

import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Scanner;


//     help 123 321
public class LineInterpreter {
    private String [] splitLine;
    private final Scanner scanner;
    public LineInterpreter(InputStream stream) {
        this.scanner = new Scanner(stream);
    }

    public void nextLine () throws NoSuchElementException {
        String line = scanner.nextLine();
        if(line == null || line.length() == 0 )
            line = " ";
        String line1 = line;
        if (line.toCharArray()[0] == ' ' )
            line = line.replaceFirst("\\s+" , "");

        splitLine = line.split("\\s+");

    }

    public ArrayDeque<String> getArgs() {
        ArrayDeque <String> arr = new ArrayDeque<>();
        for (int i = splitLine.length - 1; i >= 1; i--) {
            arr.push (splitLine[i]);
        }
        if (arr.isEmpty()) {
            arr.push(" ");
            return arr;
        }
        return arr;
    }

    public String getFirstWord () {
        return splitLine[0];
    }

    public boolean haveMoreThanOneWord () {
        return splitLine.length != 1;
    }

    public String [] getAllWords() {
        return splitLine;
    }

    public int length () {
        return splitLine.length;
    }
}
