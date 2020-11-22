package com.sortalgorithm;


/**
 * 排序
 */
public class Sort {

    public static void main(String[] args) {
        long creatArray = System.currentTimeMillis();
        int arr[] = Util.randomArray(1, 8000000);
//        int arr[] = {4,9,8,5,6};
        long creatArrayCostTime = System.currentTimeMillis() - creatArray;
        System.out.println("数组创建完毕,耗费时长" + creatArrayCostTime + "ms");
//        Util.showIntArray(arr);
        long start = System.currentTimeMillis();
//        Util.showIntArray(arr);

//        bubbleSort(arr);    //冒泡排序
//        selectSort(arr);    //选择排序
//        insertSort(arr);    //插入排序    timeout
//        shellExchangeSort(arr); //希尔排序-交换式  timeout
//        shellMoveSort(arr); //希尔排序-移动式  11973ms
//        quickSort(arr, 0, arr.length - 1);  //快速排序 5088ms
//        mergeSort(arr); //归并算法  6395ms
//        radixSort(arr); //基数排序   4620ms
        heapSort(arr);  //堆排序   11604ms
//        Util.showIntArray(arr);
        System.out.println("排序完成，耗费时长" + (System.currentTimeMillis() - start)+"ms");
//        Util.showIntArray(arr);

    }

    //冒泡排序
    public static void bubbleSort(int arr[]) {
//        int count = 0;
        boolean flag;
        while (true) {
            flag = true;
//            count++;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i]) {
                    flag = false;
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                }
            }
            if (flag) {
                break;
            }
        }
