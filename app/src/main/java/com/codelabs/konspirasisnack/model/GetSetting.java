package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

public class GetSetting {

    @SerializedName("DATA")
    private DATA DATA;
    @SerializedName("MESSAGE")
    private String MESSAGE;
    @SerializedName("STATUS")
    private int STATUS;

    public DATA getDATA() {
        return DATA;
    }

    public void setDATA(DATA DATA) {
        this.DATA = DATA;
    }

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

    public static class DATA {

        @SerializedName("id")
        private int id;
        @SerializedName("merchant_id")
        private int merchantId;
        @SerializedName("outlet_id")
        private String outletId;
        @SerializedName("settings")
        private Settings settings;
        @SerializedName("updated_by")
        private int updatedBy;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("is_master")
        private int isMaster;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(int merchantId) {
            this.merchantId = merchantId;
        }

        public String getOutletId() {
            return outletId;
        }

        public void setOutletId(String outletId) {
            this.outletId = outletId;
        }

        public Settings getSettings() {
            return settings;
        }

        public void setSettings(Settings settings) {
            this.settings = settings;
        }

        public int getUpdatedBy() {
            return updatedBy;
        }

        public void setUpdatedBy(int updatedBy) {
            this.updatedBy = updatedBy;
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

        public int getIsMaster() {
            return isMaster;
        }

        public void setIsMaster(int isMaster) {
            this.isMaster = isMaster;
        }

        public static class Settings {


            @SerializedName("tax")
            private Tax tax;
            @SerializedName("service")
            private Service service;
            @SerializedName("pembulatan")
            private Pembulatan pembulatan;
            @SerializedName("struk")
            private Struk struk;

            public Tax getTax() {
                return tax;
            }

            public void setTax(Tax tax) {
                this.tax = tax;
            }

            public Service getService() {
                return service;
            }

            public void setService(Service service) {
                this.service = service;
            }

            public Pembulatan getPembulatan() {
                return pembulatan;
            }

            public void setPembulatan(Pembulatan pembulatan) {
                this.pembulatan = pembulatan;
            }

            public Struk getStruk() {
                return struk;
            }

            public void setStruk(Struk struk) {
                this.struk = struk;
            }

            public static class Tax {

                @SerializedName("is_active")
                private String isActive;
                @SerializedName("tax_type")
                private String taxType;
                @SerializedName("percentage")
                private String percentage;

                public boolean getIsActive() {
                    return isActive.equals("on");
                }

                public void setIsActive(String isActive) {
                    this.isActive = isActive;
                }

                public String getTaxType() {
                    return taxType;
                }

                public void setTaxType(String taxType) {
                    this.taxType = taxType;
                }

                public String getPercentage() {
                    return percentage;
                }

                public void setPercentage(String percentage) {
                    this.percentage = percentage;
                }

                public String getRealIsActive() {
                    return isActive;
                }
            }

            public static class Service {

                @SerializedName("is_active")
                private String isActive;
                @SerializedName("percentage")
                private String percentage;
                @SerializedName("table")
                private String table;
                @SerializedName("free_table")
                private String freeTable;
                @SerializedName("bungkus")
                private String bungkus;
                @SerializedName("pengiriman")
                private String pengiriman;
                @SerializedName("ojek_online")
                private String ojekOnline;
                @SerializedName("reservasi")
                private String reservasi;
                @SerializedName("jasa")
                private String jasa;
                @SerializedName("lainnya")
                private String lainnya;

                public boolean getIsActive() {
                    return isActive.equals("on");
                }

                public void setIsActive(String isActive) {
                    this.isActive = isActive;
                }

                public String getPercentage() {
                    return percentage;
                }

                public void setPercentage(String percentage) {
                    this.percentage = percentage;
                }

                public String getTable() {
                    return table;
                }

                public void setTable(String table) {
                    this.table = table;
                }

                public String getFreeTable() {
                    return freeTable;
                }

                public void setFreeTable(String freeTable) {
                    this.freeTable = freeTable;
                }

                public String getBungkus() {
                    return bungkus;
                }

                public void setBungkus(String bungkus) {
                    this.bungkus = bungkus;
                }

                public String getPengiriman() {
                    return pengiriman;
                }

                public void setPengiriman(String pengiriman) {
                    this.pengiriman = pengiriman;
                }

                public String getOjekOnline() {
                    return ojekOnline;
                }

                public void setOjekOnline(String ojekOnline) {
                    this.ojekOnline = ojekOnline;
                }

                public String getReservasi() {
                    return reservasi;
                }

                public void setReservasi(String reservasi) {
                    this.reservasi = reservasi;
                }

                public String getJasa() {
                    return jasa;
                }

                public void setJasa(String jasa) {
                    this.jasa = jasa;
                }

                public String getLainnya() {
                    return lainnya;
                }

                public void setLainnya(String lainnya) {
                    this.lainnya = lainnya;
                }

                public String getRealIsActive() {
                    return isActive;
                }
            }

            public static class Pembulatan {
                /**
                 * is_active : 0
                 * value : 500
                 */

                @SerializedName("is_active")
                private String isActive;
                @SerializedName("value")
                private String value;

                public boolean getIsActive() {
                    return isActive.equals("on");
                }

                public void setIsActive(String isActive) {
                    this.isActive = isActive;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                public String getRealIsActive() {
                    return isActive;
                }
            }

            public static class Struk {

                @SerializedName("is_active")
                private String isActive;
                @SerializedName("logo")
                private String logo;
                @SerializedName("logo_is_active")
                private String logoIsActive;
                @SerializedName("negara")
                private String negara;
                @SerializedName("nama_usaha")
                private String namaUsaha;
                @SerializedName("telepon")
                private String telepon;
                @SerializedName("nama_outlet")
                private String namaOutlet;
                @SerializedName("email")
                private String email;
                @SerializedName("alamat")
                private String alamat;
                @SerializedName("media_sosial")
                private String mediaSosial;
                @SerializedName("kota")
                private String kota;
                @SerializedName("provinsi")
                private String provinsi;
                @SerializedName("header")
                private String header;
                @SerializedName("header_is_active")
                private String headerIsActive;
                @SerializedName("footer")
                private String footer;
                @SerializedName("footer_is_active")
                private String footerIsActive;
                @SerializedName("catatan")
                private String catatan;
                @SerializedName("catatan_is_active")
                private String catatanIsActive;
                @SerializedName("max_struk")
                private String maxStruk;
                @SerializedName("no_urut")
                private String noUrut;
                @SerializedName("no_urut_is_active")
                private String noUrutIsActive;

                public String getIsActive() {
                    return isActive;
                }

                public void setIsActive(String isActive) {
                    this.isActive = isActive;
                }

                public String getLogo() {
                    return logo;
                }

                public void setLogo(String logo) {
                    this.logo = logo;
                }

                public String getLogoIsActive() {
                    return logoIsActive;
                }

                public void setLogoIsActive(String logoIsActive) {
                    this.logoIsActive = logoIsActive;
                }

                public String getNegara() {
                    return negara;
                }

                public void setNegara(String negara) {
                    this.negara = negara;
                }

                public String getNamaUsaha() {
                    return namaUsaha;
                }

                public void setNamaUsaha(String namaUsaha) {
                    this.namaUsaha = namaUsaha;
                }

                public String getTelepon() {
                    return telepon;
                }

                public void setTelepon(String telepon) {
                    this.telepon = telepon;
                }

                public String getNamaOutlet() {
                    return namaOutlet;
                }

                public void setNamaOutlet(String namaOutlet) {
                    this.namaOutlet = namaOutlet;
                }

                public String getEmail() {
                    return email;
                }

                public void setEmail(String email) {
                    this.email = email;
                }

                public String getAlamat() {
                    return alamat;
                }

                public void setAlamat(String alamat) {
                    this.alamat = alamat;
                }

                public String getMediaSosial() {
                    return mediaSosial;
                }

                public void setMediaSosial(String mediaSosial) {
                    this.mediaSosial = mediaSosial;
                }

                public String getKota() {
                    return kota;
                }

                public void setKota(String kota) {
                    this.kota = kota;
                }

                public String getProvinsi() {
                    return provinsi;
                }

                public void setProvinsi(String provinsi) {
                    this.provinsi = provinsi;
                }

                public String getHeader() {
                    return header;
                }

                public void setHeader(String header) {
                    this.header = header;
                }

                public String getHeaderIsActive() {
                    return headerIsActive;
                }

                public void setHeaderIsActive(String headerIsActive) {
                    this.headerIsActive = headerIsActive;
                }

                public String getFooter() {
                    return footer;
                }

                public void setFooter(String footer) {
                    this.footer = footer;
                }

                public String getFooterIsActive() {
                    return footerIsActive;
                }

                public void setFooterIsActive(String footerIsActive) {
                    this.footerIsActive = footerIsActive;
                }

                public String getCatatan() {
                    return catatan;
                }

                public void setCatatan(String catatan) {
                    this.catatan = catatan;
                }

                public String getCatatanIsActive() {
                    return catatanIsActive;
                }

                public void setCatatanIsActive(String catatanIsActive) {
                    this.catatanIsActive = catatanIsActive;
                }

                public String getMaxStruk() {
                    return maxStruk;
                }

                public void setMaxStruk(String maxStruk) {
                    this.maxStruk = maxStruk;
                }

                public String getNoUrut() {
                    return noUrut;
                }

                public void setNoUrut(String noUrut) {
                    this.noUrut = noUrut;
                }

                public boolean getNoUrutIsActive() {
                    return noUrutIsActive.equals("on");
                }

                public String getRealNoUrutIsActive() {
                    return noUrutIsActive;
                }

                public void setNoUrutIsActive(String noUrutIsActive) {
                    this.noUrutIsActive = noUrutIsActive;
                }
            }
        }
    }
}
