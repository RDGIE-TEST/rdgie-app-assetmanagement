<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>



<!-- Import bootstrap js and css -->

  <link href="<c:url value="/resources/bootstrap/css/pastel-stream.css" />"	rel="stylesheet">
  <link href="<c:url value="/resources/bootstrap/form/font-awesome/css/font-awesome.min.css" />"	rel="stylesheet">
  <script src='<c:url value = "/resources/js/jquery-1.10.2.min.js" />'></script>
  <script src='<c:url value = "/resources/bootstrap/js/bootstrap.min.js" />'></script>
  
<!-- End of bootstrap js imports -->

<!-- Import datatables js and css -->

    <link href="<c:url value="/resources/datatables/media/css/jquery.dataTables.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/datatables/resources/syntax/shCore.css" />" rel="stylesheet">


	<script src='<c:url value = "/resources/datatables/media/js/jquery.dataTables.js" />'></script>
	<script src='<c:url value = "/resources/datatables/resources/syntax/shCore.js" />'></script>
	
<!-- End of datatables js and css -->

 
<!-- Start of bootstrap calendar -->
 <link href="<c:url value="/resources/bootstrap/css/jquery-ui.css" />"	rel="stylesheet">
 <script src='<c:url value = "/resources/bootstrap/js/jquery-ui.js" />'></script>
<!-- End of bootstrap calendar -->

</head>
<body>

    <div class="container">


        <!-- sample templates start -->

        <!-- Navbar -->
        <div class="row">
            <div class="col-lg-12">
                <div class="page-header">
                    <h1>ASSET MANAGEMENT SYSTEM</h1>
                </div>
                <div class="navbar navbar-default">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">Home</a>
                    </div>
                     <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">Administration</a>
                    </div>
                    <div class="navbar-collapse collapse navbar-responsive-collapse">
                        <ul class="nav navbar-nav">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Employee <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="createEmployee">Create Employee</a></li>
                                    <li><a href="listEmployees">Manage Employees</a></li>
                                    <li class="divider"></li>
                                    <li class="dropdown-header">Other Actions</li>
                                    <li><a href="#">-----</a></li>
                                    <li><a href="#">-----</a></li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Identifier <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="createIdentifierType">Create Identifier Type</a></li>
                                    <li><a href="listIdentifierTypes">Manage Identifier Types</a></li>
                                    <li class="divider"></li>
                                    <li class="dropdown-header">Other Actions</li>
                                    <li><a href="#">----</a></li>
                                    <li><a href="#">----</a></li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Items <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="createItem">Create Item</a></li>
                                    <li><a href="listItems">Manage Items</a></li>
                                    <li class="divider"></li>
                                    <li class="dropdown-header">Other Actions</li>
                                    <li><a href="listItems?param=available">Available Items</a></li>
                                    <li><a href="listItems?param=damaged">Damaged Items</a></li>
                                      <li><a href="listItems?param=given">Given Items</a></li>
                                    
                                </ul>
                            </li>
                        </ul>
                        
                        
                         <ul class="nav navbar-nav">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Entry<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                 <li><a href="createEntry">New Entry</a></li>
                                     <li><a href="listEntries">View Entries</a></li>
                                   
                                    <li class="divider"></li>
                                    <li class="#">-----</li>
                                    <li><a href="#">----</a></li>
                                    <li><a href="#">----</a></li>
                                      <li><a href="#">-----</a></li>
                                    
                                </ul>
                            </li>
                        </ul>
                        
                        
                        <form class="navbar-form navbar-left">
                            <input type="text" class="form-control col-lg-8" placeholder="Search">
                        </form>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="logout">Logout</a></li>
                            
                        </ul>
                    </div>
                </div>
                
            </div>
        </div>



        <div class="clearfix" style="height:50px;"></div>

        <script type="text/javascript">
            jQuery(function ($) {
                $('[data-toggle="popover"]').popover();
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>

        <!-- sample templates end -->  