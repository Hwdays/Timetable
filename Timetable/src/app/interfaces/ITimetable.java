package app.interfaces;

public interface ITimetable {
    IDay get(int index);
    void updateDay(int index, IDay day);
}
