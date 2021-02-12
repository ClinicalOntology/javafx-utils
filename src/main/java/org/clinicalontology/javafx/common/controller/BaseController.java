package org.clinicalontology.javafx.common.controller;

import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.stage.Window;

public abstract class BaseController implements Initializable {
    protected Window getPrimaryStage(Event event) {
        return ((Node)event.getTarget()).getScene().getWindow();
    }
    protected void closeWindow(Event event) {
        Window primaryStage = getPrimaryStage(event);
        ((Stage) primaryStage).close();
    }
}
