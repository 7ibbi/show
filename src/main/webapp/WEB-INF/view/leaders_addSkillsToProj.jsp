<%@ include file="leaders_leadersHeader.jspf"%>

<br>

 <button type="button" class="btn btn-info"
 onclick="window.location.href='/retex/leaders/${project.codProiect}/adaugaColaboratori'">Adauga colaboratori</button>

 <button type="button" class="btn btn-info"
 onclick="window.location.href='/retex/leaders/${project.codProiect}/adaugaCompetente'">Adauga competente</button>
 <br><hr>
        <form:form action="addSkills" method="POST">
            <table>
                <tr>
                    <th><label>Search</label>
                    <input type="text" minlength="3" name = "cauta" title="Campul trebuie sa contina cel putin 2 caractere." required/>
                    <input type="submit" value="Search"/></th>
                </tr>
            </table>
        </form:form>
 <br>
         <c:if test="${result != null}">
         <table>
             <tr>
                 <th>Competenta</th>
                 <th>Categorie</th>
                 <th></th>

             </tr>
             <c:forEach var="tempResult" items="${result}">
                 <spring:url var="modifyUser" value="/retex/leaders/${varPath}/addSkills/add">
                     <spring:param name="skillId" value="${tempResult.idSkill}"/>
                 </spring:url>
             <tr>
                 <td>${tempResult.numeSkill}</td>
                 <td>${tempResult.categorie}</td>

                 <td>
                    <c:choose>
                        <c:when test="${hasSkill}">
                            Deja adaugat
                        </c:when>

                        <c:otherwise>
                              <form:form action="${modifyUser}" method="POST">
                                <input type="submit" class="btn btn-success" value="Adauga">
                              </form:form>
                        </c:otherwise>
                    </c:choose>
                 </td>
             </tr>
             </c:forEach>

         </table>
         </c:if>

<%@ include file="footer.jspf"%>