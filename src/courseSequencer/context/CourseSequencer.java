
package courseSequencer.context;


import courseSequencer.data.Student;
import courseSequencer.state.CourseSequencerStateI;
import courseSequencer.state.DataAnalytics;
import courseSequencer.state.DataStructuresAndAlgorithms;
import courseSequencer.state.Electives;
import courseSequencer.state.Graduate;
import courseSequencer.state.HardwareSequence;
import courseSequencer.state.LongProgrammingAndDesign;
import courseSequencer.state.NotGraduated;

public class CourseSequencer {
	
	CourseSequencerStateI courseSequencerStateI;
	
	CourseSequencerStateI courseSequencerState1;
	CourseSequencerStateI courseSequencerState2;
	CourseSequencerStateI courseSequencerState3;
	CourseSequencerStateI courseSequencerState4;
	CourseSequencerStateI courseSequencerState5;
	CourseSequencerStateI studentGraduated;
	CourseSequencerStateI studentNotGraduated;
        
	
	
	public CourseSequencer() {
		courseSequencerState1 = new LongProgrammingAndDesign(this);
		courseSequencerState2 = new DataStructuresAndAlgorithms(this);
		courseSequencerState3 = new HardwareSequence(this);
		courseSequencerState4 = new DataAnalytics(this);
		courseSequencerState5 = new Electives(this);
		studentGraduated = new Graduate(this);
		studentNotGraduated = new NotGraduated(this);
		courseSequencerStateI = courseSequencerState1;
	}
	
	public void setCoursePlannerState(CourseSequencerStateI inCoursePlannerStateI) {
		courseSequencerStateI=inCoursePlannerStateI;
	}
	
	public CourseSequencerStateI getCoursePlannerState() {
		return courseSequencerStateI;
	}
        
	public void preRequisiteValidation(Student student) {
            courseSequencerStateI.preRequisiteValidation(student);
        }

	public CourseSequencerStateI getState1() {
		return courseSequencerState1;
	}
	
	public CourseSequencerStateI getState2() {
		return courseSequencerState2;
	}
	
	public CourseSequencerStateI getState3() {
		return courseSequencerState3;
	}
	
	public CourseSequencerStateI getState4() {
		return courseSequencerState4;
	}
	
	public CourseSequencerStateI getState5() {
		return courseSequencerState5;
	}
	
	public CourseSequencerStateI getGraduateState() {
		return studentGraduated;
	}
	public CourseSequencerStateI getNotGraduateState() {
		return studentNotGraduated;
	}
}

