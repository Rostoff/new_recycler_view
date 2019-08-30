package com.hogsty.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

import io.realm.Realm;
import io.realm.RealmObject;

public class Element extends RealmObject implements Parcelable {
    private String name;
    private String pname;
    private Date birthDate;
    private String portablePhone;
    private String deskPhone;
    private String email;
    private String description;
    private int image;
    private int arrow;

    public Element() {
    }

    public Element(String name, String pname, Date birthDate, String portablePhone, String deskPhone, String email, String description, int image, int arrow) {
        this.name = name;
        this.pname = pname;
        this.birthDate = birthDate;
        this.portablePhone = portablePhone;
        this.deskPhone = deskPhone;
        this.email = email;
        this.description = description;
        this.image = image;
        this.arrow = arrow;
    }

    public String getName() {
        return name;
    }

    public String getPname() {
        return pname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPortablePhone() {
        return portablePhone;
    }

    public String getDeskPhone() {
        return deskPhone;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

    public int getArrow() {
        return arrow;
    }

    public static Creator<Element> getCREATOR() {
        return CREATOR;
    }






    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(pname);
        parcel.writeLong(birthDate.getTime());
        parcel.writeString(portablePhone);
        parcel.writeString(deskPhone);
        parcel.writeString(email);
        parcel.writeString(description);
        parcel.writeInt(image);
    }

    public static final Parcelable.Creator<Element> CREATOR = new Parcelable.Creator<Element>(){
        public Element createFromParcel(Parcel in){
            return new Element(in);
        }

        public Element[] newArray(int size){
            return new Element[size];
        }
    };

    private Element(Parcel in) {
        name = in.readString();
        pname = in.readString();
        birthDate = new Date(in.readLong());
        portablePhone = in.readString();
        deskPhone = in.readString();
        email = in.readString();
        description = in.readString();
        image = in.readInt();
    }
}
