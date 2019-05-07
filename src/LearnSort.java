public class LearnSort {
    public void learnBubbleSort01(int[] numbers){
        int temp=0;
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[i]<numbers[j]){
                    temp=numbers[i];
                    numbers[i]=numbers[j];
                    numbers[j]=temp;
                }
            }
        }
        for(int aa:numbers){
            System.out.print(aa+" ");
        }
        System.out.println();
    }
    /**
     *  冒泡法排序
     *  比较相邻的元素。如果第一个比第二个小，就交换他们两个。
     *  对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最小的数。
     *  针对所有的元素重复以上的步骤，除了最后一个。
     *  持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。

     *
     * @param a
     *            需要排序的整型数组
     */
    public void bubbleSort(int[] a) {
        //数据复杂度为O(N^2);
        int temp;
        int size = a.length;
        for(int i=1; i<size; i++) {
            for(int j=0; j<size-i; j++) {
                if(a[j] < a[j+1]) {
                    temp = a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
            for(int aa : a)
                System.out.print(aa+",");
            System.out.println();
        }
    }
    /**
     * 快速排序
     *
     *  从数列中挑出一个元素，称为“基准”
     *  重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分割之后，
     *  该基准是它的最后位置。这个称为分割（partition）操作。
     *  递归地把小于基准值元素的子数列和大于基准值元素的子数列排序。
     *
     * @param numbers
     * @param start
     * @param end
     */
    public void quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）
            int temp; // 记录临时中间值
            int i = start, j = end;
            do {
                while ((numbers[i] < base) && (i < end))
                    i++;
                while ((numbers[j] > base) && (j > start))
                    j--;
                if (i <= j) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j)
                quickSort(numbers, start, j);
            if (end > i)
                quickSort(numbers, i, end);
        }
        for(int i:numbers){
            System.out.print(i+" ");

        }
        System.out.println();
    }
    /**
     * 以上是不规则版本
     *
     */
    public void quickSort1(int[] numbers, int start, int end){
        if(start<end){
            int base=numbers[start];
            int i=start,j=end;
            do{
                while (numbers[j]>base&&j>i){
                    j--;
                }
                numbers[i]=numbers[j];
                while (numbers[i]<base&&i<j){
                    i++;
                }

                numbers[j]=numbers[i];
            }while (i<j);
            numbers[i]=base;

            quickSort1(numbers, start, i-1);

            quickSort1(numbers, i+1, end);

        }

    }
    public void quickSort_2(int[] data, int start, int end) {
        if (data == null || start >= end) return;
        int i = start, j = end;
        int pivotKey = data[start];
        while (i < j) {
            while (i < j && data[j] >= pivotKey) j--;
            if (i < j) data[i++] = data[j];
            while (i < j && data[i] <= pivotKey) i++;
            if (i < j) data[j--] = data[i];
        }
        data[i] = pivotKey;
        quickSort_2(data, start, i - 1);
        quickSort_2(data, i + 1, end);
    }
    /**
     * 选择排序
     * 在未排序序列中找到最小元素，存放到排序序列的起始位置
     * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列起始位置。
     * 以此类推，直到所有元素均排序完毕。
     *
     * @param numbers
     */
    public void selectSort(int[] numbers){
        //选择排序：选择最小的放在最前面;
        int temp=0;
        for(int i=0;i<numbers.length;i++){
            int k=i;
            for(int j=numbers.length-1;j>i;j--){
                if(numbers[j]<numbers[k]){
                    k=j;
                }
            }
            temp=numbers[i];
            numbers[i]=numbers[k];
            numbers[k]=temp;
        }
        for(int a:numbers){
            System.out.print(a+" ");
        }
        System.out.println();
    }
    /**
     * 插入排序
     *
     *  从第一个元素开始，该元素可以认为已经被排序
     *  取出下一个元素，在已经排序的元素序列中从后向前扫描
     *  如果该元素（已排序）大于新元素，将该元素移到下一位置
     *  重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     *  将新元素插入到该位置中
     *  重复步骤2
     * @param numbers
     */
    public void insertSort(int[] numbers){
        int size=numbers.length,temp,j;
        for(int i=1; i<size; i++) {
            temp = numbers[i];
            for(j = i; j > 0 && temp < numbers[j-1]; j--)
                numbers[j] = numbers[j-1];
            numbers[j] = temp;
        }
        printSort(numbers);
    }



    /**
     * 归并排序
     *
     *  申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
     *  设定两个指针，最初位置分别为两个已经排序序列的起始位置
     *  比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
     *  重复步骤3直到某一指针达到序列尾
     *  将另一序列剩下的所有元素直接复制到合并序列尾
     *
     * @param a
     */
    public void mergeSort(int[] a,int low,int high){
        int mid = (low+high)/2;
        if(low<high){
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,high);
            //左右归并
            merge(a,low,mid,high);
        }

    }

    public void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中


        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[k++] = a[i++];

            }else{
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x=0;x<temp.length;x++){
            a[x+low] = temp[x];
        }
        System.out.println("temp0="+temp[0]);
        printSort(a);
    }


    public void printSort(int[] numbers){
        for(int a:numbers){
            System.out.print(a+" ");
        }
        System.out.println();
    }
}
