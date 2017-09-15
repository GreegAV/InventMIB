package Invent;
// основной класс программы


import java.io.FileNotFoundException;

import static Invent.LoadFromFile.loadFromFile;

public class Invent {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Инвентаризация!\n");
        loadFromFile();

    }
}
