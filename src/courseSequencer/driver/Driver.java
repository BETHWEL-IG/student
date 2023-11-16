
package courseSequencer.driver;
import courseSequencer.context.CourseSequencer;
import courseSequencer.data.Student;
import courseSequencer.util.FileProcessor;
import courseSequencer.util.Results;


public class Driver {
    public static void main(String[] args) {

        if (args.length != 2 || args[0].equals("${arg0}") || args[1].equals("${arg1}")) {

            System.err.println("Error: Incorrect number of arguments. Program accepts 2 arguments.");
            System.exit(0);
        }

        FileProcessor fileProcessor = new FileProcessor();
        fileProcessor.readFile(args[0]);

        Student student=fileProcessor.getStudent();

        CourseSequencer courseSequencer=new CourseSequencer();

        while(!student.getPreferences().isEmpty()) {
            if(!student.getIsGraduated()) {
                    courseSequencer.preRequisiteValidation(student);
            }else
                break;			
        }

        if(courseSequencer.getCoursePlannerState()==courseSequencer.getGraduateState())
                courseSequencer.preRequisiteValidation(student);

        if(courseSequencer.getCoursePlannerState()==courseSequencer.getNotGraduateState())
            courseSequencer.preRequisiteValidation(student);


        Results results = new Results();
        results.writeToFile(args[1], student);
        results.writeToConsole(student);		
    }
}

