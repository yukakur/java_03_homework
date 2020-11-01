import java.util.ArrayList;

public class StorageBox <T>{
    private T [] storageBox;

    public StorageBox(T [] storageBox) {
        this.storageBox = storageBox;
    }

    /**
     * Меняет в массиве местами заданные позиции, есть проверка на вводимые данные
     *
     * @param firstPos первая позиция замены
     * @param secPos вторая позиция замены
     */
    public void arraySwapPos (int firstPos, int secPos) {
        if(firstPos > storageBox.length - 1 || secPos > storageBox.length - 1) {
            System.out.println("вне размера массива " + storageBox.length);
            return;
//            throw new IndexOutOfBoundsException();
        }
        T posOne = this.storageBox[firstPos];
        this.storageBox[firstPos] = this.storageBox[secPos];
        this.storageBox[secPos] = posOne;
    }


    public void printStorageBox() {
        for (int i = 0; i < storageBox.length; i++) {
            System.out.print(storageBox[i] + " ");
        }
        System.out.println();
    }

    /**
     * конвертирует массив в ArrayList
     * @return новый ArrayList переданного типа
     */
    public ArrayList<T> arrayToList() {
        ArrayList<T> arrayList = new ArrayList<>();
        for(T x: storageBox) arrayList.add(x);
        return arrayList;
    }

}
