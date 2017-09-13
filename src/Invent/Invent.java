package Invent;
// основной класс программы


import static Invent.LoadFromFile.loadFromFile;

public class Invent {
    public static void main(String[] args) {
        System.out.println("Инвентаризация!\n\n");
        loadFromFile();
        System.out.println("\nПуть получает!!!!");

    }
}
