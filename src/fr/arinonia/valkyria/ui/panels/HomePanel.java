package fr.arinonia.valkyria.ui.panels;

import com.sun.webkit.WebPage;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import fr.arinonia.valkyria.Main;
import fr.arinonia.valkyria.ui.PanelManager;
import fr.arinonia.valkyria.ui.component.ABigDownloadBar;
import fr.arinonia.valkyria.ui.component.ANews;
import fr.arinonia.valkyria.ui.component.ASmallDownloadBar;
import fr.arinonia.valkyria.ui.panel.IPanel;
import fr.arinonia.valkyria.ui.panel.Panel;
import javafx.collections.ListChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.Set;


public class HomePanel extends Panel {

    private GridPane centerPane = new GridPane();
    @Override
    public void init(PanelManager panelManager){
        super.init(panelManager);
        showTopBar();

        ColumnConstraints menuPaneConstraint = new ColumnConstraints();
        menuPaneConstraint.setHalignment(HPos.LEFT);
        menuPaneConstraint.setMinWidth(300);
        menuPaneConstraint.setMaxWidth(300);
        this.layout.getColumnConstraints().addAll(menuPaneConstraint, new ColumnConstraints());

        GridPane leftBarPane = new GridPane();
        GridPane.setVgrow(leftBarPane, Priority.ALWAYS);
        GridPane.setHgrow(leftBarPane, Priority.ALWAYS);

        Separator rightSeparator = new Separator();
        GridPane.setVgrow(rightSeparator, Priority.ALWAYS);
        GridPane.setHgrow(rightSeparator, Priority.ALWAYS);
        GridPane.setHalignment(rightSeparator, HPos.RIGHT);
        rightSeparator.setOrientation(Orientation.VERTICAL);
        rightSeparator.setTranslateY(1);
        rightSeparator.setTranslateX(4);
        rightSeparator.setMinWidth(2);
        rightSeparator.setMaxWidth(2);
        rightSeparator.setOpacity(0.30);

        GridPane bottomGridPane = new GridPane();
        GridPane.setVgrow(bottomGridPane, Priority.ALWAYS);
        GridPane.setHgrow(bottomGridPane, Priority.ALWAYS);
        GridPane.setHalignment(bottomGridPane, HPos.LEFT);
        GridPane.setValignment(bottomGridPane, VPos.TOP);
        bottomGridPane.setTranslateY(30);
        bottomGridPane.setMinHeight(40);
        bottomGridPane.setMaxHeight(40);
        bottomGridPane.setMinWidth(300);
        bottomGridPane.setMaxWidth(300);
        showLeftBar(bottomGridPane);
        leftBarPane.getChildren().addAll(rightSeparator, bottomGridPane);

        this.layout.add(leftBarPane,0,0);
        this.layout.add(this.centerPane,1,0);
        GridPane.setHgrow(this.centerPane, Priority.ALWAYS);
        GridPane.setVgrow(this.centerPane, Priority.ALWAYS);
        ScrollPane scrollPane = new ScrollPane();
        GridPane.setHgrow(scrollPane, Priority.ALWAYS);
        GridPane.setVgrow(scrollPane, Priority.ALWAYS);
        scrollPane.getStylesheets().add(Main.class.getResource("/fr/arinonia/valkyria/ui/resources/css/scrollbar.css").toExternalForm());


        VBox vBox = new VBox();
        GridPane.setHgrow(vBox, Priority.ALWAYS);
        GridPane.setVgrow(vBox, Priority.ALWAYS);
        vBox.setMinHeight(200);
        vBox.setMinWidth(900);
        vBox.setMaxWidth(900);
        vBox.setAlignment(Pos.CENTER);
        vBox.setTranslateX(30);
        GridPane topPane = new GridPane();
        GridPane.setVgrow(topPane, Priority.ALWAYS);
        GridPane.setHgrow(topPane, Priority.ALWAYS);
        GridPane.setValignment(topPane, VPos.TOP);
        topPane.setMaxWidth(880);
        topPane.setMinWidth(880);
        topPane.setMaxHeight(340);
        topPane.setMinHeight(340);
        addTopPanel(topPane);


        GridPane newsPane = new GridPane();
        GridPane.setVgrow(newsPane, Priority.ALWAYS);
        GridPane.setHgrow(newsPane, Priority.ALWAYS);
        GridPane.setValignment(newsPane, VPos.BOTTOM);
        newsPane.setMaxWidth(880);
        newsPane.setMinWidth(880);
        newsPane.setMaxHeight(300);
        newsPane.setMinHeight(300);
        newsPane.setTranslateY(50);
        addNewsPanel(newsPane);
        GridPane aboutPane = new GridPane();
        GridPane.setVgrow(aboutPane, Priority.ALWAYS);
        GridPane.setHgrow(aboutPane, Priority.ALWAYS);
        GridPane.setValignment(aboutPane, VPos.BOTTOM);
        aboutPane.setMaxWidth(880);
        aboutPane.setMinWidth(880);
        aboutPane.setMaxHeight(600);
        aboutPane.setMinHeight(600);
        aboutPane.setTranslateY(100);
        showAboutPanel(aboutPane);
        GridPane  footerPane = new GridPane();
        GridPane.setVgrow(footerPane, Priority.ALWAYS);
        GridPane.setHgrow(footerPane, Priority.ALWAYS);
        GridPane.setValignment(footerPane, VPos.BOTTOM);
        footerPane.setMaxWidth(880);
        footerPane.setMinWidth(880);
        footerPane.setMaxHeight(280);
        footerPane.setMinHeight(280);
        footerPane.setTranslateY(100);
        showFooterPanel(footerPane);
        this.centerPane.getChildren().addAll(scrollPane);
        scrollPane.setContent(vBox);
        vBox.getChildren().add(0,topPane);
        vBox.getChildren().add(1,newsPane);
        vBox.getChildren().add(2,aboutPane);
        vBox.getChildren().add(3,footerPane);

    }

