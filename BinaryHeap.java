class BinaryHeap  {

    //Kan bli representert med  ARRAY!!
    //Vi ma passe  pa at array hverken er for stort eller for lite.
    //da ma vi forminske/oke array etterhvert.
    //I java kan det vare lurt med arraylist.
    BinaryHeap() {}


//antar at a er stort nok til at vi kan sette inn pa n uten at det overskriver
    public void insert(Array[] a, int x) {
        int n = a.length(); //antall elementer i Heap
        a[n] = x; //vi lar siste element i a vare x
        int i = n;

        while (0 < i && a[i] < a[(i - 1)/2])  { //sammenligner med foreldrenoden
            int temp = a[(i - 1)/2];
            a[(i - 1)/2] = a[i];
            a[i] = temp;

            i = (i - 1)/2;
        }
    }

    public int removeMin(Array[] a) {
        int n = a.length();
        int x = a[0]; //minste ligger alltid "overst", denne returnerer vi gjerne
        a[0] = a[n-1];
        int i = 0;
        while ((2*i + 2) < n - 1) { //dersom indeks hoyre subtres rotnode er mindre enn lengden pa listen
            int j = 0;
            if (a[(2*i) + 1] <= a[(2*i +2)]) { //sammenligner minste barn av venstre og hoyre
                j = 2*i + 1; } else { j = 2*i + 2; }

            if (a[j] <= a[i]) { //dersom barnet er mindre enn foreldren: bytt plass.
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i = j;
                continue; //hopper opp i while-loopen igjen.
            }
            break; //bryter helt ut av while-loopen
        }

        //vi maa til slutt sorge for at venstre nodebarn
        //er storre enn foreldrenoden, sa lenge det finnes et venstre nodebarn.
        if ((2*i + 1) < n - 1 && a[2*i + 1] <= a[i]) {
            int temp = a[i];
            a[i] = a[2*i + 1];
            a[2*i + 1] = temp;
        }
        return x;
    }
}
