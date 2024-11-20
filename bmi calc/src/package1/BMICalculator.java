package package1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator {

    public static void main(String[] args) {
        JFrame frame = new JFrame("BMI Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        frame.getContentPane().setBackground(Color.DARK_GRAY);

        JLabel weightLabel = new JLabel("Weight (kg):");
        weightLabel.setForeground(Color.WHITE);
        weightLabel.setBounds(50, 50, 100, 25);

        JLabel heightLabel = new JLabel("Height (cm):");
        heightLabel.setForeground(Color.WHITE);
        heightLabel.setBounds(50, 100, 100, 25);

        JLabel resultLabel = new JLabel("");
        resultLabel.setForeground(Color.WHITE);
        resultLabel.setBounds(50, 200, 300, 25);

        JTextField weightField = new JTextField();
        weightField.setBounds(150, 50, 150, 25);
        weightField.setBackground(Color.BLACK);
        weightField.setForeground(Color.WHITE);
        weightField.setCaretColor(Color.WHITE);

        JTextField heightField = new JTextField();
        heightField.setBounds(150, 100, 150, 25);
        heightField.setBackground(Color.BLACK);
        heightField.setForeground(Color.WHITE);
        heightField.setCaretColor(Color.WHITE);

        JButton calculateButton = new JButton("Calculate BMI");
        calculateButton.setBounds(150, 150, 150, 30);
        calculateButton.setBackground(Color.GRAY);
        calculateButton.setForeground(Color.WHITE);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double weight = Double.parseDouble(weightField.getText());
                    double heightCm = Double.parseDouble(heightField.getText());
                    double heightMeters = heightCm / 100;
                    double bmi = weight / (heightMeters * heightMeters);
                    resultLabel.setText(String.format("Your BMI is: %.2f", bmi));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input. Please enter valid numbers.");
                }
            }
        });

        frame.add(weightLabel);
        frame.add(weightField);
        frame.add(heightLabel);
        frame.add(heightField);
        frame.add(calculateButton);
        frame.add(resultLabel);

        frame.setVisible(true);
    }
}
