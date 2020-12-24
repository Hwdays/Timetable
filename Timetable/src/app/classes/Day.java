package app.classes;

import app.interfaces.IDay;
import app.interfaces.ILesson;

import java.util.ArrayList;

public class Day implements IDay {
    private String title;
    private ArrayList<ILesson> lessons = new ArrayList<ILesson>();

    public Day(int index) {
        setTitle(index);
    }

    @Override
    public void setTitle(int index) {
        switch (index)
        {
            default:
            case 0: title = "Понедельник"; break;
            case 1: title = "Вторник"; break;
            case 2: title = "Среда"; break;
            case 3: title = "Четверг"; break;
            case 4: title = "Пятница"; break;
            case 5: title = "Суббота"; break;
            case 6: title = "Воскресенье"; break;
        }
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public ILesson getLesson(int index) {
        return lessons.get(index);
    }

    @Override
    public ArrayList<ILesson> getLessons() {
        return lessons;
    }

    @Override
    public void addLesson(ILesson lesson) {
        lessons.add(lesson);
    }

    @Override
    public void removeLesson(int index) {
        lessons.remove(index);
    }

    @Override
    public void updateLesson(int index, ILesson lesson) {
        lessons.set(index, lesson);
    }
}
