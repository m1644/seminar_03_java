package Seminar;


class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("Ошибка: некорректный размер массива!");
    }
}

class MyArrayDataException extends Exception {
    private int rowIndex;
    private int columnIndex;
    
    public MyArrayDataException(int rowIndex, int columnIndex) {
        super("Ошибка: неверные данные в ячейке [" + rowIndex + "][" + columnIndex + "]!");
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }
    
    public int getRowIndex() {
        return rowIndex;
    }
    
    public int getColumnIndex() {
        return columnIndex;
    }
}

public class sem_04 {

    public static void main(String[] args) {
        String[][] array = {
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
        };

        try {
            int sum = processArray(array);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException();
        }
        
        int sum = 0;
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        
        return sum;
    }

}
