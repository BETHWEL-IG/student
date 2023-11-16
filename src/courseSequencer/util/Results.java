
package courseSequencer.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import courseSequencer.data.Student;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

        @Override
	public void writeToFile(String pathToFile, Student student) {

		File file=new File(pathToFile);

		FileWriter fileWriter=null;
		try {
			fileWriter=new FileWriter(file);
			fileWriter.write(""+student.getId());
			fileWriter.write(": ");

			if(student.getIsGraduated()) {
				Iterator<Character> iterator=student.getCompleted().iterator();
				while(iterator.hasNext()) {
					fileWriter.write(" "+iterator.next());
				}

				fileWriter.write(" -- ");
				fileWriter.write(student.getSemestersTaken()+" ");
				fileWriter.write(""+student.getStateChanges());
			}else {
				fileWriter.write("Student does not satisfy graduation requirements");
				fileWriter.write(" -- ");
				fileWriter.write(student.getSemestersTaken()+" ");
				fileWriter.write(""+student.getStateChanges());
			}

		} catch (IOException ioe) {
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException ioe) {
			}}
	}

        @Override
	public void writeToConsole(Student student) {

		System.out.print(student.getId());
		System.out.print(": ");
		if(student.getIsGraduated()) {
			Iterator<Character> iterator=student.getCompleted().iterator();
			while(iterator.hasNext()) {
				System.out.print(" "+iterator.next());
			}
			System.out.print(" -- ");
			System.out.print(student.getSemestersTaken()+" ");
			System.out.print(student.getStateChanges());
		}else {
			System.out.print("Student does not satisfy graduation requirements");
			System.out.print(" -- ");
			System.out.print(student.getSemestersTaken()+" ");
			System.out.print(student.getStateChanges());
		}
	}
}

