package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetJenisUsaha {

    @Expose
    @SerializedName("STATUS")
    private int STATUS;
    @Expose
    @SerializedName("MESSAGE")
    private String MESSAGE;
    @Expose
    @SerializedName("DATA")
    private List<DATAUsaha> DATA;

    public int getSTATUS() {
        return STATUS;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public List<DATAUsaha> getDATA() {
        return DATA;
    }

    public static class DATAUsaha {
        @Expose
        @SerializedName("mcat_id")
        private int mcat_id;
        @Expose
        @SerializedName("mcat_name")
        private String mcat_name;
        @Expose
        @SerializedName("mcat_description")
        private String mcat_description;
        @Expose
        @SerializedName("mcat_images")
        private String mcat_images;
        @Expose
        @SerializedName("mcat_is_active")
        private int mcat_is_active;
        @Expose
        @SerializedName("created_at")
        private String created_at;
        @Expose
        @SerializedName("updated_at")
        private String updated_at;

        public int getMcat_id() {
            return mcat_id;
        }

        public String getMcat_name() {
            return mcat_name;
        }

        public String getMcat_description() {
            return mcat_description;
        }

        public String getMcat_images() {
            return mcat_images;
        }

        public int getMcat_is_active() {
            return mcat_is_active;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }
    }
}
