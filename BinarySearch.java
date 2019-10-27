class BinarySearch{
	int binSearchRec(int arr[], int l, int r, int x)
	{
		if(r >= l)
		{
			int mid = l + (r-l)/2;
			if(arr[mid] == x)
				return mid;
			if(arr[mid] > x)
				return binSearchRec(arr,l,mid-1,x);
			return binSearchRec(arr,mid+1,r,x);
		}
		return -1;
	}

	int binSearchItr(int arr[], int x)
	{
		int l = 0; int r = arr.length-1;
		while(l <= r)
		{
			int mid = l + (r-l)/2;
			if(arr[mid] == x)
				return mid;
			if(arr[mid] < x)
				l = mid + 1;
			else
				r = mid - 1;
		}
		return -1;
	}

	public static void main(String[] args)
	{
		BinarySearch ob = new BinarySearch();
		int arr[] = {1,4,7,10,14,56,58};
		System.out.print("List of elements: ");
		for(int a = 0; a < arr.length; a++)
		{
			System.out.print(arr[a] + " ");
		}
		System.out.println();
		int n = arr.length;
		int searchVal = 1;
		int result = ob.binSearchItr(arr,searchVal);/*ob.binSearchRec(arr,0,n-1,searchVal);*/
		if(result == -1)
			System.out.println("Value not found");
		else
			System.out.println("Value at index " + result);
	}
}
