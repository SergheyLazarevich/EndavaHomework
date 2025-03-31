package org.example;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;


public class StudentMapTest {

    private StudentMap studentMap;

    @BeforeEach
    public void setUp() {
        studentMap = new StudentMap();
    }

    @Test
    public void testPutAndGet() {
        Student student = new Student("John Doe", LocalDate.of(2000, 5, 12), "john@example.com");
        studentMap.put(student, 100);

        assertThat(studentMap.get(student)).isEqualTo(100);
    }

    @Test
    public void testContainsKey() {
        Student student = new Student("John Doe", LocalDate.of(2000, 5, 12), "john@example.com");
        studentMap.put(student, 100);

        assertThat(studentMap.containsKey(student)).isTrue();
    }

    @Test
    public void testContainsValue() {
        Student student = new Student("John Doe", LocalDate.of(2000, 5, 12), "john@example.com");
        studentMap.put(student, 100);

        assertThat(studentMap.containsValue(100)).isTrue();
    }

    @Test
    public void testRemove() {
        Student student = new Student("John Doe", LocalDate.of(2000, 5, 12), "john@example.com");
        studentMap.put(student, 100);
        studentMap.remove(student);

        assertThat(studentMap.containsKey(student)).isFalse();
    }

    @Test
    public void testSize() {
        Student student1 = new Student("John Doe", LocalDate.of(2000, 5, 12), "john@example.com");
        Student student2 = new Student("Jane Doe", LocalDate.of(2000, 7, 15), "jane@example.com");
        studentMap.put(student1, 100);
        studentMap.put(student2, 200);

        assertThat(studentMap.size()).isEqualTo(2);
    }

    @Test
    public void testResize() {
        for (int i = 0; i < 20; i++) {
            studentMap.put(new Student("Student " + i, LocalDate.of(2000, 1, 1), "student" + i + "@example.com"), i);
        }
        assertThat(studentMap.size()).isGreaterThan(16);
    }

    @Test
    public void testCollisions() {
        Student student1 = new Student("John Doe", LocalDate.of(2000, 5, 12), "john@example.com");
        Student student2 = new Student("Jane Doe", LocalDate.of(2000, 7, 15), "jane@example.com");

        studentMap.put(student1, 100);
        studentMap.put(student2, 200);

        assertThat(studentMap.get(student1)).isEqualTo(100);
        assertThat(studentMap.get(student2)).isEqualTo(200);
    }

    @Test
    public void testClear() {
        Student student1 = new Student("John Doe", LocalDate.of(2000, 5, 12), "john@example.com");
        studentMap.put(student1, 100);

        studentMap.clear();

        assertThat(studentMap.isEmpty()).isTrue();
        assertThat(studentMap.containsKey(student1)).isFalse();
    }


}
