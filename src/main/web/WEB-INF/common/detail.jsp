<%--@elvariable id="seckill" type="com.suny.entity.Seckill"--%>
<%--
  Created by IntelliJ IDEA.
  User: jianrongsun
  Date: 17-5-25
  Time: 下午5:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./tag.jsp" %>
<html>
<head>
    <title>秒杀商品详情页面</title>
    <%@include file="./head.jsp" %>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h1>${seckill.name}</h1>
        </div>
        <div class="panel-body">
            <h2 class="text-danger">
                <span class="glyphicon glyphicon-time"></span>
                <span class="glyphicon" id="seckill-box"></span>
            </h2>
        </div>
    </div>
</div>

<div id="killPhoneModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title text-center">
                    <span class="glyphicon glyphicon-phone"></span>秒杀电话:
                </h3>
            </div>
        </div>

        <div class="modal-body">
            <div class="row">
                <div class="col-xs-8 col-xs-offset-2">
                    <label for="killPhoneKey"></label><input type="text" name="killPhone" id="killPhoneKey" placeholder="填写手机号码" class="form-control">
                </div>
            </div>
        </div>

        <div class="modal-footer">
            <span id="killPhoneMessage" class="glyphicon"></span>
            <button type="button" id="killPhoneBtn" class="btn btn-success">
                <span class="glyphicon glyphicon-phone"></span>
                提交
            </button>
        </div>
    </div>
</div>
</body>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script><script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/jquery-cookie/1.4.0/jquery.cookie.min.js"></script>
<script src="https://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/script/seckill.js"></script>
<script type="text/javascript">
    $(function () {
        var startTimeVal = "${seckill.startTime} " + seckill.cloneZero("${seckill.startTime}");
        var endTimeVal = "${seckill.endTime} " + seckill.cloneZero("${seckill.endTime}");
        console.log("startTimeVal========" + startTimeVal);
        console.log("endTimeVal========" + endTimeVal);
        // 传入参数
        seckill.detail.init({
            seckillId:${seckill.seckillId},
            startTime: startTimeVal,
            endTime: endTimeVal
        })
    })
</script>

</html>