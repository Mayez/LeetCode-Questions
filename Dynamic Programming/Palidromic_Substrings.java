import java.lang.StringBuilder;
class Solution {
    public int countSubstrings(String s) {
        int total = 0;
        for(int i = 0; i < s.length(); i++)
        {
//            System.out.println("INDEX: " + i + ", char: " + s.charAt(i));
            total++;
            if(i+1 < s.length())
            {
                int count = i+1;
                while(s.indexOf(s.charAt(i),count) != -1)
                {
//                    System.out.println("NEXT INDEX: " + s.indexOf(s.charAt(i),count));
                    String subStr = s.substring(i,s.indexOf(s.charAt(i),count)+1);
//                    System.out.println("SUB STR: " + subStr);
                    StringBuilder compareStr = new StringBuilder();
                    compareStr.append(subStr);
//                    System.out.println("REV: " + compareStr.reverse());
                    if(subStr.equals(compareStr.reverse().toString()) == true)
                        total++;
                    
                    count = s.indexOf(s.charAt(i),count)+1;
                }
            }
        }
        
//        System.out.println("total: " + total);
        return total;
    }
}
