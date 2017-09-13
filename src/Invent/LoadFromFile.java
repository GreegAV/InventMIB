package Invent;

import javax.swing.*;
import java.io.File;

// Класс для загрузки данных из файла
public class LoadFromFile extends JPanel {
    // TODO
    // Считать название директории с отчетами (получить путь)
    // В цикле пока есть файлы считывать инофрмацию из каждого следующего файла
    // и добавлять в коллекцию
    //
    public static String s1;
    static JFileChooser fc;

   // public LoadFromFile() {
       // fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//do nothing
 //   }


    public static String getDirName(){
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        s1= "Запускаем окно выбора папки\n";
        int returnVal = fc.showOpenDialog(LoadFromFile.fc);
        System.out.println(returnVal);

        if (returnVal <1) {
            File file = fc.getSelectedFile();
            System.out.println("Choosed: ");
            System.out.println(file.getPath());
            System.out.println("Complete!");
        }


        String path="";

        if (path.length()>0) {

            System.out.println(path);
        } else
        {
            s1+="Path not found!\n";
        }

        s1+= "Получаем путь\n\n";

        return s1;
    }

    public static void loadFromFile(String path){

        path="Проверяем наличие файла\n";
        path+="Если файл есть - считываем его содержимое и добавляем в коллекцию\n";
        System.out.println(s1+path);
    }


}
