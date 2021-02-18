<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="myctx" value="${pageContext.request.contextPath}"/>
<jsp:include page="/top.jsp"/>

<script>
    $(function () {
        $('#tourF').on('submit', () => {
            if(!$('#keyword').val()) {
                alert('키워드 입력하세요');
                $('#keyword').focus();
                return false;
            }
            return true;
        })
    })
</script>

<div id="warp">
    <form name="tourF" id="tourF" action="tourList.do" method="get">
        <label>방문목적</label>
        <input type="text" name="keyword" id="keyword" placeholder="키워드를 입력하세요" class="search">
        <button id="btnKeyword">검색</button>
    </form>
</div>
<div id="openAPI">

</div>

<jsp:include page="/foot.jsp"/>