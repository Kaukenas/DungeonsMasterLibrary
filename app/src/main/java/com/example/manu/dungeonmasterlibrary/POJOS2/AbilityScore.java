
package com.example.manu.dungeonmasterlibrary.POJOS2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AbilityScore implements Parcelable
{

    @SerializedName("fuerza")
    @Expose
    private String fuerza;
    @SerializedName("destreza")
    @Expose
    private String destreza;
    @SerializedName("constitucion")
    @Expose
    private String constitucion;
    @SerializedName("inteligencia")
    @Expose
    private String inteligencia;
    @SerializedName("sabiduria")
    @Expose
    private String sabiduria;
    @SerializedName("carisma")
    @Expose
    private String carisma;
    public final static Creator<AbilityScore> CREATOR = new Creator<AbilityScore>() {


        @SuppressWarnings({
            "unchecked"
        })
        public AbilityScore createFromParcel(Parcel in) {
            return new AbilityScore(in);
        }

        public AbilityScore[] newArray(int size) {
            return (new AbilityScore[size]);
        }

    }
    ;

    protected AbilityScore(Parcel in) {
        this.fuerza = ((String) in.readValue((String.class.getClassLoader())));
        this.destreza = ((String) in.readValue((String.class.getClassLoader())));
        this.constitucion = ((String) in.readValue((String.class.getClassLoader())));
        this.inteligencia = ((String) in.readValue((String.class.getClassLoader())));
        this.sabiduria = ((String) in.readValue((String.class.getClassLoader())));
        this.carisma = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public AbilityScore() {
    }

    /**
     * 
     * @param carisma
     * @param constitucion
     * @param fuerza
     * @param inteligencia
     * @param destreza
     * @param sabiduria
     */
    public AbilityScore(String fuerza, String destreza, String constitucion, String inteligencia, String sabiduria, String carisma) {
        super();
        this.fuerza = fuerza;
        this.destreza = destreza;
        this.constitucion = constitucion;
        this.inteligencia = inteligencia;
        this.sabiduria = sabiduria;
        this.carisma = carisma;
    }

    public String getFuerza() {
        return fuerza;
    }

    public void setFuerza(String fuerza) {
        this.fuerza = fuerza;
    }

    public String getDestreza() {
        return destreza;
    }

    public void setDestreza(String destreza) {
        this.destreza = destreza;
    }

    public String getConstitucion() {
        return constitucion;
    }

    public void setConstitucion(String constitucion) {
        this.constitucion = constitucion;
    }

    public String getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(String inteligencia) {
        this.inteligencia = inteligencia;
    }

    public String getSabiduria() {
        return sabiduria;
    }

    public void setSabiduria(String sabiduria) {
        this.sabiduria = sabiduria;
    }

    public String getCarisma() {
        return carisma;
    }

    public void setCarisma(String carisma) {
        this.carisma = carisma;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(fuerza);
        dest.writeValue(destreza);
        dest.writeValue(constitucion);
        dest.writeValue(inteligencia);
        dest.writeValue(sabiduria);
        dest.writeValue(carisma);
    }

    public int describeContents() {
        return  0;
    }

}
