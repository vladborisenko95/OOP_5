package Homework.Core.Infrastructure;

import Homework.Core.Models.Contact;

public class ExportToDB implements ExpFormat {
    @Override
    public <C extends Contact> String createString(C contact) {
        return String.format("""
                %s
                %s
                %s
                %s
                """, contact.getFirstName(), contact.getLastName(), contact.getPhones(), contact.getDescription());
    }
}