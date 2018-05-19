
package com.example.manu.dungeonmasterlibrary.POJOS2;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.example.manu.dungeonmasterlibrary.POJOS.Traits;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Razas implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("abilityScores")
    @Expose
    private List<AbilityScore> abilityScores = new ArrayList<>();
    @SerializedName("speed")
    @Expose
    private String speed;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("traits")
    @Expose
    private List<Trait> traits = new ArrayList<>();

    ////////////////////////////////////////

    private ArrayList<Traits> traitsArrayList;

    //////////////////////////////////////

    public final static Creator<Razas> CREATOR = new Creator<Razas>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Razas createFromParcel(Parcel in) {
            return new Razas(in);
        }

        public Razas[] newArray(int size) {
            return (new Razas[size]);
        }

    }
    ;

    protected Razas(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        in.readTypedList(this.abilityScores, AbilityScore.CREATOR);
        this.speed = ((String) in.readValue((String.class.getClassLoader())));
        this.size = ((String) in.readValue((String.class.getClassLoader())));
        in.readTypedList(this.traits, Trait.CREATOR);
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Razas() {
    }

    /**
     * 
     * @param id
     * @param abilityScores
     * @param speed
     * @param description
     * @param name
     * @param traits
     * @param size
     */
    public Razas(String id, String name, String description, List<AbilityScore> abilityScores, String speed, String size, List<Trait> traits) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.abilityScores = abilityScores;
        this.speed = speed;
        this.size = size;
        this.traits = traits;
    }

    public Razas(String id, String name, String description, List<AbilityScore> abilityScores, String speed, String size, List<Trait> traits, ArrayList traitsArrayList) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.abilityScores = abilityScores;
        this.speed = speed;
        this.size = size;
        this.traits = traits;
        this.traitsArrayList = traitsArrayList;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AbilityScore> getAbilityScores() {
        return abilityScores;
    }

    public void setAbilityScores(List<AbilityScore> abilityScores) {
        this.abilityScores = abilityScores;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<Trait> getTraits() {
        return traits;
    }

    public void setTraits(List<Trait> traits) {
        this.traits = traits;
    }

    /////////////////////////////////////////////////////////////////////

    public ArrayList<Traits> getTraitsArrayList() {
        return traitsArrayList;
    }

    public void setTraitsArrayList(ArrayList<Traits> traitsArrayList) {
        this.traitsArrayList = traitsArrayList;
    }


    //////////////////////////////////////////////////////////////////////

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(description);
        dest.writeTypedList(abilityScores);
        dest.writeValue(speed);
        dest.writeValue(size);
        dest.writeTypedList(traits);
    }

    public int describeContents() {
        return  0;
    }

}
