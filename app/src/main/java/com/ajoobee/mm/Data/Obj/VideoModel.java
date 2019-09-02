package com.ajoobee.mm.Data.Obj;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideoModel {
    private int videoId;
    private String random_id;
    private String descriptions;
    private String image;
    private String smaill_image;
    private String video;
    private String privacy;
    private String profile;
    private String name;
    private String name_eng;
    private String blue_mark = "";
    private String userId;
    private String channelId;
    private String channelName;
    private String channelNameEng;


    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public void setRandom_id(String rid) {
        this.random_id = rid;
    }

    public String getRandom_id() {
        return random_id;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getName_eng() {
        return name_eng;
    }

    public void setName_eng(String name_eng) {
        this.name_eng = name_eng;
    }

    public void setBlue_mark(String blue_mark) {
        this.blue_mark = blue_mark;
    }

    public String getBlue_mark() {
        return blue_mark;
    }

    public String getSmaill_image() {
        return smaill_image;
    }

    public void setSmaill_image(String smaill_image) {
        this.smaill_image = smaill_image;
    }

    public String getChannelNameEng() {
        return channelNameEng;
    }

    public void setChannelNameEng(String channelNameEng) {
        this.channelNameEng = channelNameEng;
    }

}