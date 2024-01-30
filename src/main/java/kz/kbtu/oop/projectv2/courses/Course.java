package kz.kbtu.oop.projectv2.courses;

import kz.kbtu.oop.projectv2.users.employees.Teacher;
import kz.kbtu.oop.projectv2.users.students.Student;

import java.util.*;

/**
 * Класс, представляющий учебный курс.
 */
public class Course {
    private static final Set<Course> courseRegistry = new HashSet<>();

    private String courseId;
    private String courseName;
    private int credits;
    private List<Teacher> instructors;
    private List<Student> students;
    private HashMap<Student, Mark> marks = new HashMap<>();

    /**
     * Конструктор по умолчанию для создания объекта курса.
     */
    public Course() {
        this.instructors = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    /**
     * Конструктор для создания объекта курса с указанием идентификатора и названия курса.
     *
     * @param courseId   Идентификатор курса.
     * @param courseName Название курса.
     */
    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = 0; // You may want to provide a default value for credits
        this.instructors = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    /**
     * Конструктор для создания объекта курса с указанием всех параметров.
     *
     * @param courseId    Идентификатор курса.
     * @param courseName  Название курса.
     * @param credits     Количество кредитов.
     * @param instructors Преподаватели курса.
     * @param students    Студенты, записанные на курс.
     */
    public Course(String courseId, String courseName, int credits, List<Teacher> instructors, List<Student> students) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.instructors = instructors;
        this.students = students;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public List<Teacher> getInstructors() {
        return instructors;
    }

    /**
     * Метод для добавления преподавателя курса.
     *
     * @param teacher Преподаватель для добавления.
     */
    public void addInstructor(Teacher teacher) {
        instructors.add(teacher);
    }

    public List<Student> getStudents() {
        return students;
    }

    /**
     * Метод для добавления студента на курс и инициализации его оценки.
     *
     * @param student Студент для добавления.
     */
    public void addStudent(Student student) {
        students.add(student);
        Mark m = new Mark();
        m.setStudent(student);
        marks.put(student, m);
    }

    public HashMap<Student, Mark> getMarks() {
        return marks;
    }

    public void setMarks(HashMap<Student, Mark> marks) {
        this.marks = marks;
    }

    /**
     * Метод для установки оценки студенту по указанному типу оценки.
     *
     * @param student    Студент, которому устанавливается оценка.
     * @param points     Количество баллов.
     * @param typeOfMark Тип оценки (FIRST_ATTESTATION, SECOND_ATTESTATION, FINAL).
     */
    public void putMark(Student student, double points, TypeOfMark typeOfMark) {
        try {
            Mark mark = marks.get(student);
            mark.putMark(typeOfMark, points);
            System.out.println("Successful operation");
        } catch(Exception e) {
            System.out.println("Unsuccessful operation: This student is not " +
                    "registered in this course.");
        }

    }

    /**
     * Переопределенный метод toString для представления курса в виде строки.
     *
     * @return Строковое представление курса.
     */
    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", instructors=" + instructors +
                ", students=" + students +
                '}';
    }

    /**
     * Статический метод для добавления курса в регистрацию курсов.
     *
     * @param course Курс для добавления в регистрацию.
     */
    public static Course addCourseToRegistry(Course course) {
        courseRegistry.add(course);
        return course;
    }

    /**
     * Статический метод для удаления курса из регистрации курсов.
     *
     * @param course Курс для удаления из регистрации.
     */
    public static void removeCourseFromRegistry(Course course) {
        courseRegistry.remove(course);
    }

    /**
     * Статический метод для поиска курса в регистрации по идентификатору.
     *
     * @param courseId Идентификатор курса для поиска.
     * @return Курс, если найден, иначе null.
     */
    public static Course findCourseAtRegistry(String courseId) {
        for (Course course : courseRegistry) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    /**
     * Метод для вычисления среднего GPA всех студентов на курсе.
     *
     * @return Средний GPA.
     */
    public double calculateAverageGpa() {
        if (students.isEmpty()) {
            System.out.println("No students in the course.");
            return 0.0;
        }

        double totalGpa = 0.0;
        int studentCount = 0;

        for (Student student : students) {
            Mark mark = marks.get(student);
            if (mark != null) {
                double gpa = mark.getDigitMark();
                totalGpa += gpa;
                studentCount++;
            }
        }

        if (studentCount > 0) {
            return totalGpa / studentCount;
        } else {
            System.out.println("No GPA information available for any student.");
            return 0.0;
        }
    }

}
