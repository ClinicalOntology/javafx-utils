package org.clinicalontology.javafx.common.node;

import javafx.scene.Node;

public class NodeUtils {

    public static <T> T getAncestorOfType(Class<T> clazz, Node node) {
        Node currentNode = node;
        while(currentNode != null) {
            if (currentNode.getClass() == clazz) {
                return (T)currentNode;
            } else if(currentNode.getParent() != null){
                currentNode = currentNode.getParent();
            } else {
                break;
            }
        }
        return null;
    }
}
