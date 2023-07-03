package Seminar_dz;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/* Задание
Напишите приложение, которое будет запрашивать у пользователя следующие данные 
в произвольном порядке, разделенные пробелом:
Фамилия Имя Отчество, дата рождения, номер телефона, пол.
Форматы данных:
фамилия, имя, отчество - строки
дата рождения - строка формата dd.mm.yyyy
номер телефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.
*/


public class seminar_dz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате: " +
                           "\nФамилия Имя Отчество Дата рождения(dd.mm.yyyy) Номер телефона(74957778844) Пол(m или f)");
        String input = scanner.nextLine();
        scanner.close();
        String[] data = input.split(" ");
        if (data.length != 6) {
            System.out.println("Ошибка: Вы ввели некорректные данные!");
            return;
        }
        String surname = data[0];
        String name = data[1];
        String patronymic = data[2];
        String dateOfBirth = data[3];
        String phoneNumber = data[4];
        String gender = data[5];
        try {
            validateData(surname, name, patronymic, dateOfBirth, phoneNumber, gender);
            String fileName = surname + ".txt";
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(surname + " " + name + " " + patronymic + " " + dateOfBirth + " " + phoneNumber + " " + gender + "\n");
            writer.close();
            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при чтении-записи файла:");
            e.printStackTrace();
        }
    }

    private static void validateData(String surname, String name, String patronymic, String dateOfBirth,
                                     String phoneNumber, String gender) throws IllegalArgumentException {
        if (!isValidDate(dateOfBirth)) {
            throw new IllegalArgumentException("Неверный формат даты рождения");
        }
        if (!isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Неверный формат номера телефона");
        }
        if (!isValidGender(gender)) {
            throw new IllegalArgumentException("Неверный формат пола");
        }
    }

    private static boolean isValidDate(String date) {
        String[] parts = date.split("\\.");
        if (parts.length != 3) {
            return false;
        }
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1900 || year > 2100) {
            return false;
        }
        return true;
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        try {
            Long.parseLong(phoneNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isValidGender(String gender) {
        return gender.equals("f") || gender.equals("m");
    }

}
