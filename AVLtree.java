class AVLtree {
    AVLtree() {}

    class Node {
        public int height;
        int elem;
        public Node left;
        public Node right;

        Node(int x) {
            this.elem = x;
        }
    }

    public int height(Node v) {
        if (v == null) {
            return -1;
        }
        return v.height;
    }


/** Er balansefactor negativ --> hoyretungt, positiv --> venstretungt
**/
    public int balanceFactor(Node v) {
        if (v == null) {
            return 0;
        }
        return height(v.left) - height(v.right);
    }

    public Node balance(Node v) {
        if (balanceFactor(v.right) < -1) {
            if (balanceFactor(v.right) > 0) { //dersom hoyre subtre er venstretungt
                v.right = rightRotate(v.right); //dobbel rotasjon
            }
            return leftRotate(v);
        }
        if (balanceFactor(v.left) > 1) {
            if (balanceFactor(v.left) < 0) { //dersom venstre subtre er hoyretungt
                v.left = leftRotate(v.left); //dobbel rotasjon
            }
            return rightRotate(v.left);
        }
        return v;
    }

/** Treet vart er hoyretungt! Vi gjor venstre-rotasjon
    alle elementer til hoyre er storre enn z
**/
    private Node leftRotate(Node z) {
        Node y = z.right;
        Node temp = y.left;

        y.left = z;
        z.right = temp;

        //Husk a sette hoyde!
        y.height = 1 + max(Height(y.left), Height(y.right));
        z.height = 1 + max(Height(z.left), Height(z.right));
        return y; //returnerer ny "rot"
    }


    /** Treet vart er venstre-tungt! Vi gjor hoyre-rotasjon
        alle elementer til venstre er mindre enn z
    **/
    private Node rightRotate(Node z) {
        Node y = z.left;
        Node temp = y.right;

        y.right = z;
        z.left = temp;

        y.height = 1 + max(Height(y.left), Height(y.right));
        z.height = 1 + max(Height(z.left), Height(z.right));
        return y;
    }


    /** node v er et rot-noden, og rekursivt barna til roten
        int x er elementet som skal ligge pa noden.
        O(h)
        Er treet balansert --> O(log(n))
    **/
    public void insert(Node v, int x) {
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
            v.height = 1 + max(height(v.right), height(v.left));
            return balance(v); //denne er den noten som etter balance er roten
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
                v.height = 1 + max(height(v.right), height(v.left));
                return v;
            }

}
