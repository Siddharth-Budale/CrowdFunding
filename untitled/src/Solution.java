import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        for(int i:arr) System.out.println(i);
    }
}