    private void displaySettingsFrame() {
        GridPane panel = new GridPane();
        GridPane.setVgrow(panel, Priority.ALWAYS);
        GridPane.setHgrow(panel, Priority.ALWAYS);
        GridPane.setValignment(panel, VPos.CENTER);
        GridPane.setHalignment(panel, HPos.CENTER);
        GridPane pane = new GridPane();
        GridPane.setVgrow(pane, Priority.ALWAYS);
        GridPane.setHgrow(pane, Priority.ALWAYS);
        GridPane.setValignment(pane, VPos.CENTER);
        GridPane.setHalignment(pane, HPos.CENTER);

        pane.setMaxWidth(680);
        pane.setMinWidth(680);
        pane.setMaxHeight(440);
        pane.setMinHeight(440);
        pane.setStyle("-fx-background-color: rgba(48,84,100,0.4)");


        GridPane leftBackground = new GridPane();
        GridPane.setVgrow(leftBackground, Priority.ALWAYS);
        GridPane.setHgrow(leftBackground, Priority.ALWAYS);
        GridPane.setValignment(leftBackground, VPos.TOP);
        GridPane.setHalignment(leftBackground, HPos.LEFT);
        leftBackground.setMinWidth(200);
        leftBackground.setMaxWidth(200);
        leftBackground.setMinHeight(438);
        leftBackground.setMaxHeight(438);
        leftBackground.setTranslateY(1);
        leftBackground.setTranslateX(1);
        leftBackground.setStyle("-fx-background-color: #12151c; -fx-opacity: 90%");
        GridPane rightBackground = new GridPane();
        GridPane.setVgrow(rightBackground, Priority.ALWAYS);
        GridPane.setHgrow(rightBackground, Priority.ALWAYS);
        rightBackground.setStyle("-fx-background-color: #171b24");
        rightBackground.setMinWidth(477);
        rightBackground.setMaxWidth(477);
        rightBackground.setMinHeight(438);
        rightBackground.setMaxHeight(438);
        rightBackground.setTranslateX(202);
        Rectangle rect = new Rectangle();
        GridPane.setVgrow(rect, Priority.ALWAYS);
        GridPane.setHgrow(rect, Priority.ALWAYS);
        GridPane.setValignment(rect, VPos.BOTTOM);

        rect.setHeight(75);
        rect.setWidth(477);
        rect.setFill(Color.rgb(36,48,64));
        pane.getChildren().addAll(leftBackground, rightBackground);
        rightBackground.getChildren().add(rect);
        panel.getChildren().add(pane);
        this.centerPane.getChildren().add(panel);
    }

