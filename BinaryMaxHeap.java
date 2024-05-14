public class BinaryMaxHeap {
    private int[] heap; // Creates array to hold the elements
    private int size; // Current number of elements
    private int arraycapacity; // Array Implementation - arrray's have a certain number of spots or capacity for elements

    // Initializes

    public BinaryMaxHeap(int arraycapacity) {
        this.arraycapacity = arraycapacity;
        heap = new int[arraycapacity];
        size = 0;
    }

    // Resize Array Capacity for the heap by doubling its size if cpacity is reached
    
    private void resizeHeap() {
        int newCapacity = arraycapacity * 2;
        int[] newHeap = new int[newCapacity];
        System.arraycopy(heap, 0, newHeap, 0, arraycapacity);
        heap = newHeap;
        arraycapacity = newCapacity;
    }

    // Accessor Methods

    // Insert 
    public void insert(int value) {
        if (size == arraycapacity) {
            resizeHeap();
        }
        heap[size] = value;
        PercolateUp(size);
        size++;
    }
    
    // Exract Max
    public int extractMax() {
        if (size == 0) {
            System.out.println("Heap is empty, cannot extract max.");
            return -1;
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        PercolateDown(0);
        return max;
    }

    // Display 
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Visualize 

    public void visualize() {
    int levels = (int) (Math.log(size) / Math.log(2)) + 1; // Calculate the number of levels in the heap
    int elements = 1; // Initilaizes # of elements for the level
    int index = 0; // Initializes the index that needs to be traversed in the heap array

    for (int i = 0; i < levels; i++) {
        int spacesBetween = 50 / elements;
        int spacesBefore = spacesBetween / 2;

        // Print leading spaces
        for (int j = 0; j < spacesBefore; j++) {
            System.out.print(" ");
        }

        // Print elements
        for (int j = 0; j < elements && index < size; j++) {
            System.out.printf("%4d", heap[index++]); // Print the value of the current node with 4 characters width
            // Print spaces between elements except for the last element
            if (j < elements - 1) {
                for (int k = 0; k < spacesBetween - 4; k++) { // Adjusting spacing for 4-character numbers
                    System.out.print(" ");
                }
            }
        }

        // Move to the next line
        System.out.println();

        // Adjust elements for the next level
        elements *= 2;
    }
}

    // Traverser Methods to Peoclate the values up or down depending on the insertion

    // Percolate Up

    private void PercolateUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap[index] > heap[parentIndex]) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    // Percolate Down

    private void PercolateDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int largest = index;

        if (leftChildIndex < size && heap[leftChildIndex] > heap[largest]) {
            largest = leftChildIndex;
        }
        if (rightChildIndex < size && heap[rightChildIndex] > heap[largest]) {
            largest = rightChildIndex;
        }
        if (largest != index) {
            swap(index, largest);
            PercolateDown(largest);
        }
    }

    // Swap

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
