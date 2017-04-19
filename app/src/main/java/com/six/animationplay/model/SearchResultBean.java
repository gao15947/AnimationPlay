package com.six.animationplay.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/4/13.
 */

public class SearchResultBean {
    private int code;
    private String seid;
    private int pagesize;
    private int page;
    private SengineBean sengine;
    private int total;
    private int numResults;
    private int numPages;
    private String suggest_keyword;
    private CostBean cost;
    private List<ResultBean> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getSeid() {
        return seid;
    }

    public void setSeid(String seid) {
        this.seid = seid;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public SengineBean getSengine() {
        return sengine;
    }

    public void setSengine(SengineBean sengine) {
        this.sengine = sengine;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNumResults() {
        return numResults;
    }

    public void setNumResults(int numResults) {
        this.numResults = numResults;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public String getSuggest_keyword() {
        return suggest_keyword;
    }

    public void setSuggest_keyword(String suggest_keyword) {
        this.suggest_keyword = suggest_keyword;
    }

    public CostBean getCost() {
        return cost;
    }

    public void setCost(CostBean cost) {
        this.cost = cost;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class SengineBean {
        private String usage;
        private String count;

        public String getUsage() {
            return usage;
        }

        public void setUsage(String usage) {
            this.usage = usage;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }
    }

    public static class CostBean {
        private String timer;
        private String total;
        private String chk_params;
        private String locate_ip;
        private String rcache;
        private String prepare;
        @SerializedName("split words")
        private String _$SplitWords324;
        @SerializedName("suggest words")
        private String _$SuggestWords17;
        private String video_parse;
        private String video_sengine;
        private String video_read_db;
        private String video_score;
        private String video_sort;
        private String special_parse;
        private String bgm_parse;
        private String bgm_sengine;
        private String bgm_read_db;
        private String bgm_score;
        private String bgm_sort;
        private String bgm_format;
        private String special_sengine;
        private String special_read_db;
        private String special_score;
        private String special_sort;
        private String wcache;
        private String state;

        public String getTimer() {
            return timer;
        }

        public void setTimer(String timer) {
            this.timer = timer;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getChk_params() {
            return chk_params;
        }

        public void setChk_params(String chk_params) {
            this.chk_params = chk_params;
        }

        public String getLocate_ip() {
            return locate_ip;
        }

        public void setLocate_ip(String locate_ip) {
            this.locate_ip = locate_ip;
        }

        public String getRcache() {
            return rcache;
        }

        public void setRcache(String rcache) {
            this.rcache = rcache;
        }

        public String getPrepare() {
            return prepare;
        }

        public void setPrepare(String prepare) {
            this.prepare = prepare;
        }

        public String get_$SplitWords324() {
            return _$SplitWords324;
        }

        public void set_$SplitWords324(String _$SplitWords324) {
            this._$SplitWords324 = _$SplitWords324;
        }

        public String get_$SuggestWords17() {
            return _$SuggestWords17;
        }

        public void set_$SuggestWords17(String _$SuggestWords17) {
            this._$SuggestWords17 = _$SuggestWords17;
        }

        public String getVideo_parse() {
            return video_parse;
        }

        public void setVideo_parse(String video_parse) {
            this.video_parse = video_parse;
        }

        public String getVideo_sengine() {
            return video_sengine;
        }

        public void setVideo_sengine(String video_sengine) {
            this.video_sengine = video_sengine;
        }

        public String getVideo_read_db() {
            return video_read_db;
        }

        public void setVideo_read_db(String video_read_db) {
            this.video_read_db = video_read_db;
        }

        public String getVideo_score() {
            return video_score;
        }

        public void setVideo_score(String video_score) {
            this.video_score = video_score;
        }

        public String getVideo_sort() {
            return video_sort;
        }

        public void setVideo_sort(String video_sort) {
            this.video_sort = video_sort;
        }

        public String getSpecial_parse() {
            return special_parse;
        }

        public void setSpecial_parse(String special_parse) {
            this.special_parse = special_parse;
        }

        public String getBgm_parse() {
            return bgm_parse;
        }

        public void setBgm_parse(String bgm_parse) {
            this.bgm_parse = bgm_parse;
        }

        public String getBgm_sengine() {
            return bgm_sengine;
        }

        public void setBgm_sengine(String bgm_sengine) {
            this.bgm_sengine = bgm_sengine;
        }

        public String getBgm_read_db() {
            return bgm_read_db;
        }

        public void setBgm_read_db(String bgm_read_db) {
            this.bgm_read_db = bgm_read_db;
        }

        public String getBgm_score() {
            return bgm_score;
        }

        public void setBgm_score(String bgm_score) {
            this.bgm_score = bgm_score;
        }

        public String getBgm_sort() {
            return bgm_sort;
        }

        public void setBgm_sort(String bgm_sort) {
            this.bgm_sort = bgm_sort;
        }

        public String getBgm_format() {
            return bgm_format;
        }

        public void setBgm_format(String bgm_format) {
            this.bgm_format = bgm_format;
        }

        public String getSpecial_sengine() {
            return special_sengine;
        }

        public void setSpecial_sengine(String special_sengine) {
            this.special_sengine = special_sengine;
        }

        public String getSpecial_read_db() {
            return special_read_db;
        }

        public void setSpecial_read_db(String special_read_db) {
            this.special_read_db = special_read_db;
        }

        public String getSpecial_score() {
            return special_score;
        }

        public void setSpecial_score(String special_score) {
            this.special_score = special_score;
        }

        public String getSpecial_sort() {
            return special_sort;
        }

        public void setSpecial_sort(String special_sort) {
            this.special_sort = special_sort;
        }

        public String getWcache() {
            return wcache;
        }

        public void setWcache(String wcache) {
            this.wcache = wcache;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }

    public static class ResultBean {
        private String type;
        private int id;
        private String author;
        private String mid;
        private int spid;
        private String pic;
        private String thumb;
        private int ischeck;
        private String typename;
        private String typeurl;
        private String title;
        private String tag;
        private String description;
        private int pubdate;
        private int postdate;
        private int lastupdate;
        private int click;
        private int favourite;
        private int attention;
        private long count;
        private String bgmcount;
        private int spcount;
        private int season_id;
        private int is_bangumi;
        private int is_bangumi_end;
        private String arcurl;
        private String aid;
        private String arcrank;
        private int play;
        private int video_review;
        private int favorites;
        private int review;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public int getSpid() {
            return spid;
        }

        public void setSpid(int spid) {
            this.spid = spid;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public int getIscheck() {
            return ischeck;
        }

        public void setIscheck(int ischeck) {
            this.ischeck = ischeck;
        }

        public String getTypename() {
            return typename;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }

        public String getTypeurl() {
            return typeurl;
        }

        public void setTypeurl(String typeurl) {
            this.typeurl = typeurl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getPubdate() {
            return pubdate;
        }

        public void setPubdate(int pubdate) {
            this.pubdate = pubdate;
        }

        public int getPostdate() {
            return postdate;
        }

        public void setPostdate(int postdate) {
            this.postdate = postdate;
        }

        public int getLastupdate() {
            return lastupdate;
        }

        public void setLastupdate(int lastupdate) {
            this.lastupdate = lastupdate;
        }

        public int getClick() {
            return click;
        }

        public void setClick(int click) {
            this.click = click;
        }

        public int getFavourite() {
            return favourite;
        }

        public void setFavourite(int favourite) {
            this.favourite = favourite;
        }

        public int getAttention() {
            return attention;
        }

        public void setAttention(int attention) {
            this.attention = attention;
        }

        public long getCount() {
            return count;
        }

        public void setCount(long count) {
            this.count = count;
        }

        public String getBgmcount() {
            return bgmcount;
        }

        public void setBgmcount(String bgmcount) {
            this.bgmcount = bgmcount;
        }

        public int getSpcount() {
            return spcount;
        }

        public void setSpcount(int spcount) {
            this.spcount = spcount;
        }

        public int getSeason_id() {
            return season_id;
        }

        public void setSeason_id(int season_id) {
            this.season_id = season_id;
        }

        public int getIs_bangumi() {
            return is_bangumi;
        }

        public void setIs_bangumi(int is_bangumi) {
            this.is_bangumi = is_bangumi;
        }

        public int getIs_bangumi_end() {
            return is_bangumi_end;
        }

        public void setIs_bangumi_end(int is_bangumi_end) {
            this.is_bangumi_end = is_bangumi_end;
        }

        public String getArcurl() {
            return arcurl;
        }

        public void setArcurl(String arcurl) {
            this.arcurl = arcurl;
        }

        public String getAid() {
            return aid;
        }

        public void setAid(String aid) {
            this.aid = aid;
        }

        public String getArcrank() {
            return arcrank;
        }

        public void setArcrank(String arcrank) {
            this.arcrank = arcrank;
        }

        public int getPlay() {
            return play;
        }

        public void setPlay(int play) {
            this.play = play;
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

        public int getReview() {
            return review;
        }

        public void setReview(int review) {
            this.review = review;
        }
    }
}
