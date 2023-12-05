

public class Tree23 {
    private Node23 root = new Node23();

    public int find(long data) {
        Node23 current = root;
        int currentNumber;
        while (true) {
            if ((currentNumber = current.findItem(data)) != -1) //Found what are looking for
                return currentNumber;
            else if (current.isLeaf())  //Reached to the leaf node without finding what we are looking for
                return -1;
            else
                current = getNextChild(current, data);  //Keep going down the tree to look for data
        }
    }
    
    private Node23 getNextChild(Node23 node, long data) {
        int i;
        int numItems = node.getNumItems();
        
        for (i=0; i < numItems; i++) {
            if (data < node.getItem(i).data)
                return node.getChild(i);
        }
        
        return node.getChild(i);
    }

    public void insert(long value) {
        DataItem data = new DataItem(value);
        Node23 current = root;
            
            while (true) {
                if (current.isFull()) {
                    split(current);
                    current = getNextChild(current.getParent(), value); //Step back up to parent and look for child node to got to
                }else if (current.isLeaf()) {
                    break;
                } else {
                    current = getNextChild(current, value);
                }
            }
            
            current.insertItem(data);
            if (current.isFull()) {
                split(current);
                current = getNextChild(current, value);
            }
        }
    
    private void split(Node23 node) {
        DataItem itemB, itemC;
        Node23 child2, child3, parent;
        int itemIndex;
        
        itemC = node.removeRightMostItem();
        itemB = node.removeRightMostItem();
        child2 = node.disconnectChild(2);
        child3 = node.disconnectChild(3);
        
        if (node == root){
            parent = new Node23();
            root = parent;
            root.connectChild(0, node);
        } else {
            parent = node.getParent();
        }
        
        //Insert itemB in parent and keep track of where it is inserted for next step
        itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();
        
        //Move existing child nodes if necessary - only if current data items were moved to make space for itemB
        for (int j = n-1; j > itemIndex; j--) {
            Node23 t = parent.disconnectChild(j);
            parent.connectChild(j + 1, t);
        }
        
        //Create new sibling and add itemC as well as two child nodes
        Node23 newRight = new Node23();
        newRight.insertItem(itemC);
        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);
        parent.connectChild(itemIndex+1, newRight);
        if (parent.isFull()) {
            split(parent);
        }
    }
    
    public void display() {
        recursiveTraverse(root);
    }
    
    private void recursiveTraverse(Node23 node) {
        if (node == null)
            return;
        
        node.displayNode();
        for (int i=0; i<4; i++) {
            recursiveTraverse(node.getChild(i));
        }
    }

}
