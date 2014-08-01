$(document).ready(function(){
	    getData('top', '#class');
	    getData('title', '#title');
	    getData('sub','#sub');
	    getBody();
});

function getData(url, div){
	$.ajax({
	type:'GET',
	url : '/Bit_Place/main/frame/'+url+'.do',
	async : true,
	contentType:'application/x-www-form-urlencoded;charset=UTF-8',
	success:function(response,status,request){
		$(div).append(response);	
		}
	});
};


function getBody(){
    var pathname = window.location.pathname;	
    var data = pathname;
    var arr = data.split('/');
    var arr2 = arr[arr.length-1].split('.');
	
	$.ajax({
	type:'GET',
	url : '/Bit_Place/ajax/sub1/'+arr2[0]+'.do',
	async : true,
	contentType:'application/x-www-form-urlencoded;charset=UTF-8',
	success:function(response,status,request){
		$('#body_output').append(response);	
		}
	});	
};