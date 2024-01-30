package kz.kbtu.oop.projectv2.courses;
import kz.kbtu.oop.projectv2.enums.LessonType;

/**
 * Класс, представляющий урок в рамках учебного курса.
 */
public class Lesson {
    private Course course;
    private LessonType type;
    private int room;

    /**
     * Конструктор по умолчанию для создания объекта урока.
     */
    public Lesson() {}

    /**
     * Конструктор для создания объекта урока с указанием курса, типа урока и номера аудитории.
     *
     * @param course Курс, к которому относится урок.
     * @param type   Тип урока (P - практика, L - лекция, OH - офисные часы).
     * @param room   Номер аудитории, где проходит урок.
     */
    public Lesson(Course course, LessonType type, int room) {
        this.course = course;
        this.type = type;
        this.room = room;
    }

    /**
     * Получает курс, к которому относится урок.
     *
     * @return Объект курса.
     */
    public Course getCourse() {
        return this.course;
    }

    /**
     * Устанавливает курс, к которому относится урок.
     *
     * @param course Объект курса для установки.
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    public LessonType getType() {
        return this.type; // P/L/OH
    }

    public void setLessonType(LessonType type) {
        this.type = type;
    }

    public int getRoom() {
        return this.room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    /**
     * Переопределенный метод toString для представления урока в виде строки.
     *
     * @return Строковое представление урока.
     */
    @Override
    public String toString() {
        return "Lesson{" +
                "course=" + course +
                ", type=" + type +
                ", room=" + room +
                '}';
    }
}
