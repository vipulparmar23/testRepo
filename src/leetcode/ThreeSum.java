package leetcode;

import java.util.*;

public class ThreeSum {

    static List<List<Integer>> getThreeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            set.clear();

            for (int j = i + 1; j < nums.length; j++) {
                int sum = -(nums[i] + nums[j]);

                if (set.contains(sum)) {
                    List<Integer> temp = new LinkedList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(sum);

                    result.add(temp);
                }

                set.add(nums[j]);
            }
        }
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i).equals(result.get(i + 1))) {
                result.remove(i);
            }
        }
        return result;
    }

    public static void main(String[] args){

        int[] nums = {0,0,0,0};
        //List<List<Integer>> finalResult = new LinkedList<>();
        List<List<Integer>> finalResult = getThreeSum(nums);

        if(finalResult.size() > 0){

            for(int i = 0; i < finalResult.size() - 1; i++){
//                if(finalResult.get(i).equals(finalResult.get(i+1))){
//                    continue;
//                }
                System.out.println(finalResult.get(i));
            }
        }
    }
}