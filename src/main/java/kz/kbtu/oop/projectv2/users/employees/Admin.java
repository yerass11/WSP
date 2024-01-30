package kz.kbtu.oop.projectv2.users.employees;

import kz.kbtu.oop.projectv2.courses.Course;
import kz.kbtu.oop.projectv2.users.User;
import kz.kbtu.oop.projectv2.users.students.PhDStudent;
import kz.kbtu.oop.projectv2.users.students.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Admin extends Employee {
    public User createUser(User user) {
        return User.addUser(user);
    }

    public void deleteUser(Student user) {
        User.removeUser(user);
    }

    public Course createCourse(Course course) {
        return Course.addCourseToRegistry(course);
    }

    public void deleteCourse(Course course) {
        Course.removeCourseFromRegistry(course);
    }

    public Vector<String> readLogsBySubstr(String subStr, boolean stdOut) {
        String filePath = "logs/global.log";
        Vector<String> logBuffer = new Vector<>();
        try (FileReader fileReader = new FileReader(filePath); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (!line.contains(subStr)) {
                    continue;
                }

                if (stdOut) {
                    System.out.println(line);
                }

                logBuffer.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("error while reading logs");
        }
        return logBuffer;
    }
}
