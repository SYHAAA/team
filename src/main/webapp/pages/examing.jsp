<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/lib/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/pages/lib/layui/layui.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/pages/js/jquery-2.1.1.min.js"></script>

    <script type="text/javascript">
        //å¨å±å®ä¹ä¸æ¬¡, å è½½formSelects
        layui.config({
            base: '/layui/layui-formSelects-master/src/' //æ­¤å¤è·¯å¾è¯·èªè¡å¤ç, å¯ä»¥ä½¿ç¨ç»å¯¹è·¯å¾
        }).extend({
            formSelects: 'formSelects-v4'
        });
    </script>


    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>前台考试界面</title>
    <%--<link rel="icon" sizes="any" mask="" href="http://192.168.1.247:8088/tangqian/images/LOGO.png">--%>
    <link href="${pageContext.request.contextPath}/pages/shijuan/main.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/pages/shijuan/iconfont.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/pages/shijuan/test.css" rel="stylesheet" type="text/css">
    <style>
        .hasBeenAnswer {
            background: #5d9cec;
            color: #fff;
        }
    </style>
    <script>
        $(function () {
            $("#tj").click(function () {
                var manyLength = ${fn:length(many)};
                for (var i=0;i<manyLength;i++){
                    var s = "many"+i;
                    var as = "manyAnswer"+i;
                    var obj = document.getElementsByName(s);
                    var check_val = [];
                    for(k in obj){
                        if(obj[k].checked){
                            check_val.push(obj[k].value)
                        }
                    }
                    $(":hidden[name="+as+"]").val(check_val);
                }
            })
        })
    </script>
