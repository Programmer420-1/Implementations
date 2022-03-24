class Main{
    public static void main(String[] args){
        DoublyLinkedList<Integer> List = new DoublyLinkedList<>();
        for(int i = 0 ; i < 10 ; i++){
            List.add(i);
        }
        
        System.out.println(List.toString());
        System.out.println(List.toString(true));
        System.out.println(List.toString(false));
    }

}