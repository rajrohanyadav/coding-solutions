# Python solution to the two-sum problem
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hash_map = {}
        required_sum = target
        for enum, element in enumerate(nums):
            required_sum = target - element
            if required_sum in hash_map.keys():
                return (enum, hash_map[required_sum])
            else:
                hash_map[element] = enum
        
