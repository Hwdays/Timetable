package app.classes;

import app.interfaces.ILesson;

public class Lesson implements ILesson {
    private String title;
    private String teacher;
    private String start;
    private String end;
    private String classRoom;

    @Override
    public void setTitle(String title_) {
        title = title_;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTeacher(String teacher_) {
        teacher = teacher_;
    }

    @Override
    public String getTeacher() {
        return teacher;
    }

    @Override
    public void setClassRoom(String classRoom_) {
        classRoom = classRoom_;
    }

    @Override
    public String getClassRoom() {
        return classRoom;
    }

    @Override
    public void setStartTime(String start_) {
        start = start_;
    }

    @Override
    public String getStartTime() {
        return start;
    }

    @Override
    public void setEndTime(String end_) {
        end = end_;
    }

    @Override
    public String getEndTime() {
        return end;
    }
}
