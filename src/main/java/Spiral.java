public class Spiral {

    public static void main(String[] args) {
        int [][] spiral = new int[5][7];
        int i = 0;
        int iMax = spiral.length * spiral[0].length;
//        boolean horis = true;
//        boolean horisR = true;
//        boolean vert = true;
//        boolean vertR = true;
        int xMin = 0;
        int xMax = spiral.length - 1;
        int yMin = spiral[0].length - 1;
        int yMax = 0;

        while (true) {
//            if(horis == vert == horisR == vertR) {
                i = fillRowOfMatrix(spiral, yMax, xMin, xMax, i, false);
//                horis = !horis;
                yMax++;
//            }
            printArray(spiral);
            if(i == iMax) break;
//            if(!horis == vert == horisR == vertR) {
                i = fillColumnOfMatrix(spiral, xMax, yMax, yMin, i, false);
//                vert = !vert;
                xMax--;
//            }
            printArray(spiral);
            if(i == iMax) break;
//            if(horis == vert == !horisR == !vertR) {
                i = fillRowOfMatrix(spiral, yMin, xMin, xMax, i, true);
//                horisR = !horisR;
                yMin--;
//            }
            printArray(spiral);
            if(i == iMax) break;
//            if(horis == vert == horisR == !vertR) {
                i = fillColumnOfMatrix(spiral, xMin, yMax, yMin, i, true);
//                vertR = !vertR;
                xMin++;
//            }
            printArray(spiral);
            if(i == iMax) break;
        }




    }
    static void printArray(int[][]array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] < 10) System.out.print(array[i][j] + "  ");
                else System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }



    static int fillRowOfMatrix (int[][] array, int fillingRow, int fMin, int fMax, int i, boolean reverse) {
        if(!reverse) {
            for (int j = fMin; j <= fMax; j++) {
                array[j][fillingRow] = i;
                i++;
            }
        } else {
            for (int j = fMax; j >= fMin; j--) {
                array[j][fillingRow] = i;
                i++;
            }
        }
        return i;
    }
    static int fillColumnOfMatrix (int[][] array, int fillingColumn, int fMin, int fMax, int i, boolean reverse) {
        if(!reverse) {
            for (int j = fMin; j <= fMax; j++) {
                array[fillingColumn][j] = i;
                i++;
            }
        } else {
            for (int j = fMax; j >= fMin; j--) {
                array[fillingColumn][j] = i;
                i++;
            }
        }
        return i;
    }
}
