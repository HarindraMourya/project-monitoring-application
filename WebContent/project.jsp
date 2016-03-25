<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s"  uri="/struts-tags" %>
    <%@ taglib  prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project</title>
</head>
<body><div><h1>
<s:iterator  var="i" step="1" value="project">
<s:property value="projectId"/>
<s:property value="name"/>
<s:property value="description"/>
<s:property value="technology"/>
<s:property value="guide"/>
<s:property value="duration"/>
<s:property value="status"/>
<s:property value="report"/>
</s:iterator>
</h1></div>
</body>
</html>