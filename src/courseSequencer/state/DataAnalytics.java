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
public class DataAnalytics implements CourseSequencerStateI {

	CourseSequencer courseSequencer;
	private final String group4="MNOP";
	int count=0;

	public DataAnalytics(CourseSequencer inCoursePlanner) {
		courseSequencer = inCoursePlanner;
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
				if(group4.contains(course.toString())){
					if(course=='M') {
						student.getCompleted().add(course);
						isAdded=true;
						count++;
						student.getPreferences().remove(course);
						iterator--;
						if(iterator==student.getPreferences().size()-1)
							courseSequencer.setCoursePlannerState(courseSequencer.getGraduateState());
					}else{
						if(student.getCompleted().size()%3==0) {
							if(student.getCompleted().contains(group4.charAt(group4.indexOf(course)-1))) {
								student.getCompleted().add(course);
								isAdded=true;
								count++;
								student.getPreferences().remove(course);
								iterator--;
								if(iterator==student.getPreferences().size()-1)
									courseSequencer.setCoursePlannerState(courseSequencer.getGraduateState());
							}

						}else {
							if(student.getCompleted().size()%3==1) {
								if(!group4.contains(student.getCompleted().get(student.getCompleted().size()-1).toString())) {
									if(student.getCompleted().contains(group4.charAt(group4.indexOf(course)-1))) {
										student.getCompleted().add(course);
										isAdded=true;
										count++;
										student.getPreferences().remove(course);
										iterator--;
										if(iterator==student.getPreferences().size()-1)
											courseSequencer.setCoursePlannerState(courseSequencer.getGraduateState());
									}
								}
							}else if(student.getCompleted().size()%3==2) {
								if(!group4.contains(student.getCompleted().get(student.getCompleted().size()-1).toString()) && !group4.contains(student.getCompleted().get(student.getCompleted().size()-2).toString())) {
									if(student.getCompleted().contains(group4.charAt(group4.indexOf(course)-1))) {
										student.getCompleted().add(course);
										isAdded=true;
										count++;
										student.getPreferences().remove(course);
										iterator--;
										if(iterator==student.getPreferences().size()-1)
											courseSequencer.setCoursePlannerState(courseSequencer.getGraduateState());
									}
								}
							}
						}
					}

				}else {
					student.setPointer(iterator);
					courseSequencer.setCoursePlannerState(courseSequencer.getState5());
					break;
				}
			}


		}else {
			courseSequencer.setCoursePlannerState(courseSequencer.getGraduateState());
		}
		student.setSemestersTaken(student.getCompleted().size()/3+1);

		if(count>student.getStateCount()) {
			student.setStateCount(count);
			if(student.getGroup() == null ? group4 != null : !student.getGroup().equals(group4))
				student.setStateChanges(student.getStateChanges()+1);
			student.setGroup(group4);
		}
	}
}

