package uni;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import static java.lang.String.*;
import static java.lang.System.arraycopy;
public class GetDynamicStudentInfo {
    static Student[] stArr = null;
    static String fileName;
    private static int searchingCodeIndex;

    public static void main(String[] args) throws IOException {
        System.out.print("Enter File Name:");
        Scanner in = new Scanner(System.in);
        fileName = in.nextLine();
        loadFile();
        menuloop:
        while (true) {
            String msg = "1:Add New Student\n"
                    + "2:Edit Student\n3:Delete Student\n4:Sort Student\n5:Save File\n6:Print Student List\n7:Exit\n"
                    + "Enter Your Selection:";
            System.out.print(msg);
            int selection = in.nextInt();
            switch (selection) {
                case 1:addNewstudents();
                    // ToDo get new studnet from user and add to array
                    break;
                case 2: editStudent();
                    break;
                case 3: Deletestudent();
                    break;
                case 4:
                    String mln = "1:Byname\n2:Bycode\n3:Byfield\n4:Bytotal\n5:exite";
                    System.out.println(mln);
                    int control = in.nextInt();
                    switch (control){
                        case 1:
                            String sorn = "1:Descending\n2:Ascending\n3:exite";
                            System.out.println(sorn);
                            int son = in.nextInt();
                            switch (son){
                                case 1:
                                    sortByNameASC();
                                    break;
                                case 2:
                                    sortByNameCSA();
                                    break ;
                                case 3:
                                    break ;
                            }
                            break ;
                        case 2:
                             sorn = "1:Descending\n2:Ascending\n3:exite";
                            System.out.println(sorn);
                             son = in.nextInt();
                             switch (son){
                                 case 1:sortByCodeAtoZ();
                                     break ;
                                 case 2:sortByCodeZtoA();
                                     break ;
                                 case 3:
                                     break ;

                             }
                            break ;
                        case 3:
                            sorn = "1:Descending\n2:Ascending\n3:exite";
                            System.out.println(sorn);
                            son = in.nextInt();
                            switch (son){
                                case 1:
                                    sortByFieldAtoz();
                                    break ;
                                case 2:sortByFieldZtoA();
                                    break ;
                                case 3:
                                    break ;
                            }
                            break;
                        case 4: sorn = "1:Descending\n2:Ascending\n3:exite";
                            System.out.println(sorn);
                            son = in.nextInt();
                            switch (son){
                                case 1:sortBytotalZtoA();
                                    break ;
                                case 2:sortBytotalAtoZ();
                                    break ;
                                case 3:
                                    break ;
                            }
                            break ;
                        case 5:
                            break ;
                }
                    break;
                case 5:saveStudent();
                    break;
                case 6:printestudents();
                    break;
                case 7: //get confirmation from user
                    System.out.println("do you want to exite ? (y/n)");
                    String anw;
                    anw = in.next();
                    System.out.println();
                    if (anw.toLowerCase().charAt(0) == 'n'){
                        System.out.println("Ok thats good choice");
                    }else if(anw.toLowerCase().charAt(0) == 'y') {
                        System.out.println("hope to see you again ");
                        break menuloop;
                    }else {
                        System.out.println("errore 404");
                    }
            }//switch

        }//while

    }//main

