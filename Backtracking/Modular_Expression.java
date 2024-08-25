/*
Problem Description:

Implement pow(A, B) % C.
In other words, given A, B and C, find (AB)%C.

Problem Constraints
-106 <= A <= 109
0 <= B <= 109
0 <= C <= 109


Input Format
The first argument is an integer A.
The second argument is an integer B.
The third argument is an integer C.


Output Format
Return an integer equal to (AB) % C

Example Input
A = 2, B = 3, C = 3

Example Output
2

Example Explanation
2^3 % 3 = 8 % 3 = 2
*/

// Solution

public class Solution {
    public int Mod(int A, int B, int C) {
        if(B<1) return 1%C;

        long base = A, ans=1;
        while(B>0)
        {
            if(B%2 == 1)
            {
                ans = (base*ans) % C;
                B--;
            }
            else
            {
                base = (base*base) % C;
                B/=2;
            }
        }
        if(ans<0) ans = (ans+C)%C;
        return(int)ans;
    }
}
