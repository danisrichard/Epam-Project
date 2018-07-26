package com.project.model;

public class ResponseMobile {

    String titleValue;
    String sentenceValue;

    private ResponseMobile(Builder builder) {
        titleValue = builder.titleValue;
        sentenceValue = builder.sentenceValue;
    }

    public String getTitleValue() {
        return titleValue;
    }

    public String getSentenceValue() {
        return sentenceValue;
    }


    public static final class Builder {
        private String titleValue;
        private String sentenceValue;

        public Builder() {
        }

        public Builder titleValue(String val) {
            titleValue = val;
            return this;
        }

        public Builder sentenceValue(String val) {
            sentenceValue = val;
            return this;
        }

        public ResponseMobile build() {
            return new ResponseMobile(this);
        }
    }
}
