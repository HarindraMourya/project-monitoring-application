<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
    <%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
    <%-- <%session=request.getSession(false);
    String email=(String)session.getAttribute("user");
      if("null".equals(email))
      {
    	  //System.out.print("new user");
    	  response.sendRedirect("index.jsp");
      }
    %> 
    <s:if test="(#session.user).equals('null')" >
       <s:action name="loginfail"></s:action>
</s:if>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="Harinder">
    <meta name="keywords" content="HMRITM, college project management, management, project management, project approval">
    <title><s:property value="getText('admin.dashboard')"/></title>
    <script src="js/jquery-1.11.2.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="css/charisma-app.css" rel="stylesheet">
    <link href="css/adminDashboard.css" rel="stylesheet">
     
    
    <link id="bs-css" href="css/bootstrap-cerulean.min.css" rel="stylesheet">
    
     <script src="js/bootstrap.min.js"></script>
    
   
    <script type="text/javascript" src="js/jquery.vticker-min.js"></script>
    <script src="js/angular-min.js"></script>
     <script src="js/adminDashboard.js"></script>
    
   

</head>
<body onload="myFunction()">
<body ng-app="">

<div ng-include="'header.jsp'"></div></body>
<div class="container bg-1 text-center" id="msg" style="margin-top: 4%; max-width: 70% "><p>
<h4>
<s:property value="getText('login.message')"/> ${sessionScope.user} 
</h4>
<h4><s:property value="facultyMessege"/>  </h4>
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
                        <li><a class="ajax-link" href="#"><span> <s:property value="getText('admin.dashboard')"/></span></a>
                        </li>
                        <li><a  href="#" onclick="showMail()"><span><s:property value="getText('mail.sentmail')"/></span></a>
                        
                        </li>
                        <li><a  href="#" onclick="showInbox()"><span><s:property value="getText('mail.inbox')"/></span></a>
                        
                        </li>

                        <li><a  href="#" onclick="faculty()"><span><s:property value="getText('admin.addsingle')"/></span></a></li>
                        <li><a  href="#" onclick="mutipleFaculty()"><span><s:property value="getText('admin.addmultiple')"/></span></a></li>


                        <li><a  href="facultyDetails.action" ><span><s:property value="getText('admin.facultydetails')"/></span></a>
                        </li>
                        <li><a href="studentDetails.action" ><span><s:property value="getText('admin.studentdetails')"/></span></a>
                        </li>
                        <li><a  href="logout.action" ><span><s:property value="getText('admin.logout')"/></span></a>
                        </li>

                    </ul>
                </div>
            </div>
        </div>
        <div class="col-sm-10 col-lg-10">
        
            <div ng-include="'facultyRegistration.jsp'" id="faculty"></div>
        </div>
        
         <div class="col-sm-10 col-lg-10">
            <div ng-include="'chooseFile.jsp'" id="multiplefaculty"></div>
        </div>
         <div class="col-sm-10 col-lg-10">
            <div ng-include="'facultyDetails.jsp'" id="facultydetails"></div>
        </div>
         <div class="col-sm-10 col-lg-10">
            <div ng-include="'studentDetails.jsp'" id="studentdetails"></div>
        </div>
        
         <div class="col-sm-10 col-lg-10">
            <div ng-include="'mailbox.jsp'" id="mailbox"></div>
        </div> 
        
         <div class="col-sm-10 col-lg-10" > 
            <!-- <div ng-include="'inbox.jsp'" id="inbox"></div> -->
         
    <div class="box-inner" id="inbox">
        <div class="box-header well " data-original-title><s:property value="getText('mail.label')"/></div>
            
           <div class="box-content">
<%-- <form name="myTable" action="#" class="table my-table-class">
<table class="table table-responsive table-striped  bootstrap-datatable datatable responsive">
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
<td><s:property value="message"/></td>
</s:iterator>
</table>
</form> --%>
<s:iterator  var="i" step="1" value="mail">
<div class="container">
 
  <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse1"><b><s:property value="subject"/></b></a>
        </h4>
      </div>
      <div id="collapse1" class="panel-collapse collapse">
        <ul class="list-group">
          <li class="list-group-item"><b><s:property value="getText('mail.date')"/></b>&nbsp &nbsp<s:property value="date"/></li>
          <li class="list-group-item"><b><s:property value="getText('mail.sender')"/></b>&nbsp &nbsp<s:property value="sender"/></li>
          <li class="list-group-item"><b><s:property value="getText('mail.body')"/></b>&nbsp &nbsp<s:property value="message"/></li>
        </ul>
        <div class="panel-footer"></div>
      </div>
    </div>
  </div>
</div>

</s:iterator>

</div>
        </div> 
        </div>
        
    </div>
</div>

<!--/span-->
<!-- left menu ends -->
<script src="js/charisma.js"></script>

<body ng-app="">

<div ng-include="'footer.html'"></div></body>
</body>
</html>