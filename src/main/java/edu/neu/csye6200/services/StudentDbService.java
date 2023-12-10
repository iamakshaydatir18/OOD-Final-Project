package edu.neu.csye6200.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.neu.csye6200.models.Student;
import edu.neu.csye6200.models.StudentFactory;


public class StudentDbService {
    public static class FileUtility {

        public static List<Student> readFromFile(String filename) {
            List<Student> studentRoasterList = new ArrayList<Student>();
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                String inputLine = null;
                while ((inputLine = reader.readLine()) != null) {
                    String[] fields = inputLine.split(",");
                    int ID = Integer.parseInt(fields[0]);
                    String name = fields[1];
                    String password = fields[2];
                    List<Integer> registedcourse = new ArrayList<>();
                    for (int i = 3; i < fields.length; i++) {
                    	registedcourse.add(fields[i]);
                    }
//                    Create Student 
                    StudentFactory instance = StudentFactory.getInstance();
                    student = (Student)(instance.createUser()); 
                    student.setId(ID);
                    student.setName(name);
                    student.setPassword(password);
                    
                    for (int course: registedcourse) {
                    
                    	studentRoasterList.addCourse(course);
                    }
                    
                    
                    studentRoasterList.add();
                }
            } catch (IOException e) {
                System.err.println("Error reading from file: " + e.getMessage());
            }
            return studentRoasterList;
        }

        public static void writeToFile(List<Student> studentRosterList, String filename) {
            try (FileWriter writer = new FileWriter(filename, true)) {
                for (Student student : studentRosterList) {
                    writer.write(studentToCsvString(student));
                }
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
        }
        
        private static String studentToCsvString(Student student) {
            List<Integer> courses = student.getCourses();
            StringBuilder coursesString = new StringBuilder();
            for (int i = 0; i < courses.size(); i++) {
                coursesString.append(courses.get(i));
                if (i < courses.size() - 1) {
                    coursesString.append(",");
                }
            }
            return String.format("%d,%s,%s,%s", student.getId(), student.getName(), student.getPassword(), coursesString.toString());
        }
    }
}
