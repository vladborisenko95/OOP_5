package Homework.Core.Infrastructure;

import Homework.Core.Models.Contact;

public class ExportToJSON implements ExpFormat {
    @Override
    public <C extends Contact> String createString(C contact) {
        return String.format("""
                {
                "FirstName":%s,
                "LastName":%s,
                "Phone":%s,
                "Description":%s,
                }
                """, contact.getFirstName(), contact.getLastName(), contact.getPhones(), contact.getDescription());
    }
}