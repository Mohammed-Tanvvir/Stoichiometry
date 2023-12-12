class FrenchToastCalculator extends Calculator {
    private Food food;

    public FrenchToastCalculator(Food food) {
        this.food = food;
    }

    @Override
    public String calculate(int[] ingredients) {
        int[] requirements = food.getFrenchToastRequirements();

        int numberOfFrenchToast = Math.min(ingredients[0] / requirements[0], Math.min(ingredients[1] / requirements[1], ingredients[2] / requirements[2]));

        return "You can make " + numberOfFrenchToast + " French Toasts";
    }
}
