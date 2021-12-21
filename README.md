# Algorithms
Various algorithms & data structures

## Data Structures

### Linked List
#### Complexity:
 - Append - singly linked: `O(n)`; doubly linked: `O(1)`
 - Insert - `O(n)`
 - Search - `O(n)`
 - Delete - `O(n)`

### Hash Table
#### Complexity:
 - Insert - `O(1)` worst `O(n)`
 - Peek - `O(1)`
 - Delete - `O(1)` worst `O(n)`

Hashing is a data structure that is used to store a large amount of data, which can be accessed in O(1) time by operations such as search, insert and delete. Various Applications of Hashing are:
 - Indexing in database
 - Cryptography
 - Symbol Tables in Compiler/Interpreter
 - Dictionaries, caches, etc.

### Priority Queue
#### Complexity:
 - Insert - `O(nlog(n))`
 - Peek - `O(1)`

Priority Queue is an extension of the queue with the following properties:
 - Every item has a priority associated with it.
 - An element with high priority is dequeued before an element with low priority.
 - If two elements have the same priority, they are served according to their order in the queue.

## Sorting Algorithms

### Bubble Sort
#### Complexity:
 - Average - `O(n^2)` (can be optimized)
 - Worst - `O(n^2)`

Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.

### Insertion Sort
#### Complexity:
 - Average - `O(n^2)`
 - Worst - `O(n^2)`

Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards in your hands. The array is virtually split into a sorted and an unsorted part. Values from the unsorted part are picked and placed at the correct position in the sorted part.

### Selection Sort
#### Complexity:
 - Average - `O(n^2)`
 - Worst - `O(n^2)`

The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.

### Quick Sort
#### Complexity:
 - Average - `O(n*log(n))`
 - Worst - `O(n^2)`

Quicksort is a divide-and-conquer algorithm. It works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot. For this reason, it is sometimes called partition-exchange sort. The sub-arrays are then sorted recursively. This can be done in-place, requiring small additional amounts of memory to perform the sorting.

### Heap Sort
#### Complexity:
 - Average - `O(n*log(n))`
 - Worst - `O(n*log(n))`
 
Heap sort is a comparison-based sorting technique based on Binary Heap data structure. It is similar to selection sort where we first find the minimum element and place the minimum element at the beginning. We repeat the same process for the remaining elements.

## Graph Algorithms

### Dijkstra's Algorithm
#### Complexity:
 - Search -  `O(V + E*log(V))`

Dijkstra’s algorithm is very similar to Prim’s algorithm for minimum spanning tree. Like Prim’s MST, we generate an SPT (shortest path tree) with a given source as root. We maintain two sets, one set contains vertices included in the shortest-path tree, another set includes vertices not yet included in the shortest-path tree. At every step of the algorithm, we find a vertex that is in the other set (set of not yet included) and has a minimum distance from the source.

### Bellman Ford Algorithm
#### Complexity:
 - Search - `O(V * E)`

Bellman Ford algorithm helps us find the shortest path from a vertex to all other vertices of a weighted graph. It is similar to Dijkstra's algorithm but it can work with graphs in which edges can have negative weights.

### DFS
#### Complexity:
 - Search - `O(V + E)`

Depth First Traversal (or Search) for a graph is similar to Depth First Traversal of a tree. The only catch here is, unlike trees, graphs may contain cycles (a node may be visited twice). To avoid processing a node more than once, use a boolean visited array.

### BFS
#### Complexity:
 - Search - `O(V + E)`

Breadth-first search (BFS) is an algorithm used for tree traversal on graphs or tree data structures. BFS can be easily implemented using recursion and data structures like dictionaries and lists.

## Substring Search Algorithms

### KMP
#### Complexity:
 - Overall - `O(n + k)` (where `k` - length of substring)

The Knuth–Morris–Pratt string-searching algorithm (or KMP algorithm) searches for occurrences of a "word" W within a main "text string" S by employing the observation that when a mismatch occurs, the word itself embodies sufficient information to determine where the next match could begin, thus bypassing re-examination of previously matched characters.