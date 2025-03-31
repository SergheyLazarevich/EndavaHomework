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


}
