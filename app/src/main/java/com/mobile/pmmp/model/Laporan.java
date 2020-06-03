package com.mobile.pmmp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Laporan implements Parcelable {
    private String no;
    private String tanggal;
    private String lokasi;
    private String statusMesin;
    private String file;

    public Laporan(String no, String tanggal, String lokasi, String statusMesin, String file, String keterangan) {
        this.no = no;
        this.tanggal = tanggal;
        this.lokasi = lokasi;
        this.statusMesin = statusMesin;
        this.file = file;
        this.keterangan = keterangan;
    }

    protected Laporan(Parcel in) {
        no = in.readString();
        tanggal = in.readString();
        lokasi = in.readString();
        statusMesin = in.readString();
        file = in.readString();
        keterangan = in.readString();
    }

    public static final Creator<Laporan> CREATOR = new Creator<Laporan>() {
        @Override
        public Laporan createFromParcel(Parcel in) {
            return new Laporan(in);
        }

        @Override
        public Laporan[] newArray(int size) {
            return new Laporan[size];
        }
    };

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getStatusMesin() {
        return statusMesin;
    }

    public void setStatusMesin(String statusMesin) {
        this.statusMesin = statusMesin;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    private String keterangan;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(no);
        dest.writeString(tanggal);
        dest.writeString(lokasi);
        dest.writeString(statusMesin);
        dest.writeString(file);
        dest.writeString(keterangan);
    }
}
