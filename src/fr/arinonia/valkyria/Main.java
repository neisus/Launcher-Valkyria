package fr.arinonia.valkyria;

import fr.arinonia.valkyria.files.FileManager;
import fr.arinonia.valkyria.utils.AriLogger;
import javafx.application.Application;

import javax.swing.*;

public class Main {

    public static AriLogger logger;

    public static void main(String... args){
        logger = new AriLogger("Valkyria");
        try {
            Class.forName("javafx.application.Application");
            logger.log("JavaFX found, start application");
            Application.launch(FxApplication.class, args);
        } catch (ClassNotFoundException e) {
            logger.warn("JavaFX not found");
            JOptionPane.showMessageDialog(null, "Une erreur avec Java à été detéctée.\n" + e.getMessage() + " Not found", "Erreur-Java", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

}
