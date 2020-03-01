/*
 * ANIMAL OBJECT
 *
 * Created By: 40399682
 */
package com.example.zooapp;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {
    private String name;
    private int iconId;
    private String info;

    // Getters and setters
    public String getName() { return this.name; }
    public int getIconId() { return this.iconId; }
    public String getInfo() { return info; }

    public void setName(String n) { this.name = n; }
    public void setIconId(int i) { this.iconId = i; }
    public void setInfo(String i) { this.info = i; }

    // Constructors
    public Animal(String name, int icon, String info) {
        setName(name);
        setIconId(icon);
        setInfo(info);
    }

    public Animal(Animal a) {
        setName(a.name);
        setIconId(a.iconId);
        setInfo(a.info);
    }

    public Animal(Parcel in) {
        this.name = in.readString();
        this.iconId = in.readInt();
        this.info = in.readString();
    }

    // Parcelable
    public static final Parcelable.Creator<Animal> CREATOR =
            new Parcelable.Creator<Animal>(){
                public Animal createFromParcel(Parcel in) {
                    return new Animal(in);
                }

                public Animal[] newArray(int size) {
                    return new Animal[size];
                }
            };

    @Override
    public int describeContents() {
        return 0;
    }

    // Writing to the parcel
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.iconId);
        dest.writeString(this.info);
    }
}
