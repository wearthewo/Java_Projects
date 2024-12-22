package five_projects;

public class MaxSubArray {
    public static void main(String[] args) {

        int arr[] = {2,3,-5,6,7};
        System.out.println(maxSubArray(arr));


    }

    private static double maxSubArray (int arr[]) {
        double inf = Double.POSITIVE_INFINITY;
        double totalSum = inf = -1*inf;
        int localSum = 0;
        for (int num : arr) {
            localSum = Math.max(num, localSum+num);
            totalSum = Math.max(totalSum,localSum);
        }
        return totalSum;
    }
}
