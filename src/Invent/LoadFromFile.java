package Invent;

// Класс для загрузки данных из файла
public class LoadFromFile {
    // TODO
    // Считать название директории с отчетами (получить путь)
    // В цикле пока есть файлы считывать инофрмацию из каждого следующего файла
    // и добавлять в коллекцию
    //
    public static String s1;

    public static String getDirName(){
        s1= "Запускаем окно выбора папки\n";
        s1+= "Получаем путь\n\n";

        return s1;
    }

    public static void loadFromFile (String path){

        path="Проверяем наличие файла\n";
        path+="Если файл есть - считываем его содержимое и добавляем в коллекцию\n";
        System.out.println(s1+path);
    }


}
