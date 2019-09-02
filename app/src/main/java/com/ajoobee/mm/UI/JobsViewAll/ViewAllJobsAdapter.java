package com.ajoobee.mm.UI.JobsViewAll;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ajoobee.mm.UI.Listener.ItemClickListener;
import com.ajoobee.mm.R;

import java.util.List;

import com.ajoobee.mm.Data.Obj.VideoModel;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewAllJobsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int VIEW_ITEM = 1;
    private final int VIEW_PROG = 0;

    private List<VideoModel> lstVideo;
    private Context mContext;

    public ViewAllJobsAdapter(Context m, List<VideoModel> lst){
        mContext = m;
        lstVideo = lst;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        if(viewType == VIEW_ITEM) {//create view for Recycler View Item
            // Inflate a new view
            View v =LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_job, parent, false);
            mContext = parent.getContext();
            // add inflated new view to ViewHolder
            vh = new ViewHolder(v);
        }else{
            //Inflate a progress view
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_progress_bar,parent,false);
            //add inflated progress view to ViewHolder
            vh = new ProgressViewHolder(v);

        }

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {

        if(holder instanceof ViewHolder) {
            final VideoModel videoModel = lstVideo.get(i);
            ((ViewHolder) holder).txtJobTitle.setText(videoModel.getUserId());
            ((ViewHolder) holder).txtCompany.setText(videoModel.getDescriptions());
            ((ViewHolder) holder).txtLocation.setText(videoModel.getName());
            ((ViewHolder) holder).txtCountry.setText(videoModel.getChannelName());

            ((ViewHolder) holder).setItemClickListener(new ItemClickListener() {
                @Override
                public void onClick(View view, int position, boolean isLongClick) {
                    Toast.makeText(mContext, "click at " + position, Toast.LENGTH_SHORT).show();
                }
            });
        }else{
            ((ProgressViewHolder)holder).progressBar.setIndeterminate(true);
        }

    }

    @Override
    public int getItemCount() {
        return lstVideo.size();
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

    public static class ProgressViewHolder extends RecyclerView.ViewHolder {
       @BindView(R.id.progressBar)
       ProgressBar progressBar;

        public ProgressViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return lstVideo.get(position) != null ? VIEW_ITEM : VIEW_PROG;
    }




    public void addProgressView(){
        lstVideo.add(null);
        this.notifyItemInserted(lstVideo.size()-1);
    }
    public void removeProgressView(){
        lstVideo.remove(lstVideo.size()-1);
        this.notifyItemRemoved(lstVideo.size());
    }
}
