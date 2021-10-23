class Algorithm<T extends Comparable<T>>{

    private T[] arr;

    Algorithm(T[] array){
        this.arr = array;
    }

    public T[] BubbleSort(){
        for(int i = 0; i < arr.length ; i++){
            boolean swapped = false;
            for(int j = 0 ; j < arr.length-1-i;j++){
                if(arr[j].compareTo(arr[j+1]) > 0){
                    T temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if (swapped == false){
                break;
            }
        }
        return arr;
    }

}

class Main{
    public static void main(String[] args){
        Character[] arr = {'A','C','G','E'};
        Algorithm<Character> algo = new Algorithm<>(arr);
        Character[] bubbleSorted = algo.BubbleSort();
        for (int i = 0; i < bubbleSorted.length ; i++){
            System.out.print(bubbleSorted[i] + " ");
        }
    }
   
}