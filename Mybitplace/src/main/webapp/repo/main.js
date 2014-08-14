window.onload = function() {
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
			.append($("<td>").text(repositories[i].git_id))
			.append($("<td>").text(repositories[i].git_repository))
			.append($("<td>").text(repositories[i].content_title))
			.append($("<td>").text(repositories[i].content))
			.appendTo(table)
		  }
		}
  });
}







