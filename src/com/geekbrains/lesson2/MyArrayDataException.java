package com.geekbrains.lesson2;

public class MyArrayDataException extends RuntimeException {

    public MyArrayDataException(int i, int j) {
        super(String.format("Ячейку [%d][%d] нельзя преобразовать в число.", i, j));
    }
}
