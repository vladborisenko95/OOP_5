package Homework.Core.Infrastructure;

import Homework.Core.Models.Contact;

public class ExportToXML implements ExpFormat {
    @Override
    public <C extends Contact> String createString(C contact) {
        return String.format("""
                <xml>
                <Contact>
                <FirstName>%s</FirstName>
                <LastName>%s</LastName>
                <Phone>%s</Phone>
                <Description>%s</Description>
                </Contact></xml>
                """, contact.getFirstName(), contact.getLastName(), contact.getPhones(), contact.getDescription());
    }
}