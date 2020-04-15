import java.util.Collections; 
import java.util.HashMap;
class Solution {
    public int method(ArrayList<Integer> list,int val)
    {
        int lo = val;
        while(val != 1)
        {
//            System.out.println(val);
            if(val != lo)
                list.add(val);
            if(val % 2 == 0)
                val /= 2;
            else
                val = 3*val +1;
        }
        list.add(val);
        return list.size();   
    }
    
    
    public int getKth(int lo, int hi, int k) {
        Solution funcs = new Solution();
        int val = lo;
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashMap<Integer,Integer> sorted = new HashMap<Integer,Integer>();
        ArrayList<Integer> map = new ArrayList<Integer>();
        int[] arr = new int[hi-lo+1];
        
        
        int steps = funcs.method(list,val);
  //      System.out.println(list);
  //      System.out.println(steps);
        sorted.put(lo,steps);
        map.add(steps);
        arr[0] = lo;
        for(int i = lo+1; i <= hi; i++)
        {
            int count = 0;
            val = i;
            while(val != 1)
            {
    //            System.out.println(val);
                if(val != i)
                {
   //                 System.out.print(val+" ");
                    if(list.contains(val) == true)
                    {
                        count += list.size()-list.indexOf(val);
                        break;
                    }
                    count++;
                }
                if(val % 2 == 0)
                    val /= 2;
                else
                    val = 3*val +1;
            }
            arr[i-lo] = i;
            sorted.put(i,count);
            map.add(count);
 //           System.out.print("COUNT: " + count);
 //           System.out.println();
        }
 //       System.out.println(sorted);
        Collections.sort(map);
 //       System.out.println(map);
 //       System.out.println(map.get(k-1));
        int flag = 0;
        for(int i = 0; i < arr.length; i++)
        {
            flag = 0;
            for(int j = 0; j < arr.length-i-1; j++)
            {
                if(sorted.get(arr[j]) > sorted.get(arr[j+1]))
                {
                    flag = 1;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(flag == 0)
                break;
        }
//        for(int y = 0; y < arr.length; y++)
//            System.out.print(arr[y]);
        
        
        return arr[k-1];
    }
}
