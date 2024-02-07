package model;

import java.time.LocalDate;


public class Human {
    String lastname;
    String firstname;
    String middlename;
    LocalDate birthdate;
    Long phone;
    Character sex;

    public Human(String lastname, String firstname, String middlename, LocalDate birthdate, long phone, char sex){
        this.lastname=lastname;
        this.firstname=firstname;
        this.middlename=middlename;
        this.birthdate=birthdate;
        this.phone=phone;
        this.sex=sex; 

    }
    @Override
    public String toString() {
        return String.format("<%s><%s><%s><%s><%s><%s>",lastname,firstname,middlename,birthdate,phone,sex);
    }
}
