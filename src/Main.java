import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PeopleInTournament peopleInTournament = new PeopleInTournament();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название файла со списком участников");
        String fileName = scanner.nextLine();
        peopleInTournament.savePeople(readFileContents(fileName));
    }

    public static List<String> readFileContents(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл. Возможно файл находится в другой директории");
            return Collections.emptyList();
        }
    }
}