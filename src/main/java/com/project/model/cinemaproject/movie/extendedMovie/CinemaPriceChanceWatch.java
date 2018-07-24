package com.project.model.cinemaproject.movie.extendedMovie;

import com.project.model.cinemaproject.movie.BasicMovie;

public class CinemaPriceChanceWatch extends MovieDecorator{

    private CinemaPriceChanceWatch(Builder builder) {
        leaseRights = builder.leaseRights;
        popularityIndex = builder.popularityIndex;
        movie = builder.movie;
        chanceToWatch = builder.chanceToWatch;
    }

    public static final class Builder {
        private int leaseRights;
        private double popularityIndex;
        private BasicMovie movie;
        private double chanceToWatch;

        public Builder(BasicMovie val) {
            movie = val;
        }

        public Builder leaseRights(int val) {
            leaseRights = val;
            return this;
        }

        public Builder chanceToWatch(double val){
            chanceToWatch = val;
            return this;
        }

        public Builder popularityIndex(double val) {
            popularityIndex = val;
            return this;
        }

        public CinemaPriceChanceWatch build() {
            return new CinemaPriceChanceWatch(this);
        }
    }
}
