window.onload = function() {
  loadRepositoryList();
};


function loadRepositoryList() {
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function(event) {
	if (xhr.readyState == 4) {
	  //1. 서버로부터 받은 JSON 문자열을 실행하여 자바스크립트 객체로 만든다.
	  var repositories = eval('(' + xhr.responseText + ')');
	  
	  //2. 배열을 반복하면서 성적정보 출력
	  var table = document.getElementById("repoTable");
	  var tr, td, a;
	  for (var i in repositories) {
		
		
		tr = document.createElement("tr"); //<tr></tr>
		table.appendChild(tr); //<table>...<tr></tr></table>
		
		td = document.createElement("td"); //<td></td>
		td.textContent = repositories[i].content_no; //<a href="...">번호</a>
		tr.appendChild(td); //<tr><td>...</td></tr>
		
		td = document.createElement("td");
		td.textContent = new Date(repositories[i].edited_date).toString("yyyy-MM-dd");
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.textContent = repositories[i].mno;
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.textContent = repositories[i].participants;
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.textContent = repositories[i].open_or_close;
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.textContent = repositories[i].validation;
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.textContent = repositories[i].locker ;
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.textContent = repositories[i].title_no;
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.textContent = repositories[i].open_to;
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.textContent = repositories[i].content_title;
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.textContent = repositories[i].count;
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.textContent = new Date(repositories[i].edited_date_f).toString("yyyy-MM-dd");
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.textContent = new Date(repositories[i].edited_date_l).toString("yyyy-MM-dd");
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.textContent = repositories[i].content;
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.textContent = repositories[i].group_no;
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.textContent = repositories[i].git_repository;
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.textContent = repositories[i].git_id;
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.textContent = repositories[i].git_pwd;
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.textContent = repositories[i].git_oauthtoken;
		tr.appendChild(td);
		
	  }
	}
  };
  
  xhr.open('GET', 'list.git', false);
  xhr.send(null);	
}






