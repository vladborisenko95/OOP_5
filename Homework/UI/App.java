package Homework.UI;

import java.util.Scanner;

import Homework.Config;
import Homework.Core.MVP.Presenter;
import Homework.Core.MVP.View;

public class App {
    public static void ButtonClick() {
        System.out.print("\033[H\033[J");// ru.stackoverflow.com/questions/1315049/Как-очистить-консоль-в-java-во-время-действия-программы
        View view = new ConsoleView();
        Presenter presenter = new Presenter(view, Config.pathDb);
        presenter.LoadFromFile();

        try (Scanner in = new Scanner(System.in)) {

            while (true) {
                System.out.println(" 1 - previous contact 2 - next contact\n3 - delete contact 4 - add contact \n5 - CSV 6 - JSON 7 - XML 8 - Save in DB");
                String key = in.next();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "1":
                        presenter.prev();
                        break;
                    case "2":
                        presenter.next();
                        break;
                    case "3":
                        presenter.remove();
                        break;
                    case "4":
                        presenter.add();
                        break;
                    case "5":
                        presenter.exportToFile("CSV");
                        break;
                    case "6":
                        presenter.exportToFile("JSON");
                        break;
                    case "7":
                        presenter.exportToFile("XML");
                        break;
                    case "8":
                        presenter.exportToFile("DB");
                        break;
                    default:
                        System.out.println("No such command");
                        break;
                }
            }
        }

    }


}