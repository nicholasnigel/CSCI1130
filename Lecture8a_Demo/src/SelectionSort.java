import javax.swing.JOptionPane;
class SelectionSort {
    static void selectionSort( double[] a )
    {
        int n = a.length;
        int min_location;
        double temp ;
        
        for ( int leftmost = 0 ; leftmost < n - 1 ; leftmost++ )
        {
            min_location = leftmost ;
            for ( int j = leftmost + 1 ; j < n ; j++ )
                if ( a[j] < a[min_location] )
                    min_location = j ;
            
            // swap the content of the leftmost and the min
            temp = a[min_location] ;
            a[min_location] = a[leftmost] ;
            a[leftmost] = temp ;
        }
    }
    
    public static void main(String[] args) {
        double[] x = {3.9, -7.8, 3.4, 2.6, -5.7, 0, 4.0};

        System.out.println("Before sorting: ");
        for (double xi : x)
            System.out.print(xi + ", ");
        System.out.println();
        
        selectionSort(x);

        System.out.println("After sorting: ");
        for (double xi : x)
            System.out.print(xi + ", ");
        System.out.println();
    }
}