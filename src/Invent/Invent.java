package Invent;
// основной класс программы


import java.io.FileNotFoundException;

import static Invent.LoadFromFile.loadFromFile;
import static Invent.ReportGenerator.closeReport;
import static Invent.ReportGenerator.createReport;

public class Invent {
    public static void main(String[] args) throws Exception {
        System.out.println("Инвентаризация!\n");
        createReport();
        loadFromFile();
        closeReport();
    }
}
