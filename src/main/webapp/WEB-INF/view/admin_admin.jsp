<%@ include file="admin_header.jspf" %>
<br>
<h2>Administrare WebCM</h2>
<hr>
 <button type="button" class="btn btn-outline-primary" onclick="window.location.href='/admin/addUser'">Adauga angajat</button>
 <button type="button" class="btn btn-outline-primary" onclick="window.location.href='/admin/addSkill'">Adauga competenta</button>
 <button type="button" class="btn btn-outline-primary" onclick="window.location.href='/admin/updateUser'">Modifica angajat</button>
 <button type="button" class="btn btn-outline-danger" onclick="window.location.href='/manager'">TomcatManager</button>

<hr>

<%@ include file="footer.jspf" %>