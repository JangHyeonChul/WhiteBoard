$('#register-emailcheck').click(function () {
    var email = $("#email").val();

    if(email==""){
        alert("이메일을 입력해주세요.");
        return false;
    }else if (!email_check(email)) {

            alert("이메일 형식에 맞게 입력해주세요");
            return false;
    } else {
        emailDuplication();
    }
})

function email_check(email) {
    var reg = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
    return reg.test(email);
}

function emailDuplication() {
    let emailValue = $('#email').val();

    $.ajax({
        url : '/emailduplication',
        type : 'post',
        dataType : 'text',
        data : {
            emailValue : emailValue
        },
        success : function (result) {
            if(result === "false") {
                alert("중복된 이메일 입니다")
            } else {
                $('#email-span').html("해당 이메일로 인증번호가 발송되었습니다");
                sendEmail();
            }
        }

    })
}