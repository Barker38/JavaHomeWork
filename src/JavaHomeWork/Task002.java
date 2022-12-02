package JavaHomeWork;
import java.util.ArrayList;



public class Task002 {

    static final int A = 22;
    static final int B = 333;
    static final int C = 3;
    static final int D = 1;
    static ArrayList<String> allRoutes = new ArrayList<>();
    static int minLevel = Integer.MAX_VALUE;

    static void runFunc(int a, int level, String way) {
        if (a == B) {
            allRoutes.add(way);
            if (level < minLevel) {
                minLevel = level;
            }
        }
        if (a < B) {
            // System.out.println("*" + (a*C));
            // System.out.println("+" + (a+D));

            runFunc(a * C, level + 1, way + "*" + C + " ");
            runFunc(a + D, level + 1, way + "+" + D + " ");

        }
    }

    static String minWay(ArrayList<String> arr) {

        String minWay = arr.get(0);

        for (String elem : arr) {

            if (elem.length() < minWay.length())
                minWay = elem;

        }
        return minWay;
    }

    public static void main(String[] args) {

        // int a = 1;
        // int b = 6;
        // int c = 2;
        // int d = 1;
        runFunc(A, 0, A + " ");

        if (allRoutes.isEmpty())
            System.out.println("Решений нет!");
        else {

            StringBuilder route = new StringBuilder();

            route.append("Все варианты решений:\n\n");

            for (String elem : allRoutes) {

                route.append(elem).append(" = ").append(B);
                route.append("\n");

            }

            route.append("\n");

            route.append("Самое быстрое решение:\n\n");
            route.append(minWay(allRoutes));
            System.out.println(route + " = " + B);
            System.out.println("Число комбинаций = " + allRoutes.size());
            System.out.println("Минимальное число шагов = " + minLevel);
        }
    }
}