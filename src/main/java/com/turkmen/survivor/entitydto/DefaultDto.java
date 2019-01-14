package com.turkmen.survivor.entitydto;

import java.util.Map;


/**
 * <h1>The interface for DTOs which is used to add additional info to be shown to user  </h1>
 *
 * @author  Turkmen
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public class DefaultDto {
    private Map<String, Object> additionalInfo;

    public Map<String, Object> getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(Map<String, Object> additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
