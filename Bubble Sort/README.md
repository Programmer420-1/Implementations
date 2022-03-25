## Bubble Sort Algorithm
### Introduction
Bubble sort algorithm is the simplest sorting algorithm ever implemented. It is often used as a introductory algorithm for the students. <br>
The main concept behind this algorithm is compare an element with adjacent element, if the element is greater than the adjacent element, swapping occurs, if it is not, the pointer will then move to the next element and compare with its adjacent element again. After one cycle, the last element is locked and next cycle begins, until `length of array` cycles is completed or no swapping occurs in a cycle.
#
### Time complexity of bubble sort algorithm
Consider the following code:
```java
    int[] arr = {5,4,3,2,1};
    for(int i = 0; i < arr.length ; i++){
        boolean swapped = false;
        for(int j = 0 ; j < arr.length-1-i;j++){
            if(arr[j].compareTo(arr[j+1]) > 0){
                int temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
                swapped = true;
            }
        }
        if (swapped == false){
            break;
        }
```
For bubble sort, its time complexity is O(n<sup>2</sup>) for the average case and worst case. In the worst case, statements in the inner for loop has to gone through n<sup>2</sup> times of execution before the array is sorted.Well for the best case, time complexity is only O(n), as the array has to be iterate once to check all the elements are properly sorted in ascending manner.
<br>
| Cases | Time Complexity |
|:-----:|:---------------:|
| Worst | O(n<sup>2</sup>)|
|Average| O(n<sup>2</sup>)|           
| Best  |   O(n)          |
<br>

*Edited 23/10/2021*

