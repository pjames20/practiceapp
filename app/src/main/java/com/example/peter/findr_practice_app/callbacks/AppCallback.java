package com.example.peter.findr_practice_app.callbacks;


/**
 * Created by peter on 12/11/17.
 */

public interface AppCallback<T> {
    void onSuccess(T object);

    void onError(String error);
}
