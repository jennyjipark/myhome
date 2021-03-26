// 메뉴바 hover
	$(".li-list").hover(function() {
       $(this).addClass("li-list-hover");
     }, function() {
       $(this).removeClass("li-list-hover");
     })
       

        $(window).scroll(function() {
            if($(this).scrollTop() > 100) {
                $("header").addClass("header-scroll");
                $(".header-ul").addClass("header-ul-scroll");
                $(".header-img").addClass("header-img-scroll");
                $(".header-ul2").addClass("header-ul2-scroll");            			
                $(".li-list").hover(function() {
                    $(this).removeClass("li-list-hover");
                    $(this).addClass("li-list-scroll-hover");
                }, function() {
                    $(this).removeClass("li-list-hover");
                    $(this).removeClass("li-list-scroll-hover");
                })

            } else {
                $("header").removeClass("header-scroll");
                $(".header-ul").removeClass("header-ul-scroll");
                $(".header-img").removeClass("header-img-scroll");
                $(".header-ul2").removeClass("header-ul2-scroll");                
                $(".li-list").hover(function() {
                    $(this).removeClass("li-list-scroll-hover");
                    $(this).addClass("li-list-hover");
                }, function() {
                    $(this).removeClass("li-list-hover");
                })
            }
        });