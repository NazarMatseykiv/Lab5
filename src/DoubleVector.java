import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DoubleVector extends JFrame {

    private JLabel label1, label2, label3;

    public DoubleVector() {
        super("Double Vector");

        // Створюємо мітки для виведення результатів
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();

        // Встановлюємо менеджер розміщення FlowLayout
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        // Додаємо мітки на форму
        c.add(label1);
        c.add(label2);
        c.add(label3);

        // Створюємо вектор і виводимо його на екран
        double[] vector = {1.0, 2.0, 3.0};
        label1.setText("Vector: " + toString(vector));

        // Обчислюємо і виводимо на екран скалярний добуток вектора на самого себе
        double scalarProduct = scalarProduct(vector, vector);
        label2.setText("Scalar product of vector with itself: " + scalarProduct);

        // Обчислюємо і виводимо на екран довжину вектора
        double length = length(vector);
        label3.setText("Length of vector: " + length);

        // Додаємо обробник події закриття вікна
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Встановлюємо розмір вікна і робимо його видимим
        setSize(400, 150);
        setVisible(true);
    }

    // Метод для обчислення скалярного добутку двох векторів
    private double scalarProduct(double[] a, double[] b) {
        double result = 0.0;
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }
        return result;
    }

    // Метод для обчислення довжини вектора
    private double length(double[] a) {
        return Math.sqrt(scalarProduct(a, a));
    }

    // Метод для перетворення вектора в рядок для виведення на екран
    private String toString(double[] a) {
        String result = "[";
        for (int i = 0; i < a.length; i++) {
            result += a[i];
            if (i < a.length - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

    public static void main(String[] args) {
        DoubleVector app = new DoubleVector();
    }
}
