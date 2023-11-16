
package courseSequencer.state;
import courseSequencer.context.CourseSequencer;
import courseSequencer.data.Student;


public class Electives implements CourseSequencerStateI {

	CourseSequencer courseSequencer;
	private final String group5="QRSTUVWXYZ";
	int count=0;

	public Electives(CourseSequencer inCourseSequencer) {
		courseSequencer = inCourseSequencer;
	}

        @Override
	public void preRequisiteValidation(Student student) {
		Boolean isAdded=false;
		if(!student.getPreferences().isEmpty()) {
			for(int iterator=student.getPointer();iterator<student.getPreferences().size();iterator++) {
				if(isAdded) {
					courseSequencer.setCoursePlannerState(courseSequencer.getGraduateState());
					break;
				}
				Character course=student.getPreferences().get(iterator);
				if(group5.contains(course.toString())){
					student.getCompleted().add(course);
					isAdded=true;
					count++;
					student.getPreferences().remove(course);
					iterator--;
					if(iterator==-1)
						courseSequencer.setCoursePlannerState(courseSequencer.getGraduateState());
					if(iterator==student.getPreferences().size()-1)
						courseSequencer.setCoursePlannerState(courseSequencer.getGraduateState());
				}else {
					student.setPointer(iterator);
					courseSequencer.setCoursePlannerState(courseSequencer.getState1());
					break;
				}
			}
		}else {
			courseSequencer.setCoursePlannerState(courseSequencer.getGraduateState());
		}

		if(count>student.getStateCount()) {
			student.setStateCount(count);
			if(student.getGroup() == null ? group5 != null : !student.getGroup().equals(group5))
				student.setStateChanges(student.getStateChanges()+1);
			student.setGroup(group5);
		}

	}

}

