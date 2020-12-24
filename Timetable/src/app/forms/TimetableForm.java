package app.forms;

import app.classes.Lesson;
import app.classes.Timetable;
import app.interfaces.IDay;
import app.interfaces.ILesson;
import app.interfaces.ITimetable;

import javax.swing.BoxLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimetableForm extends JFrame {
    private ITimetable timetable;
    private JPanel panel;
    private JButton edit;
    private JButton update;
    private JPanel content;

    public TimetableForm() {
        timetable = new Timetable();
        ILesson l = new Lesson();
        l.setTitle("Пример");
        timetable.get(0).addLesson(l);

        setContentPane(panel);
        setVisible(true);
        setTitle("Расписание занятий");
        setSize(1000, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        content.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 20));
        content.add(new DayPane(timetable.get(0)));
        content.add(new DayPane(timetable.get(1)));
        content.add(new DayPane(timetable.get(2)));
        content.add(new DayPane(timetable.get(3)));
        content.add(new DayPane(timetable.get(4)));
        content.add(new DayPane(timetable.get(5)));
        content.add(new DayPane(timetable.get(6)));

        content.validate();
        content.repaint();

        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditForm f = new EditForm(timetable);
                f.setVisible(true);
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                content.removeAll();

                content.add(new DayPane(timetable.get(0)));
                content.add(new DayPane(timetable.get(1)));
                content.add(new DayPane(timetable.get(2)));
                content.add(new DayPane(timetable.get(3)));
                content.add(new DayPane(timetable.get(4)));
                content.add(new DayPane(timetable.get(5)));
                content.add(new DayPane(timetable.get(6)));

                content.validate();
                content.repaint();
            }
        });
    }

    public class DayPane extends JPanel {

        public DayPane(IDay day) {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JLabel label = new JLabel(day.getTitle());
            label.setFont(label.getFont().deriveFont(Font.BOLD));
            add(label);

            int index = 1;
            for(ILesson lesson : day.getLessons()) {
                add(new LessonPane(index, lesson));
                ++index;
            }
        }
    }

    public class LessonPane extends JPanel {

        public LessonPane(int index, ILesson lesson) {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            add("Название", lesson.getTitle());
            add("Кабинет", lesson.getClassRoom());
            add("ФИО преподавателя", lesson.getTeacher());
            add("Время начала", lesson.getStartTime());
            add("Время окончания", lesson.getEndTime());
            setBorder( BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Пара №" + String.valueOf(index)) );
        }

        private void add(String title, String value) {
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());

            JLabel label = new JLabel(title + ": ");
            label.setFont(label.getFont().deriveFont(Font.BOLD));

            JLabel lvalue = new JLabel(value);

            panel.add(label);
            panel.add(lvalue);

            add(panel);
        }
    }
}
