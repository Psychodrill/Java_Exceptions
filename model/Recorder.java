package model;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logger.Log;

public class Recorder {
    private static final Logger log = Log.log(Recorder.class.getName());
    private ArrayList<String> messages = new ArrayList<String>();
    public ArrayList<String> handleArrayData(String[] data) {
        log.log(Level.INFO, "Method handleArrayData in model package started");

        try{
            checkArrayData(data);
            Human human = mappingHuman(data);
            if(messages.isEmpty()){
                String filename = human.lastname+".txt";
                recordData(human, filename);
            }
        }
        catch(RuntimeException ex){
            messages.add(ex.getMessage());
        }
        if(messages.isEmpty()){
            messages.add("Recording successfully!");
        }
        return messages;
        
    }
    private void recordData(Human human, String filename) throws RuntimeException{

        try(FileWriter writer = new FileWriter(filename, true)){
            writer.write(human.toString());
            writer.flush();
        }
        catch(IOException ex){
            throw new RuntimeException("Recording failed");
        }
    }

    private void checkArrayData(String[] data) throws RuntimeException {
        
        System.out.println(data.length);
        if(data.length<6){
            throw new RuntimeException("Insufficient data to record");
        }
        if(data.length>6){
            throw new RuntimeException("Excess data to record");
        }

    }
    private Human mappingHuman(String[] data){


        String lastname = data[0];
        String firstname = data[1];
        String middlename=data[2];
        LocalDate birthdate= LocalDate.now();
        Long phone=Long.MIN_VALUE;
        Character sex='u';
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            birthdate = LocalDate.parse(data[3], formatter);

        }
        catch(DateTimeParseException ex){
            messages.add(String.format("Next parameter is invalid: %s", data[3]));
        }
        try{
            phone=Long.parseUnsignedLong(data[4]); 

        }
        catch(NumberFormatException ex){
            messages.add(String.format("Next parameter is invalid: %s", data[4]));
        }
        sex = data[5].charAt(0);
        if(sex != 'm' && sex!='f'){
            messages.add(String.format("Next parameter is invalid: %s", data[5]));
        }

        return new Human(lastname, firstname, middlename, birthdate, phone, sex);
    }
    
}
