package leetcode;

public class SumsUpRecursion {



    private static int getSubsets(int[] input, int total){

       // int index = 0;

        return recursiveGetSubsets(input, total, input.length - 1);
    }

    // returns number of subsets that add up to total up to index i of array
    private static int recursiveGetSubsets(int[] input, int total, int index){

        if (total == 0)
            return 1; // Just empty subset
        else if (total < 0)
            return 0;
        else if (index < 0)
            return 0;
        else if (total < input[index])
            return recursiveGetSubsets(input, total, index -1);
        else    // Considering both scenarios: with the current item in subset and without it
            return recursiveGetSubsets(input, total - input[index], index - 1) +
                    recursiveGetSubsets(input, total, index - 1);
    }

    public static void main(String[] args){
        int[] input = {2,4,6,10};
        int total = 0;
        int result = getSubsets(input, total);
        System.out.println(result);
    }
}
