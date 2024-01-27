package org.example;


import java.lang.reflect.Field;
import java.util.concurrent.ThreadLocalRandom;

public class RandomIntegerProcessor {
    public static void processObject(Object object) {
        Class<?> objectClass = object.getClass();
        for (Field declaredfield : objectClass.getDeclaredFields()) {
            if (int.class.isAssignableFrom(declaredfield.getType()) && declaredfield.isAnnotationPresent(RandomInteger.class)) {
                RandomInteger declaredAnnotation = declaredfield.getDeclaredAnnotation(RandomInteger.class);
                int minValue = declaredAnnotation.minValue(); //подлезаем в класс Object object и получаем доступ к его аннотации
                int maxValue = declaredAnnotation.maxValue(); //подлезаем в класс Object object и получаем доступ к его аннотации

                int randomValue = minValue + ThreadLocalRandom.current().nextInt(maxValue - minValue); //используем аннотацию для получения случайного значения
                declaredfield.setAccessible(true);
                try {
                    declaredfield.set(object, randomValue); //подлезаем в класс Object object и изменяем значение его поля
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
            }
        }
    }
}
