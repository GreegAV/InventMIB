package Invent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Scanner;

import static Invent.LoadFromFile.*;

public class GC {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        String path = getDirName();
        List<String> fileList = getListFiles(path);
        getListFiles(path);
        for (String tmpFileName : fileList) {
            clearGarbage(tmpFileName);
        }
    }

    private static void clearGarbage(String tmpFileName) throws FileNotFoundException, UnsupportedEncodingException {
        boolean found = false;

        File file = new File(tmpFileName);
        String newFile = tmpFileName + "x";
        Scanner sc = new Scanner(file);
        String curLine = sc.nextLine();
        PrintWriter destFile = new PrintWriter(newFile, "UTF-8");

        while (!found && (sc.hasNextLine() && (curLine != null))) {
            if (curLine.contains("Debug - PCI")) {
                found = true;
            } else {
                destFile.println(curLine);
            }
            curLine = sc.nextLine();
        }

        destFile.close();
        sc.close();
    }
}
