package com.project.model.error;


public class ExceptionResponse {

    private String errorMessage;
    private String requestedURI;

    private ExceptionResponse(Builder builder) {
        errorMessage = builder.errorMessage;
        requestedURI = builder.requestedURI;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getRequestedURI() {
        return requestedURI;
    }

    public static class Builder {
        private String errorMessage;
        private String requestedURI;

        public Builder() {
        }

        public Builder withErrorMessage(String val) {
            errorMessage = val;
            return this;
        }

        public Builder withRequestedURI(String val) {
            requestedURI = val;
            return this;
        }

        public ExceptionResponse build() {
            return new ExceptionResponse(this);
        }
    }
}
