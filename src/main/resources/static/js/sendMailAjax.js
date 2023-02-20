function sendEmail() {
    let email = $('#email').val();


    $.ajax({
        url : '/member/register',
        type : 'post',
        dataType : 'text',
        data : {
            email : email
        },
        success : function (result) {
            $('#register-emailcheck').attr("disabled", true);
            number = result
            console.log(result);
        },
        error : function (result) {
            console.log('실패');
        }

    })
}

$('#email-check').blur(function () {
    let emailchecknum = $('#email-check').val();

    if(number === emailchecknum) {
        $('#register_send_btn').attr("disabled", false);
        $('#email-check').attr("disabled", true);
        $('#email-check-span').html("인증에 성공 하였습니다").css("color", "blue");

    }  else if(number !== emailchecknum) {
        $('#email-check-span').html("인증에 실패 하였습니다");
        $('#email-check-span').css("color", "#ff6262");
    }
})