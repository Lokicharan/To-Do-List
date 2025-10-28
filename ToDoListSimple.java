import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoListSimple extends JFrame implements ActionListener {

    // GUI components
    private JTextField taskField;
    private JTextArea taskArea;
    private JButton addButton, deleteButton;
    private ArrayList<String> tasks;

    public ToDoListSimple() {
        // Initialize frame
        setTitle("To-Do List");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Using absolute layout

        tasks = new ArrayList<>();

        // Input field
        JLabel label = new JLabel("Enter Task:");
        label.setBounds(20, 20, 100, 25);
        add(label);

        taskField = new JTextField();
        taskField.setBounds(100, 20, 180, 25);
        add(taskField);

        // Add Button
        addButton = new JButton("Add");
        addButton.setBounds(290, 20, 80, 25);
        addButton.addActionListener(this);
        add(addButton);

        // Delete Button
        deleteButton = new JButton("Delete");
        deleteButton.setBounds(290, 60, 80, 25);
        deleteButton.addActionListener(this);
        add(deleteButton);

        // Text area to show tasks
        taskArea = new JTextArea();
        taskArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(taskArea);
        scrollPane.setBounds(20, 100, 350, 230);
        add(scrollPane);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Add button clicked
        if (e.getSource() == addButton) {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                tasks.add(task);
                updateTaskList();
                taskField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a task!");
            }
        }

        // Delete button clicked
        else if (e.getSource() == deleteButton) {
            String task = taskField.getText().trim();
            if (tasks.remove(task)) {
                updateTaskList();
                JOptionPane.showMessageDialog(this, "Task deleted: " + task);
            } else {
                JOptionPane.showMessageDialog(this, "Task not found!");
            }
        }
    }

    // Update text area
    private void updateTaskList() {
        taskArea.setText("");
        for (int i = 0; i < tasks.size(); i++) {
            taskArea.append((i + 1) + ". " + tasks.get(i) + "\n");
        }
    }

    public static void main(String[] args) {
        new ToDoListSimple();
    }
}
