package com.ajoobee.mm.Util;

import android.support.v7.util.DiffUtil;

import java.util.List;

import com.ajoobee.mm.Data.Obj.VideoModel;

public class Diff extends DiffUtil.Callback{

    List<VideoModel> lstOld;
    List<VideoModel> lstNew;

    public Diff(List<VideoModel> lstNew, List<VideoModel> lstOld) {
        this.lstNew = lstNew;
        this.lstOld = lstOld;
    }

    @Override
    public int getOldListSize() {
        return lstOld.size();
    }

    @Override
    public int getNewListSize() {
        return lstNew.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        boolean b= false;
        if(lstOld.get(oldItemPosition) != null && lstNew.get(newItemPosition) != null) {
            b = lstOld.get(oldItemPosition).getVideoId() == lstNew.get(newItemPosition).getVideoId();
        }
        return  b;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        boolean b= false;
        if(lstOld.get(oldItemPosition) != null && lstNew.get(newItemPosition) != null) {
            b = lstOld.get(oldItemPosition).equals(lstNew.get(newItemPosition));
        }
        return  b;
    }
    
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        //you can return particular field for changed item.
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}