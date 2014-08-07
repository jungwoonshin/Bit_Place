<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<style>
#form_wrapper{
	width : 800px;
	margin-left:20px;
	padding-top:20px;
	padding-bottom:20px;
	
	text-align: center;
}
</style>
<script type="text/javascript">
$('#insertGroup').click(function(){
	frm.submit();	
});
</script>

<div id="form_wrapper">
<form name="frm" class="form-horizontal" role="form" action="../ajax/groups/insertGroup.do" method="POST">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">GROUPNAME</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" name="groupname">
    </div>
  </div>
   <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">CODE</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" name="code">
    </div>
  </div>
    <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">LINK</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" name="link">
    </div>
  </div>
    <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">INTRODUCE</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" name="introduce" >
    </div>
  </div>
    <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">KEYWORD</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" name="keyword">
    </div>
  </div>
    <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">CREATED_DATE</label>
    <div class="col-sm-9">
      <input type="date" class="form-control" name="created_date">
    </div>
  </div>
    <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">CREATOR</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" value="${FirstGroup}" name="creator">
    </div>
  </div>
     <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">ACTIVEGROUP</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" name="activegroup">
    </div>
  </div>
     <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">GIT_REPOSITORY</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" name="git_repository">
    </div>
  </div>  
</form>
<button class="btn btn-primary" id="insertGroup" >insertGroup</button>
</div>