
/**
 *  The {@code Merge} class provides static methods for sorting an
 *  array using mergesort.
 *  <p>
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *  For an optimized version, see {@link MergeX}.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class MergeNonrecursive {

    // This class should not be instantiated.

    // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }

    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        Stack<Bounds> worklist = new GLStack<Bounds>();
        Stack<Bounds> worklist2 = new GLStack<Bounds>();

        int lo,hi;

        Bounds bounds = new Bounds(0, (a.length-1));
        worklist.push(bounds);

        while(!worklist.isEmpty()){
          Bounds bound = worklist.pop();
          lo = bound.getLo();
          hi = bound.getHi();
          worklist2.push(bound);

          if(lo<hi){
            int mid = (lo + hi)/2;
            Bounds bound2 = new Bounds(lo,mid);
            Bounds bound3 = new Bounds(mid+1,hi);
            worklist.push(bound2);
            worklist.push(bound3);

          }
        }
        while (!worklist2.isEmpty()){
          bounds = worklist2.pop();
          lo = bounds.getLo();
          hi = bounds.getHi();
          int mid = (hi + lo)/2;
          merge(a, aux, lo, mid, hi);
        }
        }

    private static class Bounds {
      private int lo, hi; //representing the lower and higher bounds of sorting.
      private boolean lsorted, rsorted; //representing whether the left half, right half is sorted already. left half and right half are defined as (lo, mid), (mid+1, hi) respectively where mid = (lo + hi)/2.


      Bounds(int lo, int hi)
        {
            this.lo = lo;
            this.hi = hi;
            if(lo >= hi)
            {
              this.lsorted = true;
              this.rsorted = true;
      }
      else {
        this.lsorted = false;
        this.rsorted = false;
      }
      }
    private int getLo() { return lo; }
    private int getHi() { return hi; }
    private boolean getLsorted() { return lsorted; }
    private boolean getRsorted() { return rsorted; }
    private void setLsorted(boolean l) { this.lsorted = l; }
    private void setRsorted(boolean r) { this.rsorted = r; }
    public String toString() { return "[" + lo + ", " + hi + "," + lsorted + "," + rsorted + "]"; }
    }

   /***************************************************************************
    *  Helper sorting function.
    ***************************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }



    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        String[] a = {"Plato", "Nietzshche", "Heidegger", "Lacan", "Kant", "Hegel"};

        MergeNonrecursive merge = new MergeNonrecursive();
        merge.sort(a);
        show(a);

        Integer[] b = {1, 3, 87, 90, 13, 17, 5};

        merge.sort(b);
        show(b);
    }
}
