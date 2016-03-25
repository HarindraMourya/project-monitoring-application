<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Language</title>
</head>
<body >
<div >
<h2><s:property value="messege"/></h2>
<h3>Select Your Language /अपनी भासा चुने</h3>
<s:a href="langAc.action?request_locale=en_US">English</s:a>
<s:a href="langAc.action?request_locale=hi_IN">हिंदी</s:a>
</div>
</body>
</html>