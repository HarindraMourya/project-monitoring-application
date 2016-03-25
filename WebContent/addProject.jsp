<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
    <%@taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/container.css"/>
<title>addProject</title>
</head>
<body>
<div class="container bg-1 text-center" id="login" >
         <h2><s:property value="getText('student.addproject')"/></h2>          
        <s:form action="addProject"  method="post" enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal" validate="true">
        <s:textfield key="project.name" name="name" placeholder="Enter Project Name" required="[A-Za-z]"  title="only alphabets are allowed"/>
        <s:textarea key="project.description" name="description" rows="3%" cols="20%" required=""></s:textarea>
        <s:textfield key="project.technology" name="technology" placeholder="Enter Technolgy Use " required="[A-Za-z]"  title="only alphabets are allowed"/>
        <s:select key="project.guide" name="guide" list="{'Ritika','Arun','Dayanand'}" headerKey="-1" headerValue="Select guide" ></s:select>
        <s:textfield key="project.duration" name="duration" placeholder="Enter Project Duration In Month" required="[1-9]"  title="only numerics are allowed"/>
         <s:select key="project.report" name="report" list="{'weekly','monthly','quaterly'}" headerKey="-1" headerValue="Select Report Generation Interval" ></s:select>
        
       <button type="reset" key="faculty.clear" class="btn btn-default">Clear  </button>
       <s:submit class="btn btn-default" key="student.addproject"></s:submit>
       
       
     
       </s:form>  
       
    </div>
</body>
</html>