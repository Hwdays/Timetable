package app.interfaces;

import java.util.ArrayList;

public interface IDay {
    void setTitle(int index);
    String getTitle();

    ILesson getLesson(int index);
    ArrayList<ILesson> getLessons();
    void addLesson(ILesson lesson);
    void removeLesson(int index);
    void updateLesson(int index, ILesson lesson);
}
