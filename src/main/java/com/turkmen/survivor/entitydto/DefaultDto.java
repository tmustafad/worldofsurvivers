package com.turkmen.survivor.entitydto;

import java.util.Map;

public class DefaultDto {
    private Map<String, Object> additionalInfo;

    public Map<String, Object> getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(Map<String, Object> additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
