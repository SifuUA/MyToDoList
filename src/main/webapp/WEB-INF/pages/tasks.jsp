<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Tasks Page</title>

    <style type="text/css">
        body {
            background-image: url("https://assets.fastcompany.com/image/upload/w_1280,f_auto,q_auto,fl_lossy/wp-cms/uploads/2017/05/p-1-these-10-ceos-to-to-do-list-hacks.jpg");
            background-size: 100%;
        }

        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>

<body>

<h1>Add a Task</h1>

<c:url var="addAction" value="/tasks/add"/>

<form:form action="${addAction}" commandName="task">
    <div align="right">
        <button><a href="../../index.jsp">Back to main menu</a></button>
    </div>
    <table>
        <c:if test="${!empty task.description}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="description">
                    <spring:message text="Description"/>
                </form:label>
            </td>
            <td>
                <form:input path="description"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="priority">
                    <spring:message text="Priority"/>
                </form:label>
            </td>
            <td>
                <form:input path="priority"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="dueDate">
                    <spring:message text="Due Date"/>
                </form:label>

            </td>
            <td>
                <form:input path="dueDate"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty task.description}">
                    <input type="submit"
                           value="<spring:message text="Edit Task"/>"/>
                </c:if>
                <c:if test="${empty task.description}">
                    <input type="submit"
                           value="<spring:message text="Add Task"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

<h1 align="center">Tasks List</h1>

<br/>

<c:if test="${!empty listTasks}">
    <table class="tg" align="center">
        <tr>
                <%--<th width="80">ID</th>--%>
            <th width="200">Description</th>
            <th width="80">Created</th>
            <th width="40">Priority</th>
            <th width="80">Due Date</th>
            <th width="60">Edit</th>
            <th width="60">Done</th>
        </tr>
        <c:forEach items="${listTasks}" var="task">
            <tr>
                    <%--<td>${task.id}</td>--%>
                <td>${task.description}</td>
                <td>${task.created}</td>
                <td>${task.priority}</td>
                <td>${task.dueDate}</td>
                <td><a href="<c:url value='/edit/${task.id}' />">Edit</a></td>
                <td><a href="<c:url value='/remove/${task.id}' />">
                    <button>Done</button>
                </a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>