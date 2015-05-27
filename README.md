=============================================================================================================================
                                                GENERAL INFORMATION
  **SortAlgorithms** is my own research project aimed to compare performance of different type of sorting algorithms.
  
Tested performance parameters are: 
- **TIME** (nanoseconds) 
- **SWAPS** (number of swaps) 
- **COMPARISONS** (number of comparisons)

  There are four types of tested arrays in project: 
- **ASC** (already sorted array)
- **DESC** (sorted descending)
- **RANDOM** (array with random elements)
- **DUPLICATED** (array with a lot of duplications)

  All types of arrays contain only integer elements. Arrays of all types are generated once and all algorithms perform on the same array as input.
  
=============================================================================================================================
                                                SCREENSHOTS
  
  **Without** quadratic algorithms:
  
  **Time** performance
  ![alt tag](https://raw.githubusercontent.com/java-fan/sort-algorithms/master/screenshots/time.jpg)
  
  **Swaps** performance
  ![alt tag](https://raw.githubusercontent.com/java-fan/sort-algorithms/master/screenshots/swaps.jpg)
  
  **Comparisons** performance
  ![alt tag](https://raw.githubusercontent.com/java-fan/sort-algorithms/master/screenshots/comparisons.jpg)

 **With** quadratic algorithms:
  
  **Time** performance
  ![alt tag](https://raw.githubusercontent.com/java-fan/sort-algorithms/master/screenshots/time_q.jpg)
  
  **Swaps** performance
  ![alt tag](https://raw.githubusercontent.com/java-fan/sort-algorithms/master/screenshots/swaps_q.jpg)
  
  **Comparisons** performance
  ![alt tag](https://raw.githubusercontent.com/java-fan/sort-algorithms/master/screenshots/comparisons_q.jpg)

=============================================================================================================================
                                                RESULTS
                                                
- Quick sort has the best performance on all types of arrays except arrays with a lot of duplications. For this reason it was implemented in Java with 3-way partition, which doesn't go quadratic on duplicated data. Later, in Java 7, it was also replaced with Dual pivot quicksort with even better performance.
- Nevertheless, quick sort has the best performance and it is in-place algorithm, it is not stable unlike Merge sort. That is why merge sort is used in Java for sorting arrays of objects, when we need stability, while quick sort is used for primitive types, where we don't need stability, but only perfromance. Merge sort is not in-place algorithm, but it is the best stable algorithm for now.
- As we can see, quadratic Insertion sorting algorithm has fantastic perfromance on already sorted data (best time, zero swaps, few comparisons). As a result, all recursive sorting algorithms use it for sorting small sublists, where insertion sort outperforms these more complex algorithms.

=============================================================================================================================
                                                ADD CUSTOM SORTING ALGORITHM

If you want to add another sorting algorithm, just follow steps:

- Add your sort algorithm type to SortAlgorithmType.java;
- Extend class SortAlgorithm and implement methods: doSort(), getType(). In your implementation use methods less(), swap() from super class to count swaps and comparisons;
- Configure your implementation in cfg-ApplicationContext.xml: add it to "sortAlgorithms" list, fill in expected results (optional).

I will appriciate your pull request ;-)

=============================================================================================================================
                                                TECHNOLOGY STACK
- Java 8
- Swing (GUI)
- JFreeChart (Charts)
- Spring Framework (IoC/DI)
- JUnit (Test)
- Maven (Build tool)
