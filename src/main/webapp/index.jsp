<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ToDo List</title>
    <style>
        body {
            background-image: url("https://blog.todoist.com/ru/wp-content/uploads/sites/3/2015/11/coffee.jpg");
            background-size: 100%;
        }

        .parent {
            margin-left: 75%;
            padding: 10px;
        }
        .child {
            padding: 10%;
            margin: 10%;
        }

        #footer {
            position: fixed; /* Фиксированное положение */
            left: 0;
            bottom: 0; /* Левый нижний угол */
            padding: 10px; /* Поля вокруг текста */
            background: grey; /* Цвет фона */
            color: #fff; /* Цвет текста */
            width: 100%; /* Ширина слоя */
        }
        .but{
            width: 180px;
            height:50px;
            border-radius: 20px;

        }
    </style>
</head>
<body>
<br/>
<div class="parent">
    <div class="child">
        <a href="/tasks" target="_blank"><button class="but"><strong>Start TODO List</strong></button></a>
    </div>

</div>
<br/>
<div id="footer">
    &copy;Kres Soft
</div>
</body>

</html>
