package app;

import service.StudentService;
import java.util.*;
import java.sql.Date;

public class MainApp {
    static Scanner sc = new Scanner(System.in);
    static StudentService s = new StudentService();

    static Date d() {
        System.out.print("yyyy mm dd: ");
        int y = sc.nextInt();
        int m = sc.nextInt();
        int da = sc.nextInt();
        return Date.valueOf(y+"-"+m+"-"+da);
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("\n1 Add Part Time");
            System.out.println("2 Add Full Time");
            System.out.println("3 Remove Student");
            System.out.println("4 View Student");
            System.out.println("5 View Students");
            System.out.println("6 Sort DoJ");
            System.out.println("7 Sort Id");
            System.out.println("8 Sort FirstName");
            System.out.println("9 Exit");

            int c = sc.nextInt();

            switch (c) {
                case 1:
                    System.out.print("Id Fn: ");
                    s.addP(sc.nextInt(), sc.next(), d());
                    break;
                case 2:
                    System.out.print("Id Fn: ");
                    s.addF(sc.nextInt(), sc.next(), d());
                    break;
                case 3:
                    s.remove(sc.nextInt());
                    break;
                case 4:
                    s.view(sc.nextInt());
                    break;
                case 5:
                    s.viewAll();
                    break;
                case 6:
                    s.sortByDoj();
                    break;
                case 7:
                    s.sortById();
                    break;
                case 8:
                    s.sortByFn();
                    break;
                case 9:
                    System.exit(0);
            }
        }
    }
}
