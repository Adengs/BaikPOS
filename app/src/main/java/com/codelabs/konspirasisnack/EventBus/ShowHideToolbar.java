package com.codelabs.konspirasisnack.EventBus;

public class ShowHideToolbar {

    public static final int POSITION_KASIR = 1;
    public static final int POSITION_PENJUALAN = 2;
    public static final int POSITION_LAPORAN = 3;
    public static final int POSITION_ABSENSI = 4;
    public static final int POSITION_PENGATURAN_PRODUK = 5;
    public static final int POSITION_PENGATURAN_KATEGORI = 6;
    public static final int POSITION_PENGATURAN_KARYAWAN = 7;
    public static final int POSITION_PENGATURAN_PROMO = 8;
    public static final int POSITION_PENGATURAN_PEMBAYARAN_NON_TUNAI = 9;
    public static final int POSITION_PENGATURAN_PASSWORD_PIN = 10;
    public static final int POSITION_PENGATURAN_OUTLET = 11;
    public static final int POSITION_PENGATURAN_PERANGKAT = 12;
    public static final int POSITION_PENGATURAN_STRUK_BIAYA= 13;
    public static final int POSITION_LAPORAN_TUTUP_KASIR = 14;
    public static final int POSITION_LAPORAN_KAS_KASIR = 15;
    public static final int POSITION_LAPORAN_KOMISI = 16;
    public static final int POSITION_STOK = 17;
    public static final int POSITION_DETAIL = 18;

    private int position;
    private int contentWidth;
    public ShowHideToolbar(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public int getContentWidth() {
        return contentWidth;
    }

    public void setContentWidth(int contentWidth) {
        this.contentWidth = contentWidth;
    }
}
