# Radix-Sort-for-Alphabetically-Sorting-Strings
This project implements the LSD (Least-Significant-Digit-First) radix sort algorithm to alphabetically sort n strings, each with a maximum length of k characters (k = 21). The strings are read from a text file ("f.txt") and stored in a two-dimensional array. The sorting algorithm operates on a character-by-character basis, ensuring efficiency by using a pointer array (P) to track the sorted order. The sorted strings are then output to another text file ("g.txt"). The program takes input and output file names from the command line, allowing users to specify custom file names or use the default names ("f.txt" and "g.txt").

Note:

The strings are assumed to consist only of uppercase letters (A-Z) without spaces.
Shorter strings are padded with blank characters to reach the fixed length of k.
The algorithm runs in O(n) time, where one character operation takes one unit of time (O(1) per character).
The program handles up to 1000 strings (n ≤ 1000) with maximum length k = 21 characters.
