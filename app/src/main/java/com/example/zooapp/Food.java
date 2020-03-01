/*
 * FOOD OBJECT
 *
 * Created By: 40399682
 */
package com.example.zooapp;

import android.graphics.drawable.Drawable;

public class Food {
    private String name;
    private Drawable icon;
    private String description;
    private String price;

    // Getters and setters
    public String getName() { return this.name; }
    public Drawable getIcon() { return this.icon; }
    public String getDescription() { return this.description; }
    public String getPrice() { return this.price; }

    public void setName(String n) { this.name = n; }
    public void setIcon(Drawable i) { this.icon = i; }
    public void setDescription(String d){ this.description = d; }
    public void setPrice(String p){ this.price = p; }

    // Constructors
    public Food(String n, Drawable i, String d, String p) {
        setName(n);
        setIcon(i);
        setDescription(d);
        setPrice(p);
    }

    public Food(Food f) {
        setName(f.name);
        setIcon(f.icon);
        setDescription(f.description);
        setPrice(f.price);
    }
}
