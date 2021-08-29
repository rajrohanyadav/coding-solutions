// Java solution for the 2-sum problem.
// Time: O(n), Space: O(n)
import java.util.*;

public class TwoSum
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int noOfTestcases = s.nextInt();
        while (noOfTestcases -- > 0) {
            int targetSum = s.nextInt();
            s.nextLine();
            int[] nums = Arrays.stream(s.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            System.out.println(Arrays.toString(twoSumIndices(nums, targetSum)));
        }
    }
    
    public static int[] twoSumIndices(int[] nums, int targetSum) // Returns the indices of pair giving target sum.
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int potentialMatch = targetSum - nums[i];
            if (map.containsKey(potentialMatch))
                return new int[]{i, map.get(potentialMatch)};
            else
                map.put(nums[i], i);
        }
        return new int[]{}; // No match found
    }

    public static int[] twoSumNums(int[] nums, int targetSum) // Returns the actual pair giving target sum.
    {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            int potentialMatch = targetSum - num;
            if (map.containsKey(potentialMatch))
                return new int[]{num, potentialMatch};
            else
                map.put(num, true);
        }
        return new int[]{}; // No match found
    }
}