//        System.out.println(count);
    }

    //选择排序
    public static void selectSort(int arr[]) {
        int num;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    num = arr[j];
                    arr[j] = arr[i];
                    arr[i] = num;

                }
            }
        }
    }

    //插入排序
    public static void insertSort(int arr[]) {
        int temp;
        int j;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
//            if (temp + 1 != i)
            arr[j + 1] = temp;
        }
    }

    //希尔排序-交换式
    public static void shellExchangeSort(int arr[]) {
        int temp;
        for (int i = arr.length / 2; i > 0; i /= 2) {
            for (int j = i; j < arr.length; j++) {
                for (int k = j - i; k >= 0; k -= i) {
                    if (arr[k] > arr[k + i]) {
                        temp = arr[k];
                        arr[k] = arr[k + i];
                        arr[k + i] = temp;
                    }
                }

            }
        }
    }

    //希尔排序-移动法
    public static void shellMoveSort(int arr[]) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素开始，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当推出while循环后，就给temp找到插入的位置
                    arr[j] = temp;
                }
            }
        }
    }

    //快速排序
    public static void quickSort(int arr[], int left, int right) {
        int l, r, temp, p;
        if (left >= right) {
            return;
        }
        l = left;
        r = right;
        p = arr[left];

        while (l < r) {
            while (arr[r] >= p && l < r) {
                r--;
            }

            while (arr[l] <= p && l < r) {
                l++;
            }
            temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;
        }
        arr[left] = arr[l];
        arr[l] = p;
        quickSort(arr, left, r - 1);
        quickSort(arr, r + 1, right);


//        int l = left;
//        int r = right;
//        int pivot = arr[(left + right) / 2];
//        System.out.println(pivot);
//        int temp = 0;   //临时变量
//        //while循环是为了让pivot值小的放到左边，值大的放到右边
//        while (l < r) {
//            //在pivot的左边一直找，找到大于等于pivot值，才退出
//            while (arr[l] < pivot) {
//                l += 1;
//            }
//            //在pivot的右边一直找，找到小于等于pivot值，才退出
//            while (arr[r] > pivot) {
//                r -= 1;
//            }
//            //如果条件成立说明pivot的左右的值已经按照左边小于等于pivot，右边全部是大于等于pivot
//            if (l >= r) {
//                break;
//            }
//            temp = arr[l];
//            arr[l] = arr[r];
//            arr[r] = temp;
//            //如果交换完后，发现这个arr[1] == pivot,r前移
//            if (arr[l] == pivot) {
//                r -= 1;
//            }
//            //如果交换完后，发现这个arr[r] == pivot,l后移
//            if (arr[r] == pivot) {
//                l += 1;
//            }
//        }
//        //如果l==r，必须l++，r--，否则会出现栈溢出
//        if (l == r) {
//            l += 1;
//            r -= 1;
//        }
//        //向左递归
//        if (left < r) {
//            quickSort(arr, l, r);
//        }
//        //向右递归
//        if (right > l) {
//            quickSort(arr, l, r);
//        }
    }

    //归并排序（分而治之）

    /**
     * @param arr   初始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  做中转的数组
     */
    public static void merge(int arr[], int left, int mid, int right, int[] temp) {
        int i = left;   //左边第一个索引
        int j = mid + 1;    //中间索引
        int t = 0;  //指向temp数组的当前索引
        //1、
        //先把左右两边（有序）的数组按照规则填充到temp数组
        //知道两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，填充到temp数组
            //然后t++，i++
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;    //temp指针右移
                i++;    //当左边指针指向元素小于右边指针指向元素时，将左边指针元素放入temp，然后左边指针右移一位
            } else { //反之，将右边的有序序列的当前元素填充到temp数组
                temp[t] = arr[j];
                t++;    //temp指针右移
                j++;    //当右边指针指向元素小于左边指针指向元素时，将右边指针元素放入temp，然后右边指针右移一位
            }
        }


        //2、
        //把有剩余数据的一边的数据一次填充到temp
        while (i <= mid) {  //左边序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[i];
            t++;
            i++;
        }

        while (j <= right) {    //右边序列还有剩余元素，就全部填充到temp
            temp[t] = arr[j];
            t++;
            j++;
        }
        //3、
        //将temp数组的元素拷贝到arr
        t = 0;
        int tempLeft = left;
        //第一次合并tempLeft=0，right=1
        //最后一次合并tempLeft = 0，right=arr.length
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }

    //归并算法，分+和方法
    public static void mergeSort(int arr[], int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;   //中间索引
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            //到合并时候
            merge(arr, left, mid, right, temp);
        }
    }

    //归并算法初始化
    public static void mergeSort(int arr[]) {
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    //基数排序（桶排序）
    public static void radixSort(int[] arr) {
        //先得到数组中最大的数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();


        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        //说明
        //1、二维数组包含10个一维数组
        //2、为了防止在放入数的时候数据溢出，则每个一维数组（桶），大小定为arr.length
        //3、名明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少个数据，定义一个一维数组来记录各个桶的每次放入数据个数
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的个位的值
                int digitOfElement = arr[j] / n % 10;

                //放入对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            //按照这个桶的顺序（一维数组的下标依次取出数据吗，放入原来数组）
            int index = 0;
            //遍历每一个桶，并将桶中的数组放入原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据才放入原数组
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    //取出元素放入arr
                    arr[index] = bucket[k][l];
                    index++;
                }
                bucketElementCounts[k] = 0;
            }
        }
    }

    //堆排序
    public static void heapSort(int[] arr){
        int temp = 0;
        for (int i = arr.length/2 -1; i >=0 ; i--) {
            adjustHeap(arr,i, arr.length);
        }
        //将无序序列构成一个堆,根据升序降序需求选择大顶堆或小顶堆
        for (int i = arr.length-1; i > 0; i--) {
            //交换
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,i);
        }
    }

    //将一个数组(二叉树)调整成一个大顶堆
    /**
     * 功能:完成将以i对应的非叶子节点的树调整成大顶堆
     * arr[] = {4,6,8,5,9} => i=1 => adjustHeap => {4,9,8,5,6}
     * 再次调用adjustHeap 传入i=0得到=>{9,4,8,5,6}
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素继续调整,length在逐渐的减少
     */
    public static void adjustHeap(int arr[], int i, int length) {
        int temp = arr[i];  //先取出当前元素的值,保存在临时变量 
        //开始调整
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;    //指向右子节点
            }
            //如果子节点大于父节点,把较大的值赋值给当前节点
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;  //i指向k,继续循环比较
            } else {
                break;
            }
        }
        //当for循环结束后,已将i为父节点的这个树的最大值放在了i上(局部)
        arr[i] = temp;  //将temp值放到调整后的位置

    }

}
