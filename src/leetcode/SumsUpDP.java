package leetcode;

import java.util.HashMap;

public class SumsUpDP {

    private static int dynamicTotal(int[] input, int total, int index, HashMap<String, Integer> mem) {
        String key = String.valueOf(total) + ":" + String.valueOf(index);
        int toReturn = 0;

        if (mem.containsKey(key))
            return mem.get(key);

        if (total == 0)
            return 1;
        else if (total < 0)
            return 0;
        else if (index < 0)
            return 0;
        else if (total < input[index])
            toReturn = dynamicTotal(input, total - input[index], index - 1, mem);
        else
            toReturn = dynamicTotal(input, total, index - 1, mem);
        mem.put(key, toReturn);
        return toReturn;

    }

    private static int countSetsDP(int[] input, int total) {
        HashMap<String, Integer> mem = new HashMap<>();
        return dynamicTotal(input, total, input.length - 1, mem);
    }

    public static void main(String[] args) {
        int[] input = { 2, 4, 6, 10};
        int result = countSetsDP(input, 6);
        System.out.println(result);
    }
}
