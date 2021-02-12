package org.clinicalontology.javafx.common.tabpane;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class TabPaneUtils {

    /**
     * Method removes tab with provided tab name from tab pane. If more than one tab with that name is found, an exception
     * will be thrown and no tab will be removed.
     *
     * @param projectTabPane
     * @param tabName
     */
    public static void removeTabWithName(TabPane projectTabPane, String tabName) {
        if (tabName == null || tabName.trim().length() <= 0) {
            return;
        } else {
            int tabIndex = -1;
            int tabCount = 0;
            for (int index = 0; index < projectTabPane.getTabs().size(); index++) {
                Tab tab = projectTabPane.getTabs().get(index);
                if (tab.getText() != null && tab.getText().equalsIgnoreCase(tabName)) {
                    tabIndex = index;
                    tabCount++;
                }
            }
            if (tabCount > 1) {
                throw new IllegalStateException("More than one tab with name " + tabName + " present");
            } else if (tabCount == 1) {
                projectTabPane.getTabs().remove(tabIndex);
            }
        }
    }
}