</head>
<body>
<div class="main">
    <!--nr start-->
    <div class="test_main">
        <div class="nr_left">
            <div style="height: 80px;">
                <h1 style=" text-align: center">${exam.examName}</h1>
                 <%--<div style="margin-top: 20px">
                     <h4 style="color: #9F9F9F;text-align: center">
                         出卷人:${} 考试时间:00:00
                     </h4>
                 </div>--%>
            </div>
            <div class="test">


                <form id="userExam" action="/examRecord/saveRecord.action" method="post">
                    <input type="hidden" name="examId" value="${exam.examId}">
                    <input type="hidden" name="singleLength" value="${fn:length(single)}">
                    <input type="hidden" name="manyLength" value="${fn:length(many)}">
                    <input type="hidden" name="judgeLength" value="${fn:length(judge)}">
                    <input type="hidden" name="answerLength" value="${fn:length(answer)}">
                    <div class="test_title">
                        <p class="test_time">
                            <i class="icon iconfont"></i><b class="alt-1">
                            <%--<time class="countdown-alt-1" datetime="PT00H00M00S"><span class="item item-hh"><span
                                    class="hh-1">0</span><span class="hh-2">0</span><span class="label label-hh"></span></span><span
                                    class="separator">:</span><span class="item item-mm"><span
                                    class="mm-1">0</span><span class="mm-2">0</span><span class="label label-mm"></span></span><span
                                    class="separator">:</span><span class="item item-ss"><span
                                    class="ss-1">0</span><span class="ss-2">0</span><span class="label label-ss"></span></span>
                            </time>--%>
                        </b>
                        </p>
                        <input type="hidden" id="studentSource" name="studentSource">
                        <font><input type="submit" name="test_jiaojuan" id="tj" value="交卷"/></font>
                    </div>

                    <c:if test="${fn:length(single)>0}">
                    <div class="test_content">
                        <div class="test_content_title">
                            <h2>单选题</h2>
                            <p>
                                <span>共</span><i
                                    class="content_lit">${fn:length(single)}</i><span>题，</span><span>合计</span><i
                                    class="content_fs">${fn:length(single)*single.get(0).subjectSource}</i><span>分</span>
                            </p>
                        </div>
                    </div>
                    <c:forEach items="${single}" var="s" varStatus="sg">
                    <div class="test_content_nr">
                        <ul>
                                <li id="qu_0_1">
                                    <input type="hidden" name="singleQuestion${sg.index}" value="${s.subjectId}">
                                    <input type="hidden" name="singleSource" value="${single.get(0).subjectSource}">
                                    <div class="test_content_nr_tt">
                                        <i>${sg.index+1}</i><span>(${s.subjectSource}分)</span><font>${s.subjectContent}</font><b
                                            class="icon iconfont"></b>
                                    </div>
                                    <div class="test_content_nr_main">
                                        <ul>
                                            <li class="option">
                                            <c:if test="${not empty(s.optionsA)}">
                                                <input name="single${sg.index}" type="radio" class="radioOrCheck"
                                                        value="A">A、<p class="ue" style="display: inline;">${s.optionsA}</p><br>
                                            </c:if>
                                            </li>
                                            <c:if test="${not empty(s.optionsB)}">
                                            <li class="option">
                                                <input name="single${sg.index}"  type="radio" class="radioOrCheck"
                                                        value="B">B、<p class="ue" style="display: inline;">${s.optionsB}</p><br>
                                            </li>
                                            </c:if>
                                            <c:if test="${not empty(s.optionsC)}">
                                             <li class="option">
                                                <input name="single${sg.index}" type="radio" class="radioOrCheck"
                                                        value="C">C、<p class="ue" style="display: inline;">${s.optionsC}</p><br>
                                             </li>
                                            </c:if>
                                            <c:if test="${not empty(s.optionsD)}">
                                             <li class="option">
                                                 <input name="single${sg.index}" type="radio" class="radioOrCheck"
                                                         value="D">D、<p class="ue" style="display: inline;">${s.optionsD}</p>
                                             </li>
                                            </c:if>
                                            <%--<c:forEach items="${s.choseList}" var="c" varStatus="ch">
                                                <li class="option">
                                                    <input name="single${sg.index}" type="radio" class="radioOrCheck"
                                                           id='answer${ch.index}'value="${ch.index}">
                                                    <label for="answer${ch.index}">
                                                        <c:choose>
                                                            <c:when test="${ch.index==0}">
                                                                A、
                                                            </c:when>
                                                            <c:when test="${ch.index==1}">
                                                                B、
                                                            </c:when>
                                                            <c:when test="${ch.index==2}">
                                                                C、
                                                            </c:when>
                                                            <c:otherwise>
                                                                D、
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <p class="ue" style="display: inline;">${c.get(ch.index)}</p>
                                                    </label>
                                                </li>
                                            </c:forEach>--%>
                                        </ul>
                                    </div>
                                </li>
                        </ul>
                    </div>
                    </c:forEach>
                    </c:if>
                    <c:if test="${fn:length(many)>0}">
                    <div class="test_content">
                        <div class="test_content_title">
                            <h2>多选题</h2>
                            <p>
                                <span>共</span><i
                                    class="content_lit">${fn:length(many)}</i><span>题，</span><span>合计</span><i
                                    class="content_fs">${fn:length(many)*many.get(0).subjectSource}</i><span>分</span>
                            </p>
                        </div>
                    </div>

                    <div class="test_content_nr">
                        <ul>
                            <c:forEach items="${many}" var="m" varStatus="my">
                                <li id="qu_1_11">
                                    <input type="hidden" name="manyQuestion${my.index}" value="${m.subjectId}">
                                    <input type="hidden" name="manySource" value="${many.get(0).subjectSource}">
                                    <div class="test_content_nr_tt">
                                        <i>${fn:length(single)+my.index+1}</i><span>(${m.subjectSource}分)</span><font>
                                            <span>&nbsp;&nbsp;${m.subjectContent}</span></font><b
                                            class="icon iconfont"></b>
                                    </div>
                                    <div class="test_content_nr_main">
                                        <ul>
                                        <c:if test="${not empty(m.optionsA)}">
                                            <li class="option">
                                            <input name="many${my.index}" type="checkbox" class="radioOrCheck"
                                                    value="A">A、<p class="ue" style="display: inline;">${m.optionsA}</p>
                                            </li>
                                        </c:if>
                                        <c:if test="${not empty(m.optionsB)}">
                                            <li class="option">
                                            <input name="many${my.index}" type="checkbox" class="radioOrCheck"
                                                    value="B">B、<p class="ue" style="display: inline;">${m.optionsB}</p>
                                            </li>
                                        </c:if>
                                        <c:if test="${not empty(m.optionsC)}">
                                            <li class="option">
                                            <input name="many${my.index}" type="checkbox" class="radioOrCheck"
                                                    value="C">C、<p class="ue" style="display: inline;">${m.optionsC}</p>
                                            </li>
                                        </c:if>
                                        <c:if test="${not empty(m.optionsD)}">
                                            <li class="option">
                                            <input name="many${my.index}" type="checkbox" class="radioOrCheck"
                                                    value="D">D、<p class="ue" style="display: inline;">${m.optionsD}</p>
                                            </li>
                                        </c:if>
                                            <input type="hidden" name="manyAnswer${my.index}" value="">
                                        </ul>
                                        <%--<c:forEach items="${m.choseList}" var="c" varStatus="ch">
                                            <ul>
                                                <li class="option">
                                                    <input type="checkbox" class="radioOrCheck" name="many${my.index}"
                                                           id="1_answer_1_option_49" value="${ch.index}">

                                                    <label for="1_answer_1_option_49">
                                                        <c:choose>
                                                            <c:when test="${ch.index==0}">
                                                                A
                                                            </c:when>
                                                            <c:when test="${ch.index==1}">
                                                                B
                                                            </c:when>
                                                            <c:when test="${ch.index==2}">
                                                                C
                                                            </c:when>
                                                            <c:otherwise>
                                                                D
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <p class="ue" style="display: inline;"></p>
                                                        <p><span>${c.chose}</span></p>
                                                        <p></p>
                                                    </label>
                                                </li>
                                            </ul>
                                        </c:forEach>--%>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    </c:if>
                    <c:if test="${fn:length(judge)>0}">
                    <div class="test_content">
                        <div class="test_content_title">
                            <h2>判断题</h2>
                            <p>
                                <span>共</span><i
                                    class="content_lit">${fn:length(judge)}</i><span>题，</span><span>合计</span><i
                                    class="content_fs">${fn:length(judge)*judge.get(0).subjectSource}</i><span>分</span>
                            </p>
                        </div>
                    </div>
                    <div class="test_content_nr">
                        <ul>
                            <c:forEach items="${judge}" var="j" varStatus="jg">
                                <li id="">
                                    <input type="hidden" name="judgeQuestion${jg.index}" value="${j.subjectId}">
                                    <input type="hidden" name="judgeSource" value="${judge.get(0).subjectSource}">
                                    <div class="test_content_nr_tt">
                                        <i>${fn:length(single)+fn:length(many)+1}</i><span>${j.subjectSource}</span>
                                        <font>${j.subjectContent}</font><b
                                            class="icon iconfont"></b>
                                    </div>
                                    <div class="test_content_nr_main" style="width: 100%;height: 50px;">
                                        <ul>
                                            <li class="option">
                                                <input name="judge${jg.index}" type="radio" class="radioOrCheck"
                                                       value="1" style="margin-left: 50px">
                                                <span>正确</span><br/>
                                                <input name="judge${jg.index}" type="radio" class="radioOrCheck"
                                                       value="0" style="margin-left: 50px">
                                                <span>错误</span>
                                            </li>
                                        </ul>
                                    </div>
                                </li>
                            </c:forEach>

                        </ul>
                    </div>
                    </c:if>
                    <c:if test="${fn:length(answer)>0}">
                    <div class="test_content">
                        <div class="test_content_title">
                            <h2>问答题</h2>
                            <p>
                                <span>共</span><i
                                    class="content_lit">${fn:length(answer)}</i><span>题，</span><span>合计</span><i
                                    class="content_fs">${fn:length(answer)*answer.get(0).subjectSource}</i><span>分</span>
                            </p>
                        </div>
                    </div>
                    <div class="test_content_nr">
                        <ul>
                            <c:forEach items="${answer}" var="a" varStatus="aw">
                                <li id="qu_3_16">
                                    <input type="hidden" name="answerQuestion${aw.index}" value="${a.subjectId}">
                                    <input type="hidden" name="answerSource" value="${answer.get(0).subjectSource}">
                                    <div class="test_content_nr_tt">
                                        <i>${fn:length(single)+fn:length(many)+fn:length(judge)+aw.index+1}</i><span>${a.subjectSource}</span>
                                        <font>${a.subjectContent}</font><b
                                            class="icon iconfont"></b>
                                    </div>
                                    <div class="test_content_nr_main">
                                    <textarea type="text" name="answer${aw.index}"
                                              style="background-color: #D9EDF7; border:1px solid #BCE8F1;border-radius:5px;width:100%;height:200px;color:blue;margin-bottom:100px"></textarea>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    </c:if>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>