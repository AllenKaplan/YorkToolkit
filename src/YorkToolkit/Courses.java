package YorkToolkit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Courses {



    List<Course> courseList = new ArrayList<Course>();
    final String COURSE_PATTERN_FORMAT = "(SU|FW)(\\d{2})\\s(\\w{2})\\s{1,2}(\\w{2,4})\\s{1,2}(\\d{2,4})\\s\\s(\\d+.\\d+)\\s([A-Z])\\s(.[^\\t]+)\\s(.+)";
    Pattern coursePattern = Pattern.compile(COURSE_PATTERN_FORMAT);
    Matcher courseMatcher;
    boolean match;
    //    final List<String> groups = new ArrayList<String>(Arrays.asList("term", "year", "faculty", "dept", "courseCode", "credits", "section", "courseTitle", "grade"));
    public Courses(Scanner classFileScanner){
        /* Eats the lines one by one to transform to regex and create a course*/
        while(classFileScanner.hasNextLine()) {
            String nextLine = classFileScanner.nextLine();
            MakeClass(nextLine);
       }
    }

    private void MakeClass (String given) {

        courseMatcher = coursePattern.matcher(given);
        match = courseMatcher.matches();

        if(!match) throw new IllegalArgumentException("String does not match: " + given);

        courseList.add(new Course(
                courseMatcher.group(1),
                courseMatcher.group(2),
                courseMatcher.group(3),
                courseMatcher.group(4),
                courseMatcher.group(5),
                courseMatcher.group(6),
                courseMatcher.group(7),
                courseMatcher.group(8),
                courseMatcher.group(9)
        ));

//        System.out.println("COURSE CREATED: " + courseList.get(courseList.size()-1));
    }

    public double getTotalCredits(){
        double credits = courseList.stream()
                .mapToDouble(c -> c.getCredits())
                .sum();
/*
for(Course c : courseList){
credits += c.getCredits();
}
*/
        return credits;
    }

    public double getAverage(String term, String year){
        List<Course> currentCourses = courseList.stream()
                .filter(c -> term.equals(c.getTerm()))
                .filter(c -> year.equals(c.getYear()))
                .collect(Collectors.toList());


        return 0;
    }


    public double getAverageOfAll(){
        double totalCreditsEarned= courseList.stream()
                .mapToDouble(c -> c.getGrade()*(c.getCredits()/this.getTotalCredits()))
                .sum();


        return totalCreditsEarned;
    }
}
