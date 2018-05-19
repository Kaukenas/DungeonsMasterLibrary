
package com.example.manu.dungeonmasterlibrary.POJOS2;

import java.util.ArrayList;
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
    private List<Ability> abilities = new ArrayList<>();
    @SerializedName("skills")
    @Expose
    private List<Skill> skills = new ArrayList<>();
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
    @SerializedName("photo")
    @Expose
    private String photo;
    ////////////////////
    private Razas raza;
    private Class aClass;
    private int vida;
    private int CA;
    private int DAMAGE;
    private String Alineamiento;


////////////////////////////

    public static Creator<Character> getCREATOR() {
        return CREATOR;
    }

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
        in.readTypedList(this.abilities, Ability.CREATOR);
        in.readTypedList(this.skills, Skill.CREATOR);
        this.aClass = (Class) in.readValue(Class.class.getClassLoader());
        this.raza = (Razas) in.readValue(Razas.class.getClassLoader());
        this.vida = (int) in.readValue(int.class.getClassLoader());
        this.CA = (int) in.readValue(int.class.getClassLoader());
        this.DAMAGE = (int) in.readValue(int.class.getClassLoader());
        this.Alineamiento = (String) in.readValue(String.class.getClassLoader());
        this.photo = (String) in.readValue(String.class.getClassLoader());
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
    public Character(String id, String name, List<Ability> abilities, List<Skill> skills, String level, String classesId, String racesId, String usersId, String photo) {
        super();
        this.id = id;
        this.name = name;
        this.abilities = abilities;
        this.skills = skills;
        this.level = level;
        this.classesId = classesId;
        this.racesId = racesId;
        this.usersId = usersId;
        this.photo = photo;
    }

    public Character(String id, String name, List<Ability> abilities, List<Skill> skills, String level, String classesId, String racesId, Razas raza, Class aClass, int vida, String usersId) {
        super();
        this.id = id;
        this.name = name;
        this.abilities = abilities;
        this.skills = skills;
        this.level = level;
        this.classesId = classesId;
        this.racesId = racesId;
        this.raza = raza;
        this.aClass=aClass;
        this.vida=vida;
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

    //////////////////////////////////////////////////////////////////
    public Razas getRaza() {
        return raza;
    }

    public void setRaza(Razas raza) {
        this.raza = raza;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getCA() {
        return CA;
    }

    public void setCA(int CA) {
        this.CA = CA;
    }

    public int getDAMAGE() {
        return DAMAGE;
    }

    public void setDAMAGE(int DAMAGE) {
        this.DAMAGE = DAMAGE;
    }

    public String getAlineamiento() {
        return Alineamiento;
    }

    public void setAlineamiento(String alineamiento) {
        Alineamiento = alineamiento;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    ////////////////////////////////////////////////////////////////////

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeTypedList(abilities);
        dest.writeTypedList(skills);
        dest.writeValue(aClass);
        dest.writeValue(raza);
        dest.writeValue(vida);
        dest.writeValue(CA);
        dest.writeValue(DAMAGE);
        dest.writeValue(Alineamiento);
        dest.writeValue(photo);
        dest.writeValue(level);
        dest.writeValue(classesId);
        dest.writeValue(racesId);
        dest.writeValue(usersId);
    }

    public int describeContents() {
        return  0;
    }

}
