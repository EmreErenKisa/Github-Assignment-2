public static void average( int[] list){
  int sumOfNumbers = 0;
  int average = 0;
  int[] difference;
  for( int i : list){
  sumOfNumbers += i ;
  }
  average = sumOfNumbers / list.length ;
  for(int i = 0; i<list.length ; i++){
    difference[i] = list[i] - average;
  }
  System.out.println(Arrays.toString(list));
}
