import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int arr[]={10,20,35,50,75,80};
        int x=110;
        int arr1[]={0,-1,2,-3,1};
        int nums[]= {1,1,2,2,3,4,4};
        int arr2[]={10,23,0,53,0,21,0};
        int arr3[]={5,32,1,7,10,19,21,2};
//        System.out.println(isPairSum(arr, arr.length, x));
//        System.out.println(findTriplets(arr1, arr.length-1));
//        System.out.println(removeDuplicates(nums));
//        System.out.println(moveZeros(arr2));
        findTriplet(arr3);
    }
/*
   1.Given a sorted array having N integers, find if there exists any pair of elements(arr[i],arr[j])
   such that their sum is equal to X.
   For Ex: arr[]={10,20,35,50,75,80} and the value of x=110
 */
    public static int isPairSum(int arr[],int n, int x){

        //represent first pointer
        int i=0;

        //represent second pointer
        int j=n-1;

        while(i<j){

            //if we find a pair
            if(arr[i]+arr[j]==x){
                System.out.println(arr[i]+":"+arr[j]);
                return 1;
            }

            //if sum of element at current pointers is less, we move towards higher values by doing i++
            else if(arr[i]+arr[j]<x){
                i++;
            }
            //if sum of elements at current pointers is more, we move towards lower values by doing j--
            else{
                j--;
            }
        }
        return 0;

    }


 /*   2. Given an array of distinct elements. The task is to find triplets in the array whose sum is zero.
        Input arr[]={0,-1,2,-3,1}
        output (0,-1,1),(2,-3,1)
        Input arr[]={1,-2,1,0,5}
        Output (1,-2,1)
        */
    public static boolean findTriplets(int arr[],int n){

        boolean found=false;
        Arrays.sort(arr);
        for(int i=0;i<n-1;i++){
            //initialise left & right
            int l=i+1;
            int r=n-1;
            int x=arr[i];
            while(l<r){
                if(arr[l]+arr[r]+x==0){
                    System.out.println(arr[l]+":"+arr[r]+":"+arr[i]);
                    l++;
                    r--;
                    found=true;
                }
                //if sum of 3 elements is less than 0, then increment in left
                else if(arr[l]+arr[r]+x<0){
                    l++;
                }
                //if sum is greater than 0 then decrement th right side
                else{
                    r--;
                }
            }
        }
        return found;
    }

    /*
     3. Given a sorted array, remove all duplicates and return the length of the modified array soln:
     Example: nums[1,1,2,2,3,4,4] output: 4
     */

    public static int removeDuplicates(int[] nums){

        int len=1;

        for(int i=1;i< nums.length-1;i++){
            if(nums[i]!=nums[i-1]){
                nums[len]=nums[i];
                len++;
            }
        }
        return len;
    }

    /*
    4. Given an array of integers move all the zeros to the end of the array while maintianing the relative order
    Input: arr[]={10,23,0,53,0,21,0}
    Output arr[]={10,23,53,21,0,0,0}
     */

    public static int[] moveZeros(int arr[]){

        int i=0;
        for(int nums:arr){
            if(nums!=0){
                arr[i++]=nums;
            }
        }
        while (i<arr.length){
            arr[i++]=0;
        }
        //Just for printing
        for(int j=0;j<arr.length;j++){
            System.out.println(arr[j]);
        }
        return arr;
    }

    /*
    5. Find 3 no. such that the sum of 2 elemenst equal to third element
    Input: {5,32,1,7,10,19,21,2}
    Output: 21,2,19
     */

    public static void findTriplet(int arr[]){

        Arrays.sort(arr);

        for(int i= arr.length-1;i>=0;i--){
            int j=0;
            int k=i-1;
            while(j<k){
                if(arr[i]==arr[j]+arr[k]){
                    //pair found
                    System.out.println("Numbers are "+arr[i]+" "+arr[j]+" "+arr[k]);
                    return;
                }
                else if(arr[i]>arr[j]+arr[k]){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
    }
}