/*by StarLee*/
/*就是用来显示分页时的上一页下一页*/
$.fn.extend( {
	pageStyleNormal : function(property, showFun) {
		var currentPage = property.currentPage;
		var pageSize = property.pageSize;
		var pageCount = property.pageCount;
		var itemCount = property.itemCount;
		var table = document.createElement("table");
		$(table).css( {
			width : "100%",
			"text-align" : "center"
		});
		var tr = table.insertRow(table.rows.length);
		var td_pageCount = tr.insertCell(tr.cells.length);
		var td_currentPage = tr.insertCell(tr.cells.length);
		var td_first = tr.insertCell(tr.cells.length);
		var td_last = tr.insertCell(tr.cells.length);
		var td_pre = tr.insertCell(tr.cells.length);
		var td_next = tr.insertCell(tr.cells.length);

		$(td_pageCount).html("共" + pageCount + "页");
		$(td_currentPage).html("当前第" + currentPage + "页");

		var prePage = parseInt(currentPage) - 1;
		var nextPage = parseInt(currentPage) + 1

		if (prePage == 0) {
			$(td_first).html("首页");
			$(td_pre).html("没有了");
		} else {
			insertA( {
				td : td_first,
				page : "1",
				showName : "首页"
			});
			insertA( {
				td : td_pre,
				page : prePage,
				showName : "上一页"
			});
		}
		if (nextPage > parseInt(pageCount)) {
			$(td_next).html("没有了");
			$(td_last).html("末页");
		} else {
			insertA( {
				td : td_next,
				page : nextPage,
				showName : "下一页"
			});
			insertA( {
				td : td_last,
				page : pageCount,
				showName : "末页"
			});
		}
		this.html(table);

		var form = document.createElement("form");

		this.append(form);
		function insertA(param) {
			var td = param.td;
			var page = param.page;
			var showName = param.showName
			var a = document.createElement("a");
			$(a).attr("href", "javascript:void(0)");
			$(a).bind("click", {
				page : page
			}, function(event) {
				var pageee = event.data.page;
				showFun(pageee, form);
			});
			$(a).html(showName);
			$(td).html(a);
		}
	}

});

$.fn.extend( {
	formParam : function(options) {
		if (this.get(0).nodeName != "FORM") {
			alert("元素不是一个表单");
			return;
		} else {
			var url = options.url;
			var type = options.type;
			var datas = options.data;
			this.empty();
			for ( var data in datas) {
				var input = document.createElement("input");
				$(input).attr("type", "hidden");
				$(input).attr("name", data);
				$(input).attr("value", datas[data]);
				this.append(input);
			}
			this.attr("action", url);
			this.attr("method", type);
			this.submit();
		}
	}
});
/**
 * normal example
 */

/**
 * 
 *function showFun(page, form) {

 *	var options = {
 *		url : "/innoPlat/projecto/ProcessingTask.do",
 *		type : "POST",
 *		data : {pageNum:page}
 *	};
$(form).formParam(options);
 *}

 *$(function(){
 *		$("#page").pageStyleNormal(
 * 		{
 *			currentPage:currentPage,
 *			pageSize:pageSize,
 *			pageCount:pageCount,
 *			itemCount:recordsCount,
 *		},showFun);
 *	});
 * 
 */
/**
 * ajax example
 */
/**
 * function showFun(page, form) {
 *	var options = {
 *		url : "/innoPlat/projecto/SelectMilestone.do",
 *		type : "POST",
 *		reset:true,
 *		clearForm:true,
 *		dataType:"json",
 *		data : {
 *			pageNum : page
 *		},
 *		success:show
 *	};
 *	$(form).ajaxSubmit(options);
 *}
 *
 *function getData() {
 *	$.ajax( {
 *		type : "POST",
 *		dataType : "json",
 *		url : "/innoPlat/projecto/SelectMilestone.do",
 *		success : show
 *	});
 *
 *}
 *function show(data) {
 *	
 *$("#page").pageStyleNormal({
 *			currentPage:data.extra.currentPage,
 *			pageSize:data.extra.pageSize,
 *			pageCount:data.extra.pageCount,
 *			itemCount:data.extra.recordsCount,
 *				},showFun);
 *	var datas=data.resultList;
 *	var table =document.createElement("table");
 *	for(var n=0;n<datas.length;n++)
 *	{
 *		var dataa=datas[n];
 *		var tr=table.insertRow(table.rows.length);
 *		var content=[dataa.oMilestoneCreatorID,dataa.oMilestoneTitle,dataa.oMilestoneID,dataa.projectItemID,dataa.projectItemName];
 *		for(var i=0;i<content.length;i++)
 *		{
 *			var td= tr.insertCell(tr.cells.length);
 *			$(td).html(content[i]);
 *		}
 *	}
 *	$("#content").html(table);
 *	$("#dialog").dialog("open");
 *}
 *
 *$(function(){
 *		
 *		$("input[name='deadline']").datepicker( {
 *		dateFormat : 'yy-mm-dd'
 *	});
 *		$("#dialog").dialog(
 *			{
 *				autoOpen:false,
 *				modal:true,
 *				resizable:false,
 *				width:500,
 *				height:400,
 *				title:"请选择一个里程碑"
 *			})
 *
 *});
 */
