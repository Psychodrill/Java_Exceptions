package view;
import java.util.Scanner;
import interfaces.Publisher;
public class ConsoleView implements interfaces.Listener<String>{
    
    private final Publisher recConsView;
    private String[] dataStrings;
    public ConsoleView(Publisher  recConsView) {
        this.recConsView = recConsView;
    }

    public void run(){
       
        while (true) {

           // String inputOperation = prompt("Input operation or 'e' for exit: ");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input Lastname, Firstname, Middlename, Birthdate (dd.mm.yyyy), Phone (only numbers) and Sex (m or f) separated by space ...");
            String next = scanner.next();
            dataStrings = next.split("\\s");
            recConsView.getResult(this);
        }
    }
    public String[] getData(){
        return dataStrings;
    }

    @Override
    public void showResult(String result) {
        System.out.printf("Result is %s %n", result);

    }

}
