package Seminar;


/* Задание_3
1. Создайте класс исключения, который будет выбрасываться при делении на 0. 
Исключение должно отображать понятное для пользователя сообщение об ошибке.
2. Создайте класс исключений, которое будет возникать при обращении к пустому элементу в массиве ссылочного типа. 
Исключение должно отображать понятное для пользователя сообщение об ошибке.
3. Создайте класс исключения, которое будет возникать при попытке открыть несуществующий файл. 
Исключение должно отображать понятное для пользователя сообщение об ошибке.
*/


class DivideByZeroException extends Exception {
    public DivideByZeroException() {
        super("Ошибка: деление на ноль!");
    }
}

class EmptyArrayElementException extends Exception {
    public EmptyArrayElementException() {
        super("Ошибка: обращение к пустому элементу массива!");
    }
}

class NonexistentFileException extends Exception {
    public NonexistentFileException() {
        super("Ошибка: попытка открыть несуществующий файл!");
    }
}

public class sem_03 {

    public static void main(String[] args) {
        try {
            int result = divide(10, 0);
            System.out.println("Результат: " + result);
        } catch (DivideByZeroException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            String[] array = new String[5];
            String element = getElement(array, 6);
            System.out.println("Элемент: " + element);
        } catch (EmptyArrayElementException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            openFile("nonexistent.txt");
        } catch (NonexistentFileException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static int divide(int a, int b) throws DivideByZeroException {
        if (b == 0) {
            throw new DivideByZeroException();
        }
        return a / b;
    }
    
    public static String getElement(String[] array, int index) throws EmptyArrayElementException {
        if (index < 0 || index >= array.length) {
            throw new EmptyArrayElementException();
        }
        return array[index];
    }
    
    public static void openFile(String fileName) throws NonexistentFileException {
        throw new NonexistentFileException();
    }

}
