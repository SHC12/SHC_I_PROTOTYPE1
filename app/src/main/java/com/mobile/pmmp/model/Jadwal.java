package com.mobile.pmmp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Jadwal implements Parcelable {
    private String no;
    private String tanggal;
    private String lokasi;
    private String nama;
    private String shift;

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Jadwal(String no, String tanggal, String lokasi, String statusMesin,String nama, String shift) {
        this.no = no;
        this.tanggal = tanggal;
        this.lokasi = lokasi;
        this.statusMesin = statusMesin;
        this.nama = nama;
        this.shift = shift;
    }

    protected Jadwal(Parcel in) {
        no = in.readString();
        tanggal = in.readString();
        lokasi = in.readString();
        statusMesin = in.readString();
        nama = in.readString();
        shift = in.readString();
    }

    public static final Creator<Jadwal> CREATOR = new Creator<Jadwal>() {
        @Override
        public Jadwal createFromParcel(Parcel in) {
            return new Jadwal(in);
        }

        @Override
        public Jadwal[] newArray(int size) {
            return new Jadwal[size];
        }
    };

    public String getStatusMesin() {
        return statusMesin;
    }

    public void setStatusMesin(String statusMesin) {
        this.statusMesin = statusMesin;
    }

    private String statusMesin;

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
        dest.writeString(nama);
        dest.writeString(shift);
    }
}
