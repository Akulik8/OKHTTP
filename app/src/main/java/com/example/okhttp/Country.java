package com.example.okhttp;

import com.google.gson.annotations.SerializedName;

public class Country {
    @SerializedName("cca2")
    public String code;
    public Names name;
    public Flags flags;

    public static class Flags{
        public String png;
        public String svg;
        public String alt;
    }

    public static class Names {
        public String common;
        public String official;
    }
}
