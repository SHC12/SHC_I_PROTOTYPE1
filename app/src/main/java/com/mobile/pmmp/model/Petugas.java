package com.mobile.pmmp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Petugas implements Parcelable {
    private String no;
    private String idPetugas;
    private String namaLengkap;

    public Petugas(String no, String idPetugas, String namaLengkap, String username, String password) {
        this.no = no;
        this.idPetugas = idPetugas;
        this.namaLengkap = namaLengkap;
        this.username = username;
        this.password = password;
    }

    private String username;
    private String password;

    protected Petugas(Parcel in) {
        no = in.readString();
        idPetugas = in.readString();
        namaLengkap = in.readString();
        username = in.readString();
        password = in.readString();
    }

    public static final Creator<Petugas> CREATOR = new Creator<Petugas>() {
        @Override
        public Petugas createFromParcel(Parcel in) {
            return new Petugas(in);
        }

        @Override
        public Petugas[] newArray(int size) {
            return new Petugas[size];
        }
    };

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getIdPetugas() {
        return idPetugas;
    }

    public void setIdPetugas(String idPetugas) {
        this.idPetugas = idPetugas;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(no);
        dest.writeString(idPetugas);
        dest.writeString(namaLengkap);
        dest.writeString(username);
        dest.writeString(password);
    }
}
