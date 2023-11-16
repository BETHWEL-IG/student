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
public class Graduate implements CourseSequencerStateI {

	CourseSequencer coursePlanner;
	private final String graduateRequirements1="ABEFIJMN";
	private final String graduateRequirements2="QRSTUVWXYZ";

	public Graduate(CourseSequencer inCoursePlanner) {
		coursePlanner = inCoursePlanner;
	}


        @Override
	public void preRequisiteValidation(Student student) {
		int count1=0, count2=0;
		Boolean flag=false;
		int flag1=0;
		String group1="ABCD";
		String group2="EFGH";
		String group3="IJKL";
		String group4="MNOP";
		if(!student.getPreferences().isEmpty()) {
			for(int iterator=0;iterator<graduateRequirements1.length();iterator++) {
				if(student.getCompleted().contains(graduateRequirements1.charAt(iterator))) {
					count1++;
				}else{
					flag=true;
					break;
				}

			}
			if(!flag) {
				for(int iterator=0;iterator<graduateRequirements2.length();iterator++) {
					if(student.getCompleted().contains(graduateRequirements2.charAt(iterator))) {
						count2++;
					}
					if(count2==2) {
						break;
					}
				}
			}
			if(count1==8 && count2==2) {
				student.setIsGraduated(true);
				student.getPreferences().clear();
			}else {
				if(!student.getPreferences().isEmpty()) {
					for(int iterator=0;iterator<graduateRequirements1.length();iterator++) {
						if(student.getPreferences().contains(graduateRequirements1.charAt(iterator))) {
							student.setPointer(0);
							coursePlanner.setCoursePlannerState(coursePlanner.getState1());
							flag1=1;
							break;
						}
					}
					if(flag1==0) {
						for(int iterator=0;iterator<graduateRequirements1.length();iterator++) {
							if(student.getPreferences().contains(graduateRequirements1.charAt(iterator))) {
								student.setPointer(0);
								coursePlanner.setCoursePlannerState(coursePlanner.getState1());
								flag1=1;
								break;
							}
						}
		if(flag1==0) {				
						for(int iterator=0;iterator<graduateRequirements1.length();iterator++) {
								if(student.getCompleted().contains(graduateRequirements1.charAt(iterator))) {
									continue;
								}else{
									flag1=2;
									break;
								}

							}
							if(flag1==2) {
								student.getPreferences().clear();
								coursePlanner.setCoursePlannerState(coursePlanner.getNotGraduateState());
							}else {
								for(int iterator=0;iterator<graduateRequirements2.length();iterator++) {
									if(student.getPreferences().contains(graduateRequirements2.charAt(iterator))) {
										student.setPointer(0);
										coursePlanner.setCoursePlannerState(coursePlanner.getState5());
										flag1=4;
										break;
									}
								}
								if(flag1!=4) {
									int counter=0;
									for(int iterator=0;iterator<graduateRequirements2.length();iterator++) {
										if(student.getCompleted().contains(graduateRequirements2.charAt(iterator))) {
											counter++;
										}	
									}
									if(counter<2) {
										student.getPreferences().clear();
										coursePlanner.setCoursePlannerState(coursePlanner.getNotGraduateState());
									}
									
								}
							}
		}
						
					}
					if(student.getCompleted().size()%3!=0) {
						for(int iterator=0;iterator<student.getPreferences().size();iterator++) {
							if(group1.contains(student.getPreferences().get(iterator).toString())) {
								int index=group1.indexOf(student.getPreferences().get(iterator).toString());
								if(index!=0) {
									if(!student.getCompleted().contains(group1.charAt(index-1))&&!student.getPreferences().contains(group1.charAt(index-1))) {
										student.getPreferences().remove(student.getPreferences().get(iterator));
										iterator--;
									}	
								}
							}else if(group2.contains(student.getPreferences().get(iterator).toString())) {
								int index=group2.indexOf(student.getPreferences().get(iterator).toString());
								if(index!=0) {
									if(!student.getCompleted().contains(group2.charAt(index-1))&&!student.getPreferences().contains(group2.charAt(index-1))) {
										student.getPreferences().remove(student.getPreferences().get(iterator));
										iterator--;
									}	
								}
							}else if(group3.contains(student.getPreferences().get(iterator).toString())) {
								int index=group3.indexOf(student.getPreferences().get(iterator).toString());
								if(index!=0) {
									if(!student.getCompleted().contains(group3.charAt(index-1))&&!student.getPreferences().contains(group3.charAt(index-1))) {
										student.getPreferences().remove(student.getPreferences().get(iterator));
										iterator--;
									}	
								}
							}else if(group4.contains(student.getPreferences().get(iterator).toString())) {
								int index=group4.indexOf(student.getPreferences().get(iterator).toString());
								if(index!=0) {
									if(!student.getCompleted().contains(group4.charAt(index-1))&&!student.getPreferences().contains(group4.charAt(index-1))) {
										student.getPreferences().remove(student.getPreferences().get(iterator));
										iterator--;
									}	
								}
							}
						}
						if(!student.getPreferences().isEmpty()) {
							if(group1.contains(student.getCompleted().get(student.getCompleted().size()-1).toString())) {
								Boolean check=false;
								for(int iterator=0;iterator<group1.length();iterator++) {
									if(group1.charAt(iterator)!=student.getCompleted().get(student.getCompleted().size()-1)) {
										if(student.getPreferences().contains(group1.charAt(iterator))) {
                                                                                } else {
											check=true;
											break;
										}
									}
								}
								if(!check && student.getPreferences().size()<=3) {
									student.getPreferences().clear();
									coursePlanner.setCoursePlannerState(coursePlanner.getNotGraduateState());
								}
							}else if(group2.contains(student.getCompleted().get(student.getCompleted().size()-1).toString())) {
								Boolean check=false;
								for(int iterator=0;iterator<group2.length();iterator++) {
									if(group2.charAt(iterator)!=student.getCompleted().get(student.getCompleted().size()-1)) {
										if(student.getPreferences().contains(group2.charAt(iterator))) {
                                                                                } else {
											check=true;
											break;
										}
									}
								}
								if(!check && student.getPreferences().size()<=3) {
									student.getPreferences().clear();
									coursePlanner.setCoursePlannerState(coursePlanner.getNotGraduateState());
								}
							}else if(group3.contains(student.getCompleted().get(student.getCompleted().size()-1).toString())) {
								Boolean check=false;
								for(int iterator=0;iterator<group3.length();iterator++) {
									if(group3.charAt(iterator)!=student.getCompleted().get(student.getCompleted().size()-1)) {
										if(student.getPreferences().contains(group3.charAt(iterator))) {
                                                                                } else {
											check=true;
											break;
										}
									}
								}
								if(!check && student.getPreferences().size()<=3) {
									student.getPreferences().clear();
									coursePlanner.setCoursePlannerState(coursePlanner.getNotGraduateState());
								}
							}else if(group4.contains(student.getCompleted().get(student.getCompleted().size()-1).toString())) {
								Boolean check=false;
								for(int iterator=0;iterator<group4.length();iterator++) {
									if(group4.charAt(iterator)!=student.getCompleted().get(student.getCompleted().size()-1)) {
										if(student.getPreferences().contains(group4.charAt(iterator))) {
                                                                                } else {
											check=true;
											break;
										}
									}
								}
								if(!check && student.getPreferences().size()<=3) {
									student.getPreferences().clear();
									coursePlanner.setCoursePlannerState(coursePlanner.getNotGraduateState());
								}
							}
						}
					}

				}else {
					coursePlanner.setCoursePlannerState(coursePlanner.getNotGraduateState());
				}
			}

		}else {
			for(int iterator=0;iterator<graduateRequirements1.length();iterator++) {
				if(student.getCompleted().contains(graduateRequirements1.charAt(iterator))) {
					count1++;
				}else{
					flag=true;
					break;
				}

			}
			if(!flag) {
				for(int iterator=0;iterator<graduateRequirements2.length();iterator++) {
					if(student.getCompleted().contains(graduateRequirements2.charAt(iterator))) {
						count2++;
					}
					if(count2==2) {
						break;
					}
				}
			}
			if(count1==8 && count2==2) {
				student.setIsGraduated(true);
				student.getPreferences().clear();
			}else {
				coursePlanner.setCoursePlannerState(coursePlanner.getNotGraduateState());
			}
		}

	}

}

