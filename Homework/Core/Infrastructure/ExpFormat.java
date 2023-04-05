package Homework.Core.Infrastructure;

import Homework.Core.Models.Contact;

public interface ExpFormat {
    <C extends Contact> String createString(C contact);
}