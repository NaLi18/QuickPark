<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored ="false" %> 
<%@ page import="com.parking.entity.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form id="garageform"action="getGarage" method="post"><input type="submit" onclick="hide()" value="List All Garages" style="width:50%;height:30px;background-color:#74F7B6;color:white; border-radius:4px;margin-left:-12px""></form>
    <c:forEach var="garage" items="${garages}">
    	<div class="row" style="background: #EAFCFE; padding:5px; border-bottom: 2px solid white">
    		<div class="ListGarage" >
    				<input  class="messageCheckbox" type="checkbox" name="garg" value="${garage.name}">
    				<p id="grs"><b >${garage.name}</b><br>
    				<a>${garage.location}</a><br>
    				<a style="color:blue">${garage.rate} out of 5</a>
    				</div>
    					<button onclick="submitform()" style="margin-left:auto; magrin-top:20;height:65%; background-color: #27D154;color:white;width:100px; border-radius:4px" >Order</button>
    			</div>
				</c:forEach>
	
	<form id="myForm" action="addReservation">
    	<input type="hidden" id="flag" name="flag2" value=""/>
    	<input type="hidden" name="operation" value="1">
    </form>

<script>
	function submitform(){
		var checkedValue = null; 
		var inputElements = document.getElementsByClassName('messageCheckbox');
		for(var i=0; inputElements[i]; ++i){
		      if(inputElements[i].checked){
		           checkedValue = inputElements[i].value;
		           break;
		      }
		}
		document.getElementById("flag").value = checkedValue;
		document.getElementById("myForm").submit();
	}
</script>
</body>
</html>