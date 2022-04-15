package com.geekbrains.lesson2;

public class MyArraySizeException extends RuntimeException {

    public MyArraySizeException(int size) {
        super(String.format("Массив не соответствует размеру [%d][%d]", size, size));
    }
}
