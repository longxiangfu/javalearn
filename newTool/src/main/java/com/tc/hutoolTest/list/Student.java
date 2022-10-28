package com.tc.hutoolTest.list;

import java.util.Objects;

public class Student {
    private long termId;//学期id
    private long classId;//班级id
    private long studentId;//班级id
    private String name;//学生名称

    public long getTermId() {
        return termId;
    }

    public void setTermId(long termId) {
        this.termId = termId;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getTermId() == student.getTermId() &&
                getClassId() == student.getClassId() &&
                getStudentId() == student.getStudentId() &&
                Objects.equals(getName(), student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTermId(), getClassId(), getStudentId(), getName());
    }


    public Student(long termId, long classId, long studentId, String name) {
        this.termId = termId;
        this.classId = classId;
        this.studentId = studentId;
        this.name = name;
    }
}
