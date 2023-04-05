package Homework.Core.Infrastructure;

import Homework.Core.Infrastructure.ExpFormat;
import Homework.Core.Models.Contact;

public class ExportToCSV implements ExpFormat {
    @Override
    public <C extends Contact> String createString(C contact) {
        return String.format("%s|%s|%s|%s\n",contact.getFirstName(), contact.getLastName(), contact.getPhones(), contact.getDescription());
    }
}