$('#register_send_btn').click(function () {
        var pwdValidBoolean = pwdValidCheck();
        var nickValidBoolean = nickValidCheck();
        if(pwdValidBoolean == true && nickValidBoolean == true)
            $('#register_send_btn').attr("type", "submit");

})


function pwdValidCheck() {
    if( $('#pwd').val().length < 9) {
        $('#pwd-check-span').html("비밀번호는 8글자 이상이여야 합니다");
        return false;
    } else if($('#pwd').val() !== $('#pwd-check').val()){
        $('#pwd-check-span').html("비밀번호가 일치하지 않습니다");
        return false;
    } else {
        $('#pwd-check-span').html("");
        return true;
    }
}

function nickValidCheck() {
    if ( $('#nick').val().length < 2) {
        $('#nick-check-span').html("닉네임은 2글자 이상입니다");
        return false;
    } else {
        $('#nick-check-span').html("");
        return true;
    }
}



