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


    public static String getDirName(){
        fc = new JFileChooser();
        String path=null;
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(LoadFromFile.fc);

        if (returnVal <1) {
            File file = fc.getSelectedFile();
            path=file.getPath();
        } else {
            // do nothing.
            System.exit(0);
        }


        if (path.length()>0) {
            System.out.println(path);
            System.out.println("Возвращаем путь\n\n");
        } else
        {
            System.out.println("Path not found!\n");
        }

        return path;
    }

    public static void loadFromFile(String path){

        System.out.println(path);
    }


}
