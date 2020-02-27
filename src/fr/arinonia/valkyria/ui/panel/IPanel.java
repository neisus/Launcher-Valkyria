package fr.arinonia.valkyria.ui.panel;

import fr.arinonia.valkyria.ui.PanelManager;
import javafx.scene.layout.GridPane;

public interface IPanel {
    void init(PanelManager panelManager);
    GridPane getLayout();
    void onShow();
}
