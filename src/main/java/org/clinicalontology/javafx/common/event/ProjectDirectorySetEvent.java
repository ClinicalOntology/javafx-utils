package org.clinicalontology.javafx.common.event;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

import java.io.File;

public class ProjectDirectorySetEvent extends Event {

    public static final EventType<ProjectDirectorySetEvent> PROJECT_DIRECTORY_SET_EVENT_EVENT_TYPE = new EventType(new EventType(ANY), "ProjectDirectorySetEvent");

    private File projectDirectory = null;

    public ProjectDirectorySetEvent(Object eventSource, EventTarget eventTarget) {
        super(eventSource, eventTarget, PROJECT_DIRECTORY_SET_EVENT_EVENT_TYPE);
    }

    public ProjectDirectorySetEvent(File projectDirectory) {
        super(PROJECT_DIRECTORY_SET_EVENT_EVENT_TYPE);
        this.projectDirectory = projectDirectory;
    }

    public File getProjectDirectory() {
        return projectDirectory;
    }

    public void setProjectDirectory(File projectDirectory) {
        this.projectDirectory = projectDirectory;
    }

    public void invokeHandler(ProjectDirectorySetEventHandler handler) {
        handler.onEvent(projectDirectory);
    }
}
