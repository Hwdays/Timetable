package app.classes;

import app.interfaces.IDay;
import app.interfaces.ITimetable;

import java.util.ArrayList;

public class Timetable implements ITimetable {
    private ArrayList<IDay> days = new ArrayList<IDay>();

    public Timetable() {
        for(int i = 0; i <7; ++i)
            days.add(new Day(i));
    }

    @Override
    public IDay get(int index) {
        return days.get(index);
    }

    @Override
    public void updateDay(int index, IDay day) {

    }
}
