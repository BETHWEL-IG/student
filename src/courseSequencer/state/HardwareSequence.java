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
public class HardwareSequence implements CourseSequencerStateI {

	CourseSequencer coursePlanner;
	private final String group3="IJKL";
	int count=0;

	public HardwareSequence(CourseSequencer inCoursePlanner) {
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
				if(group3.contains(course.toString())){
					if(course=='I') {
						student.getCompleted().add(course);
						isAdded=true;
						count++;
						student.getPreferences().remove(course);
						iterator--;
						if(iterator==student.getPreferences().size()-1)
							coursePlanner.setCoursePlannerState(coursePlanner.getGraduateState());
					}else{
						if(student.getCompleted().size()%3==0) {

							if(student.getCompleted().contains(group3.charAt(group3.indexOf(course)-1))) {
								student.getCompleted().add(course);
								isAdded=true;
								count++;
								student.getPreferences().remove(course);
								iterator--;
								if(iterator==student.getPreferences().size()-1)
									coursePlanner.setCoursePlannerState(coursePlanner.getGraduateState());
							}

						}else {
							if(student.getCompleted().size()%3==1) {
								if(!group3.contains(student.getCompleted().get(student.getCompleted().size()-1).toString())) {
									if(student.getCompleted().contains(group3.charAt(group3.indexOf(course)-1))) {
										student.getCompleted().add(course);
										isAdded=true;
										count++;
										student.getPreferences().remove(course);
										iterator--;
										if(iterator==student.getPreferences().size()-1)
											coursePlanner.setCoursePlannerState(coursePlanner.getGraduateState());
									}
								}
							}else if(student.getCompleted().size()%3==2) {
								if(!group3.contains(student.getCompleted().get(student.getCompleted().size()-1).toString()) && !group3.contains(student.getCompleted().get(student.getCompleted().size()-2).toString())) {
									if(student.getCompleted().contains(group3.charAt(group3.indexOf(course)-1))) {
										student.getCompleted().add(course);
										isAdded=true;
										count++;
										student.getPreferences().remove(course);
										iterator--;
										if(iterator==student.getPreferences().size()-1)
											coursePlanner.setCoursePlannerState(coursePlanner.getGraduateState());
									}
								}
							}
						}				
					}
				}else {
					student.setPointer(iterator);
					coursePlanner.setCoursePlannerState(coursePlanner.getState4());
					break;
				}
			}
		}else {
			coursePlanner.setCoursePlannerState(coursePlanner.getGraduateState());
		}
		student.setSemestersTaken(student.getCompleted().size()/3+1);

		if(count>student.getStateCount()) {
			student.setStateCount(count);
			if(student.getGroup() == null ? group3 != null : !student.getGroup().equals(group3))
				student.setStateChanges(student.getStateChanges()+1);
			student.setGroup(group3);
		}
	}
}

