// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.communication.callautomation.models;

import com.azure.communication.common.CommunicationIdentifier;
import com.azure.core.annotation.Immutable;

/** The CallParticipant model. */
@Immutable
public final class CallParticipant {
    /*
     * Communication identifier of the participant
     */
    private final CommunicationIdentifier identifier;

    /*
     * Is participant muted
     */
    private final Boolean isMuted;

    /*
     * Is participant on hold.
     */
    private final Boolean isOnHold;

    /**
    * Constructor of the class
    *
    * @param identifier The communication identifier
    * @param isMuted The value of isMuted
    * @param isOnHold The value of isOnHold
    */
    public CallParticipant(CommunicationIdentifier identifier, Boolean isMuted, Boolean isOnHold) {
        this.identifier = identifier;
        this.isMuted = isMuted;
        this.isOnHold = isOnHold;
    }

    /**
     * Constructor of the class
     *
     * @param identifier The communication identifier
     * @param isMuted The value of isMuted
     */
    public CallParticipant(CommunicationIdentifier identifier, Boolean isMuted) {
        this.identifier = identifier;
        this.isMuted = isMuted;
        this.isOnHold = null;

    }

    /**
     * Get the identifier property: Communication identifier of the participant.
     *
     * @return the identifier value.
     */
    public CommunicationIdentifier getIdentifier() {
        return this.identifier;
    }

    /**
     * Get the isMuted property: Is participant muted.
     *
     * @return the isMuted value.
     */
    public Boolean isMuted() {
        return this.isMuted;
    }

    /**
     * Get the isOnHold property: Is participant on hold.
     *
     * @return the isOnHold value.
     */
    public Boolean isOnHold() {
        return this.isOnHold;
    }
}
