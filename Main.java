import java.util.logging.Level;
import java.util.logging.Logger;
import logger.*;
public class Main {
    private static final Logger log = Log.log(Main.class.getName());
    public static void main(String[] args) {
        log.log(Level.INFO, "Method main in model package started");
        Application app = new Application();
        app.run();

    }
}