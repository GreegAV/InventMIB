package Invent;

import javax.swing.*;
import java.io.File;

// Класс для загрузки данных из файла
public class LoadFromFile  {
    // TODO
    // Считать название директории с отчетами (получить путь)                                   ГОТОВО!!!

    // В цикле пока есть файлы считывать инофрмацию из каждого следующего файла
    // и добавлять в коллекцию
    //
    static JFileChooser fc;


    private static String getDirName(){
        fc = new JFileChooser();
        String path=null;
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(LoadFromFile.fc);

        if (returnVal <1) {
            File file = fc.getSelectedFile();
            path=file.getPath();
        } else {
            System.exit(0);
        }

        return path;
    }

    public static void loadFromFile(){

        System.out.println(getDirName());
    }


}
