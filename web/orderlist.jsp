<%@ page pageEncoding="utf-8"%>
<%-- 引入JSTL标签库 --%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>订单管理</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="js/layui.css">
    <script type="text/javascript" src="js/layui.all.js"></script>

</head>
<body>

<table id="demo" lay-filter="test"></table>
<script>
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#demo'
            ,height: 312
            ,url: '${pageContext.request.contextPath}/dopage' //数据接口
            /*,request:{
                page:1,
                limit:2   默认值可以省略不屑
            }*/
            /*,response:{
                statusName: 'code' //规定数据状态的字段名称，默认：code
                ,statusCode: 0 //规定成功的状态码，默认：0
                ,msgName: 'message' //规定状态信息的字段名称，默认：msg
                ,countName: 'count' //规定数据总数的字段名称，默认：count
                ,dataName: 'data' //规定数据列表的字段名称，默认：data   默认值可以省略不屑
            }*/
            ,page: true //开启分页
            ,cols:[[
                {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
                ,{field: 'door_id', title: '所属门店', width:80}
                ,{field: 'order_no', title: '订单号', width:80, sort: true}
                ,{field: 'order_type', title: '类型', width:80}
                ,{field: 'pnum', title: '人数', width: 177}
                ,{field: 'cashier', title: '收银员', width: 80, sort: true}
                ,{field: 'order_time', title: '下单时间', width: 80, sort: true}
                ,{field: 'pay_time', title: '结账时间', width: 80}
                ,{field: 'pay_type', title: '支付方式', width: 135, sort: true}
                ,{field: 'price', title: '金额', width: 135, sort: true}
            ]]
            ,page:{
                layout:['limit','count','prev','page','next','skip'],
                curr:1,
                groups:7,
                first:false,
                last:false,
            }
            ,limit:6
            ,limits:[6]
        });
    });
</script>

</body><!-- body-end  -->
</html>