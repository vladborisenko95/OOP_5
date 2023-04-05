package Homework.Core.MVP;

import java.io.*;

import Homework.Config;
import Homework.Core.Infrastructure.*;
import Homework.Core.Models.Contact;

public class Model {

    Phonebook currentBook;
    private int currentIndex;
    private final String path;//for import


    public Model(String path) {
        currentBook = new Phonebook();
        currentIndex = 0;
        this.path = path;
    }

    public Contact currentContact() {
        if (currentIndex >= 0) {
            return currentBook.getContact(currentIndex);
        } else {
            System.out.println("Index of Contact is incorrect, currentIndex = " + currentIndex);
            return null;
        }
    }

    public void load() {
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String fname = reader.readLine();
            while (fname != null) {
                String lname = reader.readLine();
                String phone = reader.readLine();
                String description = reader.readLine();
                this.currentBook.add(new Contact(fname, lname, phone, description));
                fname = reader.readLine();
            }
            reader.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportToFile(String exportFileName, ExpFormat expFormat) {
        PhonebookIterator phonebookIterator = new PhonebookIterator(currentBook);
        while (phonebookIterator.hasNext()) {
            ExpModel<Contact> saved = new ExpModel<>(phonebookIterator.next());
            saved.setFormat(expFormat);
            saved.setPath(exportFileName);
            saved.save();
        }
        System.out.println("Saved to file: " + exportFileName);
    }

    public Phonebook currentBook() {
        return this.currentBook;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public void setCurrentIndex(int value) {
        this.currentIndex = value;
    }
}