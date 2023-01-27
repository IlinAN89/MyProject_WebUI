package org.example.homework4;

public class TriangleArea {

    public double triangleArea(double a, double b, double c) throws MyException {
        if (checkValues(a, b, c));
        double p = (a + b + c) / 2;
        double result = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return result;
    }

    private static boolean checkValues(double a, double b, double c) throws MyException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new MyException ("Ошибка в значении одной из сторон треугольника! Проверьте указанные значения!");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new MyException("Таких треугольников не существует! Проверьте значения треугольника!");
        }
        return false;
    }
}
