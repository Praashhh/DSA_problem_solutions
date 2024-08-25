/*
Problem Description

Given a set of distinct integers, A, return all possible subsets.

        Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.


Problem Constraints
0 <= |A| <= 20


Input Format
The first argument is an integer array A.


Output Format
Return array of all different possible subsets


Example Input
A = [1, 2, 3]


Example Output
[
 [],
 [1],
 [1, 2],
 [1, 2, 3],
 [1, 3],
 [2],
 [2, 3],
 [3],
 ]

 */

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        subs.add(new ArrayList<>());
        subsets(A,0);
        Collections.sort(subs, new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b)
            {
                for(int i=0;i<Math.min(a.size(),b.size());i++)
                {
                    int comp = Integer.compare(a.get(i),b.get(i));
                    if(comp!=0) return comp;
                }
                return Integer.compare(a.size(),b.size());
            }
        });
        return subs;
    }
    ArrayList<ArrayList<Integer>> subs = new ArrayList<ArrayList<Integer>>();

    void subsets(ArrayList<Integer> A, int i)
    {
        if(i>=A.size()) return;

        int size=subs.size();
        for(int j=0;j<size;j++)
        {
            ArrayList<Integer> arr = new ArrayList<>(subs.get(j));
            arr.add(A.get(i));
            subs.add(arr);
        }
        subsets(A,i+1);
    }
}
