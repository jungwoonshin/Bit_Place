var window;
var console;
var repositories = {
		"user_id":"",
		"repo_name":""
};

var abc = {
		"d":"gg"
}

window.onload = function () {
 loadRepositoryList();
 console.log('abc');
};



function loadRepositoryList() {
 $.ajax('list.git', 
	{
		 type: "GET",
		 dataType: "json",
		 success: function(repositories) {
			  var table = $("#repoTable"); 
			  var tr, td, a;
			  for (var i in repositories) {
				  $("<tr>")
						  .append($("<td>").append($("<a>").attr('href', 'selectcontent.git?content_no=' + repositories[i].content_no)
								  .text(repositories[i].content_no).click(
										  function(event){
											  event.preventDefault();
											  localStorage.user_id = repositories[i].git_id;
											  localStorage.repo_name = repositories[i].git_repository;
											  window.alert("loading selected repository");
//												$("#contentTable").empty();
												$.getJSON(this.href,
													function(tree_jsonArray){
														var table = $("#contentTable"); 
														var tr, td, a;
														for( var i in tree_jsonArray){
															if(tree_jsonArray[i].type.value == 'tree'){
																$("<tr>")
																.append($("<td>").append($("<a>").attr('href', 
																		'selecttree.git?'
																		+ "tree_sha=" + tree_jsonArray[i].sha.value 
																		+ "&repo_id=" + localStorage.user_id 
																		+ "&repo_name=" + localStorage.repo_name)
																		.text(tree_jsonArray[i].path.value).click(BlobTreeClick)))
																.append($("<td>").text(tree_jsonArray[i].type.value))
																.append($("<td>").text(tree_jsonArray[i].sha.value))
																.appendTo(table);
															} else {
																$("<tr>")
																.append($("<td>").text(tree_jsonArray[i].path.value))
																.append($("<td>").text(tree_jsonArray[i].type.value))
																.append($("<td>").text(tree_jsonArray[i].sha.value))
																.appendTo(table);
															}
														}
													}
												);
										  }
//										  loadSelectedRepositoryList
								  )))
						  .append($("<td>").text(repositories[i].git_id))
						  .append($("<td>").text(repositories[i].git_repository))
						  .appendTo(table);
			  }
		 }
	}
 );
}

//TODO
function BlobTreeClick(event){
	event.preventDefault();
	clearContentTable();
	$.getJSON(
			this.href,
			function(tree_sha_jsonArray){
				var table = $("#contentTable"); 
				var tr, td, a;
				for( var i in tree_sha_jsonArray){
					if(tree_sha_jsonArray[i].type.value == 'tree'){
						$("<tr>")
						.append($("<td>").append($("<a>").attr('href', 
								'selecttree.git?'
								+ "tree_sha=" + tree_sha_jsonArray[i].sha.value 
								+ "&repo_id=" + localStorage.user_id 
								+ "&repo_name=" + localStorage.repo_name)
								.text(tree_sha_jsonArray[i].path.value).click(BlobTreeClick)))
						.append($("<td>").text(tree_sha_jsonArray[i].type.value))
						.append($("<td>").text(tree_sha_jsonArray[i].sha.value))
						.appendTo(table);
					} else {
						$("<tr>")
						.append($("<td>").text(tree_sha_jsonArray[i].path.value))
						.append($("<td>").text(tree_sha_jsonArray[i].type.value))
						.append($("<td>").text(tree_sha_jsonArray[i].sha.value))
						.appendTo(table);
					}
				}
			}
	);
	
	
//	window.alert("end of tree click");
}





function clearContentTable()
{
 var tableRef = document.getElementById('contentTable');
 while ( tableRef.rows.length > 0 )
 {
  tableRef.deleteRow(0);
 }
}




//backup functions
function BlobTreeClick01(event){
	clearContentTable();
	window.alert("repo_id: " + localStorage.user_id);
	window.alert("repo_name: " + localStorage.repo_name);
	console.log("abc" + abc.d);
	
	window.alert("end of tree click");
}


// backup function
function loadSelectedRepositoryList01(event) {
	event.preventDefault();
	
	$("#contentTable").empty();
	
	$.getJSON(
		this.href,
		function(tree_jsonArray){
			var table = $("#contentTable"); 
			var tr, td, a;
			for( var i in tree_jsonArray){
				$("<tr class='clickableRow' href='contentTable.git?content_no='>")
				.append($("<td>").text(tree_jsonArray[i].path.value).click(BlobTreeClick))
				.append($("<td>").text(tree_jsonArray[i].type.value))
				.append($("<td>").text(tree_jsonArray[i].sha.value))
				.appendTo(table);
			}
		}
	);
}







