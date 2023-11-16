
package courseSequencer.data;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private int id;
	private int stateChanges;
	private int semestersTaken;
	private int pointer;
	private int stateCount;
	private String group="ABCD";
	private List<Character> preferences= new ArrayList<>();
	private List<Character> completed= new ArrayList<>();
	private Boolean isGraduated=false;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStateChanges() {
		return stateChanges;
	}
	public void setStateChanges(int stateChanges) {
		this.stateChanges = stateChanges;
	}	
	public int getSemestersTaken() {
		return semestersTaken;
	}
	public void setSemestersTaken(int semestersTaken) {
		this.semestersTaken = semestersTaken;
	}
	
	public int getPointer() {
		return pointer;
	}
	public void setPointer(int pointer) {
		this.pointer = pointer;
	}
	
	public int getStateCount() {
		return stateCount;
	}
	public void setStateCount(int stateCount) {
		this.stateCount = stateCount;
	}
	
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public Boolean getIsGraduated() {
		return isGraduated;
	}
	public void setIsGraduated(Boolean isGraduated) {
		this.isGraduated = isGraduated;
	}
	public List<Character> getPreferences() {
		return preferences;
	}
	public void setPreferences(List<Character> preferences) {
		this.preferences = preferences;
	}
	
	public List<Character> getCompleted() {
		return completed;
	}
	public void setCompleted(List<Character> completed) {
		this.completed = completed;
	}
}

