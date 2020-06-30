package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetKaryawan {



    @SerializedName("MESSAGE")
    private String MESSAGE;
    @SerializedName("STATUS")
    private int STATUS;
    @SerializedName("DATA")
    private List<DATA> DATA;
    /**
     * outlet : {"ot_id":8,"ot_merchant_id":5,"ot_manager_u_id":9,"ot_name":"Dikopian Bandung","ot_address":"Jl. yang Lurus Amin no. wahid","ot_address_alt":"","outlet_country_id":1,"outlet_province_id":32,"outlet_city_id":3204,"outlet_zip_code":"","ot_phone_no":"0236234","ot_phone_no_alt":"","ot_mobile_no":"0832422153242","ot_mobile_no_alt":"","ot_fax_no":"","ot_fax_no_alt":"","ot_social_media":{"facebook":"https://facebook.com","instagram":"https://instagram.com","twitter":"https://twitter.com","youtube":"https://youtube.coms"},"ot_image_url":"93e256bef189374c7b0f60f689a20786.png","ot_logo_struk":"93e256bef189374c7b0f60f689a20786.png","ot_is_active":1,"ot_expired_at":"","created_at":"2020-02-07 10:55:44","updated_at":"2020-02-27 10:53:53"}
     */


    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public int getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(int STATUS) {
        this.STATUS = STATUS;
    }

    public List<DATA> getDATA() {
        return DATA;
    }

    public void setDATA(List<DATA> DATA) {
        this.DATA = DATA;
    }


    public static class DATA {

        @SerializedName("u_id")
        private int uId;
        @SerializedName("u_merchant_id")
        private int uMerchantId;
        @SerializedName("u_outlet_id")
        private int uOutletId;
        @SerializedName("u_firstname")
        private String uFirstname;
        @SerializedName("u_lastname")
        private String uLastname;
        @SerializedName("u_email")
        private String uEmail;
        @SerializedName("u_pin")
        private String uPin;
        @SerializedName("u_dob")
        private String uDob;
        @SerializedName("u_address")
        private String uAddress;
        @SerializedName("u_address_alt")
        private String uAddressAlt;
        @SerializedName("u_phone_no")
        private String uPhoneNo;
        @SerializedName("u_phone_no_alt")
        private String uPhoneNoAlt;
        @SerializedName("u_mobile_no")
        private String uMobileNo;
        @SerializedName("u_mobile_no_alt")
        private String uMobileNoAlt;
        @SerializedName("u_type")
        private int uType;
        @SerializedName("u_otp_code")
        private String uOtpCode;
        @SerializedName("u_otp_date")
        private String uOtpDate;
        @SerializedName("is_otp_verified")
        private int isOtpVerified;
        @SerializedName("is_email_verified")
        private int isEmailVerified;
        @SerializedName("u_is_active")
        private int uIsActive;
        @SerializedName("u_image")
        private String uImage;
        @SerializedName("u_position")
        private String uPosition;
        @SerializedName("u_nik")
        private String uNik;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("outlet")
        private Outlet outlet;

        public Outlet getOutlet() {
            return outlet;
        }

        public void setOutlet(Outlet outlet) {
            this.outlet = outlet;
        }

        public int getUId() {
            return uId;
        }

        public void setUId(int uId) {
            this.uId = uId;
        }

        public int getUMerchantId() {
            return uMerchantId;
        }

        public void setUMerchantId(int uMerchantId) {
            this.uMerchantId = uMerchantId;
        }

        public int getUOutletId() {
            return uOutletId;
        }

        public void setUOutletId(int uOutletId) {
            this.uOutletId = uOutletId;
        }

        public String getUFirstname() {
            return uFirstname;
        }

        public String generateFullname(){
            return uFirstname+" "+uLastname;
        }
        public void setUFirstname(String uFirstname) {
            this.uFirstname = uFirstname;
        }

        public String getULastname() {
            return uLastname;
        }

        public void setULastname(String uLastname) {
            this.uLastname = uLastname;
        }

        public String getUEmail() {
            return uEmail;
        }

        public void setUEmail(String uEmail) {
            this.uEmail = uEmail;
        }

        public String getUPin() {
            return uPin;
        }

        public void setUPin(String uPin) {
            this.uPin = uPin;
        }

        public String getUDob() {
            return uDob;
        }

        public void setUDob(String uDob) {
            this.uDob = uDob;
        }

        public String getUAddress() {
            return uAddress;
        }

        public void setUAddress(String uAddress) {
            this.uAddress = uAddress;
        }

        public String getUAddressAlt() {
            return uAddressAlt;
        }

        public void setUAddressAlt(String uAddressAlt) {
            this.uAddressAlt = uAddressAlt;
        }

        public String getUPhoneNo() {
            return uPhoneNo;
        }

        public void setUPhoneNo(String uPhoneNo) {
            this.uPhoneNo = uPhoneNo;
        }

        public String getUPhoneNoAlt() {
            return uPhoneNoAlt;
        }

        public void setUPhoneNoAlt(String uPhoneNoAlt) {
            this.uPhoneNoAlt = uPhoneNoAlt;
        }

        public String getUMobileNo() {
            return uMobileNo;
        }

        public void setUMobileNo(String uMobileNo) {
            this.uMobileNo = uMobileNo;
        }

        public String getUMobileNoAlt() {
            return uMobileNoAlt;
        }

        public void setUMobileNoAlt(String uMobileNoAlt) {
            this.uMobileNoAlt = uMobileNoAlt;
        }

        public int getUType() {
            return uType;
        }

        public void setUType(int uType) {
            this.uType = uType;
        }

        public String getUOtpCode() {
            return uOtpCode;
        }

        public void setUOtpCode(String uOtpCode) {
            this.uOtpCode = uOtpCode;
        }

        public String getUOtpDate() {
            return uOtpDate;
        }

        public void setUOtpDate(String uOtpDate) {
            this.uOtpDate = uOtpDate;
        }

        public int getIsOtpVerified() {
            return isOtpVerified;
        }

        public void setIsOtpVerified(int isOtpVerified) {
            this.isOtpVerified = isOtpVerified;
        }

        public int getIsEmailVerified() {
            return isEmailVerified;
        }

        public void setIsEmailVerified(int isEmailVerified) {
            this.isEmailVerified = isEmailVerified;
        }

        public int getUIsActive() {
            return uIsActive;
        }

        public void setUIsActive(int uIsActive) {
            this.uIsActive = uIsActive;
        }

        public String getUImage() {
            return uImage;
        }

        public void setUImage(String uImage) {
            this.uImage = uImage;
        }

        public String getUPosition() {
            return uPosition;
        }

        public void setUPosition(String uPosition) {
            this.uPosition = uPosition;
        }

        public String getUNik() {
            return uNik;
        }

        public void setUNik(String uNik) {
            this.uNik = uNik;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }
    }


    public static class Outlet {

        @SerializedName("ot_id")
        private int otId;
        @SerializedName("ot_merchant_id")
        private int otMerchantId;
        @SerializedName("ot_manager_u_id")
        private int otManagerUId;
        @SerializedName("ot_name")
        private String otName;
        @SerializedName("ot_address")
        private String otAddress;
        @SerializedName("ot_address_alt")
        private String otAddressAlt;
        @SerializedName("outlet_country_id")
        private int outletCountryId;
        @SerializedName("outlet_province_id")
        private int outletProvinceId;
        @SerializedName("outlet_city_id")
        private int outletCityId;
        @SerializedName("outlet_zip_code")
        private String outletZipCode;
        @SerializedName("ot_phone_no")
        private String otPhoneNo;
        @SerializedName("ot_phone_no_alt")
        private String otPhoneNoAlt;
        @SerializedName("ot_mobile_no")
        private String otMobileNo;
        @SerializedName("ot_mobile_no_alt")
        private String otMobileNoAlt;
        @SerializedName("ot_fax_no")
        private String otFaxNo;
        @SerializedName("ot_fax_no_alt")
        private String otFaxNoAlt;
        @SerializedName("ot_social_media")
        private OtSocialMediaBean otSocialMedia;
        @SerializedName("ot_image_url")
        private String otImageUrl;
        @SerializedName("ot_logo_struk")
        private String otLogoStruk;
        @SerializedName("ot_is_active")
        private int otIsActive;
        @SerializedName("ot_expired_at")
        private String otExpiredAt;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;

        public int getOtId() {
            return otId;
        }

        public void setOtId(int otId) {
            this.otId = otId;
        }

        public int getOtMerchantId() {
            return otMerchantId;
        }

        public void setOtMerchantId(int otMerchantId) {
            this.otMerchantId = otMerchantId;
        }

        public int getOtManagerUId() {
            return otManagerUId;
        }

        public void setOtManagerUId(int otManagerUId) {
            this.otManagerUId = otManagerUId;
        }

        public String getOtName() {
            return otName;
        }

        public void setOtName(String otName) {
            this.otName = otName;
        }

        public String getOtAddress() {
            return otAddress;
        }

        public void setOtAddress(String otAddress) {
            this.otAddress = otAddress;
        }

        public String getOtAddressAlt() {
            return otAddressAlt;
        }

        public void setOtAddressAlt(String otAddressAlt) {
            this.otAddressAlt = otAddressAlt;
        }

        public int getOutletCountryId() {
            return outletCountryId;
        }

        public void setOutletCountryId(int outletCountryId) {
            this.outletCountryId = outletCountryId;
        }

        public int getOutletProvinceId() {
            return outletProvinceId;
        }

        public void setOutletProvinceId(int outletProvinceId) {
            this.outletProvinceId = outletProvinceId;
        }

        public int getOutletCityId() {
            return outletCityId;
        }

        public void setOutletCityId(int outletCityId) {
            this.outletCityId = outletCityId;
        }

        public String getOutletZipCode() {
            return outletZipCode;
        }

        public void setOutletZipCode(String outletZipCode) {
            this.outletZipCode = outletZipCode;
        }

        public String getOtPhoneNo() {
            return otPhoneNo;
        }

        public void setOtPhoneNo(String otPhoneNo) {
            this.otPhoneNo = otPhoneNo;
        }

        public String getOtPhoneNoAlt() {
            return otPhoneNoAlt;
        }

        public void setOtPhoneNoAlt(String otPhoneNoAlt) {
            this.otPhoneNoAlt = otPhoneNoAlt;
        }

        public String getOtMobileNo() {
            return otMobileNo;
        }

        public void setOtMobileNo(String otMobileNo) {
            this.otMobileNo = otMobileNo;
        }

        public String getOtMobileNoAlt() {
            return otMobileNoAlt;
        }

        public void setOtMobileNoAlt(String otMobileNoAlt) {
            this.otMobileNoAlt = otMobileNoAlt;
        }

        public String getOtFaxNo() {
            return otFaxNo;
        }

        public void setOtFaxNo(String otFaxNo) {
            this.otFaxNo = otFaxNo;
        }

        public String getOtFaxNoAlt() {
            return otFaxNoAlt;
        }

        public void setOtFaxNoAlt(String otFaxNoAlt) {
            this.otFaxNoAlt = otFaxNoAlt;
        }

        public OtSocialMediaBean getOtSocialMedia() {
            return otSocialMedia;
        }

        public void setOtSocialMedia(OtSocialMediaBean otSocialMedia) {
            this.otSocialMedia = otSocialMedia;
        }

        public String getOtImageUrl() {
            return otImageUrl;
        }

        public void setOtImageUrl(String otImageUrl) {
            this.otImageUrl = otImageUrl;
        }

        public String getOtLogoStruk() {
            return otLogoStruk;
        }

        public void setOtLogoStruk(String otLogoStruk) {
            this.otLogoStruk = otLogoStruk;
        }

        public int getOtIsActive() {
            return otIsActive;
        }

        public void setOtIsActive(int otIsActive) {
            this.otIsActive = otIsActive;
        }

        public String getOtExpiredAt() {
            return otExpiredAt;
        }

        public void setOtExpiredAt(String otExpiredAt) {
            this.otExpiredAt = otExpiredAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public static class OtSocialMediaBean {
            /**
             * facebook : https://facebook.com
             * instagram : https://instagram.com
             * twitter : https://twitter.com
             * youtube : https://youtube.coms
             */

            @SerializedName("facebook")
            private String facebook;
            @SerializedName("instagram")
            private String instagram;
            @SerializedName("twitter")
            private String twitter;
            @SerializedName("youtube")
            private String youtube;

            public String getFacebook() {
                return facebook;
            }

            public void setFacebook(String facebook) {
                this.facebook = facebook;
            }

            public String getInstagram() {
                return instagram;
            }

            public void setInstagram(String instagram) {
                this.instagram = instagram;
            }

            public String getTwitter() {
                return twitter;
            }

            public void setTwitter(String twitter) {
                this.twitter = twitter;
            }

            public String getYoutube() {
                return youtube;
            }

            public void setYoutube(String youtube) {
                this.youtube = youtube;
            }
        }
    }
}
