package com.Entity;

import java.util.ArrayList;
import java.util.List;

public class ImgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImgExample() {
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

        public Criteria andImgidIsNull() {
            addCriterion("imgid is null");
            return (Criteria) this;
        }

        public Criteria andImgidIsNotNull() {
            addCriterion("imgid is not null");
            return (Criteria) this;
        }

        public Criteria andImgidEqualTo(String value) {
            addCriterion("imgid =", value, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidNotEqualTo(String value) {
            addCriterion("imgid <>", value, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidGreaterThan(String value) {
            addCriterion("imgid >", value, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidGreaterThanOrEqualTo(String value) {
            addCriterion("imgid >=", value, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidLessThan(String value) {
            addCriterion("imgid <", value, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidLessThanOrEqualTo(String value) {
            addCriterion("imgid <=", value, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidLike(String value) {
            addCriterion("imgid like", value, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidNotLike(String value) {
            addCriterion("imgid not like", value, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidIn(List<String> values) {
            addCriterion("imgid in", values, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidNotIn(List<String> values) {
            addCriterion("imgid not in", values, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidBetween(String value1, String value2) {
            addCriterion("imgid between", value1, value2, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidNotBetween(String value1, String value2) {
            addCriterion("imgid not between", value1, value2, "imgid");
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

        public Criteria andIngnameIsNull() {
            addCriterion("ingname is null");
            return (Criteria) this;
        }

        public Criteria andIngnameIsNotNull() {
            addCriterion("ingname is not null");
            return (Criteria) this;
        }

        public Criteria andIngnameEqualTo(String value) {
            addCriterion("ingname =", value, "ingname");
            return (Criteria) this;
        }

        public Criteria andIngnameNotEqualTo(String value) {
            addCriterion("ingname <>", value, "ingname");
            return (Criteria) this;
        }

        public Criteria andIngnameGreaterThan(String value) {
            addCriterion("ingname >", value, "ingname");
            return (Criteria) this;
        }

        public Criteria andIngnameGreaterThanOrEqualTo(String value) {
            addCriterion("ingname >=", value, "ingname");
            return (Criteria) this;
        }

        public Criteria andIngnameLessThan(String value) {
            addCriterion("ingname <", value, "ingname");
            return (Criteria) this;
        }

        public Criteria andIngnameLessThanOrEqualTo(String value) {
            addCriterion("ingname <=", value, "ingname");
            return (Criteria) this;
        }

        public Criteria andIngnameLike(String value) {
            addCriterion("ingname like", value, "ingname");
            return (Criteria) this;
        }

        public Criteria andIngnameNotLike(String value) {
            addCriterion("ingname not like", value, "ingname");
            return (Criteria) this;
        }

        public Criteria andIngnameIn(List<String> values) {
            addCriterion("ingname in", values, "ingname");
            return (Criteria) this;
        }

        public Criteria andIngnameNotIn(List<String> values) {
            addCriterion("ingname not in", values, "ingname");
            return (Criteria) this;
        }

        public Criteria andIngnameBetween(String value1, String value2) {
            addCriterion("ingname between", value1, value2, "ingname");
            return (Criteria) this;
        }

        public Criteria andIngnameNotBetween(String value1, String value2) {
            addCriterion("ingname not between", value1, value2, "ingname");
            return (Criteria) this;
        }

        public Criteria andImgsizeIsNull() {
            addCriterion("imgsize is null");
            return (Criteria) this;
        }

        public Criteria andImgsizeIsNotNull() {
            addCriterion("imgsize is not null");
            return (Criteria) this;
        }

        public Criteria andImgsizeEqualTo(Double value) {
            addCriterion("imgsize =", value, "imgsize");
            return (Criteria) this;
        }

        public Criteria andImgsizeNotEqualTo(Double value) {
            addCriterion("imgsize <>", value, "imgsize");
            return (Criteria) this;
        }

        public Criteria andImgsizeGreaterThan(Double value) {
            addCriterion("imgsize >", value, "imgsize");
            return (Criteria) this;
        }

        public Criteria andImgsizeGreaterThanOrEqualTo(Double value) {
            addCriterion("imgsize >=", value, "imgsize");
            return (Criteria) this;
        }

        public Criteria andImgsizeLessThan(Double value) {
            addCriterion("imgsize <", value, "imgsize");
            return (Criteria) this;
        }

        public Criteria andImgsizeLessThanOrEqualTo(Double value) {
            addCriterion("imgsize <=", value, "imgsize");
            return (Criteria) this;
        }

        public Criteria andImgsizeIn(List<Double> values) {
            addCriterion("imgsize in", values, "imgsize");
            return (Criteria) this;
        }

        public Criteria andImgsizeNotIn(List<Double> values) {
            addCriterion("imgsize not in", values, "imgsize");
            return (Criteria) this;
        }

        public Criteria andImgsizeBetween(Double value1, Double value2) {
            addCriterion("imgsize between", value1, value2, "imgsize");
            return (Criteria) this;
        }

        public Criteria andImgsizeNotBetween(Double value1, Double value2) {
            addCriterion("imgsize not between", value1, value2, "imgsize");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNull() {
            addCriterion("isdelete is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNotNull() {
            addCriterion("isdelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteEqualTo(String value) {
            addCriterion("isdelete =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(String value) {
            addCriterion("isdelete <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(String value) {
            addCriterion("isdelete >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(String value) {
            addCriterion("isdelete >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(String value) {
            addCriterion("isdelete <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(String value) {
            addCriterion("isdelete <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLike(String value) {
            addCriterion("isdelete like", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotLike(String value) {
            addCriterion("isdelete not like", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(List<String> values) {
            addCriterion("isdelete in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(List<String> values) {
            addCriterion("isdelete not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(String value1, String value2) {
            addCriterion("isdelete between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(String value1, String value2) {
            addCriterion("isdelete not between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andImgtypeIsNull() {
            addCriterion("imgtype is null");
            return (Criteria) this;
        }

        public Criteria andImgtypeIsNotNull() {
            addCriterion("imgtype is not null");
            return (Criteria) this;
        }

        public Criteria andImgtypeEqualTo(String value) {
            addCriterion("imgtype =", value, "imgtype");
            return (Criteria) this;
        }

        public Criteria andImgtypeNotEqualTo(String value) {
            addCriterion("imgtype <>", value, "imgtype");
            return (Criteria) this;
        }

        public Criteria andImgtypeGreaterThan(String value) {
            addCriterion("imgtype >", value, "imgtype");
            return (Criteria) this;
        }

        public Criteria andImgtypeGreaterThanOrEqualTo(String value) {
            addCriterion("imgtype >=", value, "imgtype");
            return (Criteria) this;
        }

        public Criteria andImgtypeLessThan(String value) {
            addCriterion("imgtype <", value, "imgtype");
            return (Criteria) this;
        }

        public Criteria andImgtypeLessThanOrEqualTo(String value) {
            addCriterion("imgtype <=", value, "imgtype");
            return (Criteria) this;
        }

        public Criteria andImgtypeLike(String value) {
            addCriterion("imgtype like", value, "imgtype");
            return (Criteria) this;
        }

        public Criteria andImgtypeNotLike(String value) {
            addCriterion("imgtype not like", value, "imgtype");
            return (Criteria) this;
        }

        public Criteria andImgtypeIn(List<String> values) {
            addCriterion("imgtype in", values, "imgtype");
            return (Criteria) this;
        }

        public Criteria andImgtypeNotIn(List<String> values) {
            addCriterion("imgtype not in", values, "imgtype");
            return (Criteria) this;
        }

        public Criteria andImgtypeBetween(String value1, String value2) {
            addCriterion("imgtype between", value1, value2, "imgtype");
            return (Criteria) this;
        }

        public Criteria andImgtypeNotBetween(String value1, String value2) {
            addCriterion("imgtype not between", value1, value2, "imgtype");
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