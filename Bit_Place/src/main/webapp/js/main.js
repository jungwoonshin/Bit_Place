$(document).ready(function(){
    	var pathname = window.location.pathname;	
    	var data = pathname;
    	var arr = data.split('/');
    	var sub = arr[arr.length-2];    
    	var file = arr[arr.length-1].split('.');
          	
	    if(file[0]=='logged'){
	    	getLogged('top', '#class','true');
	    	getLogged('title', '#title','true');
	    	getLogged('sub','#sub','true');
		    getBody(sub, file[0]);   
	    }else if(sub=='groups'){
		    getData('top', '#class', file[0]);
		    getData('title', '#title',file[0]);
		    getData('sub','#sub',file[0]);
	    	getGroupBody(sub, file[0]);
	    }
});


function getLogged(url, div, value){
	$.ajax({
	type:'GET',
	url : '/Bit_Place/main/frame/'+url+'.do?logged='+value,
	async : true,
	contentType:'application/x-www-form-urlencoded;charset=UTF-8',
	success:function(response,status,request){
		$(div).append(response);	
		}
	});
};


function getData(url, div, value){
	$.ajax({
	type:'GET',
	url : '/Bit_Place/main/frame/'+url+'.do?groupNo='+value,
	async : true,
	contentType:'application/x-www-form-urlencoded;charset=UTF-8',
	success:function(response,status,request){
		$(div).append(response);	
		}
	});
};


function getBody(sub, url){	
	$.ajax({
	type:'GET',
	url : '/Bit_Place/ajax/'+sub+'/'+url+'.do',
	async : true,
	contentType:'application/x-www-form-urlencoded;charset=UTF-8',
	success:function(response,status,request){
		$('#body_output').append(response);	
		}
	});	
};


function getGroupBody(sub, value){
	$.ajax({
	type:'GET',
	url : '/Bit_Place/ajax/'+sub+'/home.do?groupNo='+value,
	async : true,
	contentType:'application/x-www-form-urlencoded;charset=UTF-8',
	success:function(response,status,request){
		$('#body_output').append(response);	
		}
	});	
};