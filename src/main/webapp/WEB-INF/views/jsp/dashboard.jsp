<%--
  Created by IntelliJ IDEA.
  User: MAHE
  Date: 7/19/2017
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.ttn.linksharing.model.User" %>
<% User user = (User) session.getAttribute("UserDetails");%>

<!DOCTYPE html>
<html lang="en">
<head>

    <!--For css, import:-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/core/css/dashboard.css"/>

    <!--For bootstrap, import:-->
    <link rel="icon" type="image/x-icon" href="favicon.ico">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <!--For icons, import:-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


    <script type="text/javascript"
            src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <script type="text/javascript">
        function doAjax() {
            $.ajax({
                url : 'displaytopics.html',
                success : function(data) {
                    $('#result').html(data);
                }
            });
        }
    </script>
  </head>

<body>

<!--Top part of page-->
<div class="top-box-border">
    <%@include file="dashboardheader.jsp" %>
</div>


<br>
<br>


<!--Bototm part of page-->
<div class="bottom-part">

    <div class="row">
        <div class="col-md-6">

            <div class="panel panel-default" style="border-color:black">

                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3">
                            <%if(user.getPhoto()!= null && user.getPhoto().length!=0){ %>
                            <img class="pic-class" id="dp" src="/getPhoto">
                            <% }
                            else {%>
                            <img class="pic-class" src="/resources/images/default-img.jpg">
                            <% } %>
                        </div>

                        <div class="col-md-7">
                            <strong style="font-size: x-large"><%=user.getFirstName()+" "+user.getLastName()%> </strong>
                            <table>
                                <tr>
                                    <td>
                                        <font size=2px class="text-muted">@<%=user.getUsername()%></font>
                                    </td>
                                </tr>
                                <tr><td><br/></td></tr>
                                    <td>
                                        <font size=2px> Subscriptions</font>
                                    </td>
                                    <td>&nbsp;&nbsp;</td>
                                    <td>
                                        <a onclick="return doAjax();" style="text-decoration: none;">
                                            <font size=2px> Topics</font>
                                        </a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <font size=2px style="color:blue"> 0 </font>
                                    </td>
                                    <td>&nbsp;&nbsp;</td>

                                    <%if(user.getTopicList()!= null && user.getTopicList().size()!=0){ %>
                                    <td>
                                        <font size=2px style="color:blue"> <%=user.getTopicList().size()%> </font>
                                    </td>
                                    <% }
                                    else {%>
                                    <td>
                                        <font size=2px style="color:blue"> 0 </font>
                                    </td>
                                    <% } %>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <!--Coding for "Subscriptions" panel here-->
            <div class="panel panel-default" style="border-color:black">
                <%@include file="subscriptions.jsp" %>
            </div>

            <!-- Coding for Trending Topics -->
            <div class="panel panel-default" style="border-color:black">
                <%@include file="trendingtopics.jsp" %>
            </div>

        </div>

        <div class="col-md-6">
            <!--Coding for the panel "Inbox" from here-->
            <div class="panel panel-default" style="border-color:black">
                <%@include file="inbox.jsp" %>
            </div>

            <%--Ajax part--%>
            <div class="panel panel-default" style="border-color:black">
                <div class="panel-body">
                    <div id="result"></div>
                </div>
            </div>

            <%--MODALS--%>

            <!--Coding for "Share Document" panel here-->
            <div class="modal fade" id="myModal4" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Share Document</h4>
                        </div>
                        <div class="modal-body">
                          <form method="post" action="/shareDoc">
                              Document:* <input type="file" style="position:relative;margin-left:40%;" name="file" required/>
                            <br><br>
                            Description:* <textarea cols="22" rows=3  placeholder="Description" name="description" style="position:relative;margin-left:32%;" required></textarea>
                            <br><br>
                            Topic:* <select style="position:relative;margin-left:40%;" name="topic" required>
                              <c:forEach items="${topiclist}" var="databaseValue">
                                  <option value="${databaseValue}">
                                          ${databaseValue}
                                  </option>
                              </c:forEach>
                        </select>
                            <br><br>
                            <button type="submit" style="position:relative; margin-left:48%;">Share</button>
                          </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>

            <!--Coding for "Share Link" panel here-->
            <div class="modal fade" id="myModal3" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Share Link</h4>
                        </div>
                        <div class="modal-body">
                           <form method="post" action="/shareLink">
                            Link:* <input type="text" placeholder="Link" name="url" onblur="urlcheck()" style="position:relative;margin-left:40%;" required>
                            <br><br>
                            Description:* <textarea cols="22" rows=3  placeholder="Description" name="description" style="position:relative;margin-left:32%;" required></textarea>
                            <br><br>
                            Topic:* <select style="position:relative;margin-left:40%;" name="topic" required>
                               <c:forEach items="${topiclist}" var="databaseValue">
                                   <option value="${databaseValue}">
                                           ${databaseValue}
                                   </option>
                               </c:forEach>
                        </select>
                            <br><br>
                            <button type="submit" style="position:relative; margin-left:48%;">Share</button>
                           </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>

            <!--Coding for "Send Invitation" panel here-->
            <div class="modal fade" id="myModal2" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Send Invitation</h4>
                        </div>
                        <div class="modal-body">
                            Email:* <input type="text" placeholder="Email" style="position:relative;margin-left:40%;" required>
                            <br><br>
                            Topic:* <select style="position:relative;margin-left:40%;" required>
                            <option>Topic</option>
                            <option>Topic 1</option>
                        </select>
                            <br><br>
                            <button type="submit" style="position:relative; margin-left:48%;">Invite</button>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>

            <!--Coding for "Create Topic" panel here-->
            <div class="modal fade" id="myModal1" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Create Topic</h4>
                        </div>
                        <div class="modal-body">
                            <form method="post" action="/createtopic">
                                Name:* <input type="text" placeholder="Name" name="name" style="position:relative;margin-left:40%;" required >
                                <br><br>
                                Visibility:* <select style="position:relative;margin-left:40%;" name="visibility" required>
                                <option>PUBLIC</option>
                                <option>PRIVATE</option>
                            </select>
                                <br><br>
                                <button type="submit" style="position:relative; margin-left:48%;">Save</button>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>




