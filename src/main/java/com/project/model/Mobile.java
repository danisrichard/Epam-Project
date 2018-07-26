package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mobile {

    @Id
    @GeneratedValue
    Long id;
    String manufacture;
    String mobileType;
    String desc;
    String releaseDate;

    public Mobile() {
    }


    public Mobile(String manufacture, String mobileType, String desc) {
        this.manufacture = manufacture;
        this.mobileType = mobileType;
        this.desc = desc;
    }

    public Mobile(String manufacture, String mobileType, String desc, String releaseDate) {
        this.manufacture = manufacture;
        this.mobileType = mobileType;
        this.desc = desc;
        this.releaseDate = releaseDate;
    }

    public Long getId() {
        return id;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getMobileType() {
        return mobileType;
    }

    public void setMobileType(String mobileType) {
        this.mobileType = mobileType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                ", manufacture='" + manufacture + '\'' +
                ", mobileType='" + mobileType + '\'' +
                ", desc='" + desc + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
