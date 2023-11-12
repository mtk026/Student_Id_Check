package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // this program check the student Id validation and if it has missing part it will calculate it.
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String studentId, Id, studentIdPart1, studentIdPart2;
        int missNumber, missNumber1;
        Integer[] studentIdInt = new Integer[6];

        String[] studentIdlistMain = new String[6];
        ArrayList<Integer> missNumberList = new ArrayList<Integer>();

          System.out.println("please Enter Stundent ID");
        studentId = scan.next();
        //studentId = "?67912-5";


        Id = studentId.substring(studentId.indexOf("-") + 1);


        for (int i = 0; i < studentId.indexOf("-"); i++) {

            studentIdlistMain[i] = studentId.substring(i, i + 1);


        }
        if (Arrays.asList(studentIdlistMain).contains("?")) {

            missNumber = studentId.indexOf("?");

            studentIdPart1 = studentId.substring(0, missNumber);
            studentIdPart2 = studentId.substring(missNumber + 1, studentId.indexOf("-"));


            // System.out.println(studentIdPart1 + " " + studentIdPart2);
//----------------------------------------------------------------------------------------------
            for (int x = 0; x < studentIdlistMain.length; x++) {
                if (studentId.substring(x, x + 1).equals("?")) {
                    studentIdlistMain[x] = "0";

                } else {
                    studentIdlistMain[x] = studentId.substring(x, x + 1);

                }
            }


            for (int x = 0; x < studentIdlistMain.length; x++) {
                if (x == 0 || x % 2 == 0) {
                    studentIdInt[x] = Integer.valueOf(studentIdlistMain[x]);

                }
                if (x % 2 == 1) {
                    studentIdInt[x] = Integer.valueOf(studentIdlistMain[x]) * 2 % 10 + Integer.valueOf(studentIdlistMain[x]) * 2 / 10;
                }
            }

            int total = 0;
            for (int x : studentIdInt) {
                total = total + x;
            }

            if (missNumber == 0 || missNumber % 2 == 0) {
                if ((total + Integer.valueOf(Id)) % 10 == 0) {
                    missNumber1 = 0;
                } else if (total + Integer.valueOf(Id) > 10) {
                    missNumber1 = (((total + Integer.valueOf(Id)) / 10 + 1) * 10) - (Integer.valueOf(Id) + total);
                } else {
                    missNumber1 = total + Integer.valueOf(Id);
                }

            }

            else {
                missNumber1 = ((total / 10) + 1) * 10 + Integer.valueOf(Id) - total;
                for (int x = 1; x < 10; x++) {
                    for (int y = 1; y < 10; y++) {
                        if (x + y == missNumber1) {
                            missNumberList.add((10 * x + y));
                        }
                    }
                }
                //for (int x = 0; x < missNumberList.size(); x++) {
                //    System.out.println(missNumberList.get(x));
                for (int x = 0; x < missNumberList.size(); x++) {
                    if ((missNumberList.get(x) / 2) < 10 && (missNumberList.get(x) % 2 == 0)) {
                        missNumber1 = missNumberList.get(x) / 2;
                    }
                }


            }
            System.out.println(studentIdPart1+missNumber1+studentIdPart2+"-"+Id);

            //---------------------------------------------------------------------------------------------
        } else {

            for (int x = 0; x < studentIdlistMain.length; x++) {
                if (x == 0 || x % 2 == 0) {
                    studentIdInt[x] = Integer.valueOf(studentIdlistMain[x]);

                }
                if (x % 2 == 1) {
                    studentIdInt[x] = Integer.valueOf(studentIdlistMain[x]) * 2 % 10 + Integer.valueOf(studentIdlistMain[x]) * 2 / 10;
                }
            }
            int total = 0;
            for (int x : studentIdInt) {
                total = total + x;


            }

            if (Id.equals("?")){
                Id=String.valueOf(10-(total%10));

                System.out.println(studentId.substring(0,studentId.indexOf("-"))+"-"+Id);
            }
            else if ((10 - (total % 10)) == Integer.valueOf(Id)) {
                System.out.println("Student Id is Valid");
            } else {
                System.out.println("Student Id is Non Valid");
            }


        }

    }
}


