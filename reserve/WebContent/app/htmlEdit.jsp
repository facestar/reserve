<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/yndf/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/yndf/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8">var path='<%=request.getContextPath()%>';</script>

<!--jbox-->
<script charset="utf-8" src="<%=request.getContextPath() %>/yndf/jquery.js"></script>
<link id="skin" rel="stylesheet" href="<%=request.getContextPath() %>/yndf/jBox/Skins/Green/jbox.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/yndf/jBox/jquery.jBox-2.3.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/yndf/jBox/i18n/jquery.jBox-zh-CN.js"></script>
<script language="javascript" src="<%=request.getContextPath() %>/yndf/My97DatePicker/WdatePicker.js"></script>
<script charset="utf-8" src="<%=request.getContextPath() %>/yndf/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="<%=request.getContextPath() %>/yndf/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="<%=request.getContextPath() %>/yndf/kindeditor/plugins/code/prettify.js"></script>
<script type="text/javascript">var domid='${param.domid}';</script>
<script>
	KindEditor.ready(function(K) {
		var editor1 = K.create('textarea[class="htmlEditCss"]', {
			cssPath : '<%=request.getContextPath() %>/yndf/kindeditor/plugins/code/prettify.css',
			uploadJson : '<%=request.getContextPath() %>/yndf/kindeditor/jsp/upload_json.jsp',
			fileManagerJson : '<%=request.getContextPath() %>/yndf/kindeditor/jsp/file_manager_json.jsp',
			items:[
			        'source', '|','cut', 'copy', 'paste','image','multiimage','fullscreen','insertfile',
			],
			resizeType:0,
			width:960,
			height:340,
			afterBlur : function(ob) {
				var self = this;
				self.sync();
				K.ctrl(document, 13, function() {
					self.sync();
					K('form[title=htmlEditForm')[0].submit();
				});
				K.ctrl(self.edit.doc, 13, function() {
					self.sync();
					K('form[title=htmlEditForm')[0].submit();
				});
			},
			afterUpload:function(url){
				try{
					var t=parent.document.getElementById(domid);
					if(domid=="contractFileUrl"){
						var mainContent=parent.document.getElementById("uploadFile");
						mainContent.innerHTML="";
						t.value+=url+";";
						var tmp=t.value.split(";");
						for(var i=0;i<tmp.length;i++){
							if(tmp[i]!=""){
								var ts="<a href=\"javascript:showImgFile('"+tmp[i]+"')\">文件"+(i+1)+"</a>";
								$(ts).appendTo($(mainContent));
							}
						}
					}else{
						t.value=url;
					}
	            	window.parent.window.jBox.close();
				}catch(e){
				}
			}
		});
		prettyPrint();
	});
</script>
<script>
	function direc(p){
		window.location.href=p;	
	}
	function prettyPrint(){}
</script>
 <script type="text/javascript">
 	function showfileupload(domid){
 		$.jBox("iframe:"+path+"/sys/uploadFile.jsp?domid="+domid, {
 			title: "文件上传",
 			width: 700,
 			height: 400,
 			id:'uploadfilewin',
 			top:150,
 			buttons: { '关闭': true },
 			submit:function(v, h, f){
 				
 				return true;
 			},
 			closed:function(){
 				$("#xetbody").css("padding","0px").css("margin","0px").css("min-width","1300px");
 			}
 		});
 	}
 	
 	$(function(){
 		$(".uploadfilecss").each(function(){
 			$(this)[0].readonly=true;
 		});
 		$(".uploadfilecss").dblclick(function(){
 			showfileupload($(this)[0].id);
 		});
 	});
 </script>
<style type="text/css">
	.nextPage{ overflow:auto; clear:both;}
	.nextPage div{ float:left; width:45px; border:#0d789b 1px solid; height:35px; margin-left:8px; line-height:35px; text-align:center; vertical-align:middle; font-family:"微软雅黑"; font-size:14px; background-color:#07abe1; cursor:pointer; color:#FFFFFF; font-weight:bold;}
	.nextPage div:hover{ background-color:#0592c0;}
	.uploadfilecss{ background-color:#fbf2e0;}
</style>