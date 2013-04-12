<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="eyes" uri="/eyes"%>
<!-- 这个主要是设置js中也应该具有这样一个根目录的全局 -->
<script type="text/javascript">
	(function(url) {
		Window.prototype.ROOT = url;
	})("${root}");
</script>

