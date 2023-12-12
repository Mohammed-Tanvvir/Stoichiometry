import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//NAME CHANGE FROM TACOCALCULATORAPP TO STOICHIOMETRY
public class Stoichiometry {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Stoichiometry");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 300); // Adjusted size

            JPanel panel = new JPanel(new GridLayout(5, 2)); // Adjusted grid layout

            // Dropdown for selecting food
            ///////////////String[] foodOptions = {"Tacos", "Pizza", "French Toast"};
            ////////////JComboBox<String> foodDropdown = new JComboBox<>(foodOptions);

            // Dropdowns for selecting ingredient quantities
            String[] ingredientOptions = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            JComboBox<String> Ingredient1 = new JComboBox<>(ingredientOptions);
            JComboBox<String> Ingredient2 = new JComboBox<>(ingredientOptions);
            JComboBox<String> Ingredient3 = new JComboBox<>(ingredientOptions);

            JButton calculateButton = new JButton("Calculate Tacos");

            JLabel resultLabel = new JLabel();

            calculateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //////////////////String selectedFood = (String) foodDropdown.getSelectedItem();
                    int[] ingredients = {
                            Integer.parseInt((String) Ingredient1.getSelectedItem()),
                            Integer.parseInt((String) Ingredient2.getSelectedItem()),
                            Integer.parseInt((String) Ingredient3.getSelectedItem())
                    };

                    Food food = new Food(); // Assuming one instance of Food for simplicity
                    Calculator calculator = new TacoCalculator(food);
                    String result = calculator.calculate(ingredients);
                    Calculator pizzaCalculator = new PizzaCalculator(food);
                    String pizzaResult = pizzaCalculator.calculate(ingredients);

                    resultLabel.setText(result);
                    FileManager fileManager = new FileManager("History.txt");
                    String userInput = "Calculate Tacos: " +
                            "Ingredient 1: " + ingredients[0] +
                            ", Ingredient 2: " + ingredients[1] +
                            ", Ingredient 3: " + ingredients[2];
                    fileManager.writeHistory(userInput);
      
                    // Display the result in a new window
                    JFrame resultFrame = new JFrame("Calculation Result");
                    resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    resultFrame.setSize(300, 100);

                    JPanel resultPanel = new JPanel();
                    resultPanel.add(new JLabel(result));

                    resultFrame.add(resultPanel);
                    resultFrame.setVisible(true);
                }
            });

            JButton calculatePizzaButton = new JButton("Calculate Pizza");
            calculatePizzaButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   ////////////////////// String selectedFood = (String) foodDropdown.getSelectedItem();
            
                    int[] ingredients = {
                            Integer.parseInt((String) Ingredient1.getSelectedItem()),
                            Integer.parseInt((String) Ingredient2.getSelectedItem()),
                            Integer.parseInt((String) Ingredient3.getSelectedItem())
                    };
            
                    Food food = new Food();
            
                    // Create an instance of the PizzaCalculator class
                    Calculator pizzaCalculator = new PizzaCalculator(food);
                    String pizzaResult = pizzaCalculator.calculate(ingredients);
                    
                    JLabel pizzaResultLabel = new JLabel();
                    // Set the result text for Pizza calculation
                    pizzaResultLabel.setText(pizzaResult);
                    FileManager fileManager = new FileManager("History.txt");
                    String userInput = "Calculate Pizza: " +
                            "Ingredient 1: " + ingredients[0] +
                            ", Ingredient 2: " + ingredients[1] +
                            ", Ingredient 3: " + ingredients[2];
                    fileManager.writeHistory(userInput);
                    // Display the Pizza result in a new window
                    JFrame pizzaResultFrame = new JFrame("Pizza Calculation Result");
                    pizzaResultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    pizzaResultFrame.setSize(300, 100); 
            
                    JPanel pizzaResultPanel = new JPanel();
                    pizzaResultPanel.add(new JLabel(pizzaResult));
            
                    pizzaResultFrame.add(pizzaResultPanel);
                    pizzaResultFrame.setVisible(true);
                }
            });
            
            
            JButton calculateFrenchToastButton = new JButton("Calculate French Toast");
            calculateFrenchToastButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   ////////////////////// String selectedFood = (String) foodDropdown.getSelectedItem();
            
                    int[] ingredients = {
                            Integer.parseInt((String) Ingredient1.getSelectedItem()),
                            Integer.parseInt((String) Ingredient2.getSelectedItem()),
                            Integer.parseInt((String) Ingredient3.getSelectedItem())
                    };
            
                    Food food = new Food();
            
                    // Create an instance of the PizzaCalculator class
                    Calculator FrenchToastCalculator = new FrenchToastCalculator(food);
                    String FrenchToastResult = FrenchToastCalculator.calculate(ingredients);
                    
                    JLabel FrenchToastResultLabel = new JLabel();
                    // Set the result text for Pizza calculation
                    FrenchToastResultLabel.setText(FrenchToastResult);
                    FileManager fileManager = new FileManager("History.txt");
                    String userInput = "Calculate French Toast: " +
                            "Ingredient 1: " + ingredients[0] +
                            ", Ingredient 2: " + ingredients[1] +
                            ", Ingredient 3: " + ingredients[2];
                    fileManager.writeHistory(userInput);
                    
                    // Display the Pizza result in a new window
                    JFrame FrenchToastResultFrame = new JFrame("French Toast Calculation Result");
                    FrenchToastResultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    FrenchToastResultFrame.setSize(300, 100);
            
                    JPanel FrenchToastResultPanel = new JPanel();
                    FrenchToastResultPanel.add(new JLabel(FrenchToastResult));
            
                    FrenchToastResultFrame.add(FrenchToastResultPanel);
                    FrenchToastResultFrame.setVisible(true);
                }
            });

            // Add components to the panel
          /////////////  panel.add(new JLabel("Select Food:"));
            /////////////panel.add(foodDropdown);
            panel.add(new JLabel("Ingredient 1:"));
            panel.add(Ingredient1);
            panel.add(new JLabel("Ingredient 2:"));
            panel.add(Ingredient2);
            panel.add(new JLabel("Ingredient 3:"));
            panel.add(Ingredient3);

            panel.add(calculateButton);
            panel.add(resultLabel);
            panel.add(calculatePizzaButton); // New button for Pizza calculation
            JLabel pizzaResultLabel = new JLabel();
            panel.add(pizzaResultLabel);     // New label for Pizza result
            
            panel.add(calculateFrenchToastButton); 
            JLabel FrenchToastResultLabel = new JLabel();
            panel.add(FrenchToastResultLabel);     


            // Adjust preferred size for JComboBox items
            Dimension comboBoxDimension = new Dimension(100, 25);
            ///////////foodDropdown.setPreferredSize(comboBoxDimension);
            Ingredient1.setPreferredSize(comboBoxDimension);
            Ingredient2.setPreferredSize(comboBoxDimension);
            Ingredient3.setPreferredSize(comboBoxDimension);

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}