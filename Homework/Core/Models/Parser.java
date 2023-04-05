package Homework.Core.Models;

import java.util.*;

import Homework.Core.Infrastructure.Phonebook;

public class Parser {
    private final String delimiters;//for splitting raw with multiple values like phone numbers

    public Parser(String delimiters) {
        this.delimiters = delimiters;
    }

    public HashSet<String> fromStringToSet(String str) {
        List<String> phonesArray = new ArrayList<>(Arrays.asList(str.split(delimiters)));
        Iterator<String> phonesIterator = phonesArray.iterator();

        while(phonesIterator.hasNext()) {
            String value = phonesIterator.next();
            //System.out.println(value);
            if (value.equals("")){
                //System.out.println("removing empty values");
                phonesIterator.remove();
            }
        }
        return new HashSet<>(phonesArray);
    }
}