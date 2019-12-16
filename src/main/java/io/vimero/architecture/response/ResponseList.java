package io.architecture.response;

import java.util.List;

/**
 * @author Rony Villanueva <rony@vimero.io>
 * @since 15/12/2019
 */

public class ResponseList<T> {

    private List<T> data;

    public ResponseList(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
