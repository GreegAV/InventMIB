package Invent;
// основной класс программы


public class Invent {
    public static void main(String[] args) {
        System.out.println("Инвентаризация!");
        LoadFromFile.loadFromFile(LoadFromFile.getDirName());

    }
}
