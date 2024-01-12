import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int []arr = {1,4,6,2,5,2,7,8,4};
        int number = 12;
        //give all the pairs whose sum is equal to 12 i.e [(8,4),(7,5)]

        Arrays.sort(arr); // [1,2,2,4,4,5,6,7,8]
        int firstPointer=0;
        int secondPointer=arr.length-1;

        while(firstPointer<secondPointer){
            int res = arr[firstPointer]+arr[secondPointer];
            if(res == number){
                System.out.println("First Number "+arr[firstPointer] +" "+"Second Number "+arr[secondPointer]);
                firstPointer++;
                secondPointer--;
            }else if(res < number){
                firstPointer++;
            }else {
                secondPointer--;
            }
        }

    }
}
