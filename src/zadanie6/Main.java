package zadanie6;
import java.util.*;

public class Main {
	
	private volatile long time=0;
	private final static int size=7000000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		System.out.println("Time for: " + size + " show in miliseconds");
		/*System.out.println("MERGE SORT:");
		for(int i=0; i<30; i++) 
		{
			Float [] floaty = new Float[size];
			main.adding(floaty, size);
			System.out.println(main.mergeSort(floaty, 0, size-1));
		}
		System.out.println("QUICK SORT:");
		for(int i=0; i<30; i++) 
		{
			Float [] floaty = new Float[size];
			main.adding(floaty, size);
			System.out.println(main.QuickSort(floaty, 0, size-1));		
		}*/
		System.out.println("HEAP SORT:");
		for(int i=0; i<30; i++) 
		{
			Float [] floaty = new Float[size];
			main.adding(floaty, size);
			System.out.println(main.heapsort(floaty, size));
		}
	}
	
	private void merge(Float[] array, int p, int q, int r) {

	    int n1 = q - p + 1;
	    int n2 = r - q;

	    Float[] L = new Float[n1];
	    Float[] M = new Float[n2];

	    // fill the left and right array
	    for (int i = 0; i < n1; i++)
	      L[i] = array[p + i];
	    for (int j = 0; j < n2; j++)
	      M[j] = array[q + 1 + j];

	    // Maintain current index of sub-arrays and main array
	    int i, j, k;
	    i = 0;
	    j = 0;
	    k = p;

	    // Until we reach either end of either L or M, pick larger among
	    // elements L and M and place them in the correct position at A[p..r]
	    // for sorting in descending
	    // use if(L[i] >= <[j])
	    while (i < n1 && j < n2) {
	      if (L[i] <= M[j]) {
	        array[k] = L[i];
	        i++;
	      } else {
	        array[k] = M[j];
	        j++;
	      }
	      k++;
	    }

	    // When we run out of elements in either L or M,
	    // pick up the remaining elements and put in A[p..r]
	    while (i < n1) {
	      array[k] = L[i];
	      i++;
	      k++;
	    }

	    while (j < n2) {
	      array[k] = M[j];
	      j++;
	      k++;
	    }
	  }

	  // Divide the array into two sub arrays, sort them and merge them
	  public long mergeSort(Float[] array, int left, int right) 
	  {
		 long Start, Stop;
		 Start = System.currentTimeMillis();
	    if (left < right) {

	      // m is the point where the array is divided into two sub arrays
	      int mid = (left + right) / 2;

	      // recursive call to each sub arrays
	      mergeSort(array, left, mid);
	      mergeSort(array, mid + 1, right);

	      // Merge the sorted sub arrays
	     merge(array, left, mid, right);
	    }
	    Stop = System.currentTimeMillis();
	    time = Stop - Start;
	    return time;
	  }
	
	
	  private long QuickSort(Float[] list, int startIndex, int endIndex) 
	  {
		  long Start, Stop;
		  Start = System.currentTimeMillis();
		  if (endIndex - startIndex > 1) 
		  {
			  int partition = partition(list, startIndex, endIndex);
			  QuickSort(list, startIndex, partition );
			  QuickSort(list, partition + 1, endIndex);
		  }
		  Stop = System.currentTimeMillis();
		  time = Stop - Start;
		  return time;
	  }
	  private int partition(Float[] list, int nFrom, int nTo) 
	  {
		  Random g = new Random();
		  //jako element dziel¹cy bierzemy losowy
		  int rnd=nFrom+g.nextInt(nTo-nFrom);
		  swap(list,nFrom,rnd);
		  Float value=list[nFrom];
		  int idxBigger=nFrom+1, idxLower=nTo-1;
		  do{
			  while(idxBigger<=idxLower && list[idxBigger].compareTo(value)<=0)
				  idxBigger++;
			  while(list[idxLower].compareTo(value)>0)
				  idxLower--;
			  if(idxBigger<idxLower)
		 		swap(list,idxBigger,idxLower);
		  }while(idxBigger<idxLower);
		  swap(list,idxLower,nFrom);
		  return idxLower;
	  }
	
	private void adding(Float[] list, int size)
	{
		Random g = new Random();
		float value;
		for(int i=0; i<size; i++)
		{
			value = g.nextFloat()*100;
			list[i] = value;
		}
	}
	
	private void display(Float[] list)
	{
		for(int i=0; i<list.length; i++)
		{
			System.out.print(list[i]+ " ");
		}
		System.out.println('\n');
	}
	
	private void swap(Float[] list, int left, int right) 
	{
		float temp = list[left];
		list[left] = list[right];
		list[right] = temp;
		
	}
	public void sink(Float[] heap,int idx, int n)
	{
		int idxOfBigger=2*idx+1;
		if(idxOfBigger<n)
		{
			if(idxOfBigger+1<n && heap[idxOfBigger].compareTo(heap[idxOfBigger+1])<0)
				idxOfBigger++;
			if(heap[idx].compareTo(heap[idxOfBigger])<0)
			{
				swap(heap,idx,idxOfBigger);
				sink(heap,idxOfBigger,n);
			}
		}
	}
	public void heapAdjustment(Float[] heap,int n)
	{
		for(int i=(n-1)/2;i>=0;i--)
			sink(heap, i, n);
	}
		
	private long heapsort(Float[] heap, int n) 
	{
		long Start, Stop;
		Start = System.currentTimeMillis();
		heapAdjustment(heap, n);
		for(int i=n-1;i>0;i--)
		{
			swap(heap,i,0);
			sink(heap,0,i);
		}
		Stop = System.currentTimeMillis();
		time = Stop - Start;
		return time;
	}
}
