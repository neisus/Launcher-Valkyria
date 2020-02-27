package fr.arinonia.valkyria;

import fr.arinonia.valkyria.ui.PanelManager;
import fr.arinonia.valkyria.ui.panels.PanelLogin;
import javafx.stage.Stage;

public class ValkyriaLauncher {

    private PanelManager panelManager;

    public void init(Stage stage) {
        this.panelManager = new PanelManager(this, stage);
        this.panelManager.init();
        this.panelManager.showPanel(new PanelLogin());
    }
}
