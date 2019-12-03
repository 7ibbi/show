package com.expleo.webcm.helper;

import java.util.Map;

public class ValidateResponse {
    private boolean validated;
    private Map<String, String> errorMessages;

    public ValidateResponse() {
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public Map<String, String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(Map<String, String> errorMessages) {
        this.errorMessages = errorMessages;
    }
}
