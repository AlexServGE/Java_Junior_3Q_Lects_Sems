package org.example;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //Получение нужного класса по его String имени (и пакету - пути)
        Class<?> car = Class.forName("org.example.Car");
        //Получение всех конструкторов класса в массив car.getConstructors();
        Constructor<?>[] constructors = car.getConstructors();
        //Инициализация конструктора класса через выбор одного из конструкторов в массиве и метод newInstance
        Object bmw = constructors[0].newInstance("БМВ");
        //Получение всех полей класса в массив bmw.getClass().getFields(); Очередность полей в массиве постоянная
        Field[]fields = bmw.getClass().getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        //Получение значений из полей класса (String) fields[0].get(bmw); - для String
        String name = (String) fields[0].get(bmw);
        //Получение значений из полей класса fields[fields.length-1].getInt(bmw); - для int
        int speed = fields[fields.length-1].getInt(bmw);
        System.out.println(speed);
        System.out.println(name);
        //Изменение значения в поле класса fields[0].set(bmw,"БМВ2");
        fields[0].set(bmw,"БМВ2");
        name = (String) fields[0].get(bmw);
        System.out.println(name);
        //Получение всех методов класса bmw.getClass().getDeclaredMethods(); Очередность полей в массиве непостоянная
        Method[] methods = bmw.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}