    private void showFooterPanel(@NotNull GridPane pane){
        Rectangle background = new Rectangle();
        background.setFill(Color.rgb(22,34,50));
        background.setWidth(880);
        background.setHeight(100);
        background.setTranslateY(80);
        Label configRequise = new Label("CONFIGURATION REQUISE");
        configRequise.setStyle("-fx-text-fill: #accaeb; -fx-font-size: 16px; -fx-font-weight: bold");
        configRequise.setTranslateY(50);
        configRequise.setTranslateX(10);
        Label osRequisLabel = new Label("Système d'exploitation:");
        osRequisLabel.setStyle("-fx-text-fill: #fff; -fx-font-size: 14px;");
        osRequisLabel.setTranslateY(80);
        osRequisLabel.setTranslateX(10);
        Label osRequis = new Label("Windows 7 64 bit");
        osRequis.setStyle("-fx-text-fill: #5d8098; -fx-font-size: 14px;");
        osRequis.setTranslateY(110);
        osRequis.setTranslateX(10);
        Label gpuRequisLabel = new Label("GPU:");
        gpuRequisLabel.setStyle("-fx-text-fill: #fff; -fx-font-size: 14px;");
        gpuRequisLabel.setTranslateY(80);
        gpuRequisLabel.setTranslateX(220);
        Label gpuRequis = new Label("Geforce GT440 / Radeon HD");
        gpuRequis.setStyle("-fx-text-fill: #5d8098; -fx-font-size: 14px;");
        gpuRequis.setTranslateY(110);
        gpuRequis.setTranslateX(220);

        Label configRecommande = new Label("CONFIGURATION RECOMMANDÉE");
        configRecommande.setStyle("-fx-text-fill: #accaeb; -fx-font-size: 16px; -fx-font-weight: bold");
        configRecommande.setTranslateY(50);
        configRecommande.setTranslateX(500);
        Label osRecomLabel = new Label("Système d'exploitation:");
        osRecomLabel.setStyle("-fx-text-fill: #fff; -fx-font-size: 14px;");
        osRecomLabel.setTranslateY(80);
        osRecomLabel.setTranslateX(500);
        Label osRecom = new Label("Windows 10 64 bit");
        osRecom.setStyle("-fx-text-fill: #5d8098; -fx-font-size: 14px;");
        osRecom.setTranslateY(110);
        osRecom.setTranslateX(500);
        Label gpuRecomLabel = new Label("GPU:");
        gpuRecomLabel.setStyle("-fx-text-fill: #fff; -fx-font-size: 14px;");
        gpuRecomLabel.setTranslateY(80);
        gpuRecomLabel.setTranslateX(720);
        Label gpuRecom = new Label("Nvidia GeForce GTS 250");
        gpuRecom.setStyle("-fx-text-fill: #5d8098; -fx-font-size: 14px;");
        gpuRecom.setTranslateY(110);
        gpuRecom.setTranslateX(720);
        Separator separator = new Separator();
        separator.setMinHeight(1);
        separator.setMaxHeight(1);
        separator.setTranslateY(15);
        separator.setStyle("-fx-background-color: #2B405B; -fx-border-width: 2 2 2 940; -fx-border-color: #2B405B;");
        pane.getChildren().addAll(background,configRequise, osRequisLabel, osRequis,gpuRequisLabel, gpuRequis,configRecommande,osRecomLabel,osRecom, gpuRecomLabel, gpuRecom,separator);
    }

