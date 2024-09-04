package de.ricardo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    @Test
    public void testFindById_StudentExists() {
        StudentService studentService = new StudentService();
        Student newStudent = Student.builder()
                .name("John Doe")
                .subject("Mathematics")
                .build();
        Student savedStudent = studentService.addNewStudent(newStudent);

        Student foundStudent = studentService.findById(savedStudent.id());
        assertEquals(savedStudent, foundStudent);
    }

    @Test
    public void testFindById_StudentDoesNotExist() {
        StudentService studentService = new StudentService();

        Exception exception = assertThrows(StudentNotFoundException.class, () -> {
            studentService.findById("nonexistent-id");
        });

        String expectedMessage = "Student with ID nonexistent-id not found";
        String actualMessage = exception.getMessage();

        System.out.println(actualMessage);
        assertTrue(actualMessage.contains(expectedMessage));
    }
}