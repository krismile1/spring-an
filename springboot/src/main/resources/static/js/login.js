$(function(){
    $("#user_insert_btn").click(function(){
alert("123")
            var username = $("#insert_name").val();
            var password = $("#insert_password").val();

            //发起ajax进行登录
            $.ajax({
                url:"/doLogin",
                data:{"username":username,"password":password},
                type:"post",
                success:function(data){
                    if(data.code=="000000"){
                        //这里再次经过请求才进登录页面
                        //如果放在静态static下静态页面就可以直接这样子跳页面:window.location.href = "signin.html";
                        //但是在templates下必须经过请求否则就会暴露页面不安全

                        //跳转到登录页面
                        location.href = "/index";
                    }else{
                        alert(data.msg)
                    }

                },
                error:function(){
                }
            });
    });
});
