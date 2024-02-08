package view;
import java.util.ArrayList;
import java.util.Scanner;
import interfaces.Publisher;
public class ConsoleView implements interfaces.Listener<String>{
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    private final Publisher recConsView;
    private String[] dataStrings = new String[6];
    public ConsoleView(Publisher  recConsView) {
        this.recConsView = recConsView;
    }

    public void run(){
       
        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Input Lastname, Firstname, Middlename, Birthdate (dd.mm.yyyy), Phone (only numbers) and Sex (m or f) separated by space ...");
            String next = scanner.nextLine();
            dataStrings = next.split("\\s");
            recConsView.getResult(this);
        }
    }
    public String[] getData(){
        return dataStrings;
    }

    @Override
    public void showResult(ArrayList<String> result) {
        for( String message : result){
            if(message=="Recording successfully!"){
                System.out.println(message);
            }
            else{
                System.out.println(ANSI_RED + message + ANSI_RESET);
                System.out.println("Try input correctly");
            }
            
        }
        

    }

}
