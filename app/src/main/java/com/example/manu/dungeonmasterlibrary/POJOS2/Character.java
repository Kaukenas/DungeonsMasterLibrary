
package com.example.manu.dungeonmasterlibrary.POJOS2;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Character implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("abilities")
    @Expose
    private List<Ability> abilities = null;
    @SerializedName("skills")
    @Expose
    private List<Skill> skills = null;
    @SerializedName("level")
    @Expose
    private String level;
    @SerializedName("classesId")
    @Expose
    private String classesId;
    @SerializedName("racesId")
    @Expose
    private String racesId;
    @SerializedName("usersId")
    @Expose
    private String usersId;
    public final static Parcelable.Creator<Character> CREATOR = new Creator<Character>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Character createFromParcel(Parcel in) {
            return new Character(in);
        }

        public Character[] newArray(int size) {
            return (new Character[size]);
        }

    }
    ;

    protected Character(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.abilities, (com.example.manu.dungeonmasterlibrary.POJOS2.Ability.class.getClassLoader()));
        in.readList(this.skills, (com.example.manu.dungeonmasterlibrary.POJOS2.Skill.class.getClassLoader()));
        this.level = ((String) in.readValue((String.class.getClassLoader())));
        this.classesId = ((String) in.readValue((String.class.getClassLoader())));
        this.racesId = ((String) in.readValue((String.class.getClassLoader())));
        this.usersId = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Character() {
    }

    /**
     * 
     * @param skills
     * @param id
     * @param level
     * @param abilities
     * @param classesId
     * @param racesId
     * @param name
     * @param usersId
     */
    public Character(String id, String name, List<Ability> abilities, List<Skill> skills, String level, String classesId, String racesId, String usersId) {
        super();
        this.id = id;
        this.name = name;
        this.abilities = abilities;
        this.skills = skills;
        this.level = level;
        this.classesId = classesId;
        this.racesId = racesId;
        this.usersId = usersId;
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

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getClassesId() {
        return classesId;
    }

    public void setClassesId(String classesId) {
        this.classesId = classesId;
    }

    public String getRacesId() {
        return racesId;
    }

    public void setRacesId(String racesId) {
        this.racesId = racesId;
    }

    public String getUsersId() {
        return usersId;
    }

    public void setUsersId(String usersId) {
        this.usersId = usersId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeList(abilities);
        dest.writeList(skills);
        dest.writeValue(level);
        dest.writeValue(classesId);
        dest.writeValue(racesId);
        dest.writeValue(usersId);
    }

    public int describeContents() {
        return  0;
    }

}
