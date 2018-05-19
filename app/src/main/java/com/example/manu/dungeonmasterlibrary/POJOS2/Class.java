
package com.example.manu.dungeonmasterlibrary.POJOS2;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.example.manu.dungeonmasterlibrary.POJOS.Features;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Class implements Parcelable
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
    @SerializedName("hitDice")
    @Expose
    private String hitDice;
    @SerializedName("savingThrows")
    @Expose
    private List<SavingThrow> savingThrows = null;
    @SerializedName("skills")
    @Expose
    private List<Skill> skills = new ArrayList<>();
    @SerializedName("numOfSkills")
    @Expose
    private String numOfSkills;

    /////////////////////////////

    private ArrayList<Features> features;

    //////////////////////////////
    public final static Parcelable.Creator<Class> CREATOR = new Creator<Class>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Class createFromParcel(Parcel in) {
            return new Class(in);
        }

        public Class[] newArray(int size) {
            return (new Class[size]);
        }

    }
    ;

    protected Class(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.hitDice = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.savingThrows, (com.example.manu.dungeonmasterlibrary.POJOS2.SavingThrow.class.getClassLoader()));
        in.readList(this.skills, (com.example.manu.dungeonmasterlibrary.POJOS2.Skill.class.getClassLoader()));
        this.numOfSkills = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Class() {
    }

    /**
     * 
     * @param skills
     * @param id
     * @param numOfSkills
     * @param description
     * @param name
     * @param hitDice
     * @param savingThrows
     */
    public Class(String id, String name, String description, String hitDice, List<SavingThrow> savingThrows, List<Skill> skills, String numOfSkills) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.hitDice = hitDice;
        this.savingThrows = savingThrows;
        this.skills = skills;
        this.numOfSkills = numOfSkills;
    }

    public Class(String id, String name, String description, String hitDice, List<SavingThrow> savingThrows, List<Skill> skills, String numOfSkills, ArrayList<Features> features) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.hitDice = hitDice;
        this.savingThrows = savingThrows;
        this.skills = skills;
        this.numOfSkills = numOfSkills;
        this.features = features;
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

    public String getHitDice() {
        return hitDice;
    }

    public void setHitDice(String hitDice) {
        this.hitDice = hitDice;
    }

    public List<SavingThrow> getSavingThrows() {
        return savingThrows;
    }

    public void setSavingThrows(List<SavingThrow> savingThrows) {
        this.savingThrows = savingThrows;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public String getNumOfSkills() {
        return numOfSkills;
    }

    public void setNumOfSkills(String numOfSkills) {
        this.numOfSkills = numOfSkills;
    }

    ///////////////////////////////////////

    public ArrayList<Features> getFeatures() {
        return features;
    }

    public void setFeatures(ArrayList<Features> features) {
        this.features = features;
    }

    //////////////////////////////////////

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(description);
        dest.writeValue(hitDice);
        dest.writeList(savingThrows);
        dest.writeList(skills);
        dest.writeValue(numOfSkills);
    }

    public int describeContents() {
        return  0;
    }

}
