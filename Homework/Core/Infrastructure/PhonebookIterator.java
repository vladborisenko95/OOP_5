package Homework.Core.Infrastructure;

import java.util.Iterator;

import Homework.Core.Models.Contact;

public class PhonebookIterator implements Iterator<Contact> {

    private int index = -1;
    private final Phonebook phonebook;

    public PhonebookIterator(Phonebook phonebook) {
        this.phonebook = phonebook;
    }

    @Override
    public boolean hasNext() {
        return index < phonebook.count()-1;
    }

    @Override
    public Contact next() {
        return phonebook.getContact(++index);
    }
}