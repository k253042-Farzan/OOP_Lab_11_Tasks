import java.util.*;
class GenericOperations {

    public static <T extends Number & Comparable<T>> void sortList(List<T> list) {
        Collections.sort(list);
    }
    public static double sumList(List<? extends Number> list) {
        double sum = 0;

        for (Number num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }

    public static <T extends Number & Comparable<T>> T maxValue(List<T> list) {
        return Collections.max(list);
    }
}
class Main {
    public static void main(String[] args) {

        List<Integer> intList = new ArrayList<>();
        intList.add(50);
        intList.add(20);
        intList.add(70);
        intList.add(10);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(12.5);
        doubleList.add(7.8);
        doubleList.add(20.3);
        doubleList.add(5.4);

        GenericOperations.sortList(intList);
        System.out.println("Sorted Integer List: " + intList);
        System.out.println("Sum: " + GenericOperations.sumList(intList));
        System.out.println("Max: " + GenericOperations.maxValue(intList));

        System.out.println();
        GenericOperations.sortList(doubleList);
        System.out.println("Sorted Double List: " + doubleList);
        System.out.println("Sum: " + GenericOperations.sumList(doubleList));
        System.out.println("Max: " + GenericOperations.maxValue(doubleList));
    }
}