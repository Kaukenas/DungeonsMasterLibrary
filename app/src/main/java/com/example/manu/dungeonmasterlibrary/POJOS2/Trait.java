
package com.example.manu.dungeonmasterlibrary.POJOS2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trait implements Parcelable
{

    @SerializedName("trait")
    @Expose
    private String trait;
    public final static Creator<Trait> CREATOR = new Creator<Trait>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Trait createFromParcel(Parcel in) {
            return new Trait(in);
        }

        public Trait[] newArray(int size) {
            return (new Trait[size]);
        }

    }
    ;

    protected Trait(Parcel in) {
        this.trait = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Trait() {
    }

    /**
     * 
     * @param trait
     */
    public Trait(String trait) {
        super();
        this.trait = trait;
    }

    public String getTrait() {
        return trait;
    }

    public void setTrait(String trait) {
        this.trait = trait;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(trait);
    }

    public int describeContents() {
        return  0;
    }

}
