
    public static String toString(int[] numbers)
    {
        String str = "";
        for (int i : numbers) 
        {
            str += " " +i;
        }
        return str;
    }
    
    public static void createArray(int size){
        int list[] = new int[size];
    
            for( int i =0; i< size; i++)
            {
                int number = (int)(Math.random()*100);
                list[i] = number;
            }
    }

