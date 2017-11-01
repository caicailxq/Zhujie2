package com.bawei.zhujie2;

/**
 * Created by Administrator on 2017/11/1.
 */

public class Qbean {

    /**
     * errNo : 0
     * errMsg : OK
     * data : {"id":1,"title":"Java缂栫▼鎬濇兂","type":"缂栫▼璇█","description":"C++銆丣ava涓殑鍦ｇ粡绾ц憲浣�","picture":"http://img14.360buyimg.com/n1/jfs/t2191/111/699154754/198998/32d7bfe0/5624b582Nbc01af5b.jpg","isRecommend":false,"dtCreated":"00-00 00:01"}
     */

    private int errNo;
    private String errMsg;
    private DataBean data;

    public int getErrNo() {
        return errNo;
    }

    public void setErrNo(int errNo) {
        this.errNo = errNo;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * title : Java缂栫▼鎬濇兂
         * type : 缂栫▼璇█
         * description : C++銆丣ava涓殑鍦ｇ粡绾ц憲浣�
         * picture : http://img14.360buyimg.com/n1/jfs/t2191/111/699154754/198998/32d7bfe0/5624b582Nbc01af5b.jpg
         * isRecommend : false
         * dtCreated : 00-00 00:01
         */

        private int id;
        private String title;
        private String type;
        private String description;
        private String picture;
        private boolean isRecommend;
        private String dtCreated;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public boolean isIsRecommend() {
            return isRecommend;
        }

        public void setIsRecommend(boolean isRecommend) {
            this.isRecommend = isRecommend;
        }

        public String getDtCreated() {
            return dtCreated;
        }

        public void setDtCreated(String dtCreated) {
            this.dtCreated = dtCreated;
        }
    }
}
