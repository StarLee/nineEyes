$(function() {
	$(".navication li img").each(function(i) {
		if ($(this).attr("src").lastIndexOf("_select.gif") != -1)
			return;
		$(this).bind("mouseover", function() {
			var url = this.src;
			var prefix = url.slice(0, url.lastIndexOf(".gif"));
			$(this).attr("src", prefix.concat("_select.gif"));
		});
		$(this).bind("mouseout", function() {
			var url = this.src;
			var prefix = url.slice(0, url.lastIndexOf("_select.gif"));
			$(this).attr("src", prefix.concat(".gif"));
		});
	});
});