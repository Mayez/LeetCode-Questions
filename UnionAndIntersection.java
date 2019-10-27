/*
PROBLEM:
Given two sorted arrays, find their union and intersection.

Example:

Input : arr1[] = {1, 3, 4, 5, 7}
        arr2[] = {2, 3, 5, 6} 
Output : Union : {1, 2, 3, 4, 5, 6, 7} 
         Intersection : {3, 5}

Input : arr1[] = {2, 5, 6}
        arr2[] = {4, 6, 8, 10} 
Output : Union : {2, 4, 5, 6, 8, 10} 
         Intersection : {6}
*/
class BinarySearch{
	int binSearchItr(int arr[], int x)
	{
		int l = 0; int r = arr.length-1;
		while(l <= r)
		{
			int mid = l + (r-l)/2;
			if(arr[mid] == x)
				return mid;
			else if(arr[mid] < x)
				l = mid + 1;
			else
				r = mid - 1;
		}
		return -1;
	}
}
public class Union{
	public static void main(String[] args)
	{
		int arr1[] = {2,5,6};
		int arr2[] = {4,6,8,10};
		BinarySearch ob = new BinarySearch();
		System.out.print("Intersection: {");
		int count = 0;
		for(int i = 0; i < arr1.length; i++)
		{
			int index = ob.binSearchItr(arr2,arr1[i]);
			if(index != -1)
			{
				if(count == 0)
					System.out.print(arr1[i] + ",");
				else
					System.out.print(arr1[i]);
				count++;
			}
		}
		System.out.println("}");

		System.out.print("Union: ");
		int j = 0, k = 0;
		while(j < arr1.length && k < arr2.length)
		{
			if(arr1[j] < arr2[k])
			{
				System.out.print(arr1[j] + ",");
				j++;
			}
			else if(arr2[k] < arr1[j])
			{
				System.out.print(arr2[k] + ",");
				k++;				
			}
			else
			{
				System.out.print(arr1[j] + ",");
				k++;
				j++;
			}
		}

		while(j < arr1.length)
		{
			System.out.print(arr1[j] + ",");
			j++;			
		}
		while(k < arr2.length)
		{
			System.out.print(arr2[k] + ",");
			k++;			
		}

	}
}
