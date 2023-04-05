package Homework.Core.Infrastructure;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFile {
    public static void saveTextToFile(String text, String path) {
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (Exception ignored) {
            throw new RuntimeException();
        }

        try (FileWriter fw = new FileWriter(path, true)) {
            fw.write(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}