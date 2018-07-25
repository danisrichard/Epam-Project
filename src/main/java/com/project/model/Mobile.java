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

    private Mobile(Builder builder) {
        setManufacture(builder.manufacture);
        mobileType = builder.mobileType;
        desc = builder.desc;
        releaseDate = builder.releaseDate;
    }

    public Long getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }
    public String getReleaseDate() {
        return releaseDate;
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

    public static final class Builder {
        private String manufacture;
        private String mobileType;
        private String desc;
        private String releaseDate;

        public Builder() {
        }

        public Builder manufacture(String val) {
            manufacture = val;
            return this;
        }

        public Builder mobileType(String val) {
            mobileType = val;
            return this;
        }

        public Builder desc(String val) {
            desc = val;
            return this;
        }

        public Builder releaseDate(String val) {
            releaseDate = val;
            return this;
        }

        public Mobile build() {
            return new Mobile(this);
        }
    }
}
