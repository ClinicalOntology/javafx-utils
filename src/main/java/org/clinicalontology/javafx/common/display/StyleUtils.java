package org.clinicalontology.javafx.common.display;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

import java.net.URL;

public class StyleUtils {

    /**
     *
     * @param clazz    The class whose classloader we are invoking
     * @param cssResourcePath   The path to the CSS file relative to the root of the classpath
     * @return  The external file path
     */
    public static String getCssPath(Class<?> clazz, String cssResourcePath) {
        URL cssUrl = clazz.getResource(cssResourcePath);
        if (cssUrl == null) {
            throw new RuntimeException("Error loading " + cssResourcePath);
        }
        String cssPath = cssUrl.toExternalForm();
        return cssPath;
    }

    /**
     * Useful for debugging. Note Pane are Regions.
     *
     * @param regionComponent
     * @param color
     */
    public static void setBackground(Region regionComponent, Color color) {

        // create a background fill
        BackgroundFill background_fill = new BackgroundFill(color,
                CornerRadii.EMPTY, Insets.EMPTY);

        // create Background
        Background background = new Background(background_fill);

        // set background
        regionComponent.setBackground(background);
    }

    public static void addStylingClassToAlert(Alert alert, String stylesheetPath, String styleClass) {
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
                alert.getClass().getResource(stylesheetPath).toExternalForm());
        dialogPane.getStyleClass().add("myDialog");
    }
}
