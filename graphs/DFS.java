class DFS {
    DFS(Graph G, Node start) {
        start.visited = true;
        for (int i = 0; i < naboer.length(); i++) {
            if (!naboer[i].visited) {
                naboer[i].visited = true;
                DFS(G, naboer[i]);
            }
        }
    }

//ma kalles for at vi skal traversere gjennom hele Grafen.
    DFSfull(Graph G) {
        //gitt at G er implementert som en array
        for (int i = 0; i < G.length(); i++) {
            if (!G[i].visited) {
                DFS(G, G[i]);
            }
        }
    }
}
