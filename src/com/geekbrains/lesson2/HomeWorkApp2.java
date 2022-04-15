package com.geekbrains.lesson2;

public class HomeWorkApp2 {

    public static final int SIZE = 4;

    public static void main(String[] args) {
        String[][] array =
                {{"1", "1", "1", "1"},
                        {"1", "1", "1", "1"},
                        {"1", "1", "1", "1"},
                        {"1", "1", "1", "1"}};

        try {
            int sum = sumOfElements(array);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException exception) {
            System.out.println(exception.getMessage());
            System.out.println("Завершение программы.");
        }
    }

    private static int sumOfElements(String[][] array) {
        if (!checkSize(array)) {
            throw new MyArraySizeException(SIZE);
        } else {
            int count = 0;
            int num;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    try {
                        num = Integer.parseInt(array[i][j]);
                        count += num;
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i, j);
                    }
                }
            }
            return count;
        }
    }

    private static boolean checkSize(String[][] array) {
        boolean flag = true;
        for (String[] strings : array) {
            if (strings.length != SIZE) {
                flag = false;
                break;
            }
        }
        return (array.length == SIZE) & flag;
    }
}
