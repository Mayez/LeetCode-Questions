/*
PROBLEM:
Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
Array
  1,2,3,4,5,6,7
Rotation of the above array by 2 will make array
  3,4,5,6,7,1,2
  
ArrayRotation1
*/
class Rotate{
	void rotate(int arr[],int d,int n)
	{
		int temp;
		for(int j = 0; j < d; j++)
		{
			temp = arr[0];
			for(int i = 0; i < n; i++)
			{
				if(i != 0 && i < n)
				{
					arr[i-1] = arr[i];
				}
			}
			arr[n-1] = temp;
		}
	}
}

class ArrayRot{
	public static void main(String[] args)
	{
		int arr[] = {1,2,3,4,5,6,7};
		int d = 2;
		int n = arr.length;
		Rotate r = new Rotate();
		r.rotate(arr,d,n);
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
