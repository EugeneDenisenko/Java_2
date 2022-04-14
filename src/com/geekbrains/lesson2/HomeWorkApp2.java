package com.geekbrains.lesson2;

public class HomeWorkApp2 {
    public static void main(String[] args) {

        String[][] array = new String[4][4];

        try  {
            sumElement(array);
        } catch (MyArraySizeException exception) {
            System.out.println("Завершение программы.");
        }

    }

    private static void sumElement(String[][] array) {
        if (array.length != 4 | array[0].length != 4) {
            throw new MyArraySizeException("Массив не соответствует размеру 4х4.");
        } else {
            System.out.println("Выполнение");
        }
    }
}
