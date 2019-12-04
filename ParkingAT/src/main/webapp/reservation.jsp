<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.parking.entity.Garage"%>
<%@ page isELIgnored ="false" %> 
<!DOCTYPE html>
<html>
<head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>

<h2>Reservations</h2>

<table>
  <tr>
    <th>Name</th>
    <th>Contact</th>
    <th>Licence ID</th>
  </tr>
  <tr>
    <td>Alfreds Futterkiste</td>
    <td>5184726398</td>
    <td>012 938 288</td>
  </tr>
  <tr>
    <td>Moctezuma</td>
    <td>5163728281</td>
    <td>938 181 472</td>
  </tr>
  <tr>
    <td>Ernst Handel</td>
    <td>4718172928</td>
    <td>181 827 303</td>
  </tr>
  <tr>
    <td>Rohan</td>
    <td>5193822729</td>
    <td>928 718 020</td>
  </tr>
  <tr>
    <td>Keval</td>
    <td>4732927298</td>
    <td>817 030 118</td>
  </tr>
  <tr>
    <td>Arnold</td>
    <td>2472292911</td>
    <td>827 919 333</td>
  </tr>
</table>

</body>
</html>
