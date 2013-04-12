/*
Copyright (c) 2003-2011, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function(config) {
	// Define changes to default configuration here. For example:
	config.language = 'zh-cn';
	config.uiColor = '#C2CEEA';
	config.toolbarCanCollapse = true;
	config.extraPlugins = "myfileupload";
	config.resize_enabled=false;
	config.width=800;
	config.toolbar_Basic =
		[
		    [ 'Source','Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord' ],
		    [ 'Undo', 'Redo', 'Find', 'Replace', 'SelectAll', 'RemoveFormat' ],
		    [ 'JustifyLeft', 'JustifyCenter', 'JustifyRight','JustifyBlock', 'myfileupload' ]
		];
		config.toolbar = 'Basic';
	
	config.resize_maxWidth = 750;
	
	/*config.filebrowserUploadUrl = '';
	config.filebrowserImageBrowseUrl = '';
	config.filebrowserBrowseUrl = '';
	config.filebrowserFlashBrowseUrl = '';
	config.filebrowserImageBrowseLinkUrl = '';
	config.filebrowserImageUploadUrl = '';*/
	config.autoGrow_minHeight = 600;
	
};
