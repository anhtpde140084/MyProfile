<%-- 
    Document   : ShowBlogAdmin
    Created on : Feb 20, 2021, 10:05:08 AM
    Author     : tranp
--%>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/admin/header.jsp" %>

<div id="layoutSidenav_content">
    <main>

        <div class="container-fluid">
            <h1 class="mt-4">Tables</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item"><a href="/admin-home">Dashboard</a></li>
                <li class="breadcrumb-item active">Tables</li>
            </ol>
            <div class="card mb-4">
                <div class="card-body">
                    <c:if test="${message !=null}">
                    <div class="alert alert-success">
                        <strong>Success!</strong> ${message}
                    </div>
                    </c:if>
                </div>
            </div>
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-table mr-1"></i>
                    Bảng tài khoản
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th>Tiêu đề</th>
                                    <th>Người đăng</th>
                                    <th>Ngày đăng</th>
                                    <th>Số người xem</th>
                                    <th>Xóa</th>
                                    <th>Chỉnh sửa</th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                    <th>Tiêu đề</th>
                                    <th>Người đăng</th>
                                    <th>Ngày đăng</th>
                                    <th>Số người xem</th>
                                    <th>Xóa</th>
                                    <th>Chỉnh sửa</th>
                                </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach items="${list}" var="item">
                                <tr>
                                    <td>${item.title}</td>
                                    <td>Phi Anh</td>
                                    <td>${item.create_date}</td>
                                    <td>${item.view}</td>
                                    <td><a onclick="return confirm('Bạn có chắc chắn muốn xóa?')" href="/admin-blog/delete-blog/${item.id}"><i class="far fa-trash-alt"></i></a></td>
                                    <td><a href="/admin-blog/edit-blog/${item.id}"><i class="fas fa-edit"></i></a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <script type="text/javascript">
        $("#success-alert").fadeTo(2000, 500).slideUp(500, function(){
            $("#success-alert").alert('close');
        });
    </script>
    <%@ include file="/includes/admin/footer.jsp" %>