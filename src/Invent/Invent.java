package Invent;
// основной класс программы


public class Invent {
    public static void main(String[] args) {
        System.out.println("Инвентаризация!\n\n");
        LoadFromFile.loadFromFile(LoadFromFile.getDirName());

    }
}
