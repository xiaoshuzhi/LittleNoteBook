package com.Entity;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Integer value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Integer value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Integer value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Integer value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Integer value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Integer> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Integer> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Integer value1, Integer value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andMottoIsNull() {
            addCriterion("motto is null");
            return (Criteria) this;
        }

        public Criteria andMottoIsNotNull() {
            addCriterion("motto is not null");
            return (Criteria) this;
        }

        public Criteria andMottoEqualTo(String value) {
            addCriterion("motto =", value, "motto");
            return (Criteria) this;
        }

        public Criteria andMottoNotEqualTo(String value) {
            addCriterion("motto <>", value, "motto");
            return (Criteria) this;
        }

        public Criteria andMottoGreaterThan(String value) {
            addCriterion("motto >", value, "motto");
            return (Criteria) this;
        }

        public Criteria andMottoGreaterThanOrEqualTo(String value) {
            addCriterion("motto >=", value, "motto");
            return (Criteria) this;
        }

        public Criteria andMottoLessThan(String value) {
            addCriterion("motto <", value, "motto");
            return (Criteria) this;
        }

        public Criteria andMottoLessThanOrEqualTo(String value) {
            addCriterion("motto <=", value, "motto");
            return (Criteria) this;
        }

        public Criteria andMottoLike(String value) {
            addCriterion("motto like", value, "motto");
            return (Criteria) this;
        }

        public Criteria andMottoNotLike(String value) {
            addCriterion("motto not like", value, "motto");
            return (Criteria) this;
        }

        public Criteria andMottoIn(List<String> values) {
            addCriterion("motto in", values, "motto");
            return (Criteria) this;
        }

        public Criteria andMottoNotIn(List<String> values) {
            addCriterion("motto not in", values, "motto");
            return (Criteria) this;
        }

        public Criteria andMottoBetween(String value1, String value2) {
            addCriterion("motto between", value1, value2, "motto");
            return (Criteria) this;
        }

        public Criteria andMottoNotBetween(String value1, String value2) {
            addCriterion("motto not between", value1, value2, "motto");
            return (Criteria) this;
        }

        public Criteria andUsedIsNull() {
            addCriterion("used is null");
            return (Criteria) this;
        }

        public Criteria andUsedIsNotNull() {
            addCriterion("used is not null");
            return (Criteria) this;
        }

        public Criteria andUsedEqualTo(Integer value) {
            addCriterion("used =", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotEqualTo(Integer value) {
            addCriterion("used <>", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedGreaterThan(Integer value) {
            addCriterion("used >", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedGreaterThanOrEqualTo(Integer value) {
            addCriterion("used >=", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedLessThan(Integer value) {
            addCriterion("used <", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedLessThanOrEqualTo(Integer value) {
            addCriterion("used <=", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedIn(List<Integer> values) {
            addCriterion("used in", values, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotIn(List<Integer> values) {
            addCriterion("used not in", values, "used");
            return (Criteria) this;
        }

        public Criteria andUsedBetween(Integer value1, Integer value2) {
            addCriterion("used between", value1, value2, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotBetween(Integer value1, Integer value2) {
            addCriterion("used not between", value1, value2, "used");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(Integer value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(Integer value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(Integer value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(Integer value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(Integer value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<Integer> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<Integer> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(Integer value1, Integer value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("total not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andReadlockIsNull() {
            addCriterion("readlock is null");
            return (Criteria) this;
        }

        public Criteria andReadlockIsNotNull() {
            addCriterion("readlock is not null");
            return (Criteria) this;
        }

        public Criteria andReadlockEqualTo(String value) {
            addCriterion("readlock =", value, "readlock");
            return (Criteria) this;
        }

        public Criteria andReadlockNotEqualTo(String value) {
            addCriterion("readlock <>", value, "readlock");
            return (Criteria) this;
        }

        public Criteria andReadlockGreaterThan(String value) {
            addCriterion("readlock >", value, "readlock");
            return (Criteria) this;
        }

        public Criteria andReadlockGreaterThanOrEqualTo(String value) {
            addCriterion("readlock >=", value, "readlock");
            return (Criteria) this;
        }

        public Criteria andReadlockLessThan(String value) {
            addCriterion("readlock <", value, "readlock");
            return (Criteria) this;
        }

        public Criteria andReadlockLessThanOrEqualTo(String value) {
            addCriterion("readlock <=", value, "readlock");
            return (Criteria) this;
        }

        public Criteria andReadlockLike(String value) {
            addCriterion("readlock like", value, "readlock");
            return (Criteria) this;
        }

        public Criteria andReadlockNotLike(String value) {
            addCriterion("readlock not like", value, "readlock");
            return (Criteria) this;
        }

        public Criteria andReadlockIn(List<String> values) {
            addCriterion("readlock in", values, "readlock");
            return (Criteria) this;
        }

        public Criteria andReadlockNotIn(List<String> values) {
            addCriterion("readlock not in", values, "readlock");
            return (Criteria) this;
        }

        public Criteria andReadlockBetween(String value1, String value2) {
            addCriterion("readlock between", value1, value2, "readlock");
            return (Criteria) this;
        }

        public Criteria andReadlockNotBetween(String value1, String value2) {
            addCriterion("readlock not between", value1, value2, "readlock");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andVatarIsNull() {
            addCriterion("vatar is null");
            return (Criteria) this;
        }

        public Criteria andVatarIsNotNull() {
            addCriterion("vatar is not null");
            return (Criteria) this;
        }

        public Criteria andVatarEqualTo(String value) {
            addCriterion("vatar =", value, "vatar");
            return (Criteria) this;
        }

        public Criteria andVatarNotEqualTo(String value) {
            addCriterion("vatar <>", value, "vatar");
            return (Criteria) this;
        }

        public Criteria andVatarGreaterThan(String value) {
            addCriterion("vatar >", value, "vatar");
            return (Criteria) this;
        }

        public Criteria andVatarGreaterThanOrEqualTo(String value) {
            addCriterion("vatar >=", value, "vatar");
            return (Criteria) this;
        }

        public Criteria andVatarLessThan(String value) {
            addCriterion("vatar <", value, "vatar");
            return (Criteria) this;
        }

        public Criteria andVatarLessThanOrEqualTo(String value) {
            addCriterion("vatar <=", value, "vatar");
            return (Criteria) this;
        }

        public Criteria andVatarLike(String value) {
            addCriterion("vatar like", value, "vatar");
            return (Criteria) this;
        }

        public Criteria andVatarNotLike(String value) {
            addCriterion("vatar not like", value, "vatar");
            return (Criteria) this;
        }

        public Criteria andVatarIn(List<String> values) {
            addCriterion("vatar in", values, "vatar");
            return (Criteria) this;
        }

        public Criteria andVatarNotIn(List<String> values) {
            addCriterion("vatar not in", values, "vatar");
            return (Criteria) this;
        }

        public Criteria andVatarBetween(String value1, String value2) {
            addCriterion("vatar between", value1, value2, "vatar");
            return (Criteria) this;
        }

        public Criteria andVatarNotBetween(String value1, String value2) {
            addCriterion("vatar not between", value1, value2, "vatar");
            return (Criteria) this;
        }

        public Criteria andGithubIsNull() {
            addCriterion("github is null");
            return (Criteria) this;
        }

        public Criteria andGithubIsNotNull() {
            addCriterion("github is not null");
            return (Criteria) this;
        }

        public Criteria andGithubEqualTo(String value) {
            addCriterion("github =", value, "github");
            return (Criteria) this;
        }

        public Criteria andGithubNotEqualTo(String value) {
            addCriterion("github <>", value, "github");
            return (Criteria) this;
        }

        public Criteria andGithubGreaterThan(String value) {
            addCriterion("github >", value, "github");
            return (Criteria) this;
        }

        public Criteria andGithubGreaterThanOrEqualTo(String value) {
            addCriterion("github >=", value, "github");
            return (Criteria) this;
        }

        public Criteria andGithubLessThan(String value) {
            addCriterion("github <", value, "github");
            return (Criteria) this;
        }

        public Criteria andGithubLessThanOrEqualTo(String value) {
            addCriterion("github <=", value, "github");
            return (Criteria) this;
        }

        public Criteria andGithubLike(String value) {
            addCriterion("github like", value, "github");
            return (Criteria) this;
        }

        public Criteria andGithubNotLike(String value) {
            addCriterion("github not like", value, "github");
            return (Criteria) this;
        }

        public Criteria andGithubIn(List<String> values) {
            addCriterion("github in", values, "github");
            return (Criteria) this;
        }

        public Criteria andGithubNotIn(List<String> values) {
            addCriterion("github not in", values, "github");
            return (Criteria) this;
        }

        public Criteria andGithubBetween(String value1, String value2) {
            addCriterion("github between", value1, value2, "github");
            return (Criteria) this;
        }

        public Criteria andGithubNotBetween(String value1, String value2) {
            addCriterion("github not between", value1, value2, "github");
            return (Criteria) this;
        }

        public Criteria andSkillsIsNull() {
            addCriterion("skills is null");
            return (Criteria) this;
        }

        public Criteria andSkillsIsNotNull() {
            addCriterion("skills is not null");
            return (Criteria) this;
        }

        public Criteria andSkillsEqualTo(String value) {
            addCriterion("skills =", value, "skills");
            return (Criteria) this;
        }

        public Criteria andSkillsNotEqualTo(String value) {
            addCriterion("skills <>", value, "skills");
            return (Criteria) this;
        }

        public Criteria andSkillsGreaterThan(String value) {
            addCriterion("skills >", value, "skills");
            return (Criteria) this;
        }

        public Criteria andSkillsGreaterThanOrEqualTo(String value) {
            addCriterion("skills >=", value, "skills");
            return (Criteria) this;
        }

        public Criteria andSkillsLessThan(String value) {
            addCriterion("skills <", value, "skills");
            return (Criteria) this;
        }

        public Criteria andSkillsLessThanOrEqualTo(String value) {
            addCriterion("skills <=", value, "skills");
            return (Criteria) this;
        }

        public Criteria andSkillsLike(String value) {
            addCriterion("skills like", value, "skills");
            return (Criteria) this;
        }

        public Criteria andSkillsNotLike(String value) {
            addCriterion("skills not like", value, "skills");
            return (Criteria) this;
        }

        public Criteria andSkillsIn(List<String> values) {
            addCriterion("skills in", values, "skills");
            return (Criteria) this;
        }

        public Criteria andSkillsNotIn(List<String> values) {
            addCriterion("skills not in", values, "skills");
            return (Criteria) this;
        }

        public Criteria andSkillsBetween(String value1, String value2) {
            addCriterion("skills between", value1, value2, "skills");
            return (Criteria) this;
        }

        public Criteria andSkillsNotBetween(String value1, String value2) {
            addCriterion("skills not between", value1, value2, "skills");
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