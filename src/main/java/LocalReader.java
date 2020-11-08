import java.io.*;
import java.util.*;

public class LocalReader {

    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("Test/test50bytes.txt");
//        file.mkdir();
//        file.createNewFile();

        /* первое задание
        прочитал весь файл в битовый массив
        вывел в консоль с преобразованием в char
         */
        byte [] byteArray;
        FileInputStream inputStream = new FileInputStream(file);
        byteArray = inputStream.readAllBytes();
        for (byte b :
                byteArray) {
            System.out.print((char)b);

        }
        System.out.println((double)"01.txt".length() / (1024));


        /* второе задание
        собрал файлы в arraylist  и вывел SequenceInputStreamом
         */
        List<InputStream> ipList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            ipList.add(new FileInputStream("Test/0"+ i + ".txt"));
        }
        SequenceInputStream seqis = new SequenceInputStream(Collections.enumeration(ipList));
        int x;
        while ((x = seqis.read()) != -1) {
            System.out.print((char) x);
        }

        /* третье задание
        сделал печать через рандомаксессфайл
         */

        long t = System.currentTimeMillis();
        File file1 = new File("Test/3rd task.txt");
        RandomAccessFile raf = new RandomAccessFile(file1, "r");
        for (int i = 0; i < file1.length(); i += 1800) {
            byte[] bytes1 = new byte[i + 1800];
            raf.read(bytes1, i, 1800);
            System.out.print(new String(bytes1, "UTF-8"));

//            Thread.sleep(1000);
//            System.out.println("\nстраница: " + (i / 1800));
        }
        System.out.println(System.currentTimeMillis() - t);




    }




}