    static void sortByNameASC() {
        for (int i = 0; i < stArr.length; i++) {
            for (int j = i + 1; j < stArr.length; j++) {
                if (stArr[i].stName.compareToIgnoreCase(stArr[j].stName) > 0) {
                    Student temp = stArr[i];
                    stArr[i] = stArr[j];
                    stArr[j] = temp;
                }
            }

        }
    }//sortByNameASC
    static void sortByNameCSA(){
        for (int i = 0; i < stArr.length; i++) {
            for (int j = i + 1; j < stArr.length; j++) {
                if (stArr[i].stName.compareToIgnoreCase(stArr[j].stName) < 0) {
                    Student temp = stArr[i];
                    stArr[i] = stArr[j];
                    stArr[j] = temp;
                }
            }

        }
    }
    static void sortByFieldAtoz(){
        for (int i = 0; i < stArr.length; i++) {
            for (int j = i + 1; j < stArr.length; j++) {
                if (stArr[i].field.compareToIgnoreCase(stArr[j].field) > 0) {
                    Student temp = stArr[i];
                    stArr[i] = stArr[j];
                    stArr[j] = temp;
                }
            }

        }
    }
    static void sortByFieldZtoA(){
        for (int i = 0; i < stArr.length; i++) {
            for (int j = i + 1; j < stArr.length; j++) {
                if (stArr[i].field.compareToIgnoreCase(stArr[j].field) < 0) {
                    Student temp = stArr[i];
                    stArr[i] = stArr[j];
                    stArr[j] = temp;
                }
            }

        }
    }
    static void sortByCodeAtoZ() {
        for (int i = 0; i < stArr.length; i++) {
            for (int j = i + 1; j < stArr.length; j++) {
                if (valueOf(stArr[i].stCode).compareTo(valueOf(stArr[j].stCode))>0){
                    Student temp = stArr[i];
                    stArr[i] = stArr[j];
                    stArr[j] = temp;
                }
            }
        }
    }
    static void sortByCodeZtoA(){
        for (int i = 0; i < stArr.length; i++) {
            for (int j = i + 1; j < stArr.length; j++) {
                if (valueOf(stArr[i].stCode).compareTo(valueOf(stArr[j].stCode)) < 0){
                    Student temp = stArr[i];
                    stArr[i] = stArr[j];
                    stArr[j] = temp;
                }
            }
        }
    }
    static void sortBytotalAtoZ(){
        for (int i = 0; i < stArr.length; i++) {
            for (int j = i + 1; j < stArr.length; j++) {
                if (valueOf(stArr[i].totalGrade).compareTo(valueOf(stArr[j].totalGrade)) > 0){
                    Student temp = stArr[i];
                    stArr[i] = stArr[j];
                    stArr[j] = temp;
                }
            }
        }
    }
    static void sortBytotalZtoA(){
        for (int i = 0; i < stArr.length; i++) {
            for (int j = i + 1; j < stArr.length; j++) {
                if (valueOf(stArr[i].totalGrade).compareTo(valueOf(stArr[j].totalGrade)) < 0){
                    Student temp = stArr[i];
                    stArr[i] = stArr[j];
                    stArr[j] = temp;
                }
            }
        }
    }
    static void loadFile() throws FileNotFoundException {
        File stFile = new File("Students.txt");
        Scanner fin = new Scanner(stFile);
        while (fin.hasNext()) {
            String line = fin.nextLine();
            stArr = addStudent(stArr, getStudentFromCSV(line));
        }//whilez
    }//loadFile
    static void saveStudent() throws IOException {
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < stArr.length; i++) {
            String line = String.format("%d,%s,%s,%.2f", stArr[i].stCode,stArr[i].stName,stArr[i].field,stArr[i].totalGrade);
            bw.write(line);
            bw.newLine();
        }
        bw.close();
        fw.close();
    }
    static Student[] addStudent(Student[] arr, Student st) {
        if (arr == null) {
            arr = new Student[1];
        } else {
            arr = Arrays.copyOf(arr, arr.length + 1);
        }
        arr[arr.length - 1] = st;
        return arr;
    }//addStudent
    static void addNewstudents() throws IOException {
        boolean confag = true;
        while (confag){
            Scanner input = new Scanner(System.in);
            Student st = new Student();
            System.out.print("Enter Code:");
            st.stCode = input.nextLong();
            input.nextLine();
            System.out.print("Enter Name:");
            st.stName = input.nextLine();
            System.out.print("Enter Field:");
            st.field = input.nextLine();
            System.out.print("Enter Total Grade:");
            st.totalGrade = input.nextDouble();
            if (stArr == null) {
                stArr = new Student[1];
            } else {
                stArr = Arrays.copyOf(stArr, stArr.length + 1);
            }
            stArr[stArr.length - 1] = st;

            System.out.print("Do you want to add more student?(y/n)");
            String str = input.next();
            if (str.toLowerCase().charAt(0) == 'n') {
                confag = false;
            }
        }
        FileWriter fw = new FileWriter("students.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < stArr.length; i++) {
            String line = format("%d,%s,%s,%.2f", stArr[i].stCode,stArr[i].stName,stArr[i].field,stArr[i].totalGrade);
            bw.write(line);
            bw.newLine();
        }
        bw.close();
        fw.close();
    }
    static Student getStudentFromCSV(String value) {
        Student st = new Student();
        String[] arr = value.split(",");
        st.stCode = Long.parseLong(arr[0]);
        st.stName = arr[1];
        st.field = arr[2];
        st.totalGrade = Double.parseDouble(arr[3]);
        return st;

    }
    static boolean search(){
        Scanner in = new Scanner(System.in);
        long searchingCode;
        int i;
        boolean searchFlag;

        System.out.print("Please Enter A Code: ");
        searchingCode = in.nextLong();

        searchingCodeIndex = 0;
        searchFlag = true;
        i = 0;
        while (i < stArr.length && searchFlag){
            if (stArr[i].stCode == searchingCode){
                searchFlag = false;
                searchingCodeIndex = i;
            }
            i++;
        }

        if (!searchFlag){
            System.out.println("\nThe Student is in the list !");
            return true;
        } else {
            System.out.println("There Is No Student With This Code.\n");
            return false;
        }
    }//searchStudent

    static void editStudent(){
        Scanner in = new Scanner(System.in);
        int selection;

        editloop:
        if (search()){
            boolean condition = true;
            while (condition){
                System.out.println("1.By Code");
                System.out.println("2.By Name");
                System.out.println("3.By Field");
                System.out.println("4.By Total grate");
                System.out.println("5. Cancel Edit");
                System.out.print("choice one of them : ");
                selection = in.nextInt();
                System.out.println();

                switch (selection){
                    case 1:
                        editStudentCode();
                        break;
                    case 2:
                        editStudentName();
                        break;
                    case 3:
                        editStudentField();
                        break;
                    case 4:
                        editStudentTotalGrade();
                    default:
                        break editloop;
                }

                System.out.print("Do you want to change anything else (y/n) : ");
                String ans = in.next();
                System.out.println();

                if (ans.toLowerCase().charAt(0) == 'n') {
                    condition = false;
                }
            }
        }
    }

    static void editStudentCode(){
        Scanner in = new Scanner(System.in);

        System.out.print("Please Enter The New Code: ");
        stArr[searchingCodeIndex].stCode = in.nextLong();
        System.out.println(" information changed.\n");
    }

    static void editStudentName(){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the New Name: ");
        stArr[searchingCodeIndex].stName = in.nextLine();
        System.out.println(" information changed.\n");
    }

    static void editStudentField(){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter New Field: ");
        stArr[searchingCodeIndex].field = in.nextLine();
        System.out.println(" information changed.\n");
    }

    static void editStudentTotalGrade(){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter New Grade: ");
        stArr[searchingCodeIndex].totalGrade = in.nextDouble();
        System.out.println(" information changed.\n");
    }
    static void Deletestudent() throws IOException {
        Scanner input = new Scanner(System.in);
        int choice;
        deletestudent:
        if (search()) {
            boolean shart = true;
            while (shart) {
                System.out.println("1. delete");
                System.out.println("2. back");
                System.out.print("choice one of them : ");
                choice = input.nextInt();
                System.out.println();
                switch (choice) {
                    case 1:
                        deleteStudentsBycode();
                        break;
                    case 2:
                        break deletestudent;
                }
                System.out.print("Do you want to delete anystudent else (y/n) : ");
                String ans = input.next();
                System.out.println();
                if (ans.toLowerCase().charAt(0) == 'n') {
                    System.out.println("thats your own problem");
                    System.out.println();
                    shart = false;
                }
            }
        }
    }
    static void deleteStudentsBycode() throws IOException {
        stArr[searchingCodeIndex] = stArr[stArr.length-1];
        stArr = Arrays.copyOf(stArr , stArr.length-1);
    }
    static void printestudents(){
        for (int i = 0; i < stArr.length; i++) {
            System.out.println(stArr[i]);
        }
    }
}
