//package org.example;
//
//public class Main {
//    public static class Animal { //пример создания анонимного класса на базе обычного класса
//        public void eat() {
//            System.out.println("Кушаю");
//        }
//    }
//
//    public static void main(String[] args) {
//        Animal animal = new Animal() { //создается анонимный класс, наследующий поведение класса Animal
//            public void eat() { //происходит переопределение методов
//                System.out.println("Много кушаю");
//            }
//        };
//        animal.eat();
//    }
//}
//
//public class Main {
//    public static abstract class Animal { //пример создания анонимного класса на базе абстрактного класса
//        public abstract void eat() ;
//    }
//
//    public static void main(String[] args) {
//        Animal animal = new Animal() { //создается анонимный класс, наследующий поведение класса Animal
//            public void eat() { //происходит переопределение методов
//                System.out.println("Много кушаю");
//            }
//        };
//        animal.eat();
//    }
//}
//
//public class Main {
//    interface AbleToEat { //пример создания анонимного класса на базе интерфейса с реализацией 2 и более методов
//        void eat();
//        void run();
//    }
//
//    public static void main(String[] args) {
//        AbleToEat animal = new AbleToEat() {
//            @Override
//            public void eat() {
//                System.out.println("Кушаю два раза в день");
//            }
//
//            @Override
//            public void run() {
//
//            }
//        };
//        animal.eat();
//    }
//}
//
//public class Main {
//    interface Animal { //пример создания анонимного класса на базе интерфейса с реализацией 1 метода
//        void eat();
//    }
//
//    public static void main(String[] args) {
//        Animal animal = () -> System.out.println("Много кушаю 2"); //с использованием lambda.
//        /**
//         * Важно! Использование lambda в качестве основы для анонимного класс возможно только при двух условия:
//         * Анонимный класс создается на базе интерфейса
//         * У данного интерфейса есть один единственный метод
//         */
//        animal.eat();
//    }
//}