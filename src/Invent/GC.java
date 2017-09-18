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
        String path=getDirName();
        List<String> fileList=getListFiles(path);

        //Получаем и печатаем список файлов в полученной папке

        getListFiles(path);

        for (String tmpFileName : fileList) {
            clearGarbage(tmpFileName);
        }

    }

    private static void clearGarbage(String tmpFileName) throws FileNotFoundException, UnsupportedEncodingException {

        int numlines=1;

        File file = new File(tmpFileName);
        String newFile = tmpFileName+"x";

        Scanner sc = new Scanner(file);
        String curLine=sc.nextLine();

        PrintWriter destFile = new PrintWriter(newFile, "UTF-8");

        while ( (sc.hasNextLine() && (curLine != null))){
            System.out.println(numlines+ " "+ curLine);
            if (curLine.contains("Debug - PCI")) {
                System.out.println("Found!");
                break;
            } else {
                destFile.println(curLine);
            }

            curLine=sc.nextLine();
            numlines++;
        }

        System.out.println(numlines+ " "+ curLine);
        destFile.close();
        sc.close();
    }
}
