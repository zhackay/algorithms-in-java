package i.am.jameshughkim.interviewsPrep.code_rust;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

public class CodeRustAtOnce {
    ////////////
    // TRIVIAL
    ////////////

    // https://stackoverflow.com/questions/3389264/how-to-get-the-separate-digits-of-an-int-number
    public String integerToString(int n) {

        Stack<Integer> s = new Stack<>();

        // This routine gives digits in reverse order, so the stack is needed
        while (n > 0) {
            n = n % 10; // gives the last remainder: 1023002 % 10 = 2
            s.push(n);

            n = n / 10; // gives the number except the last digit: 1023002 / 10 = 102300
        }

        StringBuilder sb = new StringBuilder();
        while (!s.empty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    public void shuffleArray(int[] a) {
        for (int i=0;i<a.length;i++) {
            Random r = new Random();
            int rPos = r.nextInt(a.length-1);

            int temp = a[rPos];
            a[rPos] = a[i];
            a[i] = temp;
        }
    }


    /**
     * CODE RUST A ONCE
     */


    // Binary Search
    public boolean binarySearch(int[] a, int k, int lo, int hi) {
        if (hi < lo) return false;
        int mid = lo + (hi - lo)/2;
        if (k == a[mid]) return true;
        if (k < a[mid]) return binarySearch(a, k, lo, mid-1);
        if (k > a[mid]) return binarySearch(a, k, mid+1, hi);
        return false;
    }

    /* Find Maximum in Sliding Window
        2 3 1 7 9 8 6 5 4
        {2,3,1}               M:3
          {3,1,7}             M:7
            {1,7,9}           M:9
              {7,9,8}         M:9
                {9,8,6}       M:9
                   {8,6,5}    M:8 **
                     {6,5,4}  M:6
                       {5,4}  M:5 ??
                         {4}  M:4

        // http://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
        1. Use Deque to store only the useful information = O(n*k)
            So, what is useful information?
                "FIRST of ALL", the element should be in window, then, ...
                - Max is useful


        // https://stackoverflow.com/questions/8031939/finding-maximum-for-every-window-of-size-k-in-an-array
        2. DP Solution = O(n)
    */
    public void printMaxSlidingWindowDeque(int[] a, int k) {
        if (k < a.length) return;
        Deque<Integer> d = new LinkedList<>();

        d.addFirst(a[0]);

        // Process the first k (the size of window)
        for (int i=1; i<k; i++) {
            if (d.peekFirst() < a[i])
                d.addFirst(a[i]);
        }

        // Process the remaining
        for (int i=k;i<a.length-k;i++) {
            if (d.peekFirst() < a[i])
                d.addFirst(a[i]);
            d.removeLast();
        }

        throw new NotImplementedException();
    }

    public void printMaxSlidingWindowDp(int[] a, int k) {
        throw new NotImplementedException();
    }

    // additionally maxSlidingWindow iterator

    // Search rotated array, return index
    public int searchRotateArray(int[] a, int k, int lo, int mid, int hi) {
        throw new NotImplementedException();
    }

    // Find smallest common number
    public int smallestCommon(int[] a, int[] b, int[] c){
        int min = Integer.MAX_VALUE;

        throw new NotImplementedException();
    }

    // Rotate Array
    public int[] rotateArray(int[] a, int k) {
        for (int i=0; i<a.length; i++) {
            // reverse
        }

    }

    // Find low/high index

    // Move zeros to left
    public void moveZeroesToLeft(int[] a) {
        throw new NotImplementedException();

    }

    // **Find maximum single sell profit

    // Implement Quicksort

    // **Merge Overlapping Intervals
    // **Sum of Two Values

    // **Reverse a singly linked list
    // Remove Duplicates from a Linked List
    // Delete node with a given key
    // Insertion Sort of a Linked List
    // **Intersection Point of Two Lists
    // Nth from last node
    // **Swap Nth Node with Head
    // Merge Two Sorted Linked Lists
    // Merge Sort
    // Reverse even nodes
    // Rotate a Linked List
    // Reverse k Elements

    // **Add Two Integers
    // Copy linked list with arbitrary pointer

    // Find kth permutation
    // **Integer Division
    // Pythagorean Triplets
    // **All Sum Combinations
    // **Find Missing Number
    // **Permute String
    // **All Subsets
    // Is Number Valid?
    // Power of a Number
    // Calculate Square Root
    // **Reverse words in a sentence
    // **Remove Duplicates
    // **Remove white spaces
    // **String Segmentation
    // **XML to Tree
    // **Find all palindrome substrings
    // **Regular Expression
    // **Check if two binary trees are identical
    // **Write an Inorder Iterator for a Binary Tree
    // **Iterative Inorder Traversal
    // **Inorder Successor BST
    // **Level Order Traversal of Binary Tree
    // **Is Binary Search Tree?
    // Convert Binary Tree To Doubly Linked List
    // **Print Tree Perimeter
    // **Connect Same Level Siblings
    // **Serialize/Deserialize Binary Tree
    // **Connect All Siblings
    // **Inorder Successor BST with parent pointers
    // **Nth Highest in BST
    // **Mirror binary tree nodes
    // **Delete zero sum sub-trees
    // N-ary Tree to Binary Tree
    // **Stack using Queues
    // **Queue using Stacks
    // Implement Deque
    // Expression Evaluation
    // **DFS
    // **BFS
    // **Clone a Directed Graph
    // **Minimum Spanning Tree
    // Word Chaining
    // Back Tracking
    // Boggle
    // **All Possible Parentheses
    // Solve N-Queens problem
    // Find K-sum subsets
    //
    // **[DP] Fibonacci numbers
    // **[DP] Largest Sum Subarray
    // **[DP] MaxSum Subsequence - Nonadjacent Elements
    // [DP] Game Scoring: Find number of ways a player can score 'n' runs
    // [DP] Coin Changing Problem
    // Levenshtein Distance
    // Sum of Three Values
    // ** Make Columns and Rows Zeros
    // **Search in a Matrix
    // **Implement LRU Cache
    // Host Endianness
    // Closest Meeting Point

}
