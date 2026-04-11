# Cache-Optimized Counting Sort Algorithm

This project implements and evaluates a hybrid sorting algorithm from the paper "Improving Countin Sort Algorithm Via Data Locality"

The paper combines a modified quicksort with counting sort to reduce the amount of cache misses. In practice, the quicksort splits the input into smaller chunks so that it can fit in L1 cache, then counting sort is applied to each chunk. Our implementation replicates the paper's experiments in Java and compares the hybrid against the classic quicksort, quicksoort with insertion sort, and classic counting sort. 
### Group Members
Thehan Arunadewa, Robbie Devilly, Dermot Yang, Li WeiHao

## Project Structure 
- 'CountingSort.java' - Classic counting sort
- 'QuickSort.java'  - Classic quicksort with median of three pivot
- 'QuickInsertionSort.java'  - Quicksort + insertion sort hybrid
- 'HybridSort.java' - Proposed algorithm 
- 'ArrayUtils.java'  - Shared Utility for generating test arrays
- 'CountingSortPerformance'  - Counting sort benchmarks
- 'QuickSortPerformance' - Quick sort benchmarks

## How to Compile and Run
### Compile all files
```bash
javac *.java
```
### Run Table 1 & 2 benchmarks (counting sort comparison)
```bash
java CountingSortPerformance
```
This outputs:
- Table 1: Counting sort on random vs sorted inputs (n = r)
- Table 2: Counting sort with vs without preprocessing (r >> n)

### Run Table 3 benchmarks (quick sort comparison)
```bash
java QuickSortPerformance
```
This outputs:
- Table 3: Classic quicksort vs quicksort+insertion sort vs hybrid (n = r)

## Requirements
- Java 17 or higher
