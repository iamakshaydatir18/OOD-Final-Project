package controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import models.Course;
import models.CourseFactory;

@RestController
public class CourseController {
    @GetMapping("/courses")
    public String getCourseList() {

        CourseFactory instance = CourseFactory.getInstance();
        ArrayList<Course> demoCourses = new ArrayList<>();
        Course course1 = instance.createCourse();
        course1.setCourseName("Sample Course 1");
        course1.setCourseCredit(3);
        course1.setCourseDescription("This is a sample course for testing purposes");
        course1.setCourseId(123);

        Course course2 = instance.createCourse();
        course2.setCourseName("Sample Course 2");
        course2.setCourseCredit(3);
        course2.setCourseDescription("This is a sample course for testing purposes");
        course2.setCourseId(124);

        Course course3 = instance.createCourse();
        course3.setCourseName("Sample Course 3");
        course3.setCourseCredit(3);
        course3.setCourseDescription("This is a sample course for testing purposes");
        course3.setCourseId(125);

        Course course4 = instance.createCourse();
        course4.setCourseName("Sample Course 4");
        course4.setCourseCredit(3);
        course4.setCourseDescription("This is a sample course for testing purposes");
        course4.setCourseId(126);

        demoCourses.add(course1);
        demoCourses.add(course2);
        demoCourses.add(course3);
        demoCourses.add(course4);

        return("Hail Hitler");

    }

    @PostMapping("/courses/add")
    public void addCourse() {

    }

    @PostMapping("/courses/remove")
    public void removeCourse() {

    }
}
