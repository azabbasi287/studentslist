package uni;

public class Student {
    long stCode;
    String stName;
    String field;
    double totalGrade;

    @Override
    public String toString() {
        return "stCode=" + stCode + ", stName=" + stName + ", field=" + field + ", totalGrade=" + totalGrade;
    }
    
    
}
