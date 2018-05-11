
package com.example.manu.dungeonmasterlibrary.POJOS2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Skill implements Parcelable
{

    @SerializedName("habilidad")
    @Expose
    private String habilidad;
    public final static Parcelable.Creator<Skill> CREATOR = new Creator<Skill>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Skill createFromParcel(Parcel in) {
            return new Skill(in);
        }

        public Skill[] newArray(int size) {
            return (new Skill[size]);
        }

    }
    ;

    protected Skill(Parcel in) {
        this.habilidad = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Skill() {
    }

    /**
     * 
     * @param habilidad
     */
    public Skill(String habilidad) {
        super();
        this.habilidad = habilidad;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(habilidad);
    }

    public int describeContents() {
        return  0;
    }

}
