<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html class="no-js" lang="vi"> <!--<![endif]-->
    <jsp:include page="Head.jsp"></jsp:include>
        <body  class="" >  
            <div class="page">      
            <jsp:include page="Header.jsp"></jsp:include>

            <jsp:include page="Menu.jsp"></jsp:include>
                <div class="breadcrumbs">
                    <div class="container">
                        <div class="row">
                            <ul>				
                                <li class="home"> <a href="/" title="Trang chủ">Trang chủ</a><span>—›</span></li>				

                                <li><strong>Liên hệ</strong></li>

                            </ul>
                        </div>
                    </div>
                </div>

                <div class="banner_contact">


                </div>
                <style>.form-control{border-radius:0px;}</style>
                <div class="google-map">
                    <div id="contact_map" class="map"></div>
                </div>
                <div class="container">
                    <div class="row">
                        <div class="col-md-4">
                            <h4 style="margin-top: 20px;">Địa chỉ liên hệ</h4>
                            <p style="font-size:14px; font-weight:bold; color:#000;text-transform:uppercase; margin-bottom: 20px; margin-top:20px;"></p>
                            <ul style="list-style:none; margin:0px;">

                                <li><p style="color:#333"><span style="color:#f26522" class="glyphicon glyphicon-map-marker"></span> &nbsp; 236 Hoàng Quốc Việt, Bắc Từ Liêm, Hà Nội</p></li>

                                <li><p style="color:#333">

                                        <span style="color:#f26522" class="glyphicon glyphicon-earphone"></span> &nbsp;  0964409463

                                </li>
                                <li><p style="color:#383838">

                                        <span style="color:#f26522" class="glyphicon glyphicon-envelope"></span> &nbsp;<span style="color:#f26522"> vanphong6822@gmail.com</span>

                                    </p>
                                </li>

                            </ul>
                        </div>
                        <div class="col-md-8">
                            <div class="form_blog_comment">
                                <form accept-charset='UTF-8' action='contact.htm' id='contact' method='post' commandName="newContact" onsubmit="return validate()">
                                    <input name='FormType' type='hidden' value='contact' />
                                    <input name='utf8' type='hidden' value='true' />
                                    <h4 style="text-transform:uppercase; margin-top: 20px;">Liên hệ với chúng tôi</h4>

                                    <div class="form-group">
                                        <label for="name">Tên*</label>
                                        <input placeholder="Tên" id="name" name="name" type="text" value="" class="form-control" path="name"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Email*</label>
                                        <input placeholder="Email" id="email" name="email" class="form-control" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" type="email" value="" path="email"/>
                                    </div>
                                    <div class="form-group">

                                        <div class="form-group">
                                            <label for="content">Nội Dung</label>
                                            <textarea id="message" name="content" style="height: 120px;" class="form-control" rows="7" path="content"/></textarea>
                                        </div>
                                        <div class="form-group">
                                            <button type="submit" class="btn btn-success">Gửi đi</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script type="text/javascript">
                (jQuery)(document).ready(function ($) {
                    if ($('#contact_map').length) {
                        $('#contact_map').gMap({
                            zoom: 17,
                            scrollwheel: true,
                            maptype: 'ROADMAP',
                            markers: [
                                {
                                    address: '442 Đội Cấn, Ba Đình, Hà Nôi',
                                    html: '_address'
                                }
                            ]
                        });
                    }
                });
            </script>
            <style>
                .google-map {width:100%;}
                .google-map .map {width:100%; height:350px; background:#dedede}
            </style>
        <jsp:include page="Footer.jsp"></jsp:include>
    </div>
    <script type="text/javascript">
        Bizweb.updateCartFromForm = function (cart, cart_summary_id, cart_count_id) {

            if ((typeof cart_summary_id) === 'string') {
                var cart_summary = jQuery(cart_summary_id);
                if (cart_summary.length) {
                    // Start from scratch.
                    cart_summary.empty();
                    // Pull it all out.        
                    jQuery.each(cart, function (key, value) {
                        if (key === 'items') {

                            var table = jQuery(cart_summary_id);
                            if (value.length) {

                                jQuery('<div class="block-subtitle">Sản phẩm đã cho vào giỏ hàng</div>').appendTo(table)
                                jQuery.each(value, function (i, item) {


                                    if (item.image != null) {
                                        var src = Bizweb.resizeImage(item.image, 'small');
                                    } else {
                                        var src = 'http://bizweb.dktcdn.net/thumb/medium/assets/themes_support/noimage.gif';
                                    }

                                    jQuery('<li class="item even"> <a class="product-image" href="' + item.url + '"><img src="' + src + '" width="80"></a><div class="detail-item"><div class="product-details"> <a href="javascript:void(0);" onclick="Bizweb.removeItem(' + item.variant_id + ')" title="xóa sản phẩm" onClick="" class="glyphicon glyphicon-remove">&nbsp;</a><p class="product-name"> <a href="' + item.url + '" title="' + item.name + '">' + item.name + '</a> </p></div><div class="product-details-bottom"> <span class="price">' + Bizweb.formatMoney(item.price, "{{amount_no_decimals_with_comma_separator}}₫") + '</span> <span class="title-desc">Số lượng:</span> <strong>' + item.quantity + '</strong> </div></div></li>').appendTo(table);
                                });
                                jQuery('<div class="top-subtotal">Tổng tiền: <span class="price total_price">2.050.000₫</span></div><div class="actions"><a class="btn-checkout" href="/checkout\"><span>Thanh toán</span></a><a class="view-cart" href="/cart\"><span>giỏ hàng</span></a></div>').appendTo(table);
                            } else {
                                jQuery('<div class="block-subtitle">Không có sản phẩm nào trong giỏ hàng.</div>').appendTo(table);
                            }
                        }
                    });
                }
            }
            updateCartDesc(cart);
        }


        function updateCartDesc(data) {
            var $cartLinkText = $('#open_shopping_cart'),
                    $cartCount = $('#cart-total'),
                    $cartPrice = Bizweb.formatMoney(data.total_price, "{{amount_no_decimals_with_comma_separator}}₫");
            switch (data.item_count) {
                case 0:
                    $cartLinkText.attr('data-amount', '0');
                    $cartCount.text('0');
                    break;
                case 1:
                    $cartLinkText.attr('data-amount', '1');
                    $cartCount.text('1');
                    break;
                default:
                    $cartLinkText.attr('data-amount', data.item_count);
                    $cartCount.text(data.item_count);
                    break;
            }
            $('.total_price').html($cartPrice);
        }
        Bizweb.onCartUpdate = function (cart) {
            Bizweb.updateCartFromForm(cart, '.shopping_cart', 'shopping-cart');
        };
        $(window).load(function () {
            // Let's get the cart and show what's in it in the cart box.  
            Bizweb.getCart(function (cart) {
                Bizweb.updateCartFromForm(cart, '.shopping_cart');
            });
        });
    </script>
</body>
</html>
