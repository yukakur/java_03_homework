import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ReflCheckMethods {
    public static void main(String[] args) throws Exception{

        File fileDir = new File("C:/Test");
        File[] fileList = fileDir.listFiles();
//        List<Method> methodList = new ArrayList<>();
//        for (File f :
//                fileList) {

            String fileName = fileList[0].getName().substring(0, fileList[0].getName().lastIndexOf('.'));
            Class ch = URLClassLoader.newInstance(new URL[]{new File("C:/Test").toURL()}).loadClass(fileName);
//            Field [] fields = ch.getDeclaredFields();
//            Method [] methods = ch.getDeclaredMethods();
            Constructor constructorN0 = ch.getConstructor(String.class);
            Object zero = constructorN0.newInstance("Animal");
            Method zeroN1 = ch.getDeclaredMethod("canRun");
            Method zeroN2 = ch.getDeclaredMethod("canJump");
            Method zeroN3 = ch.getDeclaredMethod("canSwim");
            zeroN1.invoke(zero);
            zeroN2.invoke(zero);
            zeroN3.invoke(zero);

            String fileName1 = fileList[1].getName().substring(0, fileList[1].getName().lastIndexOf('.'));
//            System.out.println(fileName1);
            Class ch1 = URLClassLoader.newInstance(new URL[]{new File("C:/Test").toURL()}).loadClass(fileName1);
            Constructor constructorN1 = ch1.getConstructor();
            Object one = constructorN1.newInstance("cat");
//            Method [] methods = one.getClass().getDeclaredMethods();
//        for (Method x :
//                methods) {
//            x.invoke(one);
//        }
        String fileName2 = fileList[2].getName().substring(0, fileList[1].getName().lastIndexOf('.'));
        System.out.println(fileName2);
        Class ch2 = URLClassLoader.newInstance(new URL[]{new File("C:/Test").toURL()}).loadClass(fileName2);
        Constructor constructorN2 = ch2.getConstructor();
        Object two = constructorN2.newInstance();
        Method twoN1 =two.getClass().getDeclaredMethod("canJump");
        twoN1.invoke(two);

        String fileName4 = fileList[4].getName().substring(0, fileList[1].getName().lastIndexOf('.'));
        System.out.println(fileName4);
        Class ch4 = URLClassLoader.newInstance(new URL[]{new File("C:/Test").toURL()}).loadClass("Personal");
        Constructor constructorN4 = ch4.getConstructor(String.class, String.class, String.class, String.class, int.class, int.class);
        Object four = constructorN4.newInstance("director", "777", "a@aa", "test", 1000, 25);
        Method fourN1 =four.getClass().getDeclaredMethod("getInfo");
        fourN1.invoke(four);



//            zeroOne.invoke(one);
//            zeroTwo.invoke(one);
//            zeroThree.invoke(one);

            }


//            StringBuffer buffer = new StringBuffer("");
//            for (Field x :
//                    fields) {
//                String[] str = (x.toString().replaceAll("\\.", " ")).split(" ");
//                buffer.append(str[str.length - 3] + " " + str[str.length - 1] + ", ");
//            }
//            String temp = (buffer.deleteCharAt(buffer.length() - 1)).toString();
//            Constructor constructor = ch.getConstructor(temp);
//        }


//    }

}
