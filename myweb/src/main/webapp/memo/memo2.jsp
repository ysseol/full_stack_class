<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
$(function() {
    list();
    $("#btnSave").click(function() {
        insert();
    });
    $("#btnSearch").click(function() {
        list();
    });

});
function list() {
    let search_option=$("#search_option").val();
    let search=$("#search").val();
    fetch("<%=request.getContextPath()%>/memo_servlet/list.do?search_option="+search_option+"&search="+search)
      .then(response => response.text())
      .then(txt => {
        document.getElementById("result").innerHTML = txt;
      });
}

function insert() {
    let writer = $("#writer").val();
    let memo = $("#memo").val();
    let params= {"writer": writer ,"memo": memo};
    fetch("<%=request.getContextPath()%>/memo_servlet/insert.do", {
          method: "POST",
          headers: {
            "Content-Type": "application/x-www-form-urlencoded",
          },
          body: new URLSearchParams(params).toString()
        })
        .then(() => {
          list();
          document.getElementById("writer").value = "";
          document.getElementById("memo").value = "";
        });
}

function memo_del(idx) {
    location.href = "<%=request.getContextPath()%>/memo_servlet/del.do?idx=" + idx;
}

function check_all(ck){    
    if (ck) {
        $("input[name=idx]").prop("checked", true);
    } else { 
        $("input[name=idx]").prop("checked", false);
    }
}

function delete_all(){
    let arr=$("input[name=idx]"); 
    let cnt=0; 
    for(i=0; i<arr.length; i++){
        if(arr[i].checked==true) cnt++;
    }
    if(cnt==0){
        alert("삭제할 메모를 선택하세요.");
        return;
    }
    document.form1.action="<%=request.getContextPath()%>/memo_servlet/delete_all.do";
    document.form1.submit();
}    
</script>
</head>
<body>
이름 : <input id="writer" size="10"><br>
메모 : <input id="memo" size="40">
<input type="button" id="btnSave" value="확인"><br>
<select id="search_option">
    <option value="writer">이름</option>
    <option value="memo">메모</option>
    <option value="writer_memo">이름+메모</option>
</select>
<input type="text" id="search" value="${search}" >
<input type="button" id="btnSearch" value="조회" >
<div id="result"></div>
</body>
</html>