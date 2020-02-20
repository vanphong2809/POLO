<%-- 
    Document   : InsertCatalog
    Created on : Jun 9, 2017, 6:30:29 AM
    Author     : TuyenMap
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">


    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <jsp:include page="Head.jsp"></jsp:include>
    <link href="/SpringFrameworks/jsp/Admin/css/sweetalert.css" rel="stylesheet" type="text/css"/>
     <script src="/SpringFrameworks/jsp/Admin/js/sweetalert.min.js" type="text/javascript"></script>
        <script>
            function validate() {
                var cardSeri = document.getElementById("cardSeri").value;
                var cardNumber = document.getElementById("cardNumber").value;
                var price = document.getElementById("priceUnit")
                if (cardSeri != "" && cardNumber != "" && price != 0) {
                    return true;
                } else {
                    if (cardSeri == "") {
                        swal("Bạn phải nhập số seri");
                        document.getElementById("cardSeri").focus();
                        return false;
                    }
                    if (cardNumber == "") {
                        swal("Bạn phải nhập số màu.");
                        document.getElementById("cardNumber").focus();
                        return false;
                    }
                    if(price == 0){
                        
                        swal("Bạn phải nhập mệnh giá").focus();
                                // đi qua vì bọn thôi đi đường khác
                          document.getElementById("user").focus();
                        return false;
                    }
                }
            }
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
                                    <a href="#">Home</a>
                                </li>
                                <li class="active">Dashboard</li>
                            </ul><!-- /.breadcrumb -->


                        </div>

                        <div class="page-content">

                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="x_panel">
                                        <div class="x_title">
                                            <h4>Quản lí thẻ nạp <small>  >> Sửa thông tin</small></h4>
                                            <div class="clearfix"></div>
                                        <f:form class="form-horizontal form-label-left" action="updateCard.htm" commandName="updateCard" onsubmit="return validate()">
                                            <div class="form-group message">
                                                 ${message}
                                             </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Mã thẻ nạp <span >*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <f:input type="text" id="cardId" class="form-control col-md-7 col-xs-12" path="cardId" readonly="readonly"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Seri thẻ nạp <span>*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <f:input type="text" id="cardSeri" class="form-control col-md-7 col-xs-12" path="cardSeri" />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Số thẻ nạp <span>*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <f:input type="text" id="cardNumber"  class="form-control col-md-7 col-xs-12" path="cardNumber" /> 
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Mệnh giá<span>*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <f:input type="text" id="priceUnit"  class="form-control col-md-7 col-xs-12" path="priceUnit" /> 
                                                </div>
                                            </div>
                                                 <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Trạng thái <span class="required">*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                   <f:select id="status" class="form-control col-md-7 col-xs-12" path="status" >
                                                      
                                                            
                                                           <f:option value="True" label="Khích hoạt"/>
                                                           <f:option value="False" label="Không kích hoạt"/>
                                                       
                                                    </f:select>
                                                </div>
                                            </div>


                                            <div class="ln_solid"></div>
                                            <div class="form-group">
                                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
          
                                                    <button class="btn btn-primary" type="button" onclick="history.go(-1)">Quay lại</button>
                                                    <button type="submit" class="btn btn-success">Lưu</button>
                                                </div>
                                            </div>
                                            
                                             
                                        </f:form>
                                    </div>
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

