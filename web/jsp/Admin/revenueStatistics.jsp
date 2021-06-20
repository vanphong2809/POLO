<%-- 
    Document   : revenueStatistics
    Created on : Jun 19, 2021, 11:08:31 PM
    Author     : Administrator
--%>

<%@page import="DTO.RevenueStatistic"%>
<%@page import="model.OrderModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<%
Gson gsonObj = new Gson();
Map<Object,Object> map = null;
List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

OrderModel orderModel=new OrderModel();
List<RevenueStatistic> revenueStatistics=orderModel.revenueStatistic();
for (int i = 1; i <= 12; i++) {
    for(RevenueStatistic rs:revenueStatistics){
        if(rs.getMonth()==i){
             map = new HashMap<Object,Object>(); map.put("x", rs.getMonth()); map.put("y", rs.getRevenue()); list.add(map);
        }
        else{
             map = new HashMap<Object,Object>(); map.put("x", i); map.put("y", 0); list.add(map);
        }
    }
}
String dataPoints = gsonObj.toJson(list);
%>
 
<!DOCTYPE HTML>
<html lang="en">
    

<jsp:include page="Head.jsp"></jsp:include>
        
<head>
     <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    
    <script src="/POLO/jsp/Admin/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="/POLO/jsp/Admin/js/jquery.min.js" type="text/javascript"></script>
        <script src="/POLO/jsp/Admin/js/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="/POLO/jsp/Admin/js/dataTables.jqueryui.js" type="text/javascript"></script>
        <link href="/POLO/jsp/Admin/css/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <link href="/POLO/jsp/Admin/css/dataTables.jqueryui.css" rel="stylesheet" type="text/css"/>
        <script src="/POLO/jsp/Admin/js/count.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
window.onload = function() { 
 
var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	exportEnabled: true,
	title: {
		text: "Thống kê doanh số bán hàng theo từng tháng"
	},
	axisY:{
		includeZero: true
	},
	data: [{
		type: "column", //change type to bar, line, area, pie, etc
		//indexLabel: "{y}", //Shows y value on all Data Points
		indexLabelFontColor: "#5A5757",
		indexLabelPlacement: "outside",
		dataPoints: <%out.print(dataPoints);%>
	}]
});
chart.render();
 
}
</script>
</head>
<body>
    <jsp:include page="Header.jsp"></jsp:include>
        <div class="main-container" id="main-container">
            <jsp:include page="Menu.jsp"></jsp:include>
            <div class="main-content">
                <div class="main-content-inner">
                    <div id="chartContainer" style="height: 650px; width: 100%;"></div>
                    <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
                </div>
            </div>
            <jsp:include page="Footer.jsp"></jsp:include>
        </div>

</body>
</html>    
