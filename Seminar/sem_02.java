package Seminar;


/* Задание_2
Создайте класс Counter, у которого есть метод add(), увеличивающий значение внутренней int переменной на 1.
Сделайте так, чтобы с объектом такого типа можно было работать в блоке  try-with-resources. 
Нужно бросить исключение, если работа с объектом типа счетчик была не в ресурсном try и/или ресурс остался открыт. 
*/


public class sem_02 {

    public static void main(String[] args) {
        try (Counter counter = new Counter()) {
            counter.add();
            System.out.println("Значение счетчика: " + counter.getCount());
        } catch (Exception e) {
            System.out.println("Произошло исключение: " + e.getMessage());
        }
    }

    static class Counter implements AutoCloseable {
        private int count;

        public Counter() {
            this.count = 0;
        }

        public void add() throws Exception {
            if (!isInTryWithResources()) {
                throw new Exception("Работа с объектом Counter должна быть в блоке try-with-resources");
            }
            count++;
        }

        public int getCount() {
            return count;
        }

        public boolean isInTryWithResources() {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (element.getMethodName().equals("close") && element.getClassName().equals("java.lang.AutoCloseable")) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public void close() throws Exception {
            if (!isInTryWithResources()) {
                throw new Exception("Ресурс объекта Counter должен быть закрыт в блоке try-with-resources");
            }
        }
    }

}
