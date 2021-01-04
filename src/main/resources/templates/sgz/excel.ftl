<!DOCTYPE html>
<html lang="en">
<head>
    <#assign basePath=request.contextPath />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>阵容信息导入</title>
</head>
<body>
    <form method="post" action="/importExcelSubmit" enctype="multipart/form-data">
        <input type="file" name="file"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