    private void showAboutPanel(@NotNull GridPane pane){
        Label labelDescription = new Label("DESCRIPTION");
        labelDescription.setStyle("-fx-font-size: 16px; -fx-text-fill: white");
        Label titleLorem = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        titleLorem.setStyle("-fx-font-size: 22px; -fx-text-fill: #fff");
        titleLorem.setTranslateY(50);
        Rectangle backgroundTop = new Rectangle();
        backgroundTop.setFill(Color.rgb(47,67,78));
        backgroundTop.setWidth(400);
        backgroundTop.setHeight(120);
        backgroundTop.setTranslateY(150);
        Label descriptionTop = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
                "Pellentesque ultricies ligula eget massa lobortis,\n" +
                "ut pharetra eros tincidunt. Phasellus ut est vehicula augue condimentum.");
        descriptionTop.setStyle("-fx-text-fill: #5d8098; -fx-font-size: 14px;");
        descriptionTop.setTranslateY(250);
        Label aboutGame = new Label("À propos du jeu");
        aboutGame.setStyle("-fx-font-size: 22px; -fx-text-fill: #fff");
        aboutGame.setTranslateY(320);
        Rectangle backgroundBottom = new Rectangle();
        backgroundBottom.setFill(Color.rgb(47,67,78));
        backgroundBottom.setWidth(400);
        backgroundBottom.setHeight(120);
        backgroundBottom.setTranslateY(420);
        Label descriptionBottom = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
                "Pellentesque ultricies ligula eget massa lobortis,\n" +
                "ut pharetra eros tincidunt. Phasellus ut est vehicula augue condimentum.");
        descriptionBottom.setStyle("-fx-text-fill: #5d8098; -fx-font-size: 14px;");
        descriptionBottom.setTranslateY(520);
        pane.getChildren().addAll(labelDescription,titleLorem,backgroundTop, descriptionTop, aboutGame,backgroundBottom,descriptionBottom);
    }

    private void addNewsPanel(@NotNull GridPane pane){
        Label newsLabel = new Label("NOUVEAUTÉS");
        GridPane.setVgrow(newsLabel, Priority.ALWAYS);
        GridPane.setHgrow(newsLabel, Priority.ALWAYS);
        GridPane.setHalignment(newsLabel, HPos.LEFT);
        GridPane.setValignment(newsLabel, VPos.TOP);
        newsLabel.setStyle("-fx-text-fill: #fff; -fx-font-size: 16px; -fx-font-weight: bold");

        ANews cash = new ANews("cash_prize", "[Du 19/02 au 04/03] Concour cash prize");
        cash.setTranslateY(-50);
        ANews black_market = new ANews("black_market", "[11/2-23/2/2020] Implémentation du black market");
        black_market.setTranslateY(-50);
        black_market.setTranslateX(310);

        ANews hopper = new ANews("spoil_hopper_de_farm", "Ajout d'un hopper super puissant !");
        hopper.setTranslateY(-50);
        hopper.setTranslateX(620);

        Button plusDactu = new Button("Plus d'actualité");
        GridPane.setVgrow(plusDactu, Priority.ALWAYS);
        GridPane.setHgrow(plusDactu, Priority.ALWAYS);
        GridPane.setHalignment(plusDactu, HPos.LEFT);
        GridPane.setValignment(plusDactu, VPos.BOTTOM);
        plusDactu.setStyle("-fx-font-size: 14px; -fx-background-color: rgba(0,0,0,0.0); -fx-text-fill: #416389; -fx-border-color: #416389");
        plusDactu.setOnMouseEntered(e->this.layout.setCursor(Cursor.HAND));
        plusDactu.setOnMouseExited(e->this.layout.setCursor(Cursor.DEFAULT));
        pane.getChildren().addAll(newsLabel, cash,black_market,hopper,plusDactu);
    }
    private void addTopPanel(GridPane pane){
        Label valkyriaTitle = new Label("Valkyria");
        GridPane.setVgrow(valkyriaTitle, Priority.ALWAYS);
        GridPane.setHgrow(valkyriaTitle, Priority.ALWAYS);
        GridPane.setValignment(valkyriaTitle, VPos.TOP);
        valkyriaTitle.setStyle("-fx-font-size: 26px; -fx-text-fill: #fff; -fx-font-weight: bold");
        valkyriaTitle.setTranslateY(20);
        Label farm = new Label("FarmToWin");
        GridPane.setVgrow(farm, Priority.ALWAYS);
        GridPane.setHgrow(farm, Priority.ALWAYS);
        GridPane.setValignment(farm, VPos.TOP);
        farm.setStyle("-fx-text-fill: #bcc6e7; -fx-font-size: 14px; -fx-opacity: 70%");
        farm.setTranslateY(70);

        Label complet = new Label("Complet");
        GridPane.setVgrow(complet, Priority.ALWAYS);
        GridPane.setHgrow(complet, Priority.ALWAYS);
        GridPane.setValignment(complet, VPos.TOP);
        complet.setStyle("-fx-text-fill: #bcc6e7; -fx-font-size: 14px; -fx-opacity: 70%");
        complet.setTranslateY(70);
        complet.setTranslateX(80);

        Label fluide = new Label("Fluide");
        GridPane.setVgrow(fluide, Priority.ALWAYS);
        GridPane.setHgrow(fluide, Priority.ALWAYS);
        GridPane.setValignment(fluide, VPos.TOP);
        fluide.setStyle("-fx-text-fill: #bcc6e7; -fx-font-size: 14px; -fx-opacity: 70%");
        fluide.setTranslateY(70);
        fluide.setTranslateX(140);

        Label desc = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean tempus\n" +
                "lectus ut tincidunt ultricies. Donec in accumsan nunc, quis volutpat arcu.\n" +
                "Cras non augue nec magna efficitur sodales. Sed non lectus id erat \n" +
                "convallis rhoncus eget sed massa. Orci varius natoque\npenatibus et magnis dis parturient");
        GridPane.setVgrow(desc, Priority.ALWAYS);
        GridPane.setHgrow(desc, Priority.ALWAYS);
        GridPane.setValignment(desc, VPos.TOP);
        desc.setStyle("-fx-text-fill: #bcc6e7; -fx-font-size: 14px; -fx-opacity: 70%");
        desc.setTranslateY(130);

        GridPane bigVideo = new GridPane();
        GridPane.setVgrow(bigVideo, Priority.ALWAYS);
        GridPane.setHgrow(bigVideo, Priority.ALWAYS);
        GridPane.setValignment(bigVideo, VPos.TOP);
        GridPane.setHalignment(bigVideo, HPos.RIGHT);
        bigVideo.setMinHeight(320);
        bigVideo.setMaxHeight(320);
        bigVideo.setMinWidth(430);
        bigVideo.setMaxWidth(430);
        String content_Url = "<iframe style='background : rgba(0,0,0,0);' width=\"420\" height=\"300\" src=\"http://arinonia.chaun14.fr/pages/video.html\" frameborder=\"0\" allow=\"accelerometer; autoplay=1; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";
        WebView webView = new WebView();
        webView.setStyle("overflow-x: hidden;overflow-y: hidden;");
        WebEngine webEngine = webView.getEngine();
        webEngine.loadContent(content_Url);
        bigVideo.getChildren().add(webView);
        webView.getChildrenUnmodifiable().addListener((ListChangeListener<Node>) change -> {
            Set<Node> deadSeaScrolls = webView.lookupAll(".scroll-bar");
            for (Node scroll : deadSeaScrolls) {
                scroll.setVisible(false);
            }
        });
        try {
            Field field = webEngine.getClass().getDeclaredField("page");
            field.setAccessible(true);
            com.sun.webkit.WebPage page = (WebPage) field.get(webEngine);
            SwingUtilities.invokeLater(() -> page.setBackgroundColor(new java.awt.Color(255, 255, 255, 0).getRGB()));
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        Button installButton = new Button("Installer");
        GridPane.setVgrow(installButton, Priority.ALWAYS);
        GridPane.setHgrow(installButton, Priority.ALWAYS);
        GridPane.setHalignment(installButton, HPos.LEFT);
        GridPane.setValignment(installButton, VPos.TOP);
        installButton.setTranslateY(260);
        installButton.setMinWidth(140);
        installButton.setMaxHeight(40);
        installButton.setStyle("-fx-background-color: #115faa; -fx-border-radius: 0px; -fx-background-insets: 0; -fx-font-size: 14px; -fx-text-fill: white;");
        installButton.setOnMouseEntered(e->this.layout.setCursor(Cursor.HAND));
        installButton.setOnMouseExited(e->this.layout.setCursor(Cursor.DEFAULT));

        Button settingsButton = new Button();
        GridPane.setVgrow(settingsButton, Priority.ALWAYS);
        GridPane.setHgrow(settingsButton, Priority.ALWAYS);
        GridPane.setHalignment(settingsButton, HPos.LEFT);
        GridPane.setValignment(settingsButton, VPos.TOP);
        MaterialDesignIconView settingsIcon = new MaterialDesignIconView(MaterialDesignIcon.SETTINGS);
        settingsIcon.setSize("18px");
        settingsIcon.setFill(Color.rgb(17,95,170));
        settingsButton.setStyle("-fx-background-color: rgba(255,255,255,0.0); -fx-border-color: #115faa; -fx-border-radius: 2px");
        settingsButton.setTranslateX(150);
        settingsButton.setTranslateY(266);
        settingsButton.setMinWidth(26);
        settingsButton.setMaxWidth(26);
        settingsButton.setMinHeight(26);
        settingsButton.setMaxHeight(26);
        settingsButton.setGraphic(settingsIcon);
        settingsButton.setOnMouseEntered(e->this.layout.setCursor(Cursor.HAND));
        settingsButton.setOnMouseExited(e->this.layout.setCursor(Cursor.DEFAULT));
        settingsButton.setOnMouseClicked(e-> {
            System.out.println("Open settings frame");
            displaySettingsFrame();
        });
        ABigDownloadBar aBigDownloadBar = new ABigDownloadBar();

        pane.getChildren().addAll(valkyriaTitle,farm,complet,fluide,desc,bigVideo, installButton, settingsButton,aBigDownloadBar);
    }

    private void showLeftBar(GridPane pane){
        Separator blueLeftSeparator = new Separator();
        GridPane.setVgrow(blueLeftSeparator, Priority.ALWAYS);
        GridPane.setHgrow(blueLeftSeparator, Priority.ALWAYS);
        blueLeftSeparator.setOrientation(Orientation.VERTICAL);
        blueLeftSeparator.setMinWidth(3);
        blueLeftSeparator.setMaxWidth(3);
        blueLeftSeparator.setMinHeight(40);
        blueLeftSeparator.setMaxHeight(40);
        blueLeftSeparator.setStyle("-fx-background-color: rgb(5,179,242); -fx-border-width: 3 3 3 0; -fx-border-color: rgb(5,179,242);");

        Image logoImageValkyria = new Image(Main.class.getResource("/fr/arinonia/valkyria/ui/resources/valkyria.png").toExternalForm());
        ImageView imageViewValkyria = new ImageView(logoImageValkyria);
        GridPane.setVgrow(imageViewValkyria, Priority.ALWAYS);
        GridPane.setHgrow(imageViewValkyria, Priority.ALWAYS);
        GridPane.setValignment(imageViewValkyria, VPos.CENTER);
        imageViewValkyria.setTranslateX(34);
        imageViewValkyria.setFitWidth(28);
        imageViewValkyria.setFitHeight(28);

        Label valkyriaLabel = new Label("Valkyria");
        GridPane.setVgrow(valkyriaLabel, Priority.ALWAYS);
        GridPane.setHgrow(valkyriaLabel, Priority.ALWAYS);
        GridPane.setValignment(valkyriaLabel, VPos.CENTER);
        valkyriaLabel.setTranslateX(90);
        valkyriaLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #fff");

        ASmallDownloadBar leftDownloadBar = new ASmallDownloadBar();
        leftDownloadBar.setTranslateX(90);
        pane.getChildren().addAll(blueLeftSeparator,imageViewValkyria,valkyriaLabel, leftDownloadBar);
    }
    private void showTopBar(){
        GridPane background  = new GridPane();
        GridPane.setVgrow(background, Priority.ALWAYS);
        GridPane.setHgrow(background, Priority.ALWAYS);
        background.setStyle("-fx-background-color: #042f59; -fx-opacity: 30%");
        Label accueilLabel = new Label("ACCUEIL");
        accueilLabel.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");
        accueilLabel.setMinSize(70,25);
        accueilLabel.setMaxSize(70,25);
        accueilLabel.setTranslateX(30);
        Label boutiqueLabel = new Label("BOUTIQUE");
        boutiqueLabel.setStyle("-fx-text-fill: rgb(200,200,200); -fx-font-size: 14px;");
        boutiqueLabel.setMinSize(70,25);
        boutiqueLabel.setMaxSize(70,25);
        boutiqueLabel.setTranslateX(108);
        boutiqueLabel.setOnMouseEntered(e-> this.layout.setCursor(Cursor.HAND));
        boutiqueLabel.setOnMouseExited(e->this.layout.setCursor(Cursor.DEFAULT));
        boutiqueLabel.setOnMouseClicked(e-> this.showPanel(new BoutiquePanel()));
        this.panelManager.getTopPanel().getTopBar().getChildren().addAll(accueilLabel,boutiqueLabel);
    }


    public void showPanel(IPanel panel){
        this.centerPane.getChildren().clear();
        this.centerPane.getChildren().add(panel.getLayout());
        panel.init(this.panelManager);
        panel.onShow();
    }
}
