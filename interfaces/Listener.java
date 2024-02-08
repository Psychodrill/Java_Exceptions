package interfaces;

import java.util.ArrayList;

public interface Listener<String> {
    
    void showResult(ArrayList<String> result);
    String[] getData();

}
