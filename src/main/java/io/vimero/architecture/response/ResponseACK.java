package io.architecture.response;

import java.util.UUID;

/**
 * @author Rony Villanueva <rony@vimero.io>
 * @since 15/12/2019
 */

public class ResponseACK {

    private String ack;

    public ResponseACK() {
        this.ack = UUID.randomUUID().toString();
    }

    public String getAck() {
        return ack;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }
}
