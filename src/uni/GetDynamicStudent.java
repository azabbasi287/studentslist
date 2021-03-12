package uni;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class GetDynamicStudent {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        Student[] stArr = null;
        boolean conFlag = true;
        while (conFlag) {
            Student st = new Student();
            System.out.print("Enter Code:");
            st.stCode = in.nextLong();
            in.nextLine();
            System.out.print("Enter Name:");
            st.stName = in.nextLine();
            System.out.print("Enter Field:");
            st.field = in.nextLine();
            System.out.print("Enter Total Grade:");
            st.totalGrade = in.nextDouble();

            if (stArr == null) {
                stArr = new Student[1];
            } else {
                stArr = Arrays.copyOf(stArr, stArr.length + 1);
            }
            stArr[stArr.length - 1] = st;

            System.out.print("Do you want to add more student?(y/n)");
            String str = in.next();
            if (str.toLowerCase().charAt(0) == 'n') {
                conFlag = false;
            }

        }//while
        
        for (int i = 0; i < stArr.length; i++) {
            System.out.println(stArr[i]);
            
        }
        
        FileWriter fw = new FileWriter("st.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < stArr.length; i++) {
            String line = String.format("%d,%s,%s,%.2f", stArr[i].stCode,stArr[i].stName,stArr[i].field,stArr[i].totalGrade);
            bw.write(line);
            bw.newLine();
        }
        bw.close();
        fw.close();
    }//main

}//class
