import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Tester {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        testing(ForTesting.class);
    }

    public static void testing(Class testClass) throws InvocationTargetException, IllegalAccessException {
//        int tests = 0;
//        int passed = 0;
        Method[] methods = testClass.getDeclaredMethods();
        List<Method> list = new ArrayList<>();
        for(Method m :methods) {

            if (m.isAnnotationPresent(Test.class)) {
//                    Constructor constructor = testClass.getConstructor();
//                    Object obj = constructor;
                int priority = m.getAnnotation(Test.class).priority();
                if (priority < 1 || priority > 10) throw new RuntimeException("Wrong priority");
//                    m.invoke(null);
                list.add(m);
            }
        }


            list.sort(new Comparator<Method>() {
                @Override
                public int compare(Method o1, Method o2) {
                    return o2.getAnnotation(Test.class).priority() -o1.getAnnotation(Test.class).priority();
                }
            });
            for(Method method: methods) {
                if(method.isAnnotationPresent(BeforeSuite.class)) {
                    if(list.get(0).isAnnotationPresent(BeforeSuite.class))
                        throw new RuntimeException("BeforeSuite exist already");
                    list.add(0, method);
                }

                if(method.isAnnotationPresent(AfterSuite.class)) {
                    if(list.get(list.size() - 1).isAnnotationPresent(AfterSuite.class))
                        throw new RuntimeException("AfterSuite exist already");
                    list.add(method);
                }
            }
//            for (Method  x :
//                    list) {
//                System.out.println(x.getName());
//            }
            for (Method x :
                    list) {
                x.invoke(null);
            }
        }
    }

    
    

