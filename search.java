// Input arr[] = {3, 4, 5, 1, 2}, key = 1
// Initially low = 0, high = 4.

// low = 0, high = 4:
//         => mid = 2
//         => arr[mid] = 5, which is not the desired value.
//         => arr[low] < arr[mid] So, the left half is sorted.
//         => key < arr[low], So the next search region is 3 to 4.

// low = 3, high = 4:
//         => mid = 3
//         => arr[mid] = 1 = key
//         => So the element is found at index 3.

// The element is found at index 3.
class Main {
    // Returns index of key in arr[l..h]
    // if key is present, otherwise returns -1
    static int search(int arr[], int l, int h, int key)
    {
        if (l > h)
            return -1;
 
        int mid = (l + h) / 2;
        if (arr[mid] == key)
            return mid;
 
        /* If arr[l...mid] first subarray is sorted */
        if (arr[l] <= arr[mid]) {
            /* As this subarray is sorted, we
               can quickly check if key lies in
               half or other half */
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid - 1, key);
            /*If key not lies in first half subarray,
           Divide other half  into two subarrays,
           such that we can quickly check if key lies
           in other half */
            return search(arr, mid + 1, h, key);
        }
 
        /* If arr[l..mid] first subarray is not sorted,
           then arr[mid... h] must be sorted subarray*/
        if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid + 1, h, key);
                return search(arr, l, mid - 1, key);
    }
}
