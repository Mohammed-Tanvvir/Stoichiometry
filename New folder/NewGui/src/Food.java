import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Food {
    // Array representing the requirements for a taco: [tortillas, beef, cheese]
    private int[] tacoRequirements = {1, 1, 1};
    public int[] getTacoRequirements() {
        return tacoRequirements;
    }

    //1lb of dough, 1 cup of cheese, and 1 cup of sauce
    private int[] pizzaRequirements = {1, 1, 1};
    public int[] getPizzaRequirements() {
        return pizzaRequirements;
    }

    //1 bread, 1 egg, and 1 cup of milk
    private int[] FrenchToastRequirements = {1, 1, 1};
    public int[] getFrenchToastRequirements() {
        return FrenchToastRequirements;
    }
}