package com.ajoobee.mm.UI.Jobs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ajoobee.mm.UI.Listener.ItemClickListener;
import com.ajoobee.mm.R;

import java.util.List;

import com.ajoobee.mm.Data.Obj.Job;
import butterknife.BindView;
import butterknife.ButterKnife;

public class JobsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Job> lstJob;
    private Context mContext;

    public JobsAdapter(Context m, List<Job> lst){
        mContext = m;
        lstJob = lst;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_job, parent, false);
        mContext = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {

        final Job job = lstJob.get(i);
        ((ViewHolder) holder).txtJobTitle.setText(job.getJobTitle());
        ((ViewHolder) holder).txtCompany.setText(job.getCompanyName());
        ((ViewHolder) holder).txtLocation.setText(job.getLocation());
        ((ViewHolder) holder).txtCountry.setText(job.getCountry());
        ((ViewHolder) holder).txtDate.setText(job.getDate());

        ((ViewHolder)holder).setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Toast.makeText(mContext,"click at " + position,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return lstJob.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ItemClickListener itemClickListener;

        @BindView(R.id.txtJobTitle)
        TextView txtJobTitle;

        @BindView(R.id.txtCompany)
        TextView txtCompany;

        @BindView(R.id.txtLocation)
        TextView txtLocation;

        @BindView(R.id.txtCountry)
        TextView txtCountry;

        @BindView(R.id.txtDate)
        TextView txtDate;

        View view;
        public ViewHolder(View v){
            super(v);
            ButterKnife.bind(this, itemView);
            view = v;
            view.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }


        @Override
        public void onClick(View v) {
            itemClickListener.onClick(view,getAdapterPosition(),false);
        }
    }
}
