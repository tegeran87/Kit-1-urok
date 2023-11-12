package org.example.task3;

public class FrontenderImpl implements Frontender, Developer {
    private String name;
    private String frontTechnology;

    public FrontenderImpl(String name, String frontTechnology) {
        this.name = name;
        this.frontTechnology = frontTechnology;
    }

    @Override
    public String getName() {
        return name;
    }


    public String getFrontTechnology() {
        return frontTechnology;
    }


    @Override
    public void developGUI() {
        System.out.println("Developer " + name + " develops frontend on " + frontTechnology);
    }
}
