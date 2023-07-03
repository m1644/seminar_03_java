package Seminar;


import java.util.ArrayList;
import java.util.List;


/* Задание_1
Создайте метод doSomething(), который может быть источником одного из типов checked exceptions 
(тело самогометода прописывать не обязательно).
Вызовите этот метод из main и обработайте в нем исключение, которое вызвалметод doSomething().
*/


public class sem_01 {

    public static void main(String[] args) {
        try {
            doSomething();
        } catch (Exception e) {
            System.out.println("Произошло исключение: " + e.getMessage());
        }
    }

    public static void doSomething() throws Exception {
        // Действия, которые могут вызвать исключение
        int a = 10;
        int b = 0;
        int result = a / b;  // Деление на ноль, ошибка - ArithmeticException
        System.out.println("a / b = " + result);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        // Получаем элемент списка, которого нет (индекс 4)
        int nonExistingNumber = numbers.get(4);  // Ошибка - IndexOutOfBoundsException
        System.out.println("Список чисел: " + numbers);
        System.out.println("Число из списка с индексом 4: " + nonExistingNumber);
    }

}
