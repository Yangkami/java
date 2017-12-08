<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%--常量输出 --%>
	jsp 表达式 <%="hewne" %><br>
	EL 表达式 ${"shuchu" }<br>	
	<%-- 变量输出 
	el表达式输出的变量必须放在4个容器（application session request pageContext
	查找范围从小到大 找到停止查找 输出）
	
	--%>
	<%int a=0;
	pageContext.setAttribute("a", a);
	
	%>
	jsp 表达式 <%=a %><br>
	EL 表达式 ${a}<br>
</body>
</html>