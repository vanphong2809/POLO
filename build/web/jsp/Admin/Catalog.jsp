<%-- 
    Document   : Head
    Created on : Jun 7, 2017, 2:04:06 PM
    Author     : TuyenMap
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">


    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <jsp:include page="Head.jsp"></jsp:include>

        <link href="/SpringFrameworks/jsp/Fontend/css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="/SpringFrameworks/jsp/Admin/css/ace.min.css" rel="stylesheet" type="text/css"/>
        <script src="/SpringFrameworks/jsp/Admin/js/jquery.min.js" type="text/javascript"></script>
        <script src="/SpringFrameworks/jsp/Admin/js/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="/SpringFrameworks/jsp/Admin/js/dataTables.jqueryui.js" type="text/javascript"></script>
        <link href="/SpringFrameworks/jsp/Admin/css/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <link href="/SpringFrameworks/jsp/Admin/css/dataTables.jqueryui.css" rel="stylesheet" type="text/css"/>
        <script src="/SpringFrameworks/jsp/Admin/js/count.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#catalog').dataTable({
                    "pagingType": "full_numbers",
                    "lengthMenu": [[5, 10, 20, -1], [5, 10, 20, "All"]],
                });
            });
        </script>

        <body class="no-skin">
        <jsp:include page="Header.jsp"></jsp:include>

            <div class="main-container" id="main-container">
                <script type="text/javascript">
                    try {
                        ace.settings.check('main-container', 'fixed')
                    } catch (e) {
                    }
                </script>
                <script src="/SpringFrameworks/jsp/Fontend/js/test.js" type="text/javascript"></script>

            <jsp:include page="Menu.jsp"></jsp:include>

                <div class="main-content">
                    <div class="main-content-inner">
                        <div class="breadcrumbs" id="breadcrumbs">
                            <script type="text/javascript">
                    try {
                        ace.settings.check('breadcrumbs', 'fixed')
                    } catch (e) {
                    }
                            </script>

                            <ul class="breadcrumb">
                                <li>
                                    <i class="ace-icon fa fa-home home-icon"></i>
                                    <a href="homeBackend.htm">Trang chủ</a>
                                </li>
                                <li class="active">Quản lí danh mục</li>
                            </ul><!-- /.breadcrumb -->


                        </div>

                        <div class="page-content">

                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="table-header">
                                       
                                        Danh sách danh mục <br/>
                                         <a href="<%=request.getContextPath()%>/initInsertCatalog.htm" class="">Thêm mới</a>
                                    </div>
                                    
                                       
                                    
                                    <div>    
                                        <table id="catalog" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                            <thead>
                                                <tr>
                                                    <th>Mã danh mục</th>
                                                    <th>Tên danh mục</th>
                                                    <th>Chú thích</th>

                                                    <th> Danh mục cha </th>
                                                    <th style="width:100px;text-align:center;">Ảnh</th>
                                                    <th>Độ ưu tiên hiển thị</th>
                                                    <th>Trạng thái</th>

                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${listCatalog}" var="catalog">
                                                <tr>
                                                    <td>
                                                        ${catalog.catalogId}
                                                    </td>
                                                    <td>${catalog.catalogName}</td>
                                                    <td class="hidden-480">${catalog.descriptions}</td>
                                                    <td>${catalog.parentId}</td>
                                                    <td> <img title="${catalog.catalogName}" src="/SpringFrameworks/jsp/Fontend/images/${catalog.images}" class="img-fix3" >
                                                    </td>                                               <td>
                                                        ${catalog.displayNumber}
                                                    </td>
                                                    <c:if test="${catalog.status == 'True'}">
                                                        <td>
                                                            Kích hoạt
                                                        </td>
                                                    </c:if>
                                                    <c:if test="${catalog.status == 'False'}">
                                                        <td>
                                                            Không khích hoạt
                                                        </td>
                                                    </c:if>
                                                    <td>
                                                        <div class="hidden-sm hidden-xs action-buttons">
                                                            <a class="blue" href="viewCatalog.htm?Id=${catalog.catalogId}">
                                                                <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                                            </a>

                                                            <a class="green" href="initUpdateCatalog.htm?Id=${catalog.catalogId}">
                                                                <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                            </a>

                                                            <a class="red" href="deleteCatalog.htm?Id=${catalog.catalogId}">
                                                                <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                                            </a>
                                                        </div>

                                                    </td>
                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>   
                                </div>
                            </div>

                        </div><!-- /.row -->
                    </div><!-- /.page-content -->
                </div>
            </div><!-- /.main-content -->

            <jsp:include page="Footer.jsp"></jsp:include>

        </div><!-- /.main-container -->

    </body>
</html>
