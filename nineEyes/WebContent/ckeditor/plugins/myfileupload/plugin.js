CKEDITOR.plugins.add("myfileupload", {
	init : function(editor) {
		editor.addCommand("myfileupload", {
			exec : function(editor) {
				//insertImg(editor);
				CKEDITOR.$_FileUpload(editor);
			}
		});
		editor.ui.addButton('myfileupload', {
			label : 'uploadFile',
			command : "myfileupload",
			icon: './plugins/myfileupload/upload.gif'
		});
	}
});
