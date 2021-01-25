<html>
<head>
<title>Calculator</title>
</head>
<body>
    <p><font color="red">${errorMessage}</font></p>
    <form action="/calculator/enter" method="POST">
        Input1 : <input name="input1" type="text" /> Input2 : <input name="input2" type="text" />
        Operation : <select name="operation">
                      <option value="add">Add</option>
                      <option value="sub">Subtract</option>
                      <option value="mul">Multiply</option>
                      <option value="div">Divide</option>
                    </select>
        <input type="submit" />
    </form>
</body>
</html>