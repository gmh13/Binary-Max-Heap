public class Driver {
    public static void main(String[] args) {
        BinaryMaxHeap heap = new BinaryMaxHeap(20);

        int[] elements = {1, 33, 98, -13, -4, 8, 31, -187, 4, 2, -55};

        // Print elements that are going to be in the array
        System.out.println("Elements to be constructed into the Binary Max Heap:");
        for (int element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();

        // Insert elements
        for (int element : elements) {
            heap.insert(element);
        }

        // Display
        System.out.println("\nBinary Max Heap after Construction:");
        heap.display();
        
        // Visualize
        System.out.println("\nVisualizing Binary Max Heap (0 is place holder for insert):");
        heap.visualize();

        // Insert 12
        heap.insert(12);
        
        // Display after inserting 12
        System.out.println("\nBinary Max Heap after inserting 12:");
        heap.display();
        
        // Visualize after inserting 12
        System.out.println("\nVisualizing Binary Max Heap after inserting 12:");
        heap.visualize();

        // Extract the max element
        int max = heap.extractMax();
        System.out.println("\nBinary Max Heap element extracted: " + max);
        
        // Display after extraction
        System.out.println("\nBinary Max Heap after extracting max element:");
        heap.display();
        
        // Visualize after extraction
        System.out.println("\nVisualizing Binary Max Heap after extracting max element:");
        heap.visualize();

        // Insert 9
        heap.insert(9);
        
        // Display after inserting 9
        System.out.println("\nBinary Max Heap after inserting 9:");
        heap.display();
        
        // Visualize after inserting 9
        System.out.println("\nVisualizing Binary Max Heap after inserting 9:");
        heap.visualize();
    }
}
