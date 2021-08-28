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
            System.out.println(Arrays.toString(twoSum(nums, targetSum)));
        }
    }

    public static int[] twoSum(int[] nums, int targetSum)
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
