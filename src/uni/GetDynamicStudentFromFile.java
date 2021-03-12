package uni;

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class GetDynamicStudentFromFile {

    public static void main(String[] args) throws IOException {
        File stFile = new File("Students.txt");
        Scanner fin = new Scanner(stFile);
        Student[] stArr = null;
        
        while (fin.hasNext()) {
            String line = fin.nextLine();
            stArr = addStudent(stArr, getStudentFromCSV(line));
//            String[] arr = line.split(",");
//            
//            Student st = new Student();
//            
//            st.stCode = Long.parseLong(arr[0]);
//            st.stName = arr[1];
//            st.field = arr[2];
//            st.totalGrade = Double.parseDouble(arr[3]);
//
//            if (stArr == null) {
//                stArr = new Student[1];
//            } else {
//                stArr = Arrays.copyOf(stArr, stArr.length + 1);
//            }
//            stArr[stArr.length - 1] = st;

        }//while
        
        for (int i = 0; i < stArr.length; i++) {
            System.out.println(stArr[i]);
            
        }
        
//        FileWriter fw = new FileWriter("st.txt");
//        BufferedWriter bw = new BufferedWriter(fw);
//        for (int i = 0; i < stArr.length; i++) {
//            String line = String.format("%d,%s,%s,%.2f", stArr[i].stCode,stArr[i].stName,stArr[i].field,stArr[i].totalGrade);
//            bw.write(line);
//            bw.newLine();
//        }
//        bw.close();
//        fw.close();
    }//main

    static Student[] addStudent(Student[] arr, Student st){
            if (arr == null) {
                arr = new Student[1];
            } else {
                arr = Arrays.copyOf(arr, arr.length + 1);
            }
            arr[arr.length - 1] = st;
           return arr;
    }//addStudent
    
    static Student getStudentFromCSV(String value){
            Student st = new Student();
            String[] arr = value.split(",");
            st.stCode = Long.parseLong(arr[0]);
            st.stName = arr[1];
            st.field = arr[2];
            st.totalGrade = Double.parseDouble(arr[3]);
            return st;

    }
    
    
}//class
