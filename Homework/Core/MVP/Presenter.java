package Homework.Core.MVP;

import Homework.Config;
import Homework.Core.Infrastructure.*;
import Homework.Core.Models.Contact;

public class Presenter {
    
    private Model model;
    private View view;

    public Presenter(View view, String pathDb) {
        this.view = view;
        model = new Model(pathDb);
    }

    public void LoadFromFile() {
        model.load();

        if (model.currentBook().count() > 0) {
            model.setCurrentIndex(0);
            var contact = model.currentContact();

            view.setFirstName(contact.firstName);
            view.setLastName(contact.lastName);
            view.setPhone(contact.getPhones());
            view.setDescription(contact.description);
        }
    }

    public void add() {
        model.currentBook().add(new Contact(view.getFirstName(), view.getLastName(), view.getPhone(), view.getDescription()));
    }

    public void remove() {
        Contact contact = new Contact(view.getFirstName(), view.getLastName(), view.getPhone(), view.getDescription());
        model.currentBook().remove(contact);

        if (model.currentBook().count() < 1) {
            model.setCurrentIndex(-1);

            view.setFirstName("");
            view.setLastName("");
            view.setPhone("");
            view.setDescription("");
        } else {
            model.setCurrentIndex(model.getCurrentIndex() - 1);
            if (model.getCurrentIndex() < 0)
                model.setCurrentIndex(0);

            Contact temp = model.currentContact();
            view.setFirstName(temp.firstName);
            view.setLastName(temp.lastName);
            view.setPhone(temp.getPhones());
            view.setDescription(temp.description);
        }
    }

    public void exportToFile(String fileFormat) {
        switch (fileFormat) {
            case "CSV":
                model.exportToFile(Config.CSVFile, new ExportToCSV());
                break;
            case "JSON":
                model.exportToFile(Config.JSONFile, new ExportToJSON());
                break;
            case "XML":
                model.exportToFile(Config.XMLFile, new ExportToXML());
                break;
            case "DB":
                model.exportToFile(Config.pathDb, new ExportToDB());
                break;
            default:
                System.out.println("File type for export is not supported");
                break;
        }

    }

    public void next() {
        if (model.currentBook().count() > 0) {
            if (model.getCurrentIndex() + 1 < model.currentBook().count()) {
                model.setCurrentIndex(model.getCurrentIndex() + 1);
                Contact contact = model.currentContact();
                view.setFirstName(contact.firstName);
                view.setLastName(contact.lastName);
                view.setPhone(contact.getPhones());
                view.setDescription(contact.description);                
            }
        }
    }

    public void prev() {
        if (model.currentBook().count() > 0) {
            if (model.getCurrentIndex() - 1 > -1) {
                model.setCurrentIndex(model.getCurrentIndex() - 1);
                Contact contact = model.currentContact();
                view.setFirstName(contact.firstName);
                view.setLastName(contact.lastName);
                view.setPhone(contact.getPhones());
                view.setDescription(contact.description);  
            }
        }
    }
}