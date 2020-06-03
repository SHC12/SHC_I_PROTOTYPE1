package com.mobile.pmmp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.pmmp.R;
import com.mobile.pmmp.model.Jadwal;
import com.mobile.pmmp.model.Laporan;

import java.util.List;

public class TableAdapterRiwayatLaporan extends RecyclerView.Adapter {
    private Context mContext;
    private List<Laporan> laporanList;
    private RecyclerViewClickListener mListener;

    public TableAdapterRiwayatLaporan(List<Laporan> laporanList, Context context, RecyclerViewClickListener listener) {
        this.laporanList = laporanList;
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.jadwal_petugas_items, parent, false);

        return new RowViewHolder(itemView, mListener);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        RowViewHolder rowViewHolder = (RowViewHolder) holder;

        int rowPos = rowViewHolder.getAdapterPosition();

        if (rowPos == 0) {

            rowViewHolder.txtNo.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.txtTanggal.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.txtLokasi.setBackgroundResource(R.drawable.table_header_cell_bg);

            rowViewHolder.txtNo.setTextColor(Color.WHITE);
            rowViewHolder.txtTanggal.setTextColor(Color.WHITE);
            rowViewHolder.txtLokasi.setTextColor(Color.WHITE);

            rowViewHolder.txtNo.setText("No");
            rowViewHolder.txtTanggal.setText("Tanggal");
            rowViewHolder.txtLokasi.setText("Lokasi");
        } else {
            Laporan modal = laporanList.get(rowPos - 1);

            rowViewHolder.txtNo.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.txtTanggal.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.txtLokasi.setBackgroundResource(R.drawable.table_content_cell_bg);

            rowViewHolder.txtNo.setTextColor(Color.BLACK);
            rowViewHolder.txtTanggal.setTextColor(Color.BLACK);
            rowViewHolder.txtLokasi.setTextColor(Color.BLACK);
            rowViewHolder.txtNo.setText(modal.getNo() + "");
            rowViewHolder.txtTanggal.setText(modal.getTanggal() + "");
            rowViewHolder.txtLokasi.setText(modal.getLokasi() + "");

        }
    }

    @Override
    public int getItemCount() {
        return laporanList.size() + 1;
    }

    public interface RecyclerViewClickListener {
        void onRowClick(View view, int position);
    }

    public class RowViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtNo;
        TextView txtTanggal;
        TextView txtLokasi;
        RelativeLayout rvItemsJadwal;
        TableAdapterRiwayatLaporan.RecyclerViewClickListener mListener;

        RowViewHolder(View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            txtNo = itemView.findViewById(R.id.txt_no);
            txtTanggal = itemView.findViewById(R.id.txt_tanggal);
            txtLokasi = itemView.findViewById(R.id.txt_lokasi);
            rvItemsJadwal = itemView.findViewById(R.id.rv_item_jadwal_user);
            mListener = listener;
            rvItemsJadwal.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.rv_item_jadwal_user:
                    mListener.onRowClick(rvItemsJadwal, getAdapterPosition());
                    break;

                default:
                    break;
            }
        }
    }
}
