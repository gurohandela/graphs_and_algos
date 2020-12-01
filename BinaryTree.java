class BinaryTree {
//Slik dette treet er implementert ma man alltid sende med roten
// nar man skal gjor noe.

    class Node {
        public int elem;
        public Node left;
        public Node right;
        Node(int elem){
            this.elem = elem;
        }
    }

    BinaryTree() {}

/** node v er et rot-noden, og rekursivt barna til roten
    int x er elementet som skal ligge pa noden.
    O(h)
    Er treet balansert --> O(log(n))
**/
    public void insert(Node v, int  x) {
        if (v == null) {
            //det er HER vi setter inn!
            v = new Node(x);
        }  else if (x < v.elem) {
            //OBS: vi ma rekursivt ga gjennom alle venstre-noder
            //og endre for hver venstre til a fa ny venstre node.
            v.left = insert(v.left, x);
        } else if (x > v.elem) {
            //samme med hoyre ;)
            v.right = insert(v.right, x);
        }
    }
/** node v er rot-noden i starten, og rekursivt barna til roten etc.
    int x er elementet som skal ligge pa noden vi vil returnere
    O(h)
    Er binarytree sortert --> O(log(n))
**/
    public Node search(Node v, int x) {
        if (v == null) {
            return null;  //vi fant ikke elementet
        } else if (v.elem == x) {
            return v;     //vi fant elementet!
        } else if (x < v.elem) {
            return search(v.left, x);
        } else {
            return search(v.right, x);
        }
    }

//Vi kan ogsa velge a implementere med findMax(Node v)
//Da ma vi huske a ga til hoyre i subtreet i remove **
    public Node findMin(Node v) {
        if (v.left == null) {
            return v;
        } else {
            return findMin(v.left);
        }
    }

/**Dersom noden ikke er i treet returneres NULL, ellers return Node som blir slettet

**/
    public Node remove(Node v, int x) {
        if (v == null) {
            return null;
        } else if (x < v.elem) {
            v.left = remove(v.left, x);
            return v;
        } else if  (x > v.elem) {
            v.right = remove(v.right, x);
            return v;
        }

        if (v.left == null) {
            return v.right;
        }

        if (v.right == null) {
            return v.left;
        }

        Node u = findMin(v.right);  //**
        v.elem = u.elem;
        v.right = remove(v.right, u.elem); //**
        return v;
    }

}
