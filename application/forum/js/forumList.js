 
function hasNewPost(o,lastVisitDate){
	  var t=document.getElementById(o).getElementsByTagName("tr");
	  var lastVisitDate="z";
	  for(var i=1;i<t.length;i++){
	  	var arr=t[i].id.split("_");
	  	if (arr[0]!=null && arr[1]!=null){
	      lastVisitDate = readCookie(arr[0]+'lastVisitDate');  
		    if (lastVisitDate!=arr[1]){ 
		    	  document.getElementById(arr[0]+"_hasNewImg").src="/images/forum_new.gif";
		  		  createCookie(arr[0]+'lastVisitDate',arr[1],3600*24);		         
		  		  continue;
		    }
		  }
	  }
}  

function popList(){
     load(getContextPath() +'/query/popularlist.shtml?count=15&dateRange=360', function(xhr) {
  	       document.getElementById('poplist').innerHTML = xhr.responseText;
			});
   
}   