/*

Problem Description

You are given a array of strings A of length N.

You have to return another string array which contains all possible special strings in Lexicographic order.
 A special string is defined as a string with length equal to N,
 and ith character of the string is equal to any character of the ith string in the array A.



Problem Constraints
1 <= N <= 5
1 <= |Ai| <= 8


Input Format
The first argument is the string array A.


Output Format
Return a string array consisting of all possible special strings.


Example Input
Input 1:
A = ['ab', 'cd']
Input 2:

A = ['aa', 'bb']


Example Output
Output 1:
['ac', 'ad', 'bc', 'bd']
Output 2:

['ab', 'ab', 'ab', 'ab']


Example Explanation
Explanation 1:
Since, the first character has to be from the 1st string 'ab' and the 2nd from 'cd'.
These are the all possible 4 combinations.
Explanation 2:

Note we can have duplicate strings, you have to add all of them.

*/

public class Solution {
    public ArrayList<String> specialStrings(ArrayList<String> A) {
        findComb(A, 0,0);
        return comb;
    }
    public ArrayList<String> comb = new ArrayList<>();
    public StringBuilder str = new StringBuilder("");

    void findComb(ArrayList<String> A, int i, int j)
    {
        if(i>=A.size() || j>=A.get(i).length())
            return;

        str.append(A.get(i).charAt(j));

        if(i==A.size()-1)
        {
            comb.add(str.toString());
        }
        findComb(A, i+1, 0);
        str.deleteCharAt(str.length()-1);
        findComb(A, i, j+1);
    }
}
