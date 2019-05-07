public class Main {

    public static void main(String[] args) {
        int[] numbers={5,3,2,4,7,6,1,8};
        LearnSort learnSort=new LearnSort();

        learnSort.quickSort1(numbers,0,7);
        learnSort.printSort(numbers);
    }
}
