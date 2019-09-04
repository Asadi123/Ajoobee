package com.ajoobee.mm.Data.Network.Response;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class ServerReturn<T> {
    private Status status;
    private String name;
    private String description;
    private final T data;

    public ServerReturn(@NonNull Status status, @Nullable String description, @Nullable T data) {
        this.data = data;
        this.status = status;
        this.description = description;
    }

    public static <T> ServerReturn<T> success(@Nullable String description, @Nullable T data )
    {
        return new ServerReturn<>(Status.SUCCESS, description, data);
    }

    public static <T> ServerReturn<T> error(@NonNull String description)
    {
        return new ServerReturn<>(Status.ERROR, description, null);
    }

    public static <T> ServerReturn<T> loading(@NonNull String description)
    {
        return new ServerReturn<>(Status.LOADING, description, null);
    }

//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
}
