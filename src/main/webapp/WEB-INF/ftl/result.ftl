<#include "header.ftl">
<body>
${user!"nullddd"}
<a id="logout"  onclick = "$('#logoutForm').submit();" >Loguot</a>
<form id="logoutForm" action="logout" method="post" >
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<script>
/*$('#logout').on("click",function(){
console.log(999);
	
});*/
</script>
</body>
<#include "footer.ftl">