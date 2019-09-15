<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <title>SB Admin 2 - Login</title>


  <!-- Custom fonts for this template-->
  <link href="<%=request.getContextPath()%>/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="<%=request.getContextPath()%>/css/sb-admin-2.css" rel="stylesheet">

</head>

<body <%--class="bg-gradient-primary"--%> style="background-image: url(img/bg.png);
   background-position: center;
   background-size: cover;
   background-repeat: no-repeat;">

  <div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

      <div class="col-xl-10 col-lg-12 col-md-9">

        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
              <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
              <div class="col-lg-6">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
                  </div>
                  <form class="user" id="logform" action="<%=request.getContextPath()%>/checklogin" method="post">
                   <%-- <div class="form-group">
                      <input type="email" class="form-control form-control-user" name="exampleInputEmail" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Enter Email Address...">
                    </div>--%>
                     <div class="form-group">
                       <input type="email" class="form-control form-control-user" name="email" id="exampleInputemail" placeholder="E-mail">
                     </div>
                    <div class="form-group">
                      <input type="password" class="form-control form-control-user" name="password" id="exampleInputPassword" placeholder="5到16位密码">
                    </div>
                     <div class="form-group clearfix">
                       <input type="text" class="form-control form-control-user float-left" name="thecode" id="code" placeholder="验证码" style="width:170px ">
                       <span class="border d-block float-left ml-3" style="margin-top: 10px;"><img src="<%=request.getContextPath()%>/code" onclick="checkCode()"></span>
                      <%-- <span style="color: red;">${sessionScope.mess}</span>--%>
                     </div>
                    <div class="form-group">
                      <div class="custom-control custom-checkbox small">
                        <input type="checkbox" class="custom-control-input" id="customCheck">
                        <label class="custom-control-label" for="customCheck">Remember Me</label>
                      </div>
                    </div>
                    <span class="btn btn-primary btn-user btn-block" id="log">
                      login
                    </span>
                     <%--<hr>
                     <a href="WEB-INF/jsp/index.jsp" class="btn btn-google btn-user btn-block">
                       &lt;%&ndash;待开发功能，可以考虑换成用qq登录或者微信登录&ndash;%&gt;
                       <i class="fab fa-google fa-fw"></i> Login with Google
                     </a>
                     <a href="WEB-INF/jsp/index.jsp" class="btn btn-facebook btn-user btn-block">
                       <i class="fab fa-facebook-f fa-fw"></i> Login with Facebook
                     </a>--%>
                  </form>
                  <hr>
                  <div class="text-center">
                    <a class="small" href="/WEB-INF/jsp/forgot-password.jsp">忘记密码</a>
                  </div>
                  <div class="text-center">
                    <a class="small" href="/toRejister">注册</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>

    </div>

  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="<%=request.getContextPath()%>/js/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="<%=request.getContextPath()%>/js/sb-admin-2.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>


</body>

</html>
<script>
  function checkCode() {
    //获取img
    var img=document.getElementsByTagName("img")[0];
    img.src="<%=request.getContextPath()%>/code?time="+new Date().getTime();
  }

  $(function(){

     /* console.log(emailcheck+" "+ passwordcheck+ " "+thecode);
      console.log($("#exampleInputPassword").val()+" "+$("#exampleInputemail").val()+ " "+$("#code").val());*/
      $("#log").click(function(){
          var emailcheck = new RegExp("^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$", "").test($("#exampleInputemail").val());
          var passwordcheck = new RegExp("^[a-zA-z][a-zA-Z0-9]{5,16}$", "").test($("#exampleInputPassword").val());
          var thecode = new RegExp("^[a-zA-Z0-9]{4}", "").test($("#code").val());
          console.log(emailcheck+" "+ passwordcheck+ " "+thecode);
          if($("#exampleInputemail").val()==""||$("#exampleInputPassword").val()==""||$("#code").val()==""){
              alert("请填入完整信息")
          }else if(emailcheck&&passwordcheck&&thecode){
              /*$.ajax({
                  type:"post",
                  url:$("#logform").attr("action"),
                  data:$("#logform").serialize(),
                  success:function(data){
                      console.log(data);
                      /!*用户名密码错误处理*!/
                      /!*var rs=eval(data);
                      if(data.massage!="") {
                          alert(data.massage);
                      }*!/
                  }
              });*/
              $("#logform").submit();

          }else{
              alert("请按格式填写信息")
          }

      })
  })
</script>