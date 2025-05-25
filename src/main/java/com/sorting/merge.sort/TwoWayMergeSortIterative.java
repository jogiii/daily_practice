

public class TwoWayMergeSortIterative {


    public static int[] twoWayMergeSort(int[] arrA, int[] arrB){
        int m = arrA.length;
        int n = arrB.length;

        int i=0;
        int j=0;

        int[] mergedList = new int[m+n];
        int k=0;

        while(i<m && j<n){
            if(arrA[i]<arrB[j]){
                mergedList[k++] = arrA[i++];

            }else{
                mergedList[k++]=arrB[j++];
            }
        }

        for(;i<m;i++){
            mergedList[k++] = arrA[i];
        }
        for(;j<n;j++){
            mergedList[k++] = arrB[j];
        }

        return mergedList;

    }

}
