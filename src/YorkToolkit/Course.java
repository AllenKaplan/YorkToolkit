package YorkToolkit;

public class Course {
    private String term, year, faculty, dept, courseCode, section, courseTitle;
    private double credits, grade;

    public double getCredits() {
        return credits;
    }

    public double getGrade() {
        return grade;
    }

    public String getTerm() {
        return term;
    }

    public String getYear() {
        return year;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getDept() {
        return dept;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getSection() {
        return section;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    @Override
    public String toString() {
        return "Course{" +
                "term='" + term + '\'' +
                ", year='" + year + '\'' +
                ", faculty='" + faculty + '\'' +
                ", dept='" + dept + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", credits='" + credits + '\'' +
                ", section='" + section + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    public Course(String term, String year, String faculty, String dept, String courseCode, String credits, String section, String courseTitle, String grade) {
        this.term = term;
        this.year = year;
        this.faculty = faculty;
        this.dept = dept;
        this.courseCode = courseCode;
        this.credits = Double.parseDouble(credits);
        this.section = section;
        this.courseTitle = courseTitle;
        switch(grade) {
            case ("F"): this.grade = 0; break;
            case ("E"): this.grade = 1; break;
            case ("D"): this.grade = 2; break;
            case ("D+"): this.grade = 3; break;
            case ("C"): this.grade = 4; break;
            case ("C+"): this.grade = 5; break;
            case ("B"): this.grade = 6; break;
            case ("B+"): this.grade = 7; break;
            case ("A"): this.grade = 8; break;
            case ("A+"): this.grade = 9; break;
        }
    }
}
