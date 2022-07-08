package zadanie7;

import java.util.Random;

public class Main {
	
	private volatile long time;
	private final static int size=10000000;
	private final static int share = 1000;
	private final static int max = 1000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		System.out.println("Time for: " + size + " show in miliseconds");
		/*System.out.println("MERGE SORT:");
		System.out.println("Random:");
		for(int i=0; i<30; i++) 
		{
			Integer [] array = new Integer[size];
			main.adding(array, size, "Random", share, max);
			System.out.println(main.mergeSort(array, 0, size-1));
		}
		System.out.println("Inorder:");
		for(int i=0; i<30; i++) 
		{
			Integer [] array = new Integer[size];
			main.adding(array, size, "Inorder", share, max);
			System.out.println(main.mergeSort(array, 0, size-1));
		}
		System.out.println("reverse:");
		for(int i=0; i<30; i++) 
		{
			Integer [] array = new Integer[size];
			main.adding(array, size, "reverse", share, max);
			System.out.println(main.mergeSort(array, 0, size-1));
		}
		System.out.println("inorder boxes:");
		for(int i=0; i<30; i++) 
		{
			Integer [] array = new Integer[size];
			main.adding(array, size, "inorder boxes", share, max);
			System.out.println(main.mergeSort(array, 0, size-1));
		}
		System.out.println("reverse boxes:");
		for(int i=0; i<30; i++) 
		{
			Integer [] array = new Integer[size];
			main.adding(array, size, "reverse boxes", share, max);
			System.out.println(main.mergeSort(array, 0, size-1));
		}
		
		System.out.println("QUICK SORT:");
		System.out.println("Random:");
		for(int i=0; i<30; i++) 
		{
			Integer [] array = new Integer[size];
			main.adding(array, size, "Random", share, max);
			System.out.println(main.QuickSort(array, 0, size-1));
		}
		System.out.println("Inorder:");
		for(int i=0; i<30; i++) 
		{
			Integer [] array = new Integer[size];
			main.adding(array, size, "Inorder", share, max);
			System.out.println(main.QuickSort(array, 0, size-1));
		}
		System.out.println("reverse:");
		for(int i=0; i<30; i++) 
		{
			Integer [] array = new Integer[size];
			main.adding(array, size, "reverse", share, max);
			System.out.println(main.QuickSort(array, 0, size-1));
		}
		System.out.println("inorder boxes:");
		for(int i=0; i<30; i++) 
		{
			Integer [] array = new Integer[size];
			main.adding(array, size, "inorder boxes", share, max);
			System.out.println(main.QuickSort(array, 0, size-1));
		}
		System.out.println("reverse boxes:");
		for(int i=0; i<30; i++) 
		{
			Integer [] array = new Integer[size];
			main.adding(array, size, "reverse boxes", share, max);
			System.out.println(main.QuickSort(array, 0, size-1));
		}*/
		
