package Assigment;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherScheduler {

    public static void main(String[] args) {
        List<Teacher> teachers = createTeachers();
        List<Subject> subjects = createSubjects();

        generateTimeslots(teachers);
        assignSubjects(teachers, subjects);
        displaySchedules(teachers);
    }

    // ... other methods ...

    static List<Teacher> createTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("John"));
        teachers.add(new Teacher("Alice"));
        // Add more teachers if needed
        return teachers;
    }

    static List<Subject> createSubjects() {
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("Math", List.of("Algebra", "Calculus")));
        subjects.add(new Subject("Science", List.of("Physics", "Chemistry")));
        // Add more subjects if needed
        return subjects;
    }

    static void generateTimeslots(List<Teacher> teachers) {
        for (Teacher teacher : teachers) {
            Assignment.Schedule schedule = teacher.getSchedule();
            for (DayOfWeek day : DayOfWeek.values()) {
                if (day.equals(DayOfWeek.SATURDAY) || day.equals(DayOfWeek.SUNDAY)) {
                    continue; // Skip weekends in the simple approach
                }
                schedule.addTimeslot(String.valueOf(day), new Assignment.TimeSlot("9:00 AM", "10:00 AM"));
                schedule.addTimeslot(String.valueOf(day), new Assignment.TimeSlot("10:30 AM", "11:30 AM"));
            }
        }
    }

    static void assignSubjects(List<Teacher> teachers, List<Subject> subjects) {
        // Your logic for assigning subjects to teachers goes here
        // You can modify the Teacher and Subject classes accordingly
        // For example, you can add a method in the Teacher class to assign a subject.
    }

    static void displaySchedules(List<Teacher> teachers) {
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }
}

class Teacher {

    private String name;
    private List<String> skills;
    private Assignment.Schedule schedule;

    public Teacher(String name) {
        this.name = name;
        this.skills = new ArrayList<>();
        this.schedule = new Assignment.Schedule();
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void addSkill(String skill) {
        skills.add(skill);
    }

    public void removeSkill(String skill) {
        skills.remove(skill);
    }

    public Assignment.Schedule getSchedule() {
        return schedule;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", skills=" + skills +
                ", schedule=" + schedule +
                '}';
    }
}

class Skill {

    private String name;

    public Skill(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return name.equals(skill.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Assignment {

    static class Schedule {

        private Map<String, List<TimeSlot>> days;

        public Schedule() {
            this.days = new HashMap<>();
            for (DayOfWeek day : DayOfWeek.values()) {
                this.days.put(String.valueOf(day), new ArrayList<>());
            }
        }

        public List<TimeSlot> getTimeslots(String day) {
            return days.get(day);
        }

        public void addTimeslot(String day, TimeSlot timeslot) {
            days.get(day).add(timeslot);
        }

        public boolean removeTimeslot(String day, TimeSlot timeslot) {
            return days.get(day).remove(timeslot);
        }


        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (String day : days.keySet()) {
                sb.append(day).append(": ");
                for (TimeSlot slot : days.get(day)) {
                    sb.append(slot).append(", ");
                }
                sb.append("\n");
            }
            return sb.toString().trim();
        }
    }

    static class TimeSlot {

        private String startTime;
        private String endTime;

        public TimeSlot(String startTime, String endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public String getStartTime() {
            return startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        @Override
        public String toString() {
            return startTime + " - " + endTime;
        }
    }
}

class Subject {

    private String name;
    private List<String> requiredSkills;

    public Subject(String name, List<String> requiredSkills) {
        this.name = name;
        this.requiredSkills = requiredSkills;
    }

    public String getName() {
        return name;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public boolean hasRequiredSkill(String skill) {
        return requiredSkills.contains(skill);
    }

    @Override
    public String toString() {
        return name;
    }
}
