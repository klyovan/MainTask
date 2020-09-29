package com.example;

 class Course implements Comparable<Course> {

    private String name;
    private String duration;

    public Course(String name, String duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course{" +
            "name='" + name + '\'' +
            ", duration='" + duration + '\'' +
            '}';
    }

    @Override
    public int compareTo(Course course) {
        int compareDuration = Integer.parseInt(course.getDuration().replaceAll(":", ""));
        return Integer.parseInt(this.getDuration().replaceAll(":", "")) - compareDuration;
    }
}
