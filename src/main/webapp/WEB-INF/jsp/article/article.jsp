<jsp:useBean id="article" scope="request" type="ee.ttu.idu0200.web.form.ArticleForm"/>
<%--<jsp:useBean id="article" scope="request" type="ee.ttu.idu0200.form.ArticleForm"/>--%>
<%--<jsp:useBean id="article" scope="request" type="ee.ttu.idu0200.model.Article"/>--%>

<%@include file="/WEB-INF/jsp/header.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
  <h1>Edit article</h1>
  <%--@elvariable id="successMessage" type="java.lang.String"--%>
  <c:if test="${not empty successMessage}">
    <div class="alert alert-success">
      Update successful.
    </div>
  </c:if>
  <c:url var="formLink" value="/article/s?action=save"/>
  <form:form role="form" class="form-horizontal" action="${formLink}" method="post" modelAttribute="article">
    <div class="form-group">
      <label for="id" class="control-label col-sm-2">Id:</label>
      <div class="col-sm-10">
        <p class="form-control-static" id="id">${article.id}</p>
        <input type="hidden" name="id" value="${article.id}" />
      </div>
    </div>

    <spring:hasBindErrors name="article">
      <c:if test="${errors.hasFieldErrors('title')}" var="isTitleError" />
    </spring:hasBindErrors>
    <div class="form-group ${isTitleError ? 'has-error' : ''}">
      <label for="title" class="control-label col-sm-2">Title:</label>
      <div class="col-sm-10">
        <form:input path="title" cssClass="form-control"/>
        <form:errors path="title" cssClass="help-block" />
      </div>
    </div>

    <spring:hasBindErrors name="article">
      <c:if test="${errors.hasFieldErrors('publishedDate')}" var="isPublishedDateError" />
    </spring:hasBindErrors>
    <div class="form-group ${isPublishedDateError ? 'has-error' : ''}">
      <form:label path="publishedDate" cssClass="control-label col-sm-2">Published date:</form:label>
      <div class="col-sm-10">
        <form:input path="publishedDate" type="date" placeholder="MM/dd/yyyy" cssClass="form-control"/>
        <form:errors path="publishedDate" cssClass="help-block" />
      </div>
    </div>

    <spring:hasBindErrors name="article">
      <c:if test="${errors.hasFieldErrors('content')}" var="isContentError" />
    </spring:hasBindErrors>
    <div class="form-group ${isContentError ? 'has-error' : ''}">
      <label for="content" class="control-label col-sm-2">Content:</label>
      <div class="col-sm-10">
        <form:textarea path="content" cssClass="form-control"/>
        <form:errors path="content" cssClass="help-block" />
      </div>
    </div>

    <div class="form-group">
      <div class="col-sm-12 text-center">
        <button type="submit" class="btn btn-primary ">Submit</button>
        <c:url var="viewAllLink" value="/article/s"/>
        <a href="${viewAllLink}" class="btn btn-default">Cancel</a>
      </div>
    </div>

  </form:form>

</div>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
