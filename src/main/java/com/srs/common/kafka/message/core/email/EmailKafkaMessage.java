package com.srs.common.kafka.message.core.email;

import java.io.Serializable;


public abstract class EmailKafkaMessage implements Serializable {
    protected EmailDelegatedService delegateTo;

    public EmailDelegatedService getDelegateTo() {
        return delegateTo;
    }

    public void setDelegateTo(EmailDelegatedService delegateTo) {
        this.delegateTo = delegateTo;
    }
}
