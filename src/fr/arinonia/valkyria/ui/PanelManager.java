package fr.arinonia.valkyria.ui;

import com.sun.istack.internal.NotNull;
import fr.arinonia.valkyria.ValkyriaLauncher;
import fr.arinonia.valkyria.ui.panel.IPanel;
import fr.arinonia.valkyria.ui.panels.includes.TopPanel;
import fr.arinonia.valkyria.ui.utils.ResizeHelper;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PanelManager {

    private final ValkyriaLauncher valkyriaLauncher;
    private final Stage stage;

    private GridPane layout;
    private TopPanel topPanel = new TopPanel();
    private GridPane centerPanel = new GridPane();

    public PanelManager(ValkyriaLauncher valkyriaLauncher, Stage stage) {
        this.valkyriaLauncher = valkyriaLauncher;
        this.stage = stage;
    }

    public void init() {
        this.stage.setTitle("Valkyria Launcher V2");

        this.stage.setMinWidth(1280);
        this.stage.setWidth(1280);
        this.stage.setMinHeight(720);
        this.stage.setHeight(720);
        this.stage.setResizable(true);
        this.stage.initStyle(StageStyle.UNDECORATED);
        this.stage.centerOnScreen();
        this.stage.show();
        this.layout = new GridPane();
        this.layout.setStyle("-fx-background-image: url('"+"http://arinonia.chaun14.fr/valkyria/bg.png"+"');"
                +"-fx-backgound-repeat: skretch;"+"-fx-backgound-position: center center;"
                +"-fx-background-size: cover;");
        this.stage.setScene(new Scene(this.layout));
        RowConstraints topPanelConstraint = new RowConstraints();
        topPanelConstraint.setValignment(VPos.TOP);
        topPanelConstraint.setMinHeight(25);
        topPanelConstraint.setMaxHeight(25);

        this.layout.getRowConstraints().addAll(topPanelConstraint,new RowConstraints());
        this.layout.add(this.topPanel.getLayout(),0,0);
        this.topPanel.init(this);

        this.layout.add(this.centerPanel,0,1);
        GridPane.setHgrow(this.centerPanel, Priority.ALWAYS);
        GridPane.setVgrow(this.centerPanel, Priority.ALWAYS);
        ResizeHelper.addResizeListener(this.stage);

    }

    public void showPanel(@NotNull IPanel panel) {
        this.centerPanel.getChildren().clear();
        this.centerPanel.getChildren().add(panel.getLayout());
        panel.init(this);
        panel.onShow();
    }

    public ValkyriaLauncher getLauncher() { return this.valkyriaLauncher; }

    public Stage getStage() {
        return this.stage;
    }

    public TopPanel getTopPanel() { return topPanel; }
}
