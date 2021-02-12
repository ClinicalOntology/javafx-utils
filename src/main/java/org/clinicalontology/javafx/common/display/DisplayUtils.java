package org.clinicalontology.javafx.common.display;

import javafx.geometry.Rectangle2D;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.stage.Screen;
import javafx.stage.Window;

import java.io.InputStream;

public class DisplayUtils {

    public static void centerWindowOnScreen(Window window, int windowWidth, int windowHeight) {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        window.setX(bounds.getWidth() / 2 - (windowWidth / 2));
        window.setY(bounds.getHeight() / 2 - (windowHeight / 2));
    }

    public static void setPreferredSizeToFullScreen(Region region) {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        region.setPrefWidth(bounds.getWidth());
        region.setPrefHeight(bounds.getHeight());
    }

    public static ImageView buildImageView(InputStream resource, int resizeHeight, int resizeWidth) {
        ImageView imageView =  new ImageView(new Image(resource));
        imageView.setFitHeight(resizeHeight);
        imageView.setFitWidth(resizeWidth);
        return imageView;
    }

    public static void setDefaultButton (Alert alert, ButtonType defBtn ) {
        DialogPane pane = alert.getDialogPane();
        for ( ButtonType t : alert.getButtonTypes() )
            ( (Button) pane.lookupButton(t) ).setDefaultButton( t == defBtn );
    }
}
