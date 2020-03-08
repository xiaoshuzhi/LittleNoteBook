package com.Entity;

import java.util.ArrayList;
import java.util.List;

public class NoteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NoteExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andNoteidIsNull() {
            addCriterion("noteid is null");
            return (Criteria) this;
        }

        public Criteria andNoteidIsNotNull() {
            addCriterion("noteid is not null");
            return (Criteria) this;
        }

        public Criteria andNoteidEqualTo(Integer value) {
            addCriterion("noteid =", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidNotEqualTo(Integer value) {
            addCriterion("noteid <>", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidGreaterThan(Integer value) {
            addCriterion("noteid >", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidGreaterThanOrEqualTo(Integer value) {
            addCriterion("noteid >=", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidLessThan(Integer value) {
            addCriterion("noteid <", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidLessThanOrEqualTo(Integer value) {
            addCriterion("noteid <=", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidIn(List<Integer> values) {
            addCriterion("noteid in", values, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidNotIn(List<Integer> values) {
            addCriterion("noteid not in", values, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidBetween(Integer value1, Integer value2) {
            addCriterion("noteid between", value1, value2, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidNotBetween(Integer value1, Integer value2) {
            addCriterion("noteid not between", value1, value2, "noteid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andDirectoryIdIsNull() {
            addCriterion("directory_id is null");
            return (Criteria) this;
        }

        public Criteria andDirectoryIdIsNotNull() {
            addCriterion("directory_id is not null");
            return (Criteria) this;
        }

        public Criteria andDirectoryIdEqualTo(Integer value) {
            addCriterion("directory_id =", value, "directoryId");
            return (Criteria) this;
        }

        public Criteria andDirectoryIdNotEqualTo(Integer value) {
            addCriterion("directory_id <>", value, "directoryId");
            return (Criteria) this;
        }

        public Criteria andDirectoryIdGreaterThan(Integer value) {
            addCriterion("directory_id >", value, "directoryId");
            return (Criteria) this;
        }

        public Criteria andDirectoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("directory_id >=", value, "directoryId");
            return (Criteria) this;
        }

        public Criteria andDirectoryIdLessThan(Integer value) {
            addCriterion("directory_id <", value, "directoryId");
            return (Criteria) this;
        }

        public Criteria andDirectoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("directory_id <=", value, "directoryId");
            return (Criteria) this;
        }

        public Criteria andDirectoryIdIn(List<Integer> values) {
            addCriterion("directory_id in", values, "directoryId");
            return (Criteria) this;
        }

        public Criteria andDirectoryIdNotIn(List<Integer> values) {
            addCriterion("directory_id not in", values, "directoryId");
            return (Criteria) this;
        }

        public Criteria andDirectoryIdBetween(Integer value1, Integer value2) {
            addCriterion("directory_id between", value1, value2, "directoryId");
            return (Criteria) this;
        }

        public Criteria andDirectoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("directory_id not between", value1, value2, "directoryId");
            return (Criteria) this;
        }

        public Criteria andAbstractnoteIsNull() {
            addCriterion("abstractnote is null");
            return (Criteria) this;
        }

        public Criteria andAbstractnoteIsNotNull() {
            addCriterion("abstractnote is not null");
            return (Criteria) this;
        }

        public Criteria andAbstractnoteEqualTo(String value) {
            addCriterion("abstractnote =", value, "abstractnote");
            return (Criteria) this;
        }

        public Criteria andAbstractnoteNotEqualTo(String value) {
            addCriterion("abstractnote <>", value, "abstractnote");
            return (Criteria) this;
        }

        public Criteria andAbstractnoteGreaterThan(String value) {
            addCriterion("abstractnote >", value, "abstractnote");
            return (Criteria) this;
        }

        public Criteria andAbstractnoteGreaterThanOrEqualTo(String value) {
            addCriterion("abstractnote >=", value, "abstractnote");
            return (Criteria) this;
        }

        public Criteria andAbstractnoteLessThan(String value) {
            addCriterion("abstractnote <", value, "abstractnote");
            return (Criteria) this;
        }

        public Criteria andAbstractnoteLessThanOrEqualTo(String value) {
            addCriterion("abstractnote <=", value, "abstractnote");
            return (Criteria) this;
        }

        public Criteria andAbstractnoteLike(String value) {
            addCriterion("abstractnote like", value, "abstractnote");
            return (Criteria) this;
        }

        public Criteria andAbstractnoteNotLike(String value) {
            addCriterion("abstractnote not like", value, "abstractnote");
            return (Criteria) this;
        }

        public Criteria andAbstractnoteIn(List<String> values) {
            addCriterion("abstractnote in", values, "abstractnote");
            return (Criteria) this;
        }

        public Criteria andAbstractnoteNotIn(List<String> values) {
            addCriterion("abstractnote not in", values, "abstractnote");
            return (Criteria) this;
        }

        public Criteria andAbstractnoteBetween(String value1, String value2) {
            addCriterion("abstractnote between", value1, value2, "abstractnote");
            return (Criteria) this;
        }

        public Criteria andAbstractnoteNotBetween(String value1, String value2) {
            addCriterion("abstractnote not between", value1, value2, "abstractnote");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(String value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(String value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(String value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(String value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLike(String value) {
            addCriterion("createtime like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotLike(String value) {
            addCriterion("createtime not like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<String> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<String> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(String value1, String value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(String value1, String value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(String value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(String value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(String value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(String value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLike(String value) {
            addCriterion("updatetime like", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotLike(String value) {
            addCriterion("updatetime not like", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<String> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<String> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(String value1, String value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andIslockedIsNull() {
            addCriterion("islocked is null");
            return (Criteria) this;
        }

        public Criteria andIslockedIsNotNull() {
            addCriterion("islocked is not null");
            return (Criteria) this;
        }

        public Criteria andIslockedEqualTo(String value) {
            addCriterion("islocked =", value, "islocked");
            return (Criteria) this;
        }

        public Criteria andIslockedNotEqualTo(String value) {
            addCriterion("islocked <>", value, "islocked");
            return (Criteria) this;
        }

        public Criteria andIslockedGreaterThan(String value) {
            addCriterion("islocked >", value, "islocked");
            return (Criteria) this;
        }

        public Criteria andIslockedGreaterThanOrEqualTo(String value) {
            addCriterion("islocked >=", value, "islocked");
            return (Criteria) this;
        }

        public Criteria andIslockedLessThan(String value) {
            addCriterion("islocked <", value, "islocked");
            return (Criteria) this;
        }

        public Criteria andIslockedLessThanOrEqualTo(String value) {
            addCriterion("islocked <=", value, "islocked");
            return (Criteria) this;
        }

        public Criteria andIslockedLike(String value) {
            addCriterion("islocked like", value, "islocked");
            return (Criteria) this;
        }

        public Criteria andIslockedNotLike(String value) {
            addCriterion("islocked not like", value, "islocked");
            return (Criteria) this;
        }

        public Criteria andIslockedIn(List<String> values) {
            addCriterion("islocked in", values, "islocked");
            return (Criteria) this;
        }

        public Criteria andIslockedNotIn(List<String> values) {
            addCriterion("islocked not in", values, "islocked");
            return (Criteria) this;
        }

        public Criteria andIslockedBetween(String value1, String value2) {
            addCriterion("islocked between", value1, value2, "islocked");
            return (Criteria) this;
        }

        public Criteria andIslockedNotBetween(String value1, String value2) {
            addCriterion("islocked not between", value1, value2, "islocked");
            return (Criteria) this;
        }

        public Criteria andIsdeleIsNull() {
            addCriterion("isdele is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleIsNotNull() {
            addCriterion("isdele is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleEqualTo(String value) {
            addCriterion("isdele =", value, "isdele");
            return (Criteria) this;
        }

        public Criteria andIsdeleNotEqualTo(String value) {
            addCriterion("isdele <>", value, "isdele");
            return (Criteria) this;
        }

        public Criteria andIsdeleGreaterThan(String value) {
            addCriterion("isdele >", value, "isdele");
            return (Criteria) this;
        }

        public Criteria andIsdeleGreaterThanOrEqualTo(String value) {
            addCriterion("isdele >=", value, "isdele");
            return (Criteria) this;
        }

        public Criteria andIsdeleLessThan(String value) {
            addCriterion("isdele <", value, "isdele");
            return (Criteria) this;
        }

        public Criteria andIsdeleLessThanOrEqualTo(String value) {
            addCriterion("isdele <=", value, "isdele");
            return (Criteria) this;
        }

        public Criteria andIsdeleLike(String value) {
            addCriterion("isdele like", value, "isdele");
            return (Criteria) this;
        }

        public Criteria andIsdeleNotLike(String value) {
            addCriterion("isdele not like", value, "isdele");
            return (Criteria) this;
        }

        public Criteria andIsdeleIn(List<String> values) {
            addCriterion("isdele in", values, "isdele");
            return (Criteria) this;
        }

        public Criteria andIsdeleNotIn(List<String> values) {
            addCriterion("isdele not in", values, "isdele");
            return (Criteria) this;
        }

        public Criteria andIsdeleBetween(String value1, String value2) {
            addCriterion("isdele between", value1, value2, "isdele");
            return (Criteria) this;
        }

        public Criteria andIsdeleNotBetween(String value1, String value2) {
            addCriterion("isdele not between", value1, value2, "isdele");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNull() {
            addCriterion("filename is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("filename is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("filename =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("filename <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("filename >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("filename >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("filename <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("filename <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("filename like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("filename not like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(List<String> values) {
            addCriterion("filename in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(List<String> values) {
            addCriterion("filename not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("filename between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("filename not between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(Float value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(Float value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(Float value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(Float value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(Float value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(Float value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<Float> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<Float> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(Float value1, Float value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(Float value1, Float value2) {
            addCriterion("size not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andContentTypeIsNull() {
            addCriterion("content_type is null");
            return (Criteria) this;
        }

        public Criteria andContentTypeIsNotNull() {
            addCriterion("content_type is not null");
            return (Criteria) this;
        }

        public Criteria andContentTypeEqualTo(String value) {
            addCriterion("content_type =", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotEqualTo(String value) {
            addCriterion("content_type <>", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeGreaterThan(String value) {
            addCriterion("content_type >", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("content_type >=", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLessThan(String value) {
            addCriterion("content_type <", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLessThanOrEqualTo(String value) {
            addCriterion("content_type <=", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLike(String value) {
            addCriterion("content_type like", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotLike(String value) {
            addCriterion("content_type not like", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeIn(List<String> values) {
            addCriterion("content_type in", values, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotIn(List<String> values) {
            addCriterion("content_type not in", values, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeBetween(String value1, String value2) {
            addCriterion("content_type between", value1, value2, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotBetween(String value1, String value2) {
            addCriterion("content_type not between", value1, value2, "contentType");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}