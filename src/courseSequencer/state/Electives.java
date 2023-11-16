/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseSequencer.state;
import courseSequencer.context.CourseSequencer;
import courseSequencer.data.Student;

/**
 *
 * @author ADMIN
 */
public class Electives implements CourseSequencerStateI {

	CourseSequencer coursePlanner;
	private final String group5="QRSTUVWXYZ";
	int count=0;

	public Electives(CourseSequencer inCoursePlanner) {
		coursePlanner = inCoursePlanner;
	}

        @Override
	public void preRequisiteValidation(Student student) {
		Boolean isAdded=false;
		if(!student.getPreferences().isEmpty()) {
			for(int iterator=student.getPointer();iterator<student.getPreferences().size();iterator++) {
				if(isAdded) {
					coursePlanner.setCoursePlannerState(coursePlanner.getGraduateState());
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
						coursePlanner.setCoursePlannerState(coursePlanner.getGraduateState());
					if(iterator==student.getPreferences().size()-1)
						coursePlanner.setCoursePlannerState(coursePlanner.getGraduateState());
				}else {
					student.setPointer(iterator);
					coursePlanner.setCoursePlannerState(coursePlanner.getState1());
					break;
				}
			}
		}else {
			coursePlanner.setCoursePlannerState(coursePlanner.getGraduateState());
		}

		if(count>student.getStateCount()) {
			student.setStateCount(count);
			if(student.getGroup() == null ? group5 != null : !student.getGroup().equals(group5))
				student.setStateChanges(student.getStateChanges()+1);
			student.setGroup(group5);
		}

	}

}

