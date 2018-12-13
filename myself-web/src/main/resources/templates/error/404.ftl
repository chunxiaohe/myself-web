<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>404</title>

<link href="static/error/css/404.css" rel="stylesheet" type="text/css" />

</head>
<body >
    <div class="main-content" >
        <div class="st"><img src="static/error/img/404_03.png"></div>
        <div class="fh"><a href="/blog/page/index"><img src="static/error/img/404_06.png"></a></div>
        <div class="fh"><b id="num">5</b>秒后跳转到首页</div>
    </div>
<!--脚本开始-->
<script>
function countDown(secs){
	if(--secs>0) {
		document.getElementById("num").innerText=secs;
		setTimeout(function(){countDown(secs)},1000);  
	}
	else{
		window.location.href='/blog/page/index';
	} 
}
countDown(5); 
</script>
<!--脚本结束--> 

</body>
</html>
