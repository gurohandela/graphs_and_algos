class Graph {
    Array[] g;

    Graph() {}

    public void initializeMatrix(int v) {
        g = new Array[v];
        for (int i = 0; i <= g; i++) {
            g[i] = new Array[v];
        }
    }

//v er indeks for noden, adjs er liste med indekser som skal vare 1
    public void setAdjsMatrix(int v, Array[] adjs) {
        for (int i = 0; i <= g[v].length; i++) {
            for (int j = 0; j <= adjs.length; i++) {
                if (i == adjs[j]) {
                    g[v][i] = 1;
                }
            }
        }
    }


    public void initializeAdjList(int v, Array[] adjs) {
        g = new Array[v];
        for (int i = 0; i <= g; i++) {
            g[i] = new Array[v];
        }
    }

}
