package org.example.homework4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTest {
    public static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @Test
    void testCalcTriangleArea() throws MyException {
        TriangleArea triangleArea = new TriangleArea();
        Assertions.assertEquals(72.61843774138907, triangleArea.triangleArea(10, 15, 20));
        logger.info("Позитивный тест: Сравнение фактического результата с ожидаемым результатом.");
    }

    @Test
    void testNegativeSideValue() throws MyException {
        TriangleArea triangleArea = new TriangleArea();
        Assertions.assertThrows(MyException.class, ()-> triangleArea.triangleArea(10, 15, -20));
        logger.info("Негатиный тест: Проверка при введении отрицательного значения одной из сторон.");
    }

    @Test
    void testZeroSideValue() throws MyException {
        TriangleArea triangleArea = new TriangleArea();
        Assertions.assertThrows(MyException.class, ()-> triangleArea.triangleArea(10, 0, 20));
        logger.info("Негатиный тест: Проверка при введении нулевого значения одной из сторон.");
    }

    @Test
    void testSumTwoSides() throws MyException {
        TriangleArea triangleArea = new TriangleArea();
        Assertions.assertThrows(MyException.class, ()-> triangleArea.triangleArea(36, 15, 20));
        logger.info("Негатиный тест: Проверка при введении значения одной из сторон, которое больше либо равно сумме двух других сторон.");
    }
}
