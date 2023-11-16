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
public class NotGraduated implements CourseSequencerStateI {

	public NotGraduated(CourseSequencer inCoursePlanner) {
	}


        @Override
	public void preRequisiteValidation(Student student) {
		student.setSemestersTaken(0);
		student.setIsGraduated(false);
	}

}

