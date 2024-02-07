package model;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import logger.Log;

public class Recorder {
    private static final Logger log = Log.log(Recorder.class.getName());

    public String recordData(String[] data) {
        log.log(Level.INFO, "Method calculate in model package started");
        String result;
        checkData(data);
        String lastname = data[0];
        String firstname = data[1];
        String middlename=data[2];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd,mm,yyyy");
        LocalDate birthdate = LocalDate.parse(data[3], formatter);
        Long phone=Long.parseUnsignedLong(data[4]); 
        Character sex = data[5].charAt(0);
        String filename = lastname+".txt";
       
        try(FileWriter writer = new FileWriter(filename, true)){
            writer.write(new Human(lastname, firstname, middlename, birthdate, phone, sex).toString());
            writer.flush();
        }
        catch(IOException ex){
            throw new RuntimeException("except");
        }

        return "#######";
        
    }

    private void checkData(String[] data) {
        
        if(data.length<6){
            throw new RuntimeException("Insufficient data to record");
        }
        if(data.length>6){
            throw new RuntimeException("Excess data to record");
        }

    }
    
}
