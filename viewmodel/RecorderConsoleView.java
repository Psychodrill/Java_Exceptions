package viewmodel;
import java.util.ArrayList;

import interfaces.*;
import model.Recorder;

public class RecorderConsoleView implements Publisher{

    private final Recorder rec;
    private ArrayList<String> result;

    public RecorderConsoleView(Recorder rec) {
        this.rec=rec;
    }

    @Override
    public void getResult(Listener<String> listener) {
        sendData(listener.getData());
        listener.showResult(result);
    }

    public void sendData(String[] data) {

        result= rec.handleArrayData(data);
    }
    
}
