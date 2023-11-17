package com.simple.main.entity;

public class Materials {
    final int COFFEE_OUT = 10;
    final int SUGAR_OUT = 10;
    final int CREAM_OUT = 20;

    final int MAX_COFF_MATERIAL = 150;

    final int MONITOR_COFFEE_RATE = 10;
    private int coffee;
    private int cream;
    private int sugar;
    private int coffeeRate;
    private int creamRate;
    private int sugarRate;

    public Materials(){
    }
    public Materials(int coffee, int cream, int sugar) {
        this.coffee = coffee;
        this.cream = cream;
        this.sugar = sugar;
    }

    public int getCoffee() {
        return coffee;
    }

    public boolean isMakeMilkCoffee(){
        if(getCoffee() >= COFFEE_OUT
                && getCream() >= COFFEE_OUT
                &&  getSugar() >= SUGAR_OUT){
            return true;
        }else {
            return false;
        }
    }

    public boolean isMakeSugarCoffee(){
        if(getCoffee() >= COFFEE_OUT
                && getSugar() >= SUGAR_OUT){
            return true;
        }else {
            return false;
        }
    }
    public boolean isMakeBlackCoffee(){
        if(getCoffee() >= COFFEE_OUT){
            return true;
        }else {
            return false;
        }
    }

    private void calculateCoffeeRate(){
        // 커피재료의 잔량 계산
        coffeeRate = (int) (((double)getCoffee() / MAX_COFF_MATERIAL)*100);
    }
    private void calculateCreamRate(){
        // 프림재료의 잔량 계산
        creamRate = (getCream() / MAX_COFF_MATERIAL)*100;
    }

    private void calculateSugarRate(){
        // 프림재료의 잔량 계산
        sugarRate = (getSugar() / MAX_COFF_MATERIAL)*100;
    }

    public int showCoffeeRate(String coffee){
        int total=0;
        if(coffee.equals("coffee")){
            calculateCoffeeRate();
            total = coffeeRate;
        }else if(coffee.equals("cream")){
            calculateCreamRate();
            total = creamRate;
        }else if(coffee.equals("sugar")){
            calculateSugarRate();
            total = sugarRate;
        }
        return total;
    }

    public int dispenseCoffee(){
        if(getCoffee() >= COFFEE_OUT) {
            setCoffee(getCoffee() - COFFEE_OUT);
            return COFFEE_OUT;
        } else {
            return 0;
        }
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }
    public int getCream() {
        return cream;
    }
    public int dispenseCream(){
        if(getCream() >= CREAM_OUT) {
            setCream(getCream() - CREAM_OUT);
            return CREAM_OUT;
        } else {
            return 0;
        }
    }

    public void setCream(int cream) {
        this.cream = cream;
    }

    public int getSugar() {
        return sugar;
    }
    public int dispenseSugar(){
        if(getSugar() >= SUGAR_OUT) {
            setSugar(getSugar() - SUGAR_OUT);
            return SUGAR_OUT;
        } else {
            return 0;
        }
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    @Override
    public String toString() {
        return "Materials{" +
                "coffee=" + coffee +
                ", cream=" + cream +
                ", sugar=" + sugar +
                '}';
    }

}
