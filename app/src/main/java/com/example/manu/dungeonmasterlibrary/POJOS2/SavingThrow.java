
package com.example.manu.dungeonmasterlibrary.POJOS2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SavingThrow implements Parcelable
{

    @SerializedName("competencia")
    @Expose
    private String competencia;
    public final static Parcelable.Creator<SavingThrow> CREATOR = new Creator<SavingThrow>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SavingThrow createFromParcel(Parcel in) {
            return new SavingThrow(in);
        }

        public SavingThrow[] newArray(int size) {
            return (new SavingThrow[size]);
        }

    }
    ;

    protected SavingThrow(Parcel in) {
        this.competencia = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public SavingThrow() {
    }

    /**
     * 
     * @param competencia
     */
    public SavingThrow(String competencia) {
        super();
        this.competencia = competencia;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(competencia);
    }

    public int describeContents() {
        return  0;
    }

}
