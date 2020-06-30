/*PROBLEM
Compare two version numbers version1 and version2.
If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.

The . character does not represent a decimal point and is used to separate number sequences.

For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

You may assume the default revision number for each level of a version number to be 0. For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number. Its third and fourth level revision number are both 0.

Example 1:
Input: version1 = "0.1", version2 = "1.1"
Output: -1

Example 2:
Input: version1 = "1.0.1", version2 = "1"
Output: 1

Example 3:
Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1

Example 4:
Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”

Example 5:
Input: version1 = "1.0", version2 = "1.0.0"
Output: 0
Explanation: The first version number does not have a third level revision number, which means its third level revision number is default to "0"
 

Note:

Version strings are composed of numeric strings separated by dots . and this numeric strings may have leading zeroes.
Version strings do not start or end with dots, and they will not be two consecutive dots.
*/
class Solution {
    public int compareVersion(String version1, String version2) {
        if(version1.equals(version2))
            return 0;
        
        
        String[] tempSplit1 = version1.split("\\.");
        String[] tempSplit2 = version2.split("\\.");
        
        int index = 0;
        int strPos = 0;
        int savedIndex = 0;
        while(index < tempSplit1.length)
        {
            if(strPos < tempSplit1[index].length())
            {
                if(tempSplit1[index].charAt(strPos) != '0')
                {
                    savedIndex = strPos;
                    strPos = tempSplit1[index].length();
                }
                else
                    strPos++;
            }
            else
            {
                tempSplit1[index] = tempSplit1[index].substring(savedIndex,tempSplit1[index].length());
                savedIndex = 0;
                strPos = 0;
                index++;
            }
        }

        index = 0;
        strPos = 0;
        savedIndex = 0;
        while(index < tempSplit2.length)
        {
            if(strPos < tempSplit2[index].length())
            {
                if(tempSplit2[index].charAt(strPos) != '0')
                {
                    savedIndex = strPos;
                    strPos = tempSplit2[index].length();
                }
                else
                    strPos++;
            }
            else
            {
                tempSplit2[index] = tempSplit2[index].substring(savedIndex,tempSplit2[index].length());
                savedIndex = 0;
                strPos = 0;
                index++;
            }
        }

        
        /*
        for(int i = 0; i < tempSplit1.length; i++)
        {
            int j = 0;
            for(j = 0; j < tempSplit1[i].length(); j++)
            {
                if(tempSplit1[i].charAt(j) != '0')
                    break;
            }
            tempSplit1[i] = tempSplit1[i].substring(j,tempSplit1[i].length());
        }

        for(int i = 0; i < tempSplit2.length; i++)
        {
            int j = 0;
            for(j = 0; j < tempSplit2[i].length(); j++)
            {
                if(tempSplit2[i].charAt(j) != '0')
                    break;
            }
            tempSplit2[i] = tempSplit2[i].substring(j,tempSplit2[i].length());
        }*/
        
        ArrayList<String> list1 = new ArrayList<String>(Arrays.asList(tempSplit1));
        ArrayList<String> list2 = new ArrayList<String>(Arrays.asList(tempSplit2));
        
        while(list1.size() < list2.size())
            list1.add("0");
        
        while(list2.size() < list1.size())
            list2.add("0");

//        System.out.println(list1);
//        System.out.println(list2);
        
        for(int i = 0; i < list1.size(); i++)
        {
            if(Integer.valueOf(list1.get(i)) > Integer.valueOf(list2.get(i)))
                return 1;
            if(Integer.valueOf(list1.get(i)) < Integer.valueOf(list2.get(i)))
                return -1;            
        }
        
        
        return 0;
    }
}
