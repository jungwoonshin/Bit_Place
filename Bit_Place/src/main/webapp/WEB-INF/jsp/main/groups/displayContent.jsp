<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript">
$.ajax({
	type:'GET',
	url : '/Bit_Place/ajax/groups/content_commitinfo.do',
	async : true,
	contentType:'application/x-www-form-urlencoded;charset=UTF-8',
	success:function(response,status,request){
	$('#commit_wrapper').append(response);	
	    var totalnum = $('#content_commitinfo_btn_num').val();	
     	    for(i=0; i<totalnum; i++){
                 $('.content_commintinfo_btn_'+i).click(function(){
		    var sha = $(this).attr('id');
		    $.ajax({
		    type:'GET',
		    url : '/Bit_Place/ajax/groups/content_commitinfo_search1.do?sha='+sha,
		    async : true,
		    contentType:'application/x-www-form-urlencoded;charset=UTF-8',
		    success:function(response,status,request){	
		    	$('#folders_wrapper').append(response);	
		          var totalnum = $('#content_commitinfo_btn_num2').val();
		    	   for(var s =0; s<totalnum; s++){
		    		$('#content_commitinfo_searchbtn_'+s).click(function(){
		    			var filesha = $(this).attr('class');
		    		    $.ajax({
		    			    type:'GET',
		    			    url : '/Bit_Place/ajax/groups/content_commitinfo_contents.do?filesha='+filesha,
		    			    async : true,
		    			    contentType:'application/x-www-form-urlencoded;charset=UTF-8',
		    			    success:function(response,status,request){	
		    			    	$('#contents_wrapper').append(response);	
		    			    }
		    		      });
	              		});	   
		    	     }
		    	   
			    for(var s=0; s<totalnum; s++){
			    	$('#content_commitinfo_folderbtn_'+s).click(function(){
    			    		var bufname = $(this).attr('id');

			    		
			    		var foldersha = $(this).attr('class');
			    		   $.ajax({
			    			    type:'GET',
			    			    url : '/Bit_Place/ajax/groups/content_commitinfo_folder.do?foldersha='+foldersha,
			    			    async : true,
			    			    contentType:'application/x-www-form-urlencoded;charset=UTF-8',
			    			    success:function(response,status,request){	
			    			    	
			    			    	bufname ="#sub_"+bufname;
			    			    	alert(bufname);
			    			    	$(bufname).append(response);	
			    			    	
			    			    				    			    				    			    	
			    			    }
			    	     });				    		
			        });
			    }
		        }});		 
		    });
		 }
                 }
	 });
</script>


<table id="displayContent_table">
<tr>
	<td>
		<img src="../img/top/leadericon.png">
	</td>
	<td>
		${ajax_data.name }
	</td>
	<td>
		${ajax_data.content_title }
	</td>
	<td>
	<fmt:formatDate pattern="yyyy - MM - dd" value="${ajax_data.edited_date }" />
	</td>
	<td>
	<span id="displayContent_count">조회수 234</span>	
	</td>
</tr>
</table>


<div id="commit_wrapper"></div>

<div id="folders_wrapper"></div>

<div id="contents_wrapper"></div>
