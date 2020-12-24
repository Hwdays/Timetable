package app.forms;

import app.classes.Lesson;
import app.interfaces.IDay;
import app.interfaces.ILesson;
import app.interfaces.ITimetable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class EditForm extends JFrame {
    private ITimetable timetable;
    private JComboBox weekday;
    private JTextField index;
    private JTextField classRoom;
    private JTextField start;
    private JTextField end;
    private JButton add;
    private JPanel panel;
    private JTextField title;
    private JButton delete;
    private JTextField teacher;

    private String[] weekdayTitle = {
            "Понедельник",
            "Вторник",
            "Среда",
            "Четверг",
            "Пятница",
            "Суббота",
            "Воскресенье",
    };

    public EditForm(ITimetable timetable_) {
        timetable = timetable_;
        setVisible(true);
        setTitle("Редактирование");
        setContentPane(panel);
        setSize(500, 400);

        weekday.setModel(new DefaultComboBoxModel<>(weekdayTitle));

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ILesson lesson = new Lesson();
                lesson.setTitle(title.getText());
                lesson.setClassRoom(classRoom.getText());
                lesson.setTeacher(teacher.getText());
                lesson.setStartTime(start.getText());
                lesson.setEndTime(end.getText());

                int dayIndex = weekday.getSelectedIndex();
                int indexLesson = Integer.parseInt(index.getText()) - 1;

                IDay day = timetable.get(dayIndex);
                try {
                    day.getLesson(indexLesson);
                } catch (IndexOutOfBoundsException err) {
                    System.out.println(err.getMessage());
                    day.addLesson(lesson);
                    return;
                }

                day.updateLesson(indexLesson, lesson);
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dayIndex = weekday.getSelectedIndex();
                int indexLesson = Integer.parseInt(index.getText()) - 1;

                IDay day = timetable.get(dayIndex);
                try {
                    day.getLesson(indexLesson);
                } catch (IndexOutOfBoundsException err) {
                    System.out.println(err.getMessage());
                    return;
                }

                day.removeLesson(indexLesson);
            }
        });
    }
}
