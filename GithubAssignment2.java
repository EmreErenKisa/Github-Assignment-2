import java.util.Scanner;

/**
 * Apply some array operations with a terminal menu.
 */
public class GithubAssignment2 {  
    /**
    * Lower and upper bounds are both inclusive.
    */
    public static int takeValidInput(int lowerBound, int upperBound){
        boolean invalidEntered;
        boolean noLowerBound = lowerBound == Integer.MIN_VALUE;
        boolean noUpperBound = upperBound == Integer.MAX_VALUE;
        int output = 0; // To silence the compiler

        Scanner scanner = new Scanner(System.in);
        String prompt = String.format("%nPlease enter an integer");

        if (noLowerBound && !noUpperBound){
            prompt += " less than or equal to " + upperBound;
        }
        else if (!noLowerBound && noUpperBound) {
            prompt += " greater than or equal to " + lowerBound;
        }
        else if (!noLowerBound && !noUpperBound) {
            prompt += " between " + lowerBound + " and " + upperBound;
        }
        prompt += ": ";

        do {
            invalidEntered = false;
            System.out.println(prompt);

            if (scanner.hasNextInt()){
                output = scanner.nextInt();
            }
            else {
                invalidEntered = true;
                scanner.nextLine();
                continue;
            }

            if (output < lowerBound || output > upperBound){
                invalidEntered = true;
            }

        } while(invalidEntered);

        return output;
    }

    /**
    * Method to find the smallest integer in the list of integers
    * @param numberList - the list of numbers
    * @return the smallest integer in the list
    */
    public static int findMinimum(int[] numberList) {
      int smallestNumber = numberList[0];

      for(int i = 1; i < numberList.length; i++) {
        if(numberList[i] <= smallestNumber) {
          smallestNumber = numberList[i];
        }
      }
      return smallestNumber;
    }

    /**
    * Method to find the biggest integer in the list of integers
    * @param numberList - the list of numbers
    * @return the biggest integer in the list
    */
    public static int findMaximum(int[] numberList) {
      int biggestNumber = numberList[0];

      for(int i = 1; i < numberList.length; i++) {
        if(numberList[i] >= biggestNumber) {
          biggestNumber = numberList[i];
        }
      }
      return biggestNumber;
    }
    //Method to find the sum of elements with odd and even-numbered indexes
    public static String oddEven(int[] array)
    {
        int oddCount  = 0;
        int evenCount = 0;
        int arraySize = array.length;
        for(int i = 0; i<arraySize;i++)
        {
            if(i % 2 == 0)
            {
                evenCount += array[i];
            }
            else
            {
                oddCount += array[i];
            }
        }
        String counts = "Sum of the elements with odd indexes: " + oddCount + ". Sum of the elements with even indexes: " + evenCount;
        return counts;
     }
    
    public static String toString(int[] numbers)
    {
        String str = "";
        for (int i : numbers) 
        {
            str += " " +i;
        }
        return str;
    }
    public static int[] createArray(int size){
        int list[] = new int[size];
    
            for( int i = 0; i < size; i++)
            {
                int number = (int)(Math.random()*100);
                list[i] = number;
            }
        return list;
    }
    public static void findAverage( int[] list){
        int sumOfNumbers = 0;
        int average = 0;
        int[] difference = new int[list.length];
        for( int i : list){
            sumOfNumbers += i;
        }
        average = sumOfNumbers / list.length ;
        System.out.println("Average of the array: " + average);
        for(int i = 0; i < list.length ; i++){
          difference[i] = list[i] - average;
        }
        for (int i = 0; i < difference.length; i++) {
            System.out.printf("The difference between element %d and average: %d%n", i + 1, difference[i]);
        }
    }
    public static void main(String[] args) 
    {
        boolean wannaContinue = true;
        boolean arrayCreated = false;
        boolean notPrintResult;
        int[] array = {0}; // To silence the compiler
        int result = 0; // To silence the compiler
        int size;

        int choice = 0;
        final int CREATE_ARRAY = 1;
        final int FIND_MINIMUM = 2;
        final int FIND_MAXIMUM = 3;
        final int FIND_AVERAGE = 4;
        final int FIND_SUM = 5;

        Scanner scanner = new Scanner(System.in);

        while (wannaContinue){
            System.out.println();

            notPrintResult = false;
            System.out.printf("Please choose an operation:%n" +
                    "1- Create an array containing random numbers%n" +
                    "2- Find minimum in the array%n" +
                    "3- Find maximum in the array%n" +
                    "4- Find the average in the array%n" +
                    "5- Find the sum of odd or even indexes in the array%n");

            if (arrayCreated){
                System.out.println("You may create a new array or continue to work on" +
                        "the existing one.");
            }
            else {
                System.out.println("You must create an array, only valid input is 1.");
            }

            choice = takeValidInput(1,5);

            System.out.println();

            if (!arrayCreated && choice != CREATE_ARRAY){
                System.out.println("You must create an initial array. Invalid Choice!");
                continue;
            }

            switch (choice){
                case CREATE_ARRAY:
                    System.out.print("Please enter the size of the array:");
                    size = takeValidInput(1, Integer.MAX_VALUE);
                    array = createArray(size);
                    System.out.println("The array has been created.");
                    arrayCreated = true;
                    System.out.println("Elements:" + toString(array));
                    break;
                case FIND_MINIMUM:
                    result = findMinimum(array);
                    System.out.println("Minimum element is: " + result);
                    break;
                case FIND_MAXIMUM:
                    result = findMaximum(array);
                    System.out.println("Maximum element is: " + result);
                    break;
                case FIND_AVERAGE:
                    findAverage(array);
                    break;
                case FIND_SUM:
                    System.out.println(oddEven(array));
                    break;
                default:
                    notPrintResult = true;
                    System.out.println("Your input is not between 1 and 5.");
            }

            if (!notPrintResult){
            }

            System.out.printf("%nDo you want to continue? (Enter 1 to continue," +
                    " any other number to exit): ");
            if (!scanner.nextLine().equals("1")){
                wannaContinue = false;
            }
        }
    }
}