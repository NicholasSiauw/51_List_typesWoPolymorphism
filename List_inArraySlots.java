/**
 Implement a list of integer elements, including
 both data and operations.
*/

public class List_inArraySlots {

   // declare fields here
   private int[] refArray;
   private int filledElements;

   private static final int INITIAL_CAPACITY = 10;
   /**
     Construct an empty list with a small initial capacity.
    */
   public List_inArraySlots() {
       refArray = new int[INITIAL_CAPACITY];
       filledElements = 0;
   }


   /**
     @return the number of elements in this list
    */
   public int size() {
       return filledElements;
   }


    /**
      @return a string representation of this list,
      in [a,b,c,] format
     */
   public String toString() {
       String toReturn = "";
       for (int index = 0; index < filledElements; index++) {
           toReturn += "\t" + refArray[index] + "\n";
       }
       return toReturn;
   }

   //To remove value at certain index
   //The whole idea is that if we remove a value we must shift all the other values to make up for that empty spot
   //PLEASE CORRECT IF WRONG
   public boolean remove (int index){
     int x = index;
     while (x < filledElements){
       refArray[x] = refArray[x + 1];
       x++;
     }
     filledElements--;
   }

   public void setElement ( int index, int value ){
     refArray[index] = value;
   }
   /**
     Appends @value to the end of this list.
     @return true, in keeping with conventions yet to be discussed
    */
   public boolean add( int value) {
       if (filledElements >= refArray.length){ //If before adding this value, the array is full;
           expand();
       } else {}
       refArray[filledElements] = value; //appended the new value to the next available position
       filledElements++;
       return true;
   }


   /**
     Double the capacity of the List_inArraySlots,
     preserving existing data
    */
   private void expand() {
       int[] newRefArray = new int[refArray.length * 2]; //Created the new array with double the length of the old one
       for (int index = 0; index < filledElements; index++) { //copy each element of the old array into the corresponding
                                                              //index in the new Array
           newRefArray[index] = refArray[index];
       }
       refArray = newRefArray;
       //Switched refArray from the old, small array to the
       //new, twice as big array
    }
            // --------- end of "code that worked in v0" ---------
   public int get( int index ) {
       return refArray[index];
   }

   public int set( int index, int newValue ) {
       int toReturn = refArray[index];
       refArray[index] = newValue;
       return toReturn;
   }

   public void add( int index, int value) {
       add(0);
       for ( int position = filledElements--; position > index ;position-- ) {
           refArray[position] = refArray[position--];
       }
       refArray[index++] = value;
   }

   public int remove( int index) {
       int toReturn = refArray[index];
       refArray[index] = 0;
       filledElements--;
       for ( int position = index; position < filledElements--; filledElements++) {
           refArray[index] = refArray[index++];
       }
       return toReturn;
   }



}
