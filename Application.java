import model.Recorder;
import view.ConsoleView;
import viewmodel.RecorderConsoleView;
import interfaces.*;

public class Application {
 
    public void run(){

        Recorder recorder = new Recorder();
        Publisher recConsView= new RecorderConsoleView(recorder);
        ConsoleView consView = new ConsoleView(recConsView);
        consView.run();

    }
}
