<%@page import="net.bitacademy.java41.vo.Member"%>
<%@page import="net.bitacademy.java41.vo.Project"%>
<%@page import="java.util.List"%>


<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="net.bitacademy.java41.vo.Member" 
		scope="session"></jsp:useBean>   

<jsp:useBean id="member_project" type="java.util.Collection<net.bitacademy.java41.vo.Project>" 
		scope="session"></jsp:useBean>  
<jsp:useBean id="allmember" type="java.util.List<net.bitacademy.java41.vo.Member>" 
		scope="session"></jsp:useBean>  
<jsp:useBean id="memberdetail" type="net.bitacademy.java41.vo.Member" 
		scope="session"></jsp:useBean>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <title>Bootstrap Admin</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="../lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="../stylesheets/theme.css">
    <link rel="stylesheet" href="../lib/font-awesome/css/font-awesome.css">

    <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  </head>

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
  <body class=""> 
  <!--<![endif]-->
    
<jsp:include page="../header.jsp"></jsp:include>
 <jsp:include page="../sidebar.jsp"></jsp:include>
    
    <div class="content">
        
        <div class="header">
            
            <h1 class="page-title">회원 상세 정보  </h1>
        </div>
        
            <!-- <li><a href="index.html">Home</a> <span class="divider">/</span></li> 
            <li class="active">Users</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button class="btn btn-primary"><i class="icon-plus"></i> New User</button>
    <button class="btn">Import</button>
    <button class="btn">Export</button>
  <div class="btn-group">
  </div>
</div>-->
<div class="row-fluid">
    <div class="block span6">
        <a href="#tablewidget" class="block-heading" data-toggle="collapse"><h2><%=memberdetail.getName() %></h2></a>
        
            
            <table class="table list">
			
            <tr>
            <th>이메일  </th>
            <td><%= memberdetail.getEmail()%></td>
            </tr>
            <tr>
            <th>전화번호  </th>
            <td><%= memberdetail.getTel()%></td>
            </tr>
            <tr>
            <th>블로그  </th>
            <td><%= memberdetail.getBlog()%></td>
            </tr>
            <tr>
            <th>등록일  </th>
            <td><%= memberdetail.getRegDate()%></td>
            </tr>
            <tr>
            <th>수정일  </th>
            <td><%= memberdetail.getUpdateDate()%></td>
            </tr>
            <tr>
            <th>주소번호  </th>
            <td><%= memberdetail.getAddressNo()%></td>
            </tr>
            <tr>
            <th>상세주소  </th>
            <td><%= memberdetail.getDetailAddress()%></td>
            </tr>
            <tr>
            <th>Tag  </th>
            <td><%= memberdetail.getTag()%></td>
            </tr>
            <tr>
            <th>Level  </th>
            <td><% if(memberdetail.getLevel() == 0){
            out.println("일반회원");
            }else if(memberdetail.getLevel() == 1){
            	out.println("관리자");
            }else if(memberdetail.getLevel() == 2){
            	out.println("PM강사");
            }else if(memberdetail.getLevel() == 9){
            	out.println("손님");
            }else{
            	out.println("너님 누구?");
            }
            
            %></td>
            </tr>
            
            
                        
        </div>
    </div>
    
</div>

<!-- 
<div class="pagination">
    <ul>
        <li><a href="#">Prev</a></li>
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">Next</a></li>
    </ul>
</div>
 -->

    


    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  </body>
</html>


