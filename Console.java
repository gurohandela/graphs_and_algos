public class Console {
    public static void main(String[] args) {
        Graph g = new Graph();
        Traversering travers = new Traversering();
        TopologiskSort ts = new TopologiskSort();

        Spenntre spt = new Spenntre();
        Korteststi ks = new Korteststi();

        g.initializeMatrix(5);
        g.setAdjsMatrix(1, [3, 4, 5]);
        g.setAdjsMatrix(2, [3]);

        spt.boruvkas(g.g);
    }

/** Returner true om du finner noe
NORMAL SOK
for (int i = 0; i < a.length(); i++) {
    if (a[i] == x) {
        return true;
    }
}
return false;

BinarySearch regner med at a er sortert!
O(log(n)) fordi vi deler pa 2 log(n) ganger. 
**/
    public static void binarySearch(Array[] a, int x) {
        int lowest_index = 0;
        int highest_index = a.length() - 1;
        while (lowest_index <= highest_index) {
            int middle_index = (lowest_index + highest_index) / 2;
            if (a[middle_index] == x) {
                return true;
                //VIKTIG let fra forste indeks til siste indeks: er den mindre?
                //vi regner med at listen er sortert!
            } else if (a[middle_index] < x) { //vi leter fremover
                lowest_index += 1;
            } else {
                highest_index -= 1; //vi leter bakover
            }
        }
        return false; //vi fant den ikke!
    }
}
