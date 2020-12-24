package app.interfaces;

public interface ILesson {
    void setTitle(String title);
    String getTitle();

    void setTeacher(String teacher);
    String getTeacher();

    void setClassRoom(String classRoom);
    String getClassRoom();

    void setStartTime(String start);
    String getStartTime();

    void setEndTime(String end);
    String getEndTime();
}
