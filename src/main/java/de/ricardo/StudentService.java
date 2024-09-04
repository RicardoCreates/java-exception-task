package de.ricardo;

import java.util.List;
import java.util.UUID;

public class StudentService {

    private final StudentRepo repo = new StudentRepo();

    public Student addNewStudent(Student newStudent) {
        Student studentToSave = newStudent.withId(UUID.randomUUID().toString());
        return repo.save(studentToSave);
    }

    public List<Student> getAllStudents() {
        return repo.getAllStudents();
    }

    // Step 1: Implement the findById method
    public Student findById(String id) {
        return repo.findStudentById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found"));
    }
}
