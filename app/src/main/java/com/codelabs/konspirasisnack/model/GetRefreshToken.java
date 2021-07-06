package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;


public class GetRefreshToken {

    @SerializedName("DATA")
    public DATA data;
    @SerializedName("MESSAGE")
    public String message;
    @SerializedName("STATUS")
    public Integer status;

    public static class DATA {
        @SerializedName("user")
        public User user;
        @SerializedName("token")
        public String token;

        public static class User {
            @SerializedName("u_id")
            public Integer uId;
            @SerializedName("u_merchant_id")
            public Integer uMerchantId;
            @SerializedName("u_merchant_code")
            public String uMerchantCode;
            @SerializedName("u_outlet_id")
            public Integer uOutletId;
            @SerializedName("u_outlet_code")
            public String uOutletCode;
            @SerializedName("u_firstname")
            public String uFirstname;
            @SerializedName("u_lastname")
            public String uLastname;
            @SerializedName("u_email")
            public String uEmail;
            @SerializedName("u_dob")
            public String uDob;
            @SerializedName("u_address")
            public String uAddress;
            @SerializedName("u_address_alt")
            public String uAddressAlt;
            @SerializedName("u_phone_no")
            public String uPhoneNo;
            @SerializedName("u_phone_no_alt")
            public String uPhoneNoAlt;
            @SerializedName("u_mobile_no")
            public String uMobileNo;
            @SerializedName("u_mobile_no_alt")
            public String uMobileNoAlt;
            @SerializedName("u_type")
            public Integer uType;
            @SerializedName("u_role_id")
            public Integer uRoleId;
            @SerializedName("u_otp_code")
            public String uOtpCode;
            @SerializedName("u_otp_date")
            public String uOtpDate;
            @SerializedName("is_otp_verified")
            public Integer isOtpVerified;
            @SerializedName("is_email_verified")
            public Integer isEmailVerified;
            @SerializedName("u_is_active")
            public Integer uIsActive;
            @SerializedName("u_image")
            public String uImage;
            @SerializedName("u_position")
            public String uPosition;
            @SerializedName("u_nik")
            public String uNik;
            @SerializedName("u_is_pic")
            public Integer uIsPic;
            @SerializedName("created_at")
            public String createdAt;
            @SerializedName("updated_at")
            public String updatedAt;
            @SerializedName("deleted_at")
            public String deletedAt;
            @SerializedName("merchant")
            public Merchant merchant;
            @SerializedName("outlet")
            public Outlet outlet;

            public static class Merchant {
                @SerializedName("mc_id")
                public Integer mcId;
                @SerializedName("mc_code")
                public String mcCode;
                @SerializedName("mc_mcat_id")
                public Integer mcMcatId;
                @SerializedName("mc_name")
                public String mcName;
                @SerializedName("mc_logo")
                public String mcLogo;
                @SerializedName("mc_address")
                public String mcAddress;
                @SerializedName("mc_address_alt")
                public String mcAddressAlt;
                @SerializedName("mc_phone_no")
                public String mcPhoneNo;
                @SerializedName("mc_phone_no_alt")
                public String mcPhoneNoAlt;
                @SerializedName("mc_mobile_no")
                public String mcMobileNo;
                @SerializedName("mc_mobile_no_alt")
                public String mcMobileNoAlt;
                @SerializedName("mc_fax_no")
                public String mcFaxNo;
                @SerializedName("mc_fax_no_alt")
                public String mcFaxNoAlt;
                @SerializedName("mc_province")
                public String mcProvince;
                @SerializedName("mc_city")
                public String mcCity;
                @SerializedName("mc_kecamatan")
                public String mcKecamatan;
                @SerializedName("mc_country")
                public String mcCountry;
                @SerializedName("mc_latitude")
                public String mcLatitude;
                @SerializedName("mc_longitude")
                public String mcLongitude;
                @SerializedName("mc_slug")
                public String mcSlug;
                @SerializedName("mc_is_marketplace")
                public Integer mcIsMarketplace;
                @SerializedName("mc_trial_expired")
                public String mcTrialExpired;
                @SerializedName("mc_is_trial")
                public Integer mcIsTrial;
                @SerializedName("mc_is_active")
                public Integer mcIsActive;
                @SerializedName("created_at")
                public String createdAt;
                @SerializedName("updated_at")
                public String updatedAt;
                @SerializedName("deleted_at")
                public String deletedAt;
            }

            public static class Outlet {
                @SerializedName("ot_id")
                public Integer otId;
                @SerializedName("ot_code")
                public String otCode;
                @SerializedName("ot_merchant_id")
                public Integer otMerchantId;
                @SerializedName("ot_manager_u_id")
                public Integer otManagerUId;
                @SerializedName("ot_merchant_code")
                public String otMerchantCode;
                @SerializedName("ot_name")
                public String otName;
                @SerializedName("ot_logo")
                public String otLogo;
                @SerializedName("ot_address")
                public String otAddress;
                @SerializedName("ot_address_alt")
                public String otAddressAlt;
                @SerializedName("outlet_country_id")
                public Integer outletCountryId;
                @SerializedName("outlet_province_id")
                public Integer outletProvinceId;
                @SerializedName("outlet_city_id")
                public Integer outletCityId;
                @SerializedName("outlet_kecamatan_id")
                public Integer outletKecamatanId;
                @SerializedName("outlet_zip_code")
                public String outletZipCode;
                @SerializedName("ot_email")
                public String otEmail;
                @SerializedName("ot_phone_no")
                public String otPhoneNo;
                @SerializedName("ot_phone_no_alt")
                public String otPhoneNoAlt;
                @SerializedName("ot_mobile_no")
                public String otMobileNo;
                @SerializedName("ot_mobile_no_alt")
                public String otMobileNoAlt;
                @SerializedName("ot_fax_no")
                public String otFaxNo;
                @SerializedName("ot_fax_no_alt")
                public String otFaxNoAlt;
                @SerializedName("ot_social_media")
                public OtSocialMedia otSocialMedia;
                @SerializedName("ot_image_url")
                public String otImageUrl;
                @SerializedName("ot_logo_struk")
                public String otLogoStruk;
                @SerializedName("ot_province")
                public String otProvince;
                @SerializedName("ot_city")
                public String otCity;
                @SerializedName("ot_kecamatan")
                public String otKecamatan;
                @SerializedName("ot_country")
                public String otCountry;
                @SerializedName("ot_latitude")
                public String otLatitude;
                @SerializedName("ot_longitude")
                public String otLongitude;
                @SerializedName("ot_service_point")
                public Integer otServicePoint;
                @SerializedName("ot_slug")
                public String otSlug;
                @SerializedName("ot_is_active")
                public Integer otIsActive;
                @SerializedName("ot_expired_at")
                public String otExpiredAt;
                @SerializedName("created_at")
                public String createdAt;
                @SerializedName("updated_at")
                public String updatedAt;
                @SerializedName("deleted_at")
                public String deletedAt;

                public static class OtSocialMedia {
                    @SerializedName("facebook")
                    public String facebook;
                    @SerializedName("twitter")
                    public String twitter;
                    @SerializedName("instagram")
                    public String instagram;
                    @SerializedName("youtube")
                    public String youtube;
                }
            }
        }
    }
}
