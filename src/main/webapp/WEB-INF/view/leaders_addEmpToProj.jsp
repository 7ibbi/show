<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<br>

 <button type="button" class="btn btn-info"
 onclick="window.location.href='/webCM/leaders/${varPath}/addSkills'">Adauga competente</button>

 <button type="button" class="btn btn-warning"
 onclick="window.location.href='/webCM/leaders/${varPath}'">Inapoi</button>



 <br><hr>
        <form:form id="collabForm" onsubmit="return searchCollab('${codProiect}', searchTerm.value)">
            <table>
                <tr>
                    <th><label>Search</label>
                    <input type="text" pattern=".{3,}" name = "searchTerm" title="Campul trebuie sa contina cel putin 4 caractere." required/>
                    <input type="submit" value="Search"/></th>
                </tr>
            </table>
        </form:form>
 <br>
         <c:if test="${not empty result}">
         <table>
             <tr>
                 <th>Nume</th>
                 <th>Prenume</th>
                 <th>Numar Matricol</th>
                 <th>Email</th>
                 <th>Rol</th>
                 <th>Adaugare</th>
             </tr>
             <c:forEach var="tempResult" items="${result}">
                 <spring:url var="modifyUser" value="/webCM/leaders/${varPath}/adaugaColaboratori/add">
                     <spring:param name="userId" value="${tempResult.id}"/>
                 </spring:url>
             <tr>
                 <td>${tempResult.nume}</td>
                 <td>${tempResult.prenume}</td>
                 <td>${tempResult.numarMatricol}</td>
                 <td>${tempResult.email}</td>
                 <td>${tempResult.functie}</td>

                 <td>

                              <form:form action="${modifyUser}" method="POST">
                                <input type="submit" class="btn btn-success" value="Adauga-l">
                              </form:form>

                 </td>
             </tr>
             </c:forEach>

         </table>
         </c:if>


<script>

    function searchCollab(codProiect, searchTerm) {
        console.log(codProiect + searchTerm);
        $("#div3").load($("#collabForm").ajaxSubmit({url: '"/" + codProiect + "/adaugaColaboratori?searchTerm=" +
        searchTerm', type: 'post'});

        return false;
    }
</script>