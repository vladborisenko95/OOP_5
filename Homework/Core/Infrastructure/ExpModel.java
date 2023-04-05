package Homework.Core.Infrastructure;

import Homework.Core.Models.Contact;

public class ExpModel <C extends Contact>{
    ExpFormat format;
    String text;
    String path;
    C contact;
    public ExpModel(C contact) {
        this.contact = contact;
    }

    public void setFormat(ExpFormat format) {
        this.format = format;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void save() {
        text = format.createString(contact);
        SaveFile.saveTextToFile(text, this.path);

    }
}