/*PROBLEM
Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
 
The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
*/
import java.util.ArrayList; 

public class Node{
    String variable;
    String parent;
    double val;
}

class Solution {
    public int listContainsIndex(ArrayList<Node> list, String s)
    {
        int index = -1;
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).variable.equals(s) == true)
                index = i;
        }
        return index;
    }
    
    public int getParentIndex(ArrayList<Node> list, String s, int startIndex)
    {
        if(s == null)
            return startIndex;
            
        int index = listContainsIndex(list,s);
        while(list.get(index).parent != null)
        {
            index = listContainsIndex(list,list.get(index).parent);
        }
        return index;
    }

    public ArrayList<ArrayList<Object>> getValueList(ArrayList<Node> list, String s, int startIndex)
    {
        ArrayList<ArrayList<Object>> valList = new ArrayList<ArrayList<Object>>();
        if(s == null)
            return valList;

        valList.add(new ArrayList<Object>());
        valList.add(new ArrayList<Object>());
        int index = listContainsIndex(list,s);
        valList.get(0).add(list.get(index).val);
        valList.get(1).add(list.get(index).variable);

        while(list.get(index).parent != null)
        {
            index = listContainsIndex(list,list.get(index).parent);
//            if(list.get(index).parent != null)
//            {
                valList.get(0).add(list.get(index).val);
                valList.get(1).add(list.get(index).variable);
 //           }
        }
        return valList;
    }

    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Solution funcs = new Solution();
        ArrayList<Node> list = new ArrayList<Node>();
        int index = -1;
        for(int i = 0; i < equations.size(); i++)
        {
            index = funcs.listContainsIndex(list,equations.get(i).get(0));
            if(index == -1)
            {
                Node node = new Node();
                node.variable = equations.get(i).get(0);
                list.add(node);
            }
            index = funcs.listContainsIndex(list,equations.get(i).get(1));
            if(index == -1)
            {
                Node node = new Node();
                node.variable = equations.get(i).get(1);
                list.add(node);
            }
        }
        
        for(int i = 0; i < equations.size(); i++)
        {
            int index1 = funcs.listContainsIndex(list,equations.get(i).get(0));
 //           int parentIndex1 = funcs.getParentIndex(list,list.get(index1).parent,index1);

            int index2 = funcs.listContainsIndex(list,equations.get(i).get(1));
 //           int parentIndex2 = funcs.getParentIndex(list,list.get(index1).parent,index2);
            
            if(index1 != index2)
            {
                if(list.get(index2).parent == null)
                {
                    list.get(index2).parent = list.get(index1).variable;
                    list.get(index2).val = values[i];
                }
                else if(list.get(index1).parent == null && list.get(index2).parent != null)
                {
                    list.get(index1).parent = list.get(index2).variable;
                    list.get(index1).val = 1/values[i];
                }
                else if(list.get(index1).parent != null && list.get(index2).parent != null)
                {
                    int parentIndex1 = funcs.getParentIndex(list,list.get(index1).parent,index1);
                    int parentIndex2 = funcs.getParentIndex(list,list.get(index1).parent,index2);
                    if(parentIndex1 != parentIndex2)
                        list.get(parentIndex2).parent = list.get(index1).variable;
                }
            }
        }       
        
        double[] answers = new double[queries.size()];
        int index4 = -1;
        int index5 = -1;
        for(int k = 0; k < answers.length; k++)
        {
            index4 = funcs.listContainsIndex(list,queries.get(k).get(0));
            index5 = funcs.listContainsIndex(list,queries.get(k).get(1));
            
            if(index4 == -1 || index5 == -1)
                answers[k] = -1;
            else if(index4 != -1 && index5 != -1 && index4 == index5)
                answers[k] = 1;
            else
            {
                ArrayList<ArrayList<Object>> valList1 = new ArrayList<ArrayList<Object>>();
//                System.out.println("LETTER1: " + queries.get(k).get(0));
                valList1 = funcs.getValueList(list,queries.get(k).get(0),index4);
//                System.out.println(valList1);

                ArrayList<ArrayList<Object>> valList2 = new ArrayList<ArrayList<Object>>();
//                System.out.println("LETTER2: " + queries.get(k).get(1));
                valList2 = funcs.getValueList(list,queries.get(k).get(1),index5);
//                System.out.println(valList2);
                
                ArrayList<Object> valList3 = new ArrayList<Object>(valList1.get(1));
                valList3.retainAll(valList2.get(1));
                
//                System.out.println("COMMON: " + valList3);
                                
                if(valList3.size() == 0)
                    answers[k] = -1;
                else
                {
                    int commonListOneIndex = valList1.get(1).indexOf(valList3.get(0));
//                    System.out.println("COMMON INDEX 1: " + commonListOneIndex);
                    valList1.get(0).subList(commonListOneIndex,valList1.get(0).size()).clear();
                    valList1.get(1).subList(commonListOneIndex,valList1.get(1).size()).clear();
 //                   System.out.println("VALLIST1: " + valList1);

                    int commonListTwoIndex = valList2.get(1).indexOf(valList3.get(0));
 //                   System.out.println("COMMON INDEX 2: " + commonListTwoIndex);
                    valList2.get(0).subList(commonListTwoIndex,valList2.get(0).size()).clear();
                    valList2.get(1).subList(commonListTwoIndex,valList2.get(1).size()).clear();
 //                   System.out.println("VALLIST2: " + valList2);
                    
                    double val1Ans = 1;
                    for(int w = 0; w < valList1.get(0).size(); w++)
                        val1Ans *= (double)valList1.get(0).get(w);

                    double val2Ans = 1;
                    for(int a = 0; a < valList2.get(0).size(); a++)
                        val2Ans *= (double)valList2.get(0).get(a);
                    
//                    System.out.println("VAL2ANS: " + (double)val2Ans);
//                    System.out.println("VAL1ANS: " + (double)val1Ans);
                    answers[k] = ((double)val2Ans/(double)val1Ans);
//                    System.out.println("ANS: " + ((double)val2Ans/(double)val1Ans));

                }
            }
        }
        
/*        for(int j = 0; j < list.size(); j++)
        {
            int index3 = funcs.listContainsIndex(list,list.get(j).variable);
            int parentIndex = funcs.getParentIndex(list,list.get(j).parent,index3);
            System.out.println("VARIABLE: " + list.get(j).variable + ", PARENT: " + list.get(j).parent + ", VALUE: " + list.get(j).val + ", PARENT INDEX: " + parentIndex);
        }
//        System.out.println(list);*/
        
        return answers;
    }
}
