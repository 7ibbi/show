<%@ include file = "header.jspf" %>

<div>

    <div id="loginbox" style="margin-top: 50px;"
         class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">

        <div class="panel panel-info">
            <div style="padding-top: 30px" class="panel-body">

<%--
                <!-- Login Form -->
--%>
                <form:form action="${pageContext.request.contextPath}/forgotPassword"
                           method="POST" class="form-horizontal">

<%--
                    <!-- Place for messages: error, alert etc ... -->
--%>
                    <div class="form-group">
                        <div class="col-xs-15">
                            <div>

<%--
                                <!--        Check for login error-->
--%>

                                <c:if test="${param.error != null}">
                                    <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                        Invalid username and password.
                                    </div>
                                </c:if>

<%--
                                <!--        Check for logout error-->
--%>

                                <c:if test="${param.logout != null}">

                                    <div class="alert alert-success col-xs-offset-1 col-xs-10">
                                        You have been logged out.
                                    </div>

                                </c:if>
                            </div>
                        </div>
                    </div>

<%--
                    <!-- User name -->
--%>
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

                        <input type="text" name="email" placeholder="Email" class="form-control">
                    </div>


<%--
                    <!-- Login/Submit Button -->
--%>
                    <div style="margin-top: 10px" class="form-group">
                        <div class="col-sm-6 controls">
                            <button type="submit" class="btn btn-success">Reset password</button>
                        </div>
                    </div>
                </form:form>

            </div>

        </div>

    </div>

</div>


<%@ include file = "footer.jspf" %>