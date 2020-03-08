package com.Entity;

import java.util.ArrayList;
import java.util.List;

public class UserConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserConfigExample() {
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

        public Criteria andMaxMemeryIsNull() {
            addCriterion("max_memery is null");
            return (Criteria) this;
        }

        public Criteria andMaxMemeryIsNotNull() {
            addCriterion("max_memery is not null");
            return (Criteria) this;
        }

        public Criteria andMaxMemeryEqualTo(Integer value) {
            addCriterion("max_memery =", value, "maxMemery");
            return (Criteria) this;
        }

        public Criteria andMaxMemeryNotEqualTo(Integer value) {
            addCriterion("max_memery <>", value, "maxMemery");
            return (Criteria) this;
        }

        public Criteria andMaxMemeryGreaterThan(Integer value) {
            addCriterion("max_memery >", value, "maxMemery");
            return (Criteria) this;
        }

        public Criteria andMaxMemeryGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_memery >=", value, "maxMemery");
            return (Criteria) this;
        }

        public Criteria andMaxMemeryLessThan(Integer value) {
            addCriterion("max_memery <", value, "maxMemery");
            return (Criteria) this;
        }

        public Criteria andMaxMemeryLessThanOrEqualTo(Integer value) {
            addCriterion("max_memery <=", value, "maxMemery");
            return (Criteria) this;
        }

        public Criteria andMaxMemeryIn(List<Integer> values) {
            addCriterion("max_memery in", values, "maxMemery");
            return (Criteria) this;
        }

        public Criteria andMaxMemeryNotIn(List<Integer> values) {
            addCriterion("max_memery not in", values, "maxMemery");
            return (Criteria) this;
        }

        public Criteria andMaxMemeryBetween(Integer value1, Integer value2) {
            addCriterion("max_memery between", value1, value2, "maxMemery");
            return (Criteria) this;
        }

        public Criteria andMaxMemeryNotBetween(Integer value1, Integer value2) {
            addCriterion("max_memery not between", value1, value2, "maxMemery");
            return (Criteria) this;
        }

        public Criteria andMaxDirIsNull() {
            addCriterion("max_dir is null");
            return (Criteria) this;
        }

        public Criteria andMaxDirIsNotNull() {
            addCriterion("max_dir is not null");
            return (Criteria) this;
        }

        public Criteria andMaxDirEqualTo(Integer value) {
            addCriterion("max_dir =", value, "maxDir");
            return (Criteria) this;
        }

        public Criteria andMaxDirNotEqualTo(Integer value) {
            addCriterion("max_dir <>", value, "maxDir");
            return (Criteria) this;
        }

        public Criteria andMaxDirGreaterThan(Integer value) {
            addCriterion("max_dir >", value, "maxDir");
            return (Criteria) this;
        }

        public Criteria andMaxDirGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_dir >=", value, "maxDir");
            return (Criteria) this;
        }

        public Criteria andMaxDirLessThan(Integer value) {
            addCriterion("max_dir <", value, "maxDir");
            return (Criteria) this;
        }

        public Criteria andMaxDirLessThanOrEqualTo(Integer value) {
            addCriterion("max_dir <=", value, "maxDir");
            return (Criteria) this;
        }

        public Criteria andMaxDirIn(List<Integer> values) {
            addCriterion("max_dir in", values, "maxDir");
            return (Criteria) this;
        }

        public Criteria andMaxDirNotIn(List<Integer> values) {
            addCriterion("max_dir not in", values, "maxDir");
            return (Criteria) this;
        }

        public Criteria andMaxDirBetween(Integer value1, Integer value2) {
            addCriterion("max_dir between", value1, value2, "maxDir");
            return (Criteria) this;
        }

        public Criteria andMaxDirNotBetween(Integer value1, Integer value2) {
            addCriterion("max_dir not between", value1, value2, "maxDir");
            return (Criteria) this;
        }

        public Criteria andMaxFileIsNull() {
            addCriterion("max_file is null");
            return (Criteria) this;
        }

        public Criteria andMaxFileIsNotNull() {
            addCriterion("max_file is not null");
            return (Criteria) this;
        }

        public Criteria andMaxFileEqualTo(Integer value) {
            addCriterion("max_file =", value, "maxFile");
            return (Criteria) this;
        }

        public Criteria andMaxFileNotEqualTo(Integer value) {
            addCriterion("max_file <>", value, "maxFile");
            return (Criteria) this;
        }

        public Criteria andMaxFileGreaterThan(Integer value) {
            addCriterion("max_file >", value, "maxFile");
            return (Criteria) this;
        }

        public Criteria andMaxFileGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_file >=", value, "maxFile");
            return (Criteria) this;
        }

        public Criteria andMaxFileLessThan(Integer value) {
            addCriterion("max_file <", value, "maxFile");
            return (Criteria) this;
        }

        public Criteria andMaxFileLessThanOrEqualTo(Integer value) {
            addCriterion("max_file <=", value, "maxFile");
            return (Criteria) this;
        }

        public Criteria andMaxFileIn(List<Integer> values) {
            addCriterion("max_file in", values, "maxFile");
            return (Criteria) this;
        }

        public Criteria andMaxFileNotIn(List<Integer> values) {
            addCriterion("max_file not in", values, "maxFile");
            return (Criteria) this;
        }

        public Criteria andMaxFileBetween(Integer value1, Integer value2) {
            addCriterion("max_file between", value1, value2, "maxFile");
            return (Criteria) this;
        }

        public Criteria andMaxFileNotBetween(Integer value1, Integer value2) {
            addCriterion("max_file not between", value1, value2, "maxFile");
            return (Criteria) this;
        }

        public Criteria andMaxDefFileIsNull() {
            addCriterion("max_def_file is null");
            return (Criteria) this;
        }

        public Criteria andMaxDefFileIsNotNull() {
            addCriterion("max_def_file is not null");
            return (Criteria) this;
        }

        public Criteria andMaxDefFileEqualTo(Integer value) {
            addCriterion("max_def_file =", value, "maxDefFile");
            return (Criteria) this;
        }

        public Criteria andMaxDefFileNotEqualTo(Integer value) {
            addCriterion("max_def_file <>", value, "maxDefFile");
            return (Criteria) this;
        }

        public Criteria andMaxDefFileGreaterThan(Integer value) {
            addCriterion("max_def_file >", value, "maxDefFile");
            return (Criteria) this;
        }

        public Criteria andMaxDefFileGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_def_file >=", value, "maxDefFile");
            return (Criteria) this;
        }

        public Criteria andMaxDefFileLessThan(Integer value) {
            addCriterion("max_def_file <", value, "maxDefFile");
            return (Criteria) this;
        }

        public Criteria andMaxDefFileLessThanOrEqualTo(Integer value) {
            addCriterion("max_def_file <=", value, "maxDefFile");
            return (Criteria) this;
        }

        public Criteria andMaxDefFileIn(List<Integer> values) {
            addCriterion("max_def_file in", values, "maxDefFile");
            return (Criteria) this;
        }

        public Criteria andMaxDefFileNotIn(List<Integer> values) {
            addCriterion("max_def_file not in", values, "maxDefFile");
            return (Criteria) this;
        }

        public Criteria andMaxDefFileBetween(Integer value1, Integer value2) {
            addCriterion("max_def_file between", value1, value2, "maxDefFile");
            return (Criteria) this;
        }

        public Criteria andMaxDefFileNotBetween(Integer value1, Integer value2) {
            addCriterion("max_def_file not between", value1, value2, "maxDefFile");
            return (Criteria) this;
        }

        public Criteria andMaxImgIsNull() {
            addCriterion("max_img is null");
            return (Criteria) this;
        }

        public Criteria andMaxImgIsNotNull() {
            addCriterion("max_img is not null");
            return (Criteria) this;
        }

        public Criteria andMaxImgEqualTo(Integer value) {
            addCriterion("max_img =", value, "maxImg");
            return (Criteria) this;
        }

        public Criteria andMaxImgNotEqualTo(Integer value) {
            addCriterion("max_img <>", value, "maxImg");
            return (Criteria) this;
        }

        public Criteria andMaxImgGreaterThan(Integer value) {
            addCriterion("max_img >", value, "maxImg");
            return (Criteria) this;
        }

        public Criteria andMaxImgGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_img >=", value, "maxImg");
            return (Criteria) this;
        }

        public Criteria andMaxImgLessThan(Integer value) {
            addCriterion("max_img <", value, "maxImg");
            return (Criteria) this;
        }

        public Criteria andMaxImgLessThanOrEqualTo(Integer value) {
            addCriterion("max_img <=", value, "maxImg");
            return (Criteria) this;
        }

        public Criteria andMaxImgIn(List<Integer> values) {
            addCriterion("max_img in", values, "maxImg");
            return (Criteria) this;
        }

        public Criteria andMaxImgNotIn(List<Integer> values) {
            addCriterion("max_img not in", values, "maxImg");
            return (Criteria) this;
        }

        public Criteria andMaxImgBetween(Integer value1, Integer value2) {
            addCriterion("max_img between", value1, value2, "maxImg");
            return (Criteria) this;
        }

        public Criteria andMaxImgNotBetween(Integer value1, Integer value2) {
            addCriterion("max_img not between", value1, value2, "maxImg");
            return (Criteria) this;
        }

        public Criteria andExportFileIsNull() {
            addCriterion("export_file is null");
            return (Criteria) this;
        }

        public Criteria andExportFileIsNotNull() {
            addCriterion("export_file is not null");
            return (Criteria) this;
        }

        public Criteria andExportFileEqualTo(String value) {
            addCriterion("export_file =", value, "exportFile");
            return (Criteria) this;
        }

        public Criteria andExportFileNotEqualTo(String value) {
            addCriterion("export_file <>", value, "exportFile");
            return (Criteria) this;
        }

        public Criteria andExportFileGreaterThan(String value) {
            addCriterion("export_file >", value, "exportFile");
            return (Criteria) this;
        }

        public Criteria andExportFileGreaterThanOrEqualTo(String value) {
            addCriterion("export_file >=", value, "exportFile");
            return (Criteria) this;
        }

        public Criteria andExportFileLessThan(String value) {
            addCriterion("export_file <", value, "exportFile");
            return (Criteria) this;
        }

        public Criteria andExportFileLessThanOrEqualTo(String value) {
            addCriterion("export_file <=", value, "exportFile");
            return (Criteria) this;
        }

        public Criteria andExportFileLike(String value) {
            addCriterion("export_file like", value, "exportFile");
            return (Criteria) this;
        }

        public Criteria andExportFileNotLike(String value) {
            addCriterion("export_file not like", value, "exportFile");
            return (Criteria) this;
        }

        public Criteria andExportFileIn(List<String> values) {
            addCriterion("export_file in", values, "exportFile");
            return (Criteria) this;
        }

        public Criteria andExportFileNotIn(List<String> values) {
            addCriterion("export_file not in", values, "exportFile");
            return (Criteria) this;
        }

        public Criteria andExportFileBetween(String value1, String value2) {
            addCriterion("export_file between", value1, value2, "exportFile");
            return (Criteria) this;
        }

        public Criteria andExportFileNotBetween(String value1, String value2) {
            addCriterion("export_file not between", value1, value2, "exportFile");
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