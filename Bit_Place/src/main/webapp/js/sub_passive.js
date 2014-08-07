$(document).ready(function(){
	
//title.jsp
	var groupflag = false;
	$("#groupbtn").click(function() {		
		  if(groupflag == false){	
			 var heights = $('#submenuWrapper').css('height');
					
			$('#submenu').animate({opacity:'0.8', height : heights},500);
			groupflag=true;
		  }else{
			$('#submenu').animate({opacity:'0', height : '0px'},500);
 			groupflag=false;
		  }
	});
	
	
	
	var totalTitleNum = $('#totalTitleNum').val();
	for(var i=0; i<totalTitleNum; i++){
		$('.title_btn_'+i).click(function(){
			var titlenum = $(this).attr('value');		
			$.ajax({
				type:'GET',
				url : '/Bit_Place/ajax/groups/displayContentByTitle.do?titleno='+titlenum,
				async : true,
				contentType:'application/x-www-form-urlencoded;charset=UTF-8',
				success:function(response,status,request){
					$('#sub_data').empty();
					$('#sub_data').append(response);	
					}
			});	
		});
	}
	
//displayContent.jsp and frame/sub.jsp
	
	var datanumberresult= $('#datanumberresult').val();

	for(var i=0; i<datanumberresult;i++){
		$('.subbtn_'+i).click(function(){		
			var contentno = $(this).attr('id');	
			var git_id=$(this).attr('git_id');
			var git_rep=$(this).attr('git_rep');
			var git_pwd=$(this).attr('git_pwd');
				
			$.ajax({
				type:'GET',
				url : '/Bit_Place/ajax/groups/displayContent.do'+
				'?contentno='+contentno+
				'&git_id='+git_id+
				'&git_rep='+git_rep+
				'&git_pwd='+git_pwd,
				
				async : true,
				contentType:'application/x-www-form-urlencoded;charset=UTF-8',
				success:function(response,status,request){
					$('#body_output').empty();
					$('#body_output').append(response);	
					}
				});	
		});
	}
	
});