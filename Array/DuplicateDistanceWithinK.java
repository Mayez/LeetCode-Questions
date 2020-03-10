/*
PROBLEM:
Given an unsorted array that may contain duplicates. Also given a number k which is smaller than size of array. Write a function that returns true if array contains duplicates within k distance.
Examples:

Input: k = 3, arr[] = {1, 2, 3, 4, 1, 2, 3, 4}
Output: false
All duplicates are more than k distance away.

Input: k = 3, arr[] = {1, 2, 3, 1, 4, 5}
Output: true
1 is repeated at distance 3.

Input: k = 3, arr[] = {1, 2, 3, 4, 5}
Output: false

Input: k = 3, arr[] = {1, 2, 3, 4, 4}
Output: true
*/
class DupDistFunc{
	boolean dupDist(int arr[], int x)
	{
		for(int i = 0; i < arr.length; i++)
		{
			if(i+1 < arr.length)
			{
				for(int j = i+1; j < arr.length; j++)
				{
					if(arr[i] == arr[j] && (j-i) <= x)
						return true;
				}
			}
		}
		return false;
	}
}
class DupDist{
	public static void main(String[] args)
	{
		int arr[] = {1,2,3,4,4};
		int dist = 3;
		DupDistFunc ob = new DupDistFunc();
		boolean tf = ob.dupDist(arr,dist);
		if(tf == true)
			System.out.println("Repeated elements within chosen value");
		else
			System.out.println("Elements not within chosen value");

	}
}
