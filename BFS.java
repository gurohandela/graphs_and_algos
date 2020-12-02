class BFS {
    //forskjellen pa BFS og DFS er at vi
    //kan bruke BFS nar vi skal finne korteste sti
//med litt motifikasjoner pa BFS, fordi
//vi sjekker ALLE naboer for vi gar videre til neste
// node.

// Med DFS sa trekker vi bare en tilfeldig nabo-node.
// Med BFS velger vi alle naboene forst fra koen. 
    BFS(Graph G, Node start) {
        int i = 0;
        ArrayList list = new ArrayList<Node>();
        list.add(start); //fungerer som ko.
        while (list != null) {
            for (int i = 0; i < list.length()); i++) {
                Node l = list.remove(0);
                for (int j = 0; j < l.naboer; j++) {
                    Node nabo = l.naboer[i];
                    if (!nabo.visited) {
                        nabo.visited = true;
                        list.add(nabo);
                    }
                }
            }
        }
    }
}
