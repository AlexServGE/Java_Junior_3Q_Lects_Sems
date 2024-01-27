package org.example;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
////        Запись массива в файл
//        Stream<Integer> resultingStream = Stream.of();
//        for (int i = 0; i < 10; i++) {
//            resultingStream = Stream.concat(Stream.of(i), resultingStream);
//        }
//
//        List<String> list = resultingStream.map(Character::getName).collect(Collectors.toCollection(ArrayList::new));
//        serialObj(list, "my_file.txt");
////        Получение массива из файла
//        ArrayList<Integer> list = (ArrayList<Integer>) deSerialObj("my_file.txt");
//        System.out.println(list);

//        record Person (String name, String surname) implements Serializable{
//
//        }

////        Запись Person в файл
//        Person person = new Person("Alexander", "Sergeev");
//        serialObj(person,"my_file.txt");

////        Чтение Person из файла
//        Person person = (Person) deSerialObj("my_file.txt");
//        System.out.println(person);


//        Person2 myWritePerson = new Person2("Alexander", "Sergeev","Nick");
//        serialObj(myWritePerson,"my_file3.txt");

        Person2 myReadPerson = (Person2) deSerialObj("my_file3.txt");
        System.out.println(myReadPerson);

        

    }

    public static class Person2 implements Serializable{
        protected String name;
        protected String surname;
        protected transient String patronymic; //transient - специальный модификатор, который отменяет сериализацию у выбранного поля или метода. То есть данное поле или метод будут игнорироваться при записи объекта через сериазилацию

        //serialVersionUID - это зарезервированная переменная, которая используется для пометки версии структуры класса (один раз при записи объекта в файл).
        //Если явно не указать serialVersionUID, то номер будет присовен по умолчанию - на основании многих метаданных класса включая количество полей, тип полей, модификаторы доступа полей, интерфейсов, которые реализованы в классе и пр.
        //Если явно не указан serialVersionUID, то он изменяется каждый раз, когда изменяется структура класса.
        //При десериализации/чтении данных serialVersionUID класса сравнивается с serialVersionUID файл. При несовпадении, чтение не происходит.
        //Рекомендация: Никогда не изменять serialVersionUID после единожды определенного одного номера.
        //Пояснение: При указании новых версий serialVersionUID не происходит отдельного сохранения новой структуры класса. Просто предыдущие объекты в файлах не будут десериализованы из-за невоспадения serialVersionUID файла и serialVersionUID потока чтения
        //Пояснение: При использовании одного serialVersionUID, новые поля просто будут заполнены null в случае, если их не было в предыдущей версии структуры класса.
        @Serial
        private static final long serialVersionUID = 1L;

        public Person2(String name, String surname,String patronymic) {
            this.name = name;
            this.surname = surname;
            this.patronymic = patronymic;
        }

        @Override
        public String toString() {
            return "Person2{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", patronymic='" + patronymic + '\'' +
                    '}';
        }
    }

    public static void serialObj(Object o, String file) throws IOException {
        //открываем файл в оперативной памяти на ввод STDIN (0) новой информации/данных
        FileOutputStream fo = new FileOutputStream(file);
        //преобразуем универсальную связь с файлом в связь с записью объектов java
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fo);
        //передаем объект java в открытую связь с файлом
        objectOutputStream.writeObject(o);
        //закрываем связь с файлом
        objectOutputStream.close(); //Важно!
    }

    public static Object deSerialObj(String file) throws IOException, ClassNotFoundException {
        //открываем файл в оперативной памяти на вывод STDOUT (1) новой информации/данных
        FileInputStream fi = new FileInputStream(file);
        //преобразуем универсальную связь с файлом в связь с чтением объектов java
        ObjectInputStream objectInputStream = new ObjectInputStream(fi);
        //читаем java объект из открытой связи с файлом. Результат получаем в виде Object, который далее сможем cast в (String)
        Object deserialisedObject =  objectInputStream.readObject();
        objectInputStream.close(); //Важно!
        return deserialisedObject;
    }
}