class HuffmanTree {

    HuffmanTree(){}

    class Node {
        int elem;
        public int freq;
        Node left;
        Node right;

        Node(int elem, int freq, Node left, Node right) {
            this.elem = elem;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }

    public Node huffman(Array[] c) {
        PriorityQueue pq = new PriorityQueue();

//For hver tple
        for (tuple t in c) {
            pq.add(new Node(t.symbol, t.freq, null, null)); //hver node i ko har ingen barn
        }
//Saa popper vi av pq og inn pa et tre
//antar at  pq er sortert og at pop fungerer som FIFO
        while (pq.size > 1) {
            Node v1 = pq.pop();
            Node v2 = pq.pop();
            int totFreq = v1.freq() + v2.freq();
            //setter inn ny node pa koen.
            pd.add(new Node(null, totFreq, v1, v2));
        }
        return removeMin(pq); //er roten til huffmantreet
    }
}
