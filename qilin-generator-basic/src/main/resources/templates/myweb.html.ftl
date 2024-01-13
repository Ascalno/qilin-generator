<!DOCTYPE html>
<html>
<head>
    <title>麒麟官网</title>
</head>
<body>
<h1>欢迎来到麒麟官网</h1>
<ul>
    <#-- 循环渲染导航条 -->
    <#list menuItems as item>
        <li><a href="${item.url}">${item.label}</a></li>
    </#list>
</ul>
    <#-- 底部信息 -->
<footer>
    ${currentYear} 官网. All right reserved.
</footer>
</body>
</html>