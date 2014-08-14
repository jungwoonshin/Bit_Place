var window;

window.onload = function () {
 loadRepositoryList();
};


function loadRepositoryList() {
 $.ajax('list.git', {
 type: "GET",
 dataType: "json",
 success: function(repositories) {
  var table = $("#repoTable"); 
  var tr, td, a;
  for (var i in repositories) {
    $("<tr>")
       .append($("<td>").append(
                $("<a>").attr('href', 'selectcontent.git?content_no=' + repositories[i].content_no)
                .text(repositories[i].content_no)
                .click(loadSelectedRepositoryList)))
       .append($("<td>").text(repositories[i].git_id))
       .append($("<td>").text(repositories[i].git_repository))
       .append($("<td>").text(repositories[i].content_title))
       .append($("<td>").text(repositories[i].content))
       .appendTo(table);
      }
	}
   });
}


function loadSelectedRepositoryList(event) {
	event.preventDefault();
	$.getJSON(
		this.href,
		function(tree_jsonArray){
			var table = $("#contentTable"); 
			var tr, td, a;
			for( var i in tree_jsonArray){
				$("<tr>")
				.append($("<td>").text(tree_jsonArray[i].path.value))
				.append($("<td>").text(tree_jsonArray[i].type.value))
				.append($("<td>").text(tree_jsonArray[i].sha.value))
				.appendTo(table);
			}
		}
	);
}






