package org.clinicalontology.javafx.common.event;

import javafx.event.EventHandler;

import java.io.File;

public abstract class ProjectDirectorySetEventHandler implements EventHandler<ProjectDirectorySetEvent> {

    public abstract void onEvent(File projectDirectory);

    @Override
    public void handle(ProjectDirectorySetEvent projectDirectorySetEvent) {
        projectDirectorySetEvent.invokeHandler(this);
    }

}
