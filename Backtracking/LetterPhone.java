/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png

The digit 0 maps to 0 itself.

The digit 1 maps to 1 itself.

Input: Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Make sure the returned strings are lexicographically sorted.
 */

public class Solution {

    HashMap<Integer,String> mapping = new HashMap<>();
    ArrayList<String> nums = new ArrayList<String>();
    ArrayList<String> comb = new ArrayList<String>();

    public ArrayList<String> letterCombinations(String A) {
        mapping.put(0,"0");
        mapping.put(1,"1");
        mapping.put(2,"abc");
        mapping.put(3,"def");
        mapping.put(4,"ghi");
        mapping.put(5,"jkl");
        mapping.put(6,"mno");
        mapping.put(7,"pqrs");
        mapping.put(8,"tuv");
        mapping.put(9,"wxyz");
        for(int i=0;i<A.length();i++)
        {
            nums.add(mapping.get(Character.getNumericValue(A.charAt(i))));
        }
        findCombs(nums,0,"");
        return comb;
    }

    void findCombs(ArrayList<String> nums, int i, String combination)
    {
        if(i>nums.size()-1)
        {
            comb.add(combination);
            return;
        }

        for(int j=0;j<nums.get(i).length();j++)
        {
            findCombs(nums, i+1, combination+nums.get(i).charAt(j));
        }
    }
}
