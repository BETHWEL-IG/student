
package courseSequencer.state;
import courseSequencer.context.CourseSequencer;
import courseSequencer.data.Student;


public class DataStructuresAndAlgorithms implements CourseSequencerStateI {

	CourseSequencer courseSequencer;
	private final String group2="EFGH";
	int count=0;

	public DataStructuresAndAlgorithms(CourseSequencer inCourseSequencer) {
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
				if(group2.contains(course.toString())){
					if(course=='E') {
						student.getCompleted().add(course);
						isAdded=true;
						count++;
						student.getPreferences().remove(course);
						iterator--;
						if(iterator==student.getPreferences().size()-1)
							courseSequencer.setCoursePlannerState(courseSequencer.getGraduateState());
					}else{
						if(student.getCompleted().size()%3==0) {

							if(student.getCompleted().contains(group2.charAt(group2.indexOf(course)-1))) {
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
								if(!group2.contains(student.getCompleted().get(student.getCompleted().size()-1).toString())) {
									if(student.getCompleted().contains(group2.charAt(group2.indexOf(course)-1))) {
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
								if(!group2.contains(student.getCompleted().get(student.getCompleted().size()-1).toString()) && !group2.contains(student.getCompleted().get(student.getCompleted().size()-2).toString())) {
									if(student.getCompleted().contains(group2.charAt(group2.indexOf(course)-1))) {
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
					courseSequencer.setCoursePlannerState(courseSequencer.getState3());
					break;
				}
			}

		}else {
			courseSequencer.setCoursePlannerState(courseSequencer.getGraduateState());
		}
		student.setSemestersTaken(student.getCompleted().size()/3+1);

		if(count>student.getStateCount()) {
			student.setStateCount(count);
			if(student.getGroup() == null ? group2 != null : !student.getGroup().equals(group2))
				student.setStateChanges(student.getStateChanges()+1);
			student.setGroup(group2);
		}
	}
}
