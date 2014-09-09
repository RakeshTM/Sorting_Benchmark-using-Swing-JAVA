public class Sort
{
	public static double bubbleSort(int[] array)
	{
		double ft = System.currentTimeMillis();
		for(int i = 0;i<array.length;i++)
		{
			for(int j = 0; j < array.length-1; j++)
			{
				if(array[j] > array[j+1])
				{	
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		double lt = System.currentTimeMillis() - ft; 

		return lt;
	}

//----------------------------------------------------------------------	
	
	public static double selectionSort(int[] array)
	{	
		double ft = System.currentTimeMillis();
		for(int i = 0;i<array.length;i++)
		{	 										
			int temp = i;
			for(int j = i; j < array.length-1 ;j++)
			{	
				if(array[temp]<array[j+1])
				{
					temp = j+1;
				}
			}
			if(array[i]!=array[temp])
			{
				int tmp = array[i];
				array[i] = array[temp];
				array[temp] = tmp;
			}
		}
		double lt = System.currentTimeMillis() - ft; 

		return lt;
	}	
	
//----------------------------------------------------------------------	

	public static double insertionSort(int[] array)
	{	
		double ft = System.currentTimeMillis();

		for(int high =0;high<array.length-1;high++)
		{
			int tmp = high;
			while(tmp!=-1 && array[tmp]>array[tmp+1] )
			{
				int temp = array[tmp];
				array[tmp] = array[tmp+1];
				array[tmp+1] = temp;
				tmp--;
			}
		}
		double lt = System.currentTimeMillis() - ft; 

		return lt;
	}

//----------------------------------------------------------------------	
	public static int[] qs(int[] array)
	{
		return quickSort(array,0,array.length-1);
	}
	public static int[] quickSort(int[] array,int start,int end)
	{
		if(start < end)
		{
			int partitionIndex = partition(array,start,end);
			quickSort(array,start , partitionIndex -1);
			quickSort(array,partitionIndex +1, end);
		}
		return array;
	}
	
	public static int partition(int[] array, int start, int end)
	{
		int pivot = array[end];
		int partitionIndex = start;
		for(int i = start ; i < end ; i++)
		{
			if(array[i] < pivot)
			{
				int temp = array[i];
				array[i] = array[partitionIndex];
				array[partitionIndex] = temp;
				partitionIndex++;
			}
		}
		int temp = array[partitionIndex];
		array[partitionIndex] = array[end];
		array[end] = temp;
		
		return partitionIndex;
	}
//----------------------------------------------------------------------	
	public static int[] mergeSort(int[] array)
	{
		if(array.length >1 )
		{
			int mid = array.length/2;
						
			int[] left = new int[mid];
			int[] right = new int[array.length - mid];
			for(int i =0;i < mid;i++)
				left[i] = array[i];
						
			for(int i = mid; i <array.length ; i++)
				right[i-mid] = array[i];
						
			mergeSort(left);
			mergeSort(right);
			merge(left, right, array);
		}
		return array;
	}
	public static void merge(int[] left,int[] right, int[] array)
	{	
		int iLeft = 0;   
        int iRight = 0;  
        
        for (int i = 0; i < array.length; i++) 
		{
            if (iRight >= right.length || (iLeft < left.length && left[iLeft] <= right[iRight])) 
					array[i] = left[iLeft++];    
                
            else 
                array[i] = right[iRight++];   
        }
	}
	
	public static int[] reverse(int[] array)
	{
		for(int i=0;i<array.length/2;i++)
		{
			int temp = array[i];
			array[i] = array[array.length-1-i];
			array[array.length-1-i]= temp;
				
		}
		return array;
	}
}

