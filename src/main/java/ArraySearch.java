public class ArraySearch {

    public  int[] arrayAfterFour(int array[]) throws RuntimeException{
        int[] arrayAfterFour;
        int delta = 0;
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] == 4) {
                    delta = array.length - i - 1;
                    System.arraycopy(array, array.length - delta, arrayAfterFour = new int[delta], 0, delta);
                    return arrayAfterFour;
                }
            }
        throw  new RuntimeException();
    }
    public boolean findInArray(int [] array) {
        for (int x :
                array) {
            if(x == 1 || x == 4) return true;
        }
        return false;

    }


//    public static void main(String[] args) {
//        ArraySearch arraySearch = new ArraySearch();
//        int array [] = {1, 2, 3, 4, 5, 6, 7, 4, 5, 6};
//        System.out.println(arraySearch.findInArray(array));
//    }
}
