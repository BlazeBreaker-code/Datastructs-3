class Tree {
    Node root;
    Tree ( ) {
        //Sets root to null
        root = null;
    }
    public Node getRoot( ) {
        //Returns root
        return root;
    }
    public void setRoot(Node newRoot) {
        //Sets root to newRoot
        root = newRoot;
    }
    public boolean empty( ) {
        //Returns true if the tree is empty and false otherwise
        return (root == null);
    }
    public int count( ) {
        //Returns the number of nodes in the tree.
        //Uses function countNodes().
        if(empty()) {
            return 0;
        } else{
            return countNodes(root);
        }
    }
    public int countNodes(Node N) {
        //Recursive function which returns the number of node
        //in the subtree rooted at N.
        if(N != null){
            int left = countNodes(N.getLeft());
            int right = countNodes(N.getRight());
            return left+right+1;
        } else {
            return 0;
        }
    }
    public boolean equal(Tree T) {
        //Returns true if our tree equals tree T. Returns false otherwise.
        //Uses function equalNodes().
        if(T.count() != count()) {
            return false;
        } else {
            return equalNodes(root,T.root);
        }
    }
    public boolean equalNodes(Node N, Node M) {
        //Recursive function which returns true if the subtrees rooted
        //at N and M are equal. Returns false otherwise.
        if(N == null && M == null) return true;
        if((N == null && M != null)||(N != null && M == null)) return false;
        if(N.getData() != M.getData()) return false;
        if((!equalNodes(N.getRight(), M.getRight())|| (!equalNodes(N.getLeft(), M.getLeft())))) return false;

        return true;
    }
    public boolean search(int element) {
        //Returns true if element belongs in the tree. Returns false otherwise.
        if(empty()) return false;
        if(root.getData() == element) return true;

        return searchNodes(root, element);
    }
    public boolean searchNodes(Node N, int element) {
        //Recursive function which returns true if element belongs to the
        // subtree rooted at N. Returns false otherwise.
        if(N != null) {
            if(N.getData() == element) return true;
            if(searchNodes(N.getLeft(), element)|| searchNodes(N.getRight(), element)) return true;
            return false;
        }
        return false;
    }
    public void printLDR() {
        //Prints the elements of the tree in in-order (LDR).
        //Uses function printLDRNodes().
        if(!empty()) {
            printLDRNodes(root);
            System.out.println();
        }
    }
    public void printLDRNodes(Node N) {
        //Recursive function which prints the elements of the subtree
        //rooted at N in in-order (LDR).
        //Left Root Right
        if(N != null) {
            printLDRNodes(N.getLeft());
            System.out.print(N.getData() + " ");
            printLDRNodes(N.getRight());
        }
    }
    public void printLRD() {
        //Prints the elements of the tree in post-order (LRD).
        //Uses function printLRDNodes().
        if(!empty()){
            printLRDNodes(root);
            System.out.println();
        }
    }
    public void printLRDNodes(Node N) {
        //Recursive function which prints the elements of the subtree
        //rooted at N in post-order (LRD).
        //Left Right Root
        if(N != null) {
            printLRDNodes(N.getLeft());
            printLRDNodes(N.getRight());
            System.out.print(N.getData() + " ");
        }
    }
    public void printDLR() {
        //Prints the elements of the tree in pre-order (DLR).
        //Uses function printDLRNodes().
        if(!empty()) {
            printDLRNodes(root);
            System.out.println();
        }
    }
    public void printDLRNodes(Node N) {
        //Uses function searchNodes().
        //Recursive function which prints
        //rooted at N in pre-order (DLR).
        //Root Left Right
        if(N != null) {
            System.out.print(N.getData() + " ");
            printDLRNodes(N.getLeft());
            printDLRNodes(N.getRight());
        }
    }
    public Tree copy() {
        //Returns a copy of our tree.
        //Uses function copyNodes().
        Tree cpTree = new Tree();
        if(!empty()) {
            Node cpNode = copyNodes(root);
            cpTree.setRoot(cpNode);
        }
        return cpTree;
    }
    public Node copyNodes(Node N) {
        //Recursive function which returns a copy of the subtree rooted at N.
        if(N != null){
            Node cp = new Node();
            cp.setData(N.getData()); //copying contents into new node
            cp.setLeft(copyNodes(N.getLeft()));
            cp.setRight(copyNodes(N.getRight()));
            return cp;
        }
        return N;
    }
    public void leaves( ) {
        //Prints the leaves of our tree. The root is not a leave.
        //Uses function leavesNodes().
        if(count() == 1) return;
        if(!empty()){
            leavesNodes(root);
        }
        System.out.println();
    }
    public void leavesNodes(Node N) {
        //Recursive function which prints the leaves of the subtree
        //rooted at N.
        if( N != null) {
            if(N.getLeft() == null && N.getRight() == null) {
                System.out.print(N.getData() + " ");
            } else {
                leavesNodes(N.getLeft());
                leavesNodes(N.getRight());
            }
        }
    }
    public void internal() {
        //Prints the internal nodes of our tree.
        //The root is not an internal node.
        //Uses function internalNodes().
        if(count() == 1) return;
        if(!empty()){
            internalNodes(root);
        }
        System.out.println();
    }
    public void internalNodes(Node N) {
        //Recursive function which prints the internal nodes of the
        //subtree rooted at N.
        if(N != null) {
            if((N.getRight() != null) || (N.getLeft() != null)) {
                if(N != root) {
                    System.out.print(N.getData() + " ");
                }
            }
            internalNodes(N.getLeft());
            internalNodes(N.getRight());
        }
    }
    public void path(int element) {
        //Prints the path from root to element if element exists in the tree.
        //Uses function pathNodes().
        if(!empty()) pathNodes(element, root);
        System.out.println();
    }
    public void pathNodes(int element, Node N) {
        //Recursive function which prints the path from N to element.
        //Assumes element belongs in the subtree rooted at N.
        if(searchNodes(N, element))
        {
            System.out.print(N.getData()+" ");
            if(N.getData() == element)
                return;
            pathNodes(element, N.getLeft());
            pathNodes(element, N.getRight());
        }
    }
    public int height() {
        //Returns the height of the tree.
        //Uses function heightNodes().
        return heightNodes(root);
    }
    public int heightNodes(Node N) {
        //Recursive function which returns the height of the subtree
        //rooted at N.
        if(N == null) return 0;
        if((N.getRight() == null) && (N.getLeft() == null)) return 0;
        int left = heightNodes(N.getLeft());
        int right = heightNodes(N.getRight());

        if(left > right) return 1 + left;
        else return 1 + right;

    }
    public void descendents(int element) {
        //Prints all the descendents of element if element exists in the tree.
        //Uses function descendentsNodes().
        descendentsNodes(root, element);
    }
    public void descendentsNodes(Node N, int element) {
        //Recursive function which prints all the descendents of element in
        //the subtree rooted at N.
        //Assumes element belongs in the subtree rooted at N.
        if (searchNodes(N, element)) {
            if (N.getData() == element) {
                printLDRNodes(N.getLeft());
                printLDRNodes(N.getRight());
                System.out.println();
            } else {
                descendentsNodes(N.getLeft(), element);
                descendentsNodes(N.getRight(), element);
            }
        }
    }
}
