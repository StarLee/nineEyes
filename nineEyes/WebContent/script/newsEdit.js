$(function() {
	
		$("#uploadIMG").dialog({
			"autoOpen" : false,
			"modal" : true,
			"resizable" : false,
			"open" : checkVar,
			"width" : 500,
			"height" : 220,
			"close" : function() {
				var form = $(this).find("form");
				form.each(function(i) {
					this.reset();
				});
			}
		});
		$("#uploadForm").ajaxForm({
			url : "./NewsPic.do",
			type : "post",
			dataType : "json",
			clearForm : true,
			resetForm : true,
			success : makeProcess
		});
		$("input[name='category']").each(function(i) {
			$(this).bind("click", function() {
				addRadioClickEvent($(this).attr("value"));
			});
		});
		CKEDITOR.$_FileUpload=function(editor)
		{
			insertImg(editor);
		};
	});

	function addRadioClickEvent(value,select)
	{
		var form = document.createElement("form");
		var input = document.createElement("input");
		$(input).attr("name", "id");
		$(input).attr("value", value);
		$(input).attr("type", "hidden");
		$(form).append(input);
		var options = {
			url : "./GetNewsTypesSort.do",
			type : "post",
			dataType : "json",
			clearForm : true,
			resetForm : true,
			success :function(data){ showSubclass(data,select);}
		};
		$(form).ajaxSubmit(options);
	}

	function showSubclass(datas,selected) {
		var data = datas[0];
		var list = data.listElements;
		var select = document.createElement("select");
		$(select).attr("name", "sort");
		for ( var n = 0; n < list.length; n++) {
			var option = document.createElement("option");
			$(option).attr("value", list[n].id);
			$(option).html(list[n].name);
			if(selected!=undefined&&selected!=null)
				{
					if(selected==list[n].id)
						$(option).attr("selected","selected");
				}
			$(select).append(option);
		}
		$("#sort").html(select);
	}
	function makeProcess(data, status) {
		if (data[0].bean.code == 1) {
			$("#message").html("上传成功");
			$("input[name='result']").attr("value", data[0].bean.path);
		}
	}

	function checkVar() {
		if (editorCustom == null || editorCustom == undefined)
			alert("网络有问题，上传图片将不会成功");
	}
	function insertImg(editor) {
		$("#uploadIMG").dialog("open");
		$("#confirm").bind("click", function() {
			getIMG(editor);
		});
	}
	function getIMG(editor) {
		var url = $("input[name='result']").attr("value");
		if (url != null && url != undefined) {
			if (editor.name == "outline") {
				editor
						.insertHtml("<img width='300' height='200' src='" +ROOT+url + "'>");
			} else
				editor
						.insertHtml("<img width='700' height='525' src='" +ROOT+url + "'>");
		}
		$("#confirm").unbind("click");
		$("#uploadIMG").dialog("close");
	}
	function cancell() {
		$("#uploadIMG").dialog("close");
	}