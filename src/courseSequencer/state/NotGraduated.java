
package courseSequencer.state;
import courseSequencer.context.CourseSequencer;
import courseSequencer.data.Student;


public class NotGraduated implements CourseSequencerStateI {

	public NotGraduated(CourseSequencer inCourseSequencer) {
	}


        @Override
	public void preRequisiteValidation(Student student) {
		student.setSemestersTaken(0);
		student.setIsGraduated(false);
	}

}

