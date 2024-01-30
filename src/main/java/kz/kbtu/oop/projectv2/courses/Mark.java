package kz.kbtu.oop.projectv2.courses;

import kz.kbtu.oop.projectv2.users.students.Student;

import java.util.Objects;

/**
 * Класс, представляющий оценку (Marks) студента по курсу.
 */
public class Mark{
    private Course course;
    private double points;
    private double firstAttestation;
    private double secondAttestation;
    private double finalExam;
    private double total;
    private double gpa;
    private double digit_mark;
    private String literalMark;
    private Student student;

    /**
     * Конструктор по умолчанию для создания объекта оценки.
     */
    public Mark() {}

    /**
     * Конструктор для создания объекта оценки с указанием курса и типа оценки.
     *
     * @param course     Курс, по которому ставится оценка.
     * @param typeOfMark Тип оценки (FIRST_ATTESTATION, SECOND_ATTESTATION, FINAL).
     */
    public Mark(Course course, TypeOfMark typeOfMark) {
        this.points = points;
        this.course =  course;
        switch (typeOfMark) {
            case FIRST_ATTESTATION -> this.setFirstAttestation(points);
            case SECOND_ATTESTATION -> this.setSecondAttestation(points);
            case FINAL -> this.setFinal(points);
        }
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    private double getPoints() {
        return this.points;
    }

    private void setPoints(double points) {
        this.points = points;
    }

    public double getFirstAttestation() {
        return this.firstAttestation;
    }

    public void setFirstAttestation(double first_attestation) {
        this.firstAttestation = first_attestation;
    }

    public double getSecondAttestation() {
        return this.secondAttestation;
    }

    public void setSecondAttestation(double secondAttestation) {
        this.secondAttestation = secondAttestation;
    }

    public double getFinal() {
        return this.finalExam;
    }

    public void setFinal(double finalExam) {
        this.finalExam = finalExam;
    }
    public double getTotal() {
        this.total = getFirstAttestation() + getSecondAttestation() + getFinal();
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getLiteralMark() {
        return this.literalMark;
    }

    public double getDigitMark() {
        return this.digit_mark;
    }

    private void setLiteralMark(String literalMark) {
        this.literalMark = literalMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark = (Mark) o;
        if (Double.compare(mark.points, points) != 0) return false;
        if (Double.compare(mark.firstAttestation, firstAttestation) != 0) return false;
        if (Double.compare(mark.secondAttestation, secondAttestation) != 0) return false;
        if (Double.compare(mark.finalExam, finalExam) != 0) return false;
        if (Double.compare(mark.total, total) != 0) return false;
        if (!literalMark.equals(mark.literalMark)) return false;
        return Objects.equals(student, mark.student);
    }

    public int hashCode() {
        return Objects.hash(points, firstAttestation, secondAttestation, finalExam);
    }

    public String toString() {
        return "Mark{" +
                "firstAttestation=" + firstAttestation +
                ", secondAttestation=" + secondAttestation +
                ", finalExam=" + finalExam +
                ", total=" + total +
                ", literalMark=" + literalMark +
                ", student=" + student +
                '}';
    }

    /**
     * Метод преобразует общий балл в оценку (literalMark и digit_mark).
     *
     * @param total Общий балл студента.
     */
    public void transformMark(double total) {
        if (total >= 94.5) {
            literalMark = "A";
            digit_mark = 4.0;
        }
        else if (total >= 89.5) {
            literalMark = "A-";
            digit_mark = 3.67;
        }
        else if (total >= 84.5) {
            literalMark = "B+";
            digit_mark = 3.33;
        }
        else if (total >= 79.5) {
            literalMark = "B";
            digit_mark = 3.0;
        }
        else if (total >= 74.5) {
            literalMark = "B-";
            digit_mark = 2.67;
        }
        else if (total >= 69.5) {
            literalMark = "C+";
            digit_mark = 2.33;
        }
        else if (total >= 64.5) {
            literalMark = "C";
            digit_mark = 2.0;
        }
        else if (total >= 59.5) {
            literalMark = "C-";
            digit_mark = 1.67;
        }
        else if (total >= 54.5) {
            literalMark = "D+";
            digit_mark = 1.33;
        }
        else if (total >= 50) {
            literalMark = "D";
            digit_mark = 1.0;
        }
        else {
            literalMark = "F";
            digit_mark = 0;
        }
    }

    /**
     * Метод для установки оценки по определенному типу оценки (FIRST_ATTESTATION, SECOND_ATTESTATION, FINAL).
     *
     * @param typeOfMark Тип оценки (FIRST_ATTESTATION, SECOND_ATTESTATION, FINAL).
     * @param points     Количество баллов для установки.
     */
    public void putMark(TypeOfMark typeOfMark, double points) {
        if (typeOfMark == TypeOfMark.FIRST_ATTESTATION) {
            this.setFirstAttestation(points);
        }
        else if (typeOfMark == TypeOfMark.SECOND_ATTESTATION) {
            this.setSecondAttestation(points);
        }
        else if (typeOfMark == TypeOfMark.FINAL) {
            this.setFinal(points);
            this.transformMark(this.getTotal());
        }
    }

}
