// ro/ulbs/paradigme/lab2/doublechained/DoubleChainedList.java
package ro.ulbs.paradigme.lab2.doublechained;

import ro.ulbs.paradigme.lab2.api.MyList;
import ro.ulbs.paradigme.lab2.api.Node;

public class DoubleChainedList implements MyList {
    private DoubleChainedNode head;
    private DoubleChainedNode tail;

    @Override
    public void addValue(int value) {
        DoubleChainedNode newNode = new DoubleChainedNode();
        newNode.setValue(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNextNode(newNode);
            newNode.setPrevNode(tail);
            tail = newNode;
        }
    }

    @Override
    public void removeNodeByValue(int value) {
        if (head == null) return;
        if (head.getValue() == value) {
            head = head.getNextNode();
            if (head != null) head.setPrevNode(null);
            return;
        }
        DoubleChainedNode current = head;
        while (current != null && current.getValue() != value) {
            current = current.getNextNode();
        }
        if (current != null) {
            if (current.getPrevNode() != null) {
                current.getPrevNode().setNextNode(current.getNextNode());
            }
            if (current.getNextNode() != null) {
                current.getNextNode().setPrevNode(current.getPrevNode());
            }
        }
    }

    @Override
    public Node getNodeByValue(int value) {
        DoubleChainedNode current = head;
        while (current != null) {
            if (current.getValue() == value) {
                return current;
            }
            current = current.getNextNode();
        }
        return null;
    }

    @Override
    public void listNodes() {
        DoubleChainedNode current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNextNode();
        }
        System.out.println();
    }

    @Override
    public boolean isSorted() {
        if (head == null) return true;
        DoubleChainedNode current = head;
        while (current.getNextNode() != null) {
            if (current.getValue() > current.getNextNode().getValue()) {
                return false;
            }
            current = current.getNextNode();
        }
        return true;
    }

    @Override
    public int sum() {
        int sum = 0;
        DoubleChainedNode current = head;
        while (current != null) {
            sum += current.getValue();
            current = current.getNextNode();
        }
        return sum;
    }
}