		System.out.println("HEAP SORT:");
		System.out.println("Random:");
		for(int i=0; i<30; i++) 
		{
			Integer [] array = new Integer[size];
			main.adding(array, size, "Random", share, max);
			System.out.println(main.heapsort(array, size-1));
		}
		System.out.println("Inorder:");
		for(int i=0; i<30; i++) 
		{
			Integer [] array = new Integer[size];
			main.adding(array, size, "Inorder", share, max);
			System.out.println(main.heapsort(array, size-1));
		}
		System.out.println("reverse:");
		for(int i=0; i<30; i++) 
		{
			Integer [] array = new Integer[size];
			main.adding(array, size, "reverse", share, max);
			System.out.println(main.heapsort(array, size-1));
		}
		System.out.println("inorder boxes:");
		for(int i=0; i<30; i++) 
		{
			Integer [] array = new Integer[size];
			main.adding(array, size, "inorder boxes", share, max);
			System.out.println(main.heapsort(array, size-1));
		}
		System.out.println("reverse boxes:");
		for(int i=0; i<30; i++) 
		{
			Integer [] array = new Integer[size];
			main.adding(array, size, "reverse boxes", share, max);
			System.out.println(main.heapsort(array, size-1));
		}
	}
	
	private void merge(Integer [] array, int p, int q, int r) {

	    int n1 = q - p + 1;
	    int n2 = r - q;

	    Integer [] L = new Integer[n1];
	    Integer [] M = new Integer[n2];

	    for (int i = 0; i < n1; i++)
	      L[i] = array[p + i];
	    for (int j = 0; j < n2; j++)
	      M[j] = array[q + 1 + j];

	    int i, j, k;
	    i = 0;
	    j = 0;
	    k = p;

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

	  public long mergeSort(Integer [] array, int left, int right) 
	  {
		 long Start, Stop;
		 Start = System.currentTimeMillis();
	    if (left < right) 
	    {
	      int mid = (left + right) / 2;
	      mergeSort(array, left, mid);
	      mergeSort(array, mid + 1, right);
	     merge(array, left, mid, right);
	    }
	    Stop = System.currentTimeMillis();
	    time = Stop - Start;
	    return time;
	  }
	  
	  private long QuickSort(Integer [] list, int startIndex, int endIndex) 
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
	  private int partition(Integer [] list, int nFrom, int nTo) 
	  {
		  Random g = new Random();
		  //jako element dziel¹cy bierzemy losowy
		  int rnd=nFrom+g.nextInt(nTo-nFrom);
		  swap(list,nFrom,rnd);
		  Integer value=list[nFrom];
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
	  
	  public void sink(Integer [] heap,int idx, int n)
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
		public void heapAdjustment(Integer [] heap,int n)
		{
			for(int i=(n-1)/2;i>=0;i--)
				sink(heap, i, n);
		}
			
		private long heapsort(Integer [] heap, int n) 
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
		
		private void swap(Integer [] list, int left, int right) 
		{
			int temp = list[left];
			list[left] = list[right];
			list[right] = temp;
			
		}
		
		private void adding(Integer [] list, int size, String how, int share, int max)
		{
			Random g = new Random();
			if(how == "Random") 
			{
				int value;
				for(int i=0; i<size; i++)
				{
					value = g.nextInt(1000000);
					list[i] = value;
				}
			}
			else if(how == "Inorder")
			{
				for(int i=0; i<size; i++)
				{
					list[i] = i;
				}
			}
			else if(how == "reverse") 
			{
				for(int i=0; i<size; i++)
				{
					list[i] = size-1-i;
				}
			}
			else if(how == "inorder boxes") 
			{
				int value, tmp = 0, range,k=1;
				range = max/share;
				int box = size/share;
				for(int i=0; i<size; i++)
				{
					if(i < box*k)
					{
						int temp = range*tmp;
						value = g.nextInt(10) + temp;
						if(value > max)
							value = max;
						list[i] = value;
					}else 
					{
						tmp++;
						k++;
						int temp = range*tmp;
						value = g.nextInt(10) + temp;
						if(value > max)
							value = max;
						list[i] = value;						
					}
				}
			}
			else
			{
				int value, tmp = 0, range,k=1;
				range = max/share;
				int box = size/share;
				for(int i=0; i<size; i++)
				{
					if(i < box*k)
					{
						int temp = range*(share - tmp);
						value = g.nextInt(10) + temp;
						if(value > max)
							value = max;
						list[i] = value;
					}else 
					{
						tmp++;
						k++;
						int temp = range*(share - tmp);
						value = g.nextInt(10) + temp;
						if(value > max)
							value = max;
						list[i] = value;						
					}
				}
			}
		}
		
		private void display(Integer[] list)
		{
			for(int i=0; i<list.length; i++)
			{
				System.out.print(list[i]+ " ");
			}
			System.out.println('\n');
		}

}
