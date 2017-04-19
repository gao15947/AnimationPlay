package com.six.animationplay.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/5.
 */

public class BangumiIndexBean {
    private int code;
    private int pages;
    private String name;
    private int num;
    private int results;
    private ListBean list;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    public ListBean getList() {
        return list;
    }

    public void setList(ListBean list) {
        this.list = list;
    }

    public static class ListBean {
        @SerializedName("0")
        private BangumiBean _$0;
        @SerializedName("1")
        private BangumiBean _$1;
        @SerializedName("2")
        private BangumiBean _$2;
        @SerializedName("3")
        private BangumiBean _$3;
        @SerializedName("4")
        private BangumiBean _$4;
        @SerializedName("5")
        private BangumiBean _$5;
        @SerializedName("6")
        private BangumiBean _$6;
        @SerializedName("7")
        private BangumiBean _$7;
        @SerializedName("8")
        private BangumiBean _$8;
        @SerializedName("9")
        private BangumiBean _$9;
        @SerializedName("10")
        private BangumiBean _$10;
        @SerializedName("11")
        private BangumiBean _$11;
        @SerializedName("12")
        private BangumiBean _$12;
        @SerializedName("13")
        private BangumiBean _$13;
        @SerializedName("14")
        private BangumiBean _$14;
        @SerializedName("15")
        private BangumiBean _$15;
        @SerializedName("16")
        private BangumiBean _$16;
        @SerializedName("17")
        private BangumiBean _$17;
        @SerializedName("18")
        private BangumiBean _$18;
        @SerializedName("19")
        private BangumiBean _$19;
        private String num;

        public static class BangumiBean {
            private String aid;
            private String copyright;
            private int typeid;
            private String typename;
            private String title;
            private String subtitle;
            private int play;
            private int review;
            private int video_review;
            private int favorites;
            private int mid;
            private String author;
            private String description;
            private String create;
            private String pic;
            private int credit;
            private int coins;
            private String duration;
            private int comment;
            private boolean badgepay;

            public String getAid() {
                return aid;
            }

            public void setAid(String aid) {
                this.aid = aid;
            }

            public String getCopyright() {
                return copyright;
            }

            public void setCopyright(String copyright) {
                this.copyright = copyright;
            }

            public int getTypeid() {
                return typeid;
            }

            public void setTypeid(int typeid) {
                this.typeid = typeid;
            }

            public String getTypename() {
                return typename;
            }

            public void setTypename(String typename) {
                this.typename = typename;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public int getPlay() {
                return play;
            }

            public void setPlay(int play) {
                this.play = play;
            }

            public int getReview() {
                return review;
            }

            public void setReview(int review) {
                this.review = review;
            }

            public int getVideo_review() {
                return video_review;
            }

            public void setVideo_review(int video_review) {
                this.video_review = video_review;
            }

            public int getFavorites() {
                return favorites;
            }

            public void setFavorites(int favorites) {
                this.favorites = favorites;
            }

            public int getMid() {
                return mid;
            }

            public void setMid(int mid) {
                this.mid = mid;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCreate() {
                return create;
            }

            public void setCreate(String create) {
                this.create = create;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public int getCredit() {
                return credit;
            }

            public void setCredit(int credit) {
                this.credit = credit;
            }

            public int getCoins() {
                return coins;
            }

            public void setCoins(int coins) {
                this.coins = coins;
            }

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public int getComment() {
                return comment;
            }

            public void setComment(int comment) {
                this.comment = comment;
            }

            public boolean isBadgepay() {
                return badgepay;
            }

            public void setBadgepay(boolean badgepay) {
                this.badgepay = badgepay;
            }
        }
    }
}
