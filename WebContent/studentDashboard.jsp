<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
    <%@taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="Harinder">
    <meta name="keywords" content="HMRITM, college project management, management, project management, project approval">
<title><s:property value="getText('student.dashboard')"/></title>
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <script src="js/jquery-1.11.2.min.js"></script>
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="css/charisma-app.css" rel="stylesheet">
    <link id="bs-css" href="css/bootstrap-cerulean.min.css" rel="stylesheet">
    <link href="css/home.css" rel="stylesheet">
    
    <script src="js/angular-min.js"></script>
    <script src="js/studentDashboard.js"></script>
    
   
   
</head>
<body ng-app="" onload="myFunction()">

<div ng-include="'header.jsp'"></div>
<div class="container bg-1 text-center" id="msg" style="margin-top: 4%; max-width: 70%">
<p>
<h4>
<s:property value="getText('login.message')"/> ${sessionScope.user} 
</h4>
<h4><s:property value="initialProjectMsg"/>  </h4>
<h4><s:property value="mailMessage"/>  </h4>
</p>
</div>

<!-- left menu starts -->
<div class="container" id="dash">
    <div class="row">
        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked">

                    </div>
                    <ul class="nav nav-pills nav-stacked main-menu">
                        <li class="nav-header"><s:property value="getText('admin.main')"/></li>
                        <li><a class="ajax-link" href="#"><span> <s:property value="getText('student.dashboard')"/></span></a>
                        </li>
                        <li><a  href="#" onclick="addproject()"><span><s:property value="getText('student.addproject')"/></span></a>
                        
                        </li>
                        <li><a  href="#" onclick="showProject()"><span><s:property value="getText('student.projects')"/></span></a>
                        
                        </li>
                        <li><a  href="#" onclick="showMail()"><span><s:property value="getText('mail.sentmail')"/></span></a>
                        
                        </li>
                        <li><a  href="#" onclick="showInbox()"><span><s:property value="getText('mail.inbox')"/></span></a>
                        
                        </li>

                       
                        <li><a  href="logout.action" ><span><s:property value="getText('admin.logout')"/></span></a>
                        </li>

                    </ul>
                </div>
            </div>
        </div>
       
        <div class="col-sm-10 col-lg-10">
            <div ng-include="'addProject.jsp'" id="addproject"></div>
        </div> 
        <div class="col-sm-10 col-lg-10">
            <div ng-include="'project.jsp'" id="project"></div>
        </div> 
        
         <div class="col-sm-10 col-lg-10">
            <div ng-include="'mailbox.jsp'" id="mailbox"></div>
        </div> 
        
         <div class="col-sm-10 col-lg-10" > 
            <!-- <div ng-include="'inbox.jsp'" id="inbox"></div> -->
         
    <div class="box-inner" id="inbox">
        <div class="box-header well " data-original-title><s:property value="getText('mail.label')"/></div>
            
           <div class="box-content">
<form name="myTable" action="#" class="table my-table-class">
<table class="table table-responsive table-striped table-bordered bootstrap-datatable datatable responsive">
    <thead>
    <tr>
        <th><s:property value="getText('mail.date')"/></th>
        <th><s:property value="getText('mail.sender')"/></th>
        <th><s:property value="getText('mail.subject')"/></th>
        <th><s:property value="getText('mail.body')"/></th>
        
    </tr>
    </thead> 
            
<s:iterator  var="i" step="1" value="mail">
<tr><td><s:property value="date"/></td>
<td><s:property value="sender"/></td>
<td><s:property value="subject"/></td>
<td><s:property value="message"/></td></tr>
</s:iterator>
</table>
</form>
</div>
        </div> 
        </div>
        
    </div>
</div>

<!--/span-->
<!-- left menu ends -->


<div ng-include="'footer.html'"></div>
 <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery.vticker-min.js"></script>
   
</body>
</html>