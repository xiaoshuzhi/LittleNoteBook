package com.Entity;

import java.util.ArrayList;
import java.util.List;

public class DirectoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DirectoryExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andDirectoryNameIsNull() {
            addCriterion("directory_name is null");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameIsNotNull() {
            addCriterion("directory_name is not null");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameEqualTo(String value) {
            addCriterion("directory_name =", value, "directoryName");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameNotEqualTo(String value) {
            addCriterion("directory_name <>", value, "directoryName");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameGreaterThan(String value) {
            addCriterion("directory_name >", value, "directoryName");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("directory_name >=", value, "directoryName");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameLessThan(String value) {
            addCriterion("directory_name <", value, "directoryName");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameLessThanOrEqualTo(String value) {
            addCriterion("directory_name <=", value, "directoryName");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameLike(String value) {
            addCriterion("directory_name like", value, "directoryName");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameNotLike(String value) {
            addCriterion("directory_name not like", value, "directoryName");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameIn(List<String> values) {
            addCriterion("directory_name in", values, "directoryName");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameNotIn(List<String> values) {
            addCriterion("directory_name not in", values, "directoryName");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameBetween(String value1, String value2) {
            addCriterion("directory_name between", value1, value2, "directoryName");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameNotBetween(String value1, String value2) {
            addCriterion("directory_name not between", value1, value2, "directoryName");
            return (Criteria) this;
        }

        public Criteria andIsddeleIsNull() {
            addCriterion("isddele is null");
            return (Criteria) this;
        }

        public Criteria andIsddeleIsNotNull() {
            addCriterion("isddele is not null");
            return (Criteria) this;
        }

        public Criteria andIsddeleEqualTo(String value) {
            addCriterion("isddele =", value, "isddele");
            return (Criteria) this;
        }

        public Criteria andIsddeleNotEqualTo(String value) {
            addCriterion("isddele <>", value, "isddele");
            return (Criteria) this;
        }

        public Criteria andIsddeleGreaterThan(String value) {
            addCriterion("isddele >", value, "isddele");
            return (Criteria) this;
        }

        public Criteria andIsddeleGreaterThanOrEqualTo(String value) {
            addCriterion("isddele >=", value, "isddele");
            return (Criteria) this;
        }

        public Criteria andIsddeleLessThan(String value) {
            addCriterion("isddele <", value, "isddele");
            return (Criteria) this;
        }

        public Criteria andIsddeleLessThanOrEqualTo(String value) {
            addCriterion("isddele <=", value, "isddele");
            return (Criteria) this;
        }

        public Criteria andIsddeleLike(String value) {
            addCriterion("isddele like", value, "isddele");
            return (Criteria) this;
        }

        public Criteria andIsddeleNotLike(String value) {
            addCriterion("isddele not like", value, "isddele");
            return (Criteria) this;
        }

        public Criteria andIsddeleIn(List<String> values) {
            addCriterion("isddele in", values, "isddele");
            return (Criteria) this;
        }

        public Criteria andIsddeleNotIn(List<String> values) {
            addCriterion("isddele not in", values, "isddele");
            return (Criteria) this;
        }

        public Criteria andIsddeleBetween(String value1, String value2) {
            addCriterion("isddele between", value1, value2, "isddele");
            return (Criteria) this;
        }

        public Criteria andIsddeleNotBetween(String value1, String value2) {
            addCriterion("isddele not between", value1, value2, "isddele");
            return (Criteria) this;
        }

        public Criteria andIsdlockedIsNull() {
            addCriterion("isdlocked is null");
            return (Criteria) this;
        }

        public Criteria andIsdlockedIsNotNull() {
            addCriterion("isdlocked is not null");
            return (Criteria) this;
        }

        public Criteria andIsdlockedEqualTo(String value) {
            addCriterion("isdlocked =", value, "isdlocked");
            return (Criteria) this;
        }

        public Criteria andIsdlockedNotEqualTo(String value) {
            addCriterion("isdlocked <>", value, "isdlocked");
            return (Criteria) this;
        }

        public Criteria andIsdlockedGreaterThan(String value) {
            addCriterion("isdlocked >", value, "isdlocked");
            return (Criteria) this;
        }

        public Criteria andIsdlockedGreaterThanOrEqualTo(String value) {
            addCriterion("isdlocked >=", value, "isdlocked");
            return (Criteria) this;
        }

        public Criteria andIsdlockedLessThan(String value) {
            addCriterion("isdlocked <", value, "isdlocked");
            return (Criteria) this;
        }

        public Criteria andIsdlockedLessThanOrEqualTo(String value) {
            addCriterion("isdlocked <=", value, "isdlocked");
            return (Criteria) this;
        }

        public Criteria andIsdlockedLike(String value) {
            addCriterion("isdlocked like", value, "isdlocked");
            return (Criteria) this;
        }

        public Criteria andIsdlockedNotLike(String value) {
            addCriterion("isdlocked not like", value, "isdlocked");
            return (Criteria) this;
        }

        public Criteria andIsdlockedIn(List<String> values) {
            addCriterion("isdlocked in", values, "isdlocked");
            return (Criteria) this;
        }

        public Criteria andIsdlockedNotIn(List<String> values) {
            addCriterion("isdlocked not in", values, "isdlocked");
            return (Criteria) this;
        }

        public Criteria andIsdlockedBetween(String value1, String value2) {
            addCriterion("isdlocked between", value1, value2, "isdlocked");
            return (Criteria) this;
        }

        public Criteria andIsdlockedNotBetween(String value1, String value2) {
            addCriterion("isdlocked not between", value1, value2, "isdlocked");
            return (Criteria) this;
        }

        public Criteria andDefuatforderIsNull() {
            addCriterion("defuatForder is null");
            return (Criteria) this;
        }

        public Criteria andDefuatforderIsNotNull() {
            addCriterion("defuatForder is not null");
            return (Criteria) this;
        }

        public Criteria andDefuatforderEqualTo(String value) {
            addCriterion("defuatForder =", value, "defuatforder");
            return (Criteria) this;
        }

        public Criteria andDefuatforderNotEqualTo(String value) {
            addCriterion("defuatForder <>", value, "defuatforder");
            return (Criteria) this;
        }

        public Criteria andDefuatforderGreaterThan(String value) {
            addCriterion("defuatForder >", value, "defuatforder");
            return (Criteria) this;
        }

        public Criteria andDefuatforderGreaterThanOrEqualTo(String value) {
            addCriterion("defuatForder >=", value, "defuatforder");
            return (Criteria) this;
        }

        public Criteria andDefuatforderLessThan(String value) {
            addCriterion("defuatForder <", value, "defuatforder");
            return (Criteria) this;
        }

        public Criteria andDefuatforderLessThanOrEqualTo(String value) {
            addCriterion("defuatForder <=", value, "defuatforder");
            return (Criteria) this;
        }

        public Criteria andDefuatforderLike(String value) {
            addCriterion("defuatForder like", value, "defuatforder");
            return (Criteria) this;
        }

        public Criteria andDefuatforderNotLike(String value) {
            addCriterion("defuatForder not like", value, "defuatforder");
            return (Criteria) this;
        }

        public Criteria andDefuatforderIn(List<String> values) {
            addCriterion("defuatForder in", values, "defuatforder");
            return (Criteria) this;
        }

        public Criteria andDefuatforderNotIn(List<String> values) {
            addCriterion("defuatForder not in", values, "defuatforder");
            return (Criteria) this;
        }

        public Criteria andDefuatforderBetween(String value1, String value2) {
            addCriterion("defuatForder between", value1, value2, "defuatforder");
            return (Criteria) this;
        }

        public Criteria andDefuatforderNotBetween(String value1, String value2) {
            addCriterion("defuatForder not between", value1, value2, "defuatforder");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andFileNumIsNull() {
            addCriterion("file_num is null");
            return (Criteria) this;
        }

        public Criteria andFileNumIsNotNull() {
            addCriterion("file_num is not null");
            return (Criteria) this;
        }

        public Criteria andFileNumEqualTo(Integer value) {
            addCriterion("file_num =", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumNotEqualTo(Integer value) {
            addCriterion("file_num <>", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumGreaterThan(Integer value) {
            addCriterion("file_num >", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_num >=", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumLessThan(Integer value) {
            addCriterion("file_num <", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumLessThanOrEqualTo(Integer value) {
            addCriterion("file_num <=", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumIn(List<Integer> values) {
            addCriterion("file_num in", values, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumNotIn(List<Integer> values) {
            addCriterion("file_num not in", values, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumBetween(Integer value1, Integer value2) {
            addCriterion("file_num between", value1, value2, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumNotBetween(Integer value1, Integer value2) {
            addCriterion("file_num not between", value1, value2, "fileNum");